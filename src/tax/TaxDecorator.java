package tax;

import java.math.BigDecimal;

public class TaxDecorator implements Tax {

    protected Tax decoratorTax;

    public TaxDecorator(Tax decoratorTax) {
        this.decoratorTax = decoratorTax;
    }

    @Override
    public BigDecimal getTax(BigDecimal priceHt) {
        return decoratorTax.getTax(priceHt);
    }
}
