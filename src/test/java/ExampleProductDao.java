import app.ProductDao;
import model.Product;


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
