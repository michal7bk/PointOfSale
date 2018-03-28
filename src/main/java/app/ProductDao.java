package app;

import model.Product;


public interface ProductDao {

    Product getProduct(String barCode);
}
