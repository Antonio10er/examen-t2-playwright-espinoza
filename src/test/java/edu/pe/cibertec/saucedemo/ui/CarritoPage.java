package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {
    public static final String CART_BADGE = "[data-test='shopping-cart-badge']";
    public static final String CART_LINK = "[data-test='shopping-cart-link']";
    public static final String CART_ITEM_NAME = "[data-test='inventory-item-name']";

    public static String addToCartButton(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        return "[data-test='add-to-cart-" + formattedName + "']";
    }

    public static String removeButton(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        return "[data-test='remove-" + formattedName + "']";
    }
}
