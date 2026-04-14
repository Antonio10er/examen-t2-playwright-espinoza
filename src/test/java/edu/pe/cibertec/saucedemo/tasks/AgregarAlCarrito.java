package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AgregarAlCarrito {

    public static Performable named(String productName) {
        return Task.where("{0} adds product '" + productName + "' to cart",
                Click.on(Target.the("Add to cart button for " + productName)
                        .locatedBy(CarritoPage.addToCartButton(productName)))
        );
    }

}
