import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Product {

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    String getName();

    void setName(String name);

    String getCompany();

    void setCompany(String company);

    LocalDateTime getExpireDate();

    void setExpireDate(LocalDateTime expireDate);

    @Override
    String toString();
}
