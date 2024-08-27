package model;

import java.util.List;

public class ShoppingCard {

    private List<ShoppingCardItem> items;

    public ShoppingCard(List<ShoppingCardItem> items) {
        this.items = items;
    }

    public List<ShoppingCardItem> getItems() {
        return items;
    }
}
