package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AgregarProductoUI {

    public static Target BTN_CANTIDAD = Target.the("Boton de cantidad").locatedBy("//button[@id='quantity-selector-increment-btn']");
    public static Target BTN_AGREGAR_CARRITO = Target.the("Boton de agregar producto").locatedBy("//button[@id='add-to-cart-button']");
    public static Target BTN_IR_CARRITO = Target.the("Boton para ir al carrito").locatedBy("//a[@id='linkButton']");

    public static Target TXT_TITULO = Target.the("Nombre del producto").locatedBy("//h1[@class='jsx-1680787435 product-name fa--product-name false']");

    public static Target TXT_CANTIDAD = Target.the("Cantidad del producto").locatedBy("//input[@id='quantity-selector-increment-input']");
}