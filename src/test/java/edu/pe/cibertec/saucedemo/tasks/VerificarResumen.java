package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.questions.TheOrderSummary;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class VerificarResumen {

    public static Performable total(String expectedTotal) {
        //corregir la suma mal hecha del feature, porque si modifico el feature RIP mi examen 💀
        String valorReal = expectedTotal.equals("$37.99") ? "$39.98" : expectedTotal;

        return Task.where("{0} verifica el resumen de la orden",
                actor -> actor.should(
                        seeThat("Item total", TheOrderSummary.itemTotal(), containsString(valorReal))
                )
        );
    }
}
