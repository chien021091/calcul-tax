import enumeration.CategoryEnum;
import model.Invoice;
import model.ShoppingCardItem;
import model.ShoppingCard;
import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("### Output");
        test01();
        test02();
        test03();
    }

    private static void test01(){
        System.out.println("#### Output 1");
        Product livre = new Product("livre", BigDecimal.valueOf(12.49), CategoryEnum.BOOK, false);
        Product cd = new Product("CD musical", BigDecimal.valueOf(14.99), CategoryEnum.OTHER, false);
        Product barreChocolate = new Product("barre de chocolate", BigDecimal.valueOf(0.85), CategoryEnum.FOOD, false);

        List<ShoppingCardItem> items = new ArrayList<>();
        items.add(new ShoppingCardItem(livre, 1));
        items.add(new ShoppingCardItem(cd, 1));
        items.add(new ShoppingCardItem(barreChocolate, 1));

        ShoppingCard shoppingCard = new ShoppingCard(items);
        Invoice invoice = new Invoice(shoppingCard);
        invoice.printInvoice();
    }

    private static void test02(){
        System.out.println("#### Output 2");
        Product boiteChocolateImport = new Product("boîte de chocolate importée", BigDecimal.valueOf(10), CategoryEnum.FOOD, true);
        Product flaconParfumImport = new Product("flacon de parfum importé", BigDecimal.valueOf(47.5), CategoryEnum.OTHER, true);

        List<ShoppingCardItem> items = new ArrayList<>();
        items.add(new ShoppingCardItem(boiteChocolateImport, 1));
        items.add(new ShoppingCardItem(flaconParfumImport, 1));

        ShoppingCard shoppingCard = new ShoppingCard(items);
        Invoice invoice = new Invoice(shoppingCard);
        invoice.printInvoice();
    }

    private static void test03(){
        System.out.println("#### Output 3");

        Product flaconParfumImport = new Product("flacon de parfum importé", BigDecimal.valueOf(27.99), CategoryEnum.OTHER, true);
        Product flaconParfum = new Product("flacon de parfum", BigDecimal.valueOf(18.99), CategoryEnum.OTHER, false);
        Product boitePilulesContreMigraine = new Product("boîte de pilules contre la migraine", BigDecimal.valueOf(9.75), CategoryEnum.MEDECINE, false);
        Product boiteChocolateImport = new Product("boîte de chocolate importée", BigDecimal.valueOf(11.25), CategoryEnum.FOOD, true);

        List<ShoppingCardItem> items = new ArrayList<>();
        items.add(new ShoppingCardItem(flaconParfumImport, 1));

        items.add(new ShoppingCardItem(flaconParfum, 1));
        items.add(new ShoppingCardItem(boitePilulesContreMigraine, 1));
        items.add(new ShoppingCardItem(boiteChocolateImport, 1));

        ShoppingCard shoppingCard = new ShoppingCard(items);
        Invoice invoice = new Invoice(shoppingCard);
        invoice.printInvoice();
    }
}