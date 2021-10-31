package Clases_Dominio;

import java.util.Random;

public class Tablero {

    private final Validaciones validar = new  Validaciones();
    private final Random randomNum = new Random();

    private String[][] tablero;
    private String[][] tableroAmpliado; // es para ingresar los ejes de coordenadas (X y Y)
    private final String [] cartas =  {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] paresDeCartas;
    private int cantidadCartasTablero;

    public String[][] generarTablero(int filas, int columnas){
        tablero = new String[filas][columnas];
        cantidadCartasTablero = filas * columnas;
        tableroAmpliado = new String[filas + 1][columnas + 1];
        tableroAmpliado = llenarTableroAmpliado();
        return tableroAmpliado;
    }//LISTO

    public String[][] llenarTableroAmpliado(){
        tableroAmpliado = llenarFilaColumnaExterna(tableroAmpliado);
        int[] numerosAleatorios = new int[cantidadCartasTablero];
        numerosAleatorios = numerosAleatoriosNoRepetidos(numerosAleatorios);
        String[] tableroTemporal = new String[cantidadCartasTablero];
        tableroTemporal = llenarTableroTemporal(tableroTemporal, numerosAleatorios);
        tableroAmpliado = asignarCartas(tableroTemporal);
        return tableroAmpliado;
    }//LISTO

    public String[] llenarTableroTemporal(String[] tableroTemporal, int[] numerosAleatorios) {
        int contador = 0;
        paresDeCartas = new String[cantidadCartasTablero / 2];
        paresDeCartas = cartasNoRepetidas();
        for (int i = 0; i < cantidadCartasTablero; i++) {
            if (i < (cantidadCartasTablero / 2)) {
                tableroTemporal[numerosAleatorios[i]] = paresDeCartas[i];
            } else {
                tableroTemporal[numerosAleatorios[i]] = paresDeCartas[contador];
                contador++;
            }
        }
        return tableroTemporal;
    }//LISTO

    public String[][] asignarCartas(String[] tableroTemporal){
        int contador = 0;
        for (int i = 1; i < tableroAmpliado.length; i++) {
            for (int j = 1; j < tableroAmpliado[0].length; j++) {
                tableroAmpliado[i][j] = tableroTemporal[contador];
                contador++;
            }
        }
        return tableroAmpliado;
    }//LISTO

    public int[] numerosAleatoriosNoRepetidos(int[] arreglo) {
        arreglo[0] = randomNum.nextInt(arreglo.length);
        for (int i = 1; i <arreglo.length; i++) {
            arreglo[i] = randomNum.nextInt(arreglo.length);
            for (int j = 0; j < i; j++) {
                if(arreglo[i] == arreglo[j]){
                    i--;
                }
            }
        }
        return arreglo;
    }//LISTO

    public String[] cartasNoRepetidas() {
        paresDeCartas[0] = cartas[randomNum.nextInt(cartas.length)];
        for (int i = 1; i <paresDeCartas.length; i++) {
            paresDeCartas[i] = cartas[randomNum.nextInt(cartas.length)];
            for (int j = 0; j < i; j++) {
                if(paresDeCartas[i].equals(paresDeCartas[j])){
                    i--;
                }
            }
        }
        return paresDeCartas;
    } //LISTO

    public String[][] llenarFilaColumnaExterna(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][0] = Integer.toString(i);
        }
        for (int i = 0; i < matriz[0].length; i++){
            matriz[0][i] = Integer.toString(i);
        }
        return matriz;
    } //LISTO

    public String[][] coordenadas(String[][] matriz){
        System.out.println("\nEje X: ");
        int ejeXcoord1 = validar.pedirNumeroLimitado(1, matriz[0].length - 1);
        System.out.println("Eje Y: ");
        int ejeYcoord1 = validar.pedirNumeroLimitado(1, matriz.length - 1);
        String carta1 = matriz[ejeYcoord1][ejeXcoord1];
        System.out.println("Carta seleccionada: [" + carta1 + "]");

        System.out.println("\nEje X: ");
        int ejeXcoord2 = validar.pedirNumeroLimitado(1, matriz[0].length - 1);
        System.out.println("Eje Y: ");
        int ejeYcoord2 = validar.pedirNumeroLimitado(1, matriz.length - 1);
        String carta2 = matriz[ejeYcoord2][ejeXcoord2];
        System.out.println("Carta seleccionada: [" + carta2 + "]");

        if (carta1.equals(carta2)) {
            System.out.println("\nCartas iguales, sigue asi!\n");
            matriz[ejeYcoord1][ejeXcoord1] = "=";
            matriz[ejeYcoord2][ejeXcoord2] = "=";
        } else {
            System.out.println("\nLas cartas no son iguales, intentalo nuevamente\n");
        }
        return matriz;
    }// MUCHAS FUNCIONES --> HACERLO MAS CORTO

    public String[][] mostrarMatriz(String[][] matriz) {
        for (String[] strings : matriz) {
            for (String string : strings) {
                System.out.print("[" + string + "]");
            }
            System.out.println();
        }
        return matriz;
    }//LISTO



    // GETTERS Y SETTERS

    public String[][] getTablero() {
        return tablero;
    }

    public String[][] getTableroAmpliado() {
        return tableroAmpliado;
    }

    public int getCantidadCartasTablero() {
        return cantidadCartasTablero;
    }
}