package edu.pe.cibertec.saucedemo.tasks;

import com.microsoft.playwright.Page;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion {

    public static Performable activa() {
        return Task.where("{0} verifica la sesión activa con aserciones nativas de Playwright",
                actor -> {
                    Page page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();
                    assertThat(page.locator(".shopping_cart_link")).isVisible();
                    assertThat(page.locator(".app_logo")).containsText("Swag Labs");
                }
        );
    }
}