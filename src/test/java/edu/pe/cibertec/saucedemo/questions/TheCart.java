package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

import java.util.List;

public class TheCart {

    public static Question<String> badgeCount() {
        return Text.of(Target.the("Cart badge count")
                .locatedBy(CarritoPage.CART_BADGE));
    }

    public static Question<List<String>> items() {
        return Text.ofEach(Target.the("Cart items names")
                .locatedBy(CarritoPage.CART_ITEM_NAME));
    }

}
