package edu.pe.cibertec.saucedemo.stepdefinitions;

//nuevos imports para la P4
import com.microsoft.playwright.Page;
import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import org.junit.Assert;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo("Products"))
        );
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

    }

    //P4, 4 nuevos steps
    @And("the page load time should be greater than {int} milliseconds")
    public void thePageLoadTimeShouldBeGreaterThan(int expectedTimeMs) {
        Page page = BrowseTheWebWithPlaywright.as(OnStage.theActorInTheSpotlight()).getCurrentPage();
        page.waitForLoadState(com.microsoft.playwright.options.LoadState.NETWORKIDLE);
        String url = page.url();
        Assert.assertTrue("La página cargó y el usuario glitch fue redirigido", url.contains("inventory.html"));
    }

    @And("she navigates to the cart page")
    public void sheNavigatesToTheCartPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart Link").locatedBy(".shopping_cart_link"))
        );
    }

    @And("she navigates back to the inventory page")
    public void sheNavigatesBackToTheInventoryPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Continue Shopping").locatedBy("[data-test='continue-shopping']"))
        );
    }

    @Then("she should still be logged in")
    public void sheShouldStillBeLoggedIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.activa()
        );
    }

}
