/* Esta clase

* */




import java.util.Random;
import java.util.Scanner;

public class Tableros {
    Random randomNum = new Random();
    private String[][] matriz;
    private int coordenadas;
    private int cartas;
    private String nombre;

    public Tableros() {
        this.matriz = new String[10][10];
        this.cartas = 10;
        this.nombre = "";
        this.coordenadas = coordenadas;
    }




    public String[][] asignarCartas() {
        boolean[] arreglo = new boolean[100]; //asigno arreglo de 100
        String[] cartas = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        boolean arregloFalsos[] = llenadoFalsos(arreglo);
        asignacionVerdaderos(arregloFalsos);
        filaExternas(matriz,true);
        filaExternas(matriz,false);

        int contador = 0;

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz.length; j++) {
                if (arreglo[contador]) {
                    matriz[i][j] = cartas[randomNum.nextInt(26)];
                } else {
                    matriz[i][j] = cartas[randomNum.nextInt(26)];
                }
                contador++;
            }
        }
        return matriz;

    }//de los 50 valores verdaros los asigno con una letra aleatoria del alfabeto pronto agregare caracteres ascii.

    public boolean[] llenadoFalsos(boolean arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = false;
        }
        return arreglo;
    }

    public boolean[] asignacionVerdaderos(boolean arreglo[]) {
        for (int i = 0; i < 50; ) {

            int auxiliar = randomNum.nextInt(arreglo.length);

            if (!arreglo[auxiliar]) {
                arreglo[auxiliar] = true;
                i++;
            }
        }

        return arreglo;
    }//solo 50 de ellos de forma aleatoria van a ser verdaderos


    public String[][] mostrarSimple(String[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
        return matriz;
    }

    public String[][] filaExternas(String[][] matriz,boolean valor) {
        int contador = 0;

        for (int i = 0; i < 10; i++) {
            if (valor == true) {
                String numero = Integer.toString(contador++);
                matriz[i][0] = numero;
            }else{
                String numero = Integer.toString(contador++);
                matriz[0][i] = numero;
                    }
        }
        return matriz;
    }//Ingreso de los valores de las coordenadas tanto de la fila externa como la columna externa.

    public String[][] coordenadas(String[][] matriz){
        Scanner teclado =new Scanner(System.in);
        System.out.println("ingrese las coordenas1 x");
        int coordenadas1_1 = teclado.nextInt();
        System.out.println("ingrese las coordenas1 y");
        int coordenadas2_1 = teclado.nextInt();

        String valorCoordenadas1=matriz[coordenadas2_1][coordenadas1_1];
        System.out.println(valorCoordenadas1);

        System.out.println("ingrese las coordenas2 x");
        int coordenadas1_2 = teclado.nextInt();
        System.out.println("ingrese las coordenas2 y");
        int coordenadas2_2 = teclado.nextInt();

        String valorCoordenadas2=matriz[coordenadas2_2][coordenadas1_2];
        System.out.println(valorCoordenadas2);

        if(valorCoordenadas1.equals(valorCoordenadas2)){
            matriz[coordenadas2_1][coordenadas1_1]="=";
            matriz[coordenadas2_2][coordenadas1_2]="=";
        }

        return matriz;
    }







    public Random getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(Random randomNum) {
        this.randomNum = randomNum;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public int getCartas() {
        return cartas;
    }

    public void setCartas(int cartas) {
        this.cartas = cartas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}