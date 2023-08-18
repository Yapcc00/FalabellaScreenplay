package co.com.falabella.stepDefinitions;


import co.com.falabella.interactions.SeleccionRandom;
import co.com.falabella.questions.ValidacionCantidadQuestion;
import co.com.falabella.task.*;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;


import static co.com.falabella.ui.AgregarProductoUI.TXT_CANTIDAD;
import static co.com.falabella.ui.AgregarProductoUI.TXT_TITULO;
import static co.com.falabella.ui.BusquedaAleatoriaUI.BUSQUEDA_ALEATORIA;
import static co.com.falabella.ui.BusquedaAleatoriaUI.BUSQUEDA_ALEATORIA_LISTA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class ProductoStepDefinitions {


    @Dado("que el usuario abra la pagina y busque un producto")
    public void queElUsuarioAbraLaPaginaYBusqueUnProducto() {
        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("usuario").wasAbleTo(AbrirNavegadorTask.onAbrir());
        theActorInTheSpotlight().wasAbleTo(BusquedaTask.onBusqueda());
    }
    @Cuando("aleatoriamente seleccione el producto y la cantidad")
    public void aleatoriamenteSeleccioneElProductoYLaCantidad() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionRandom.de(BUSQUEDA_ALEATORIA, BUSQUEDA_ALEATORIA_LISTA)
        );
        theActorInTheSpotlight().attemptsTo(CantidadRandomTask.on());
        theActorInTheSpotlight().attemptsTo(AgregarCarritoTask.onAgregar());

    }
    @Entonces("el producto se agregara al carrito con la cantidad seleccionada")
    public void elProductoSeAgregaraAlCarritoConLaCantidadSeleccionada() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidacionCantidadQuestion.esIgual(), Matchers.equalTo(true)));
    }
}
