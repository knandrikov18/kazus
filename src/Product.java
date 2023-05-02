import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Product {

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    String getName();

    void setName(String name);

    String getCompany();

    void setCompany(String company);

    LocalDate getExpireDate();

    void setExpireDate(LocalDate expireDate);

    @Override
    String toString();
}
