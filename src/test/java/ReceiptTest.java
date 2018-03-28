import model.Product;
import model.Receipt;
import org.junit.Test;
import static org.junit.Assert.*;
public class ReceiptTest {
    Receipt receipt = new Receipt();
    @Test
    public void shouldCountTotalPriceForReceipt(){
        //given
        Product product = new Product("prod1",10.0,"997");
        Product product1 = new Product("prod2",5.00,"998");
        //when
        receipt.addToReceipt(product);
        receipt.addToReceipt(product1);

        //then
        assertEquals(product.getPrice()+product1.getPrice(),receipt.sumUp(),0 );
    }
}
