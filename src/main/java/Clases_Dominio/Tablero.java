package Clases_Dominio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {

    private final Random randomNum = new Random();

    private ImageIcon[] imagenes;
    private String rutaImagesAnimales =  "src/main/java/Imagenes/Animales/";
    private String extensionImagenes = ".png";

    private int[] cartasSeleccionadas;
    private int filas;
    private int columnas;
    private int[] indicesImagenes;
    private int cantidadCartas;
    private int[] cartasTotalesSeleccionadas;
    private int cantidadCartasDisponibles = 20;// se esta trabajando con imagenes del directorio "Animales", y solo hay 20 imagenes allí

    public ImageIcon[] dimensiones(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        cantidadCartas = (this.filas * this.columnas);
        imagenes = new ImageIcon[cantidadCartas];
        contruirArregloCartas();
        asignarImagenes();
        return imagenes;
    } //  LISTO

    private void contruirArregloCartas() {
        llenarIndicesImagenes();
        asignarParesCartas();
        arregloCartasTotales();
    }

    private int[] llenarIndicesImagenes() {
        indicesImagenes = new int[cantidadCartasDisponibles];
        for (int i = 1; i <= cantidadCartasDisponibles; i++) {
            indicesImagenes[i - 1] = i;
        }
        return indicesImagenes;
    } // LISTO

    private int[] asignarParesCartas() {
        cartasSeleccionadas = new int[cantidadCartas / 2];
        cartasSeleccionadas = cartasNoRepetidas();
        return cartasSeleccionadas;
    } // LISTO

    private int[] cartasNoRepetidas() {
        cartasSeleccionadas[0] = indicesImagenes[randomNum.nextInt(indicesImagenes.length)];
        for (int i = 1; i < cartasSeleccionadas.length; i++) {
            cartasSeleccionadas[i] = indicesImagenes[randomNum.nextInt(indicesImagenes.length)];
            for (int j = 0; j < i; j++) {
                if (cartasSeleccionadas[i] == cartasSeleccionadas[j]) {
                    i--;
                }
            }
        }
        return cartasSeleccionadas;
    } // LISTO

    private int[] numerosAleatoriosNoRepetidos(int[] numeros) {
        int[] arreglo = new int[numeros.length];
        arreglo[0] = numeros[randomNum.nextInt(numeros.length)];
        for (int i = 1; i < arreglo.length; i++) {
            arreglo[i] = numeros[randomNum.nextInt(numeros.length)];
            for (int j = 0; j < i; j++) {
                if(arreglo[i] == arreglo[j]){
                    i--;
                }
            }
        }
        return arreglo;
    }//LISTO

    private void arregloCartasTotales() {
        int[] arreglo1 = numerosAleatoriosNoRepetidos(cartasSeleccionadas);
        int[] arreglo2 = numerosAleatoriosNoRepetidos(cartasSeleccionadas);
        cartasTotalesSeleccionadas = new int[cantidadCartas];
        int contador = 0;
        for (int i = 0; i < cantidadCartas; i++) {
            if (i < (cartasTotalesSeleccionadas.length / 2)) {
                cartasTotalesSeleccionadas[i] = arreglo1[i];
            } else {
                cartasTotalesSeleccionadas[i] = arreglo2[contador];
                contador++;
            }
        }
        desordenarCartas();
    }

    private int[] desordenarCartas() {
        int[] arreglo3 = new int[cartasTotalesSeleccionadas.length];
        for (int i = 1; i <= cartasTotalesSeleccionadas.length; i++) {
            arreglo3[i - 1] = i;
        }
        arreglo3 = numerosAleatoriosNoRepetidos(arreglo3);

        int[] copia = new int[cartasTotalesSeleccionadas.length];
        for (int i = 0; i < copia.length; i++) {
            copia[i] = cartasTotalesSeleccionadas[i];
        }

        for (int i = 0; i < arreglo3.length; i++) {
            cartasTotalesSeleccionadas[i] = copia[arreglo3[i] - 1];
        }
        return cartasTotalesSeleccionadas;
    }

    /* // MUESTRA LA COMBINACION DE CARTAS (SIN REPETIR, Y DESORDENADAS -> TODAS LAS CARTAS NECESARIAS PARA EL TABLERO)
    public void mostrarArreglo() {
        System.out.println(Arrays.toString(cartasTotalesSeleccionadas));
    }
    */

    private void asignarImagenes() {
        String[] rutasImagenes = convertirRutaImagenes(new String[cantidadCartas]);
        crearImagenes(rutasImagenes);
    }

    private ImageIcon[] crearImagenes(String[] rutasImagenes) {
        for (int i = 0; i < rutasImagenes.length; i++) {
            ImageIcon imagen = new ImageIcon(rutasImagenes[i]);
            imagenes[i] = imagen;
        }
        return imagenes;
    }

    private String[] convertirRutaImagenes(String[] nombresRutas) {
        for (int i = 0; i < nombresRutas.length; i++) {
            nombresRutas[i] = rutaImagesAnimales + cartasTotalesSeleccionadas[i] + extensionImagenes;
            System.out.println("imagen " + i + ": " + nombresRutas[i]);
        }
        return nombresRutas;
    }


    // GETTERS

    public int getCantidadCartas() {
        return cantidadCartas;
    }

    public ImageIcon[] getImagenes() {
        return imagenes;
    }
}