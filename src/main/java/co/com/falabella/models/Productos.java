package co.com.falabella.models;

import co.com.falabella.utils.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Productos {

    private static ArrayList<Map<String, String>> productos = new ArrayList<>();

    public static ArrayList<Map<String, String>> data(){

        try {
            productos = Excel.leerDatosDeHojaDeExcel("src\\test\\resources\\data\\Data.xlsx", "hojaProductos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }
}
