package Clases_Dominio;

import java.util.Arrays;
import java.util.Random;

public class Tablero {

    int[] arregloCartas;
    int[] arregloControlRepeticion;

    public void contruirArreglosCartas(int cartasTotales) {
        secuenciaCartas(cartasTotales);
    }

    private void secuenciaCartas(int cartas) {
        arregloCartas = new int[cartas];
        arregloControlRepeticion = new int[cartas / 2];
        trabajarArreglos();
    }

    private void trabajarArreglos() {
        llenarArregloCeros(arregloCartas);
        llenarArregloCeros(arregloControlRepeticion);
        int posicion;
        Random random = new Random();
        for (int i = 0; i < arregloCartas.length; i++) {
            posicion = random.nextInt(arregloControlRepeticion.length);
            if (arregloControlRepeticion[posicion] < 2) {
                arregloCartas[i] = posicion + 1;
                arregloControlRepeticion[posicion]++;
            } else {
                i--;
            }
        }
    }

    public int[] llenarArregloCeros(int[] arreglo) {
        Arrays.fill(arreglo, 0);
        return arreglo;
    }

    public int[] getArregloCartas() {
        return arregloCartas;
    }


}