package model;

import java.math.BigDecimal;

public class Invoice {

    private ShoppingCard shoppingCard;

    public Invoice(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    public void printInvoice(){
        if(shoppingCard.getItems() == null){
            System.out.println("Panier est vide");
            return;
        }

        for(ShoppingCardItem item : shoppingCard.getItems()){
            printLine(item);
        }

        printTotal();
    }

    private void printLine(ShoppingCardItem item){
        System.out.println(item.getQuantity() + " " + item.getProduct().getName() + " : " + item.calculTotalTtc());
    }

    private void printTotal(){
        BigDecimal totalTax = shoppingCard.getItems().stream()
                .reduce(BigDecimal.ZERO, (cumul, item) -> cumul.add(item.calculTotalTax()), BigDecimal::add);

        BigDecimal totalTtc = shoppingCard.getItems().stream()
                .reduce(BigDecimal.ZERO, (cumul, item) -> cumul.add(item.calculTotalTtc()), BigDecimal::add);

        System.out.println("Montant de taxes : " + totalTax);
        System.out.println("Total : " + totalTtc);
    }
}
