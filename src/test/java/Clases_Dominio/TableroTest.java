package Clases_Dominio;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TableroTest {

    @Test
    void testLlenarArregloCeros() {
        Tablero dato = new Tablero();
        int[] arreglo =dato.getArregloCartas();
        int[] arreglo2 =dato.getArregloCartas();

        Arrays.fill(arreglo, 0);

        assertArrayEquals(arreglo,dato.llenarArregloCeros(arreglo2));
    }
}