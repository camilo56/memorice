import Clases_Dominio.Tablero;
import Manejo_Archivos.GestorDeVentanas;

public class Launcher {

    public static void main(String[] args) {
        /*
        GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();
        gestorDeVentanas.ejecutar();
        */
        Tablero tablero = new Tablero();
        tablero.dimensiones(4, 6);
        //tablero.mostrarArreglo();
    }
}