import devices.LcdDisplay;
import devices.ReceiptPrinter;
import model.Receipt;

public class app {
    public static class PoS {
        private ReceiptPrinter receiptPrinter;
        private LcdDisplay lcdDisplay;
        private Receipt receipt;
    }
}
