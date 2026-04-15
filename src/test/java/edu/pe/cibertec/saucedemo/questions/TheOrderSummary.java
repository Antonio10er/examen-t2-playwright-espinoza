package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class TheOrderSummary {

    public static Question<String> itemTotal() {
        return Text.of(Target.the("Item total label").locatedBy(CheckoutPage.ITEM_TOTAL_LABEL));
    }

    public static Question<String> confirmationMessage() {
        return Text.of(Target.the("Confirmation message").locatedBy(CheckoutPage.COMPLETE_HEADER));
    }

    public static Question<Boolean> formIsVisible() {
        return Visibility.of(Target.the("Checkout info form").locatedBy(CheckoutPage.CHECKOUT_INFO_CONTAINER));
    }

    public static Question<String> errorMessage() {
        return Text.of(Target.the("Checkout error message").locatedBy(CheckoutPage.ERROR_MESSAGE));
    }
}
