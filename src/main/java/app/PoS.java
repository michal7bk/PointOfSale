package app;

import devices.LcdDisplay;
import devices.ReceiptPrinter;
import model.Product;
import model.Receipt;


    public  class PoS implements ScannerListener {
        private ReceiptPrinter receiptPrinter;
        private LcdDisplay lcdDisplay;
        private Receipt receipt = new Receipt();
        private ProductDao productDao;


        private final String productNotFound ="Product not found";
        private final String emptyScannedCode ="Invalid bar-code";


        public void onExit(){
        lcdDisplay.displayReceipt(receipt,receipt.sumUp());
        receiptPrinter.printReceipt(receipt,receipt.sumUp());
        }

        @Override
        public void onScan(String barCode) {
            if (barCode ==null || barCode.isEmpty()){
                lcdDisplay.displayMesage(emptyScannedCode);
            }else {
                printProducts(barCode);
            }

        }
        void  printProducts(String barCode){
            Product product = productDao.getProduct(barCode);
            if (product != null ){
                lcdDisplay.displayProduct(product);
                receipt.addToReceipt(product);
            }else {
                lcdDisplay.displayMesage(productNotFound);
            }

        }

    }

