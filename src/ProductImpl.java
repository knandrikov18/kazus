import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductImpl implements Product {
    private BigDecimal price;
    private String name;
    private String company;
    private LocalDate expireDate;


    public ProductImpl() {
        price = new BigDecimal(0);
        name = "";
        company = "";
        expireDate = LocalDate.now();
    }

    public ProductImpl(BigDecimal price, String name, String company, LocalDate expireDate) {
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
    public LocalDate getExpireDate() {
        return expireDate;
    }

    @Override
    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Product{" + "price=" + price + ", name='" + name + '\'' + ", company='" + company + '\'' + ", expireDate=" + expireDate + '}';
    }
}
