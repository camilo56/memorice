package Clases_Dominio;

import Manejo_Archivos.GestorArchivo;

public class Datos {

    private String rutaArchivo = "Estadisticas.csv";

    public String obtenerEstadisticas(){

        GestorArchivo gestorArchivo = new GestorArchivo();
        String datos =  "****************************************\n";
        datos += "               Esdisticas               \n";
        datos += gestorArchivo.obtenerLineasArchivo(rutaArchivo);;
        datos = datos.replace(";", "    ");
        datos += "****************************************\n";
        return datos;
    }
}
