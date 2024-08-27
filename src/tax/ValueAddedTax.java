package tax;

import java.math.BigDecimal;

public class ValueAddedTax extends TaxDecorator {

    private static final BigDecimal taxRate  = BigDecimal.valueOf(0.1);

    public ValueAddedTax(Tax decoratorTax) {
        super(decoratorTax);
    }

    @Override
    public BigDecimal getTax(BigDecimal priceHt) {
        return decoratorTax.getTax(priceHt).add(priceHt.multiply(taxRate));
    }
}
