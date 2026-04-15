package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class CompletarCheckout {

    public static Performable conDatos(String firstName, String lastName, String postalCode) {
        return Task.where("{0} completes checkout with name " + firstName,
                Click.on(Target.the("Cart Link").locatedBy(CarritoPage.CART_LINK)),
                Click.on(Target.the("Checkout button").locatedBy("[data-test='checkout']")),
                Enter.theValue(firstName).into(Target.the("First name").locatedBy(CheckoutPage.FIRST_NAME_INPUT)),
                Enter.theValue(lastName).into(Target.the("Last name").locatedBy(CheckoutPage.LAST_NAME_INPUT)),
                Enter.theValue(postalCode).into(Target.the("Postal code").locatedBy(CheckoutPage.POSTAL_CODE_INPUT)),
                Click.on(Target.the("Continue button").locatedBy(CheckoutPage.CONTINUE_BUTTON))
        );
    }

}
