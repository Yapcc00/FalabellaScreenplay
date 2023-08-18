package co.com.falabella.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.Random;

import static co.com.falabella.ui.AgregarProductoUI.TXT_CANTIDAD;
import static co.com.falabella.ui.AgregarProductoUI.TXT_TITULO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionRandom implements Interaction {

    private final Target target;
    private final Target backupTarget;

    public SeleccionRandom(Target target, Target backupTarget) {
        this.target = target;
        this.backupTarget = backupTarget;
    }

    public static Performable de(Target target, Target backupTarget) {
        return instrumented(SeleccionRandom.class, target, backupTarget);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listaProductos = target.resolveAllFor(actor);

        if (listaProductos.isEmpty()) {
            listaProductos = backupTarget.resolveAllFor(actor);
        }

        if (!listaProductos.isEmpty()) {
            int indexRandom = new Random().nextInt(listaProductos.size());
            WebElementFacade elementoAleatorio = listaProductos.get(indexRandom);
            elementoAleatorio.click();

            WebElementFacade nombreProducto = TXT_TITULO.resolveFor(actor);
            actor.remember("cantidad",TXT_CANTIDAD.resolveAllFor(actor));
            actor.remember("titulo",nombreProducto.getText().toString());

        } else {
            throw new RuntimeException("No se encontraron productos para seleccionar.");
        }
    }
}
