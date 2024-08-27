package tax;

import java.math.BigDecimal;

public class ImportTax extends TaxDecorator {

    private static final BigDecimal taxRate  = BigDecimal.valueOf(0.05);

    public ImportTax(Tax decoratorTax) {
        super(decoratorTax);
    }

    @Override
    public BigDecimal getTax(BigDecimal priceHt) {
        return decoratorTax.getTax(priceHt).add(priceHt.multiply(taxRate));
    }
}
