
import java.util.Random;
import java.util.Scanner;

public class Tableros {

    Validaciones validar = new  Validaciones();

    private Random randomNum = new Random();

    private String[][] matriz;
    private int coordenadas;
    private int cartas;
    private String nombre;

    public Tableros() {
        /*
        this.cartas = 10;
        this.nombre = "";
        this.coordenadas = coordenadas;
        */
    } // NO OCUPADO ACTUALMENTE

    public String[][] crearTablero(int fila, int columna){
        this.matriz = new String[fila + 1][columna + 1];// mas 1 para poder colocar referencias (eje X, eje Y)
        matriz = llenarFilaColumnaExterna();
        return matriz;
    }

    public String[][] asignarCartas() {
        String[] cartas = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int cantidadParCartas = ((matriz.length - 1) * (matriz[0].length - 1)) / 2; //Esto considera un "par de cartas" se le resta uno ya que no se consideran fila y columna externa
        int cartasTotales = cantidadParCartas * 2;

        String [] arregloParCartas = new String[cantidadParCartas] ; // HACE QUE NO SE REPITAN LAS CARTAS EN EL ARREGLO DE LA MITAD DE LAS CARTAS TOTALES
        arregloParCartas = generarArregloNoRepetido(arregloParCartas, cartas);

        int[] arregloNumerosAleatorios = generarArregloInt(cartasTotales);
        arregloNumerosAleatorios = generarNumeroAleatoriosNoRepetidos(arregloNumerosAleatorios);

        int k = 0;
        String[] asignarCartasTablero = new String[cartasTotales];
        for (int i = 0; i < cartasTotales; i++) {
            if(i < arregloParCartas.length){
                asignarCartasTablero[arregloNumerosAleatorios[i]] = arregloParCartas[i];
            }else{
                asignarCartasTablero[arregloNumerosAleatorios[i]] = arregloParCartas[k];
                k++;
            }
        }

        int contador = 0;
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length ; j++) {
                matriz[i][j] = asignarCartasTablero[contador];
                contador++;
            }
        }
        return matriz;
    }

    public int[] generarNumeroAleatoriosNoRepetidos(int[] arreglo) {
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
    }

    public int[] generarArregloInt(int cantidad) {
        return new int [cantidad];
    }

    public String [] generarArregloString(int cantidad){
        return new String [cantidad];
    }

    public String[] generarArregloNoRepetido(String[] arregloCartas, String[] cartas) {
        arregloCartas[0] = cartas[randomNum.nextInt(cartas.length)];
        for (int i = 1; i <arregloCartas.length; i++) {
            arregloCartas[i] = cartas[randomNum.nextInt(cartas.length)];
            for (int j = 0; j < i; j++) {
                if(arregloCartas[i] == arregloCartas[j]){
                    i--;
                }
            }
        }
        return arregloCartas;
    } //BIEN

    public String[][] llenarFilaColumnaExterna(){
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][0] = Integer.toString(i);
        }
        for (int i = 0; i < matriz[0].length; i++){
            matriz[0][i] = Integer.toString(i);
        }
        return matriz;
    } //BIEN

    public String[][] mostrarSimple(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
        return matriz;
    }

    public String[][] coordenadas(String[][] matriz){

        System.out.println("ingrese las coordenas1 x");
        int coordenadas1_1 = validar.pedirNumeroLimitado(1,matriz[0].length - 1);
        System.out.println("ingrese las coordenas1 y");
        int coordenadas2_1 = validar.pedirNumeroLimitado(1, matriz.length - 1);

        String valorCoordenadas1=matriz[coordenadas2_1][coordenadas1_1];
        System.out.println(valorCoordenadas1);

        System.out.println("ingrese las coordenas2 x");
        int coordenadas1_2 = validar.pedirNumeroLimitado(1,matriz[0].length - 1);
        System.out.println("ingrese las coordenas2 y");
        int coordenadas2_2 = validar.pedirNumeroLimitado(1, matriz.length - 1);

        String valorCoordenadas2=matriz[coordenadas2_2][coordenadas1_2];
        System.out.println(valorCoordenadas2);

        if(valorCoordenadas1.equals(valorCoordenadas2)){
            matriz[coordenadas2_1][coordenadas1_1]="=";
            matriz[coordenadas2_2][coordenadas1_2]="=";
        }
        return matriz;
    }// MUCHAS FUNCIONES --> HACERLO MAS CORTO Y FUNCIONAL (SE CAE CUANDO INPUT != NUMERO)
    //ARREGLE EL PROBLEMA DEL INPUT






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