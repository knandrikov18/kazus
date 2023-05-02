import java.util.stream.Collectors;

public class ShopImpl extends Shop {


    public ShopImpl() {
        super();
    }

    @Override
    public String getDetails() {
        return "shop name: %s  owner name: %s products: %s".formatted(getName(), getOwnerName(), super.getProductsInfo());
    }
}