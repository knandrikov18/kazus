import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductImpl implements Product {
    private BigDecimal price;
    private String name;
    private String company;
    private LocalDateTime expireDate;


    public ProductImpl(BigDecimal price, String name, String company, LocalDateTime expireDate) {
        this.price = price;
        this.name = name;
        this.company = company;
        this.expireDate = expireDate;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCompany() {
        return company;
    }

    @Override
    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    @Override
    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Product{" + "price=" + price + ", name='" + name + '\'' + ", company='" + company + '\'' + ", expireDate=" + expireDate + '}';
    }
}
