package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheOrderSummary;
import edu.pe.cibertec.saucedemo.tasks.CompletarCheckout;
import edu.pe.cibertec.saucedemo.tasks.VerificarResumen;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarCheckout.conDatos(firstName, lastName, postalCode)
        );
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesTheOrderSummary(String expectedTotal) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarResumen.total(expectedTotal)
        );
    }

    @And("she completes the order")
    public void sheCompletesTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Finish button").locatedBy(CheckoutPage.FINISH_BUTTON))
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeTheConfirmationMessage(String expectedMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheOrderSummary.confirmationMessage(), equalTo(expectedMessage))
        );
    }

    @And("the checkout form should remain visible")
    public void theCheckoutFormShouldRemainVisible() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheOrderSummary.formIsVisible(), is(true))
        );
    }
}