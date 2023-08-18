package co.com.falabella.task;

import co.com.falabella.interactions.CantidadRandom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.falabella.ui.AgregarProductoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CantidadRandomTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CantidadRandom.usando(BTN_CANTIDAD, TXT_CANTIDAD, TXT_TITULO));
    }

    public static CantidadRandomTask on(){
        return instrumented(CantidadRandomTask.class);
    }
}
