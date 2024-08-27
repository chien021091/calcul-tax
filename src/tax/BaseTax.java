package tax;

import java.math.BigDecimal;

public class BaseTax implements Tax {

    @Override
    public BigDecimal getTax(BigDecimal priceHt) {
        return BigDecimal.ZERO;
    }
}
