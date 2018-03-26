import app.PoS;
import devices.LcdDisplay;
import org.junit.Test;


import static org.mockito.Mockito.*;
import static app.PoS.PRODUCT_NOT_FOUND;


public class ProductDaoTest {

    final String barCode = new String("997");
    @Test
    public void shoukdMessageWhenInvalidBarCode(){
        String emptyBarCode = new String("");
        LcdDisplay lcdDisplay = mock(LcdDisplay.class);

        PoS pos = new PoS();
        pos.onScan(emptyBarCode);
        verify(lcdDisplay).displayMesage(PRODUCT_NOT_FOUND);
    }



}
