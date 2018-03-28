import app.ProductDao;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ExampleProductDao implements ProductDao {

    private Product product;


    @Override
    public Product getProduct(String barCode) {
        return product;
    }

    public ExampleProductDao(Product product) {
        this.product = product;
    }
}
