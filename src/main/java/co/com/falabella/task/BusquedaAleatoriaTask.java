package co.com.falabella.task;

import co.com.falabella.interactions.SeleccionRandom;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;
import java.util.Random;

import static co.com.falabella.ui.BusquedaAleatoriaUI.BUSQUEDA_ALEATORIA;

public class BusquedaAleatoriaTask implements Task {

    private WebElementFacade element;

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaProductos = BUSQUEDA_ALEATORIA.resolveAllFor(actor);

        Random random = new Random();
        int indexRandom = random.nextInt(listaProductos.size());

        // Seleccionar el elemento aleatorio de la lista
        element = listaProductos.get(indexRandom);
    }


}

