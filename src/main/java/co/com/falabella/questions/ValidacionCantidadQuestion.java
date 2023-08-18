package co.com.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.falabella.ui.AgregarProductoUI.TXT_CANTIDAD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionCantidadQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        String cantidadEsperada = actor.recall("cantidad");

        try {
            WaitUntil.the(TXT_CANTIDAD, isVisible()).forNoMoreThan(10).seconds();
            String cantidadActual = TXT_CANTIDAD.resolveFor(actor).getText();
            return cantidadEsperada.equals(cantidadActual);
        } catch (Exception e) {
            // Manejo de errores: en caso de excepción, retorna false
            return false;
        }
    }

    // Método estático para crear la instancia de la pregunta
    public static ValidacionCantidadQuestion esIgual() {
        return new ValidacionCantidadQuestion();
    }
}
