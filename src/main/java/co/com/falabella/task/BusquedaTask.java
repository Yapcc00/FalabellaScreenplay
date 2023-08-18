package co.com.falabella.task;


import co.com.falabella.models.Productos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.falabella.ui.BusquedaAleatoriaUI.BUSQUEDA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BusquedaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String txtProductosRandom = Productos.data().get(2).get("Productos");
        actor.attemptsTo(
                WaitUntil.the(BUSQUEDA, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(txtProductosRandom).into(BUSQUEDA).thenHit(Keys.ENTER)
        );
    }

    public static BusquedaTask onBusqueda(){
        return instrumented(BusquedaTask.class);
    }

}

