package model;

import enumeration.CategoryEnum;
import tax.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumSet;

public class Product {

    private String name;

    private BigDecimal priceHt;

    private CategoryEnum category;

    private boolean isImport;

    public Product(String name, BigDecimal priceHt, CategoryEnum category, boolean isImport) {
        this.name = name;
        this.priceHt = priceHt;
        this.category = category;
        this.isImport = isImport;
    }

    public BigDecimal calculTaxes() {

        Tax tax = new BaseTax();

        if(!EnumSet.of(CategoryEnum.BOOK, CategoryEnum.FOOD, CategoryEnum.MEDECINE).contains(this.category)){
            tax = new ValueAddedTax(tax);
        }

        if(isImport){
            tax = new ImportTax(tax);
        }

        BigDecimal amountTax = tax.getTax(this.priceHt);
        return rountTo5CentsUp(amountTax);
    }

    private BigDecimal rountTo5CentsUp(BigDecimal montant) {
        final BigDecimal COEF_ROUND = BigDecimal.valueOf(20);
        return montant.setScale(2, RoundingMode.UP)
                .multiply(COEF_ROUND)
                .setScale(0, RoundingMode.CEILING)
                .divide(COEF_ROUND, 2, RoundingMode.CEILING);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPriceHt() {
        return priceHt;
    }
}