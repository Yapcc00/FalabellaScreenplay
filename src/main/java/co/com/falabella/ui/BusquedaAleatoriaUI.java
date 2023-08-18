package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class BusquedaAleatoriaUI {

    public static Target BUSQUEDA = Target.the("Barra de busqueda").locatedBy(".SearchBar-module_searchBar__Input__1kPKS");
    public static Target BUSQUEDA_ALEATORIA = Target.the("Busqueda del producto aleatoriamente").locatedBy("//div[@class='jsx-1833870204 jsx-3831830274 pod-head']");

    public static Target BUSQUEDA_ALEATORIA_LISTA =  Target.the("Busqueda del producto aleatoriamente en lista ").locatedBy("//div[@class='jsx-1576191951 pod-details section-body--left']");

}
