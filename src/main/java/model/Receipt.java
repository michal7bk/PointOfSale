package model;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> receipt = new ArrayList<Product>();
    public double sum ;

    public void addToReceipt(Product product){
        receipt.add(product);
    }


    public double sumUp(){
        for(int i=0;i< receipt.size();i++ ) {
            sum += receipt.get(i).getPrice();
        }
        return sum;
    }


}
