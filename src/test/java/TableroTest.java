
import Clases_Dominio.Tablero;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TableroTest {

    @Test
    void testLlenarArregloCeros() {
        Tablero dato = new Tablero();
        int valor=(int) Math.floor(Math.random()*100+1);

        int[] arreglo =new int[valor];
        int[] arreglo2 = new int[valor];
        for (int i = 0; i < arreglo2.length; i++) {
            final var i1 = arreglo2[i];

        }

        fill(arreglo2, 0);
        assertArrayEquals(arreglo,dato.llenarArregloCeros(arreglo2));
    }
}