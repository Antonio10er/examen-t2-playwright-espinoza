package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheCart;
import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @When("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.named(productName)
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.named(productName)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String expectedCount) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.badgeCount(), equalTo(expectedCount))
        );
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContainAnd(String product1, String product2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart Link").locatedBy(CarritoPage.CART_LINK))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.items(), hasItems(product1, product2))
        );
    }

    @Then("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String expectedProduct) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart Link").locatedBy(CarritoPage.CART_LINK))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.items(), contains(expectedProduct))
        );
    }

}
