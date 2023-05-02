import java.util.stream.Collectors;

public class ShopImpl extends Shop {


    public ShopImpl() {
        super();
    }

    @Override
    public String getDetails() {
        return "shop name: %s  owner name: %s products: %s".formatted(getName(), getOwnerName(),
                super.getProducts().entrySet().stream()
                        .map(entry -> String.format("product: %s quantity: %s", entry.getKey(), entry.getValue()))
                        .collect(Collectors.joining("\n")));
    }
}