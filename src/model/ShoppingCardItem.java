package model;

import java.math.BigDecimal;

public class ShoppingCardItem {

    private Product product;

    private int quantity;

    public ShoppingCardItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal calculTotalTtc(){
        BigDecimal priceTtcUnit = product.getPriceHt().add(product.calculTaxes());
        return BigDecimal.valueOf(quantity).multiply(priceTtcUnit);
    }

    public BigDecimal calculTotalTax(){
        BigDecimal taxUnit = product.calculTaxes();
        return BigDecimal.valueOf(quantity).multiply(taxUnit);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
