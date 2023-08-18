package co.com.falabella.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Random;

public class CantidadRandom implements Interaction {

    private final Target botonSeleccionCantidad;
    private final Target cantidadText;
    private final Target tituloText;

    public CantidadRandom(Target botonSeleccionCantidad, Target cantidadText, Target tituloText) {
        this.botonSeleccionCantidad = botonSeleccionCantidad;
        this.cantidadText = cantidadText;
        this.tituloText = tituloText;
    }

    public static CantidadRandom usando(Target botonSeleccionCantidad, Target cantidadText, Target tituloText) {
        return new CantidadRandom(botonSeleccionCantidad, cantidadText, tituloText);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();
        int numeroRandom = random.nextInt(3) + 1;

        for (int i = 0; i < numeroRandom; i++) {
            actor.attemptsTo(
                    Click.on(botonSeleccionCantidad)
            );
        }

        String tituloProducto = tituloText.resolveFor(actor).getText();
        int cantidadSeleccionada = numeroRandom;

        actor.remember("tituloProducto", tituloProducto);
        actor.remember("cantidadSeleccionada", cantidadSeleccionada);

        actor.attemptsTo(
                Click.on(cantidadText)
        );
    }
}
