import app.PoS;
import app.ProductDao;
import devices.LcdDisplay;
import devices.ReceiptPrinter;
import model.Product;
import org.junit.Test;


import static org.mockito.Mockito.*;
import static app.PoS.PRODUCT_NOT_FOUND;
import static app.PoS.EMPTY_SCANNED_CODE;

public class PoSTest {




    private LcdDisplay lcdDisplay = mock(LcdDisplay.class);



    @Test
    public void shouldMessageWhenInvalidBarCode(){
        //given
        String barCode = "997";
        ProductDao productDao = mock(ProductDao.class);
        PoS pos = new PoS(null,lcdDisplay,productDao);
        //when
        pos.onScan(barCode);
        verify(lcdDisplay).displayMesage(PRODUCT_NOT_FOUND);
    }

    @Test
    public void shouldMessageWhenEmptyBarCode(){
        //given
        String emptyBarCode =("");
        ProductDao productDao = mock(ProductDao.class);
        PoS poS = new PoS(null,lcdDisplay,productDao);
        //when
        poS.onScan(emptyBarCode);

        //then
        verify(lcdDisplay).displayMesage(EMPTY_SCANNED_CODE);

    }

    @Test
    public void shouldPrintProductWhenCorrectBarCode(){
        //given
        Product product = new Product("prod1",10.0,"997");
        ProductDao productDao = new ExampleProductDao(product);
        PoS pos = new PoS(null,lcdDisplay,productDao);

        //when
        pos.onScan("997");

        //then
        verify(lcdDisplay).displayProduct(product);
    }

    @Test
    public void shouldPrintTotalPriceAfterExit(){
        //given
        ReceiptPrinter receiptPrinter = mock(ReceiptPrinter.class);
        Product product = new Product("prod1",10.0,"998");
        ProductDao productDao = new ExampleProductDao(product);
        PoS pos = new PoS(receiptPrinter,lcdDisplay, productDao);
        pos.onScan(product.getBarCode());

        //when
        pos.onExit();

        //then
        verify(lcdDisplay).displayTotalPrice(product.getPrice());
    }

    @Test
    public void shouldPrintZeroWhenExitWithoutAnyScannedProducts(){
        //given
        ReceiptPrinter receiptPrinter=mock(ReceiptPrinter.class);
    ProductDao productDao = new ExampleProductDao(null);
    PoS pos = new PoS(receiptPrinter,lcdDisplay,productDao);

    //when
    pos.onExit();

    //then
    verify(lcdDisplay).displayTotalPrice(0.0);
    }



}
