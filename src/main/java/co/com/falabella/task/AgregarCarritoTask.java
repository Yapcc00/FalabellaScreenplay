package co.com.falabella.task;

import co.com.falabella.ui.AgregarProductoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.falabella.ui.AgregarProductoUI.BTN_AGREGAR_CARRITO;
import static co.com.falabella.ui.AgregarProductoUI.BTN_IR_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarCarritoTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(Click.on(BTN_AGREGAR_CARRITO));
        actor.attemptsTo(Click.on(BTN_IR_CARRITO));

    }

    public static AgregarCarritoTask onAgregar(){
        return instrumented(AgregarCarritoTask.class);
    }
}
