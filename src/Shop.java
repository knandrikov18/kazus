import java.util.HashMap;
import java.util.Map;

public abstract class Shop {

    private String name;
    private String ownerName;
    private Map<Product, Integer> products;

    public Shop() {
        name = "";
        ownerName = "";
        products = new HashMap<>();
    }

    public Shop(String name, String ownerName, Map<Product, Integer> products) {
        this.name = name;
        this.ownerName = ownerName;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String name) {
        this.ownerName = name;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public abstract String getDetails();
}