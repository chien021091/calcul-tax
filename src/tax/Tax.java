package tax;

import java.math.BigDecimal;

public interface Tax {

    BigDecimal getTax(BigDecimal priceHt);

}
