package Clases_Guis;

import Clases_Dominio.Tablero;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Gui_JuegoTest {

    @Test
    void llenarArregloConCeros() {
        Gui_Juego dato = new Gui_Juego();
        int[] arregloEsperado =new int[(int) Math.floor(Math.random()*100+1)];
        int[] arregloActual =new int[(int) Math.floor(Math.random()*100+1)];

        Arrays.fill(arregloEsperado, 0);

        assertArrayEquals(arregloEsperado,dato.llenarArregloConCeros(arregloActual));
    }

    @Test
    void testCrearCartasIncognitas() {
        Gui_Juego dato = new Gui_Juego();
        assertNotNull(dato.crearCartasIncognitas());
    }

    @Test
    void testDatosJugador() {
        Gui_Juego dato = new Gui_Juego();
        assertTrue(dato.DatosJugador());
    }
}