
import java.util.Random;

public class Tableros {

    private Validaciones validar = new  Validaciones();

    private Random randomNum = new Random();

    private String[][] matriz;
    private String [] cartas =  {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
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
        matriz = llenarFilaColumnaExterna(matriz);
        return matriz;
    }

    public String[][] asignarCartas() {
        int cantidadCartasTotales = cantidadCartasTotalesTablero(matriz);
        String[] cantidadParCartas = generarArregloCartasPares(cantidadCartasTotales, cartas);
        int[] arregloNumerosNoRepetidos = generarArregloNumerosNoRepetidos(cantidadCartasTotales);
        String[] asignarCartasTablero = asignarCartasTableroTemporal(cantidadCartasTotales, cantidadParCartas, arregloNumerosNoRepetidos);
        matriz = llenarMatrizGlobal(asignarCartasTablero, matriz);
        return matriz;
    }

    public int cantidadCartasTotalesTablero(String[][] matriz){
        return ((matriz.length - 1) * (matriz[0].length - 1));
    }

    public String[] generarArregloCartasPares(int cantidadCartasTotales, String[] cartas){
        String[] arregloParCartas = new String[cantidadCartasTotales / 2];
        return arregloNoRepetido(arregloParCartas, cartas);
    }// genera la mitad (no repetidas) de las cartas totales del tablero

    public int[] generarArregloNumerosNoRepetidos(int cantidad){
        int[] arregloNumAleat = crearArregloInt(cantidad);
        return (numeroAleatoriosNoRepetidos(arregloNumAleat));
    }// genera arreglo int de numeros aleatorios no repetidos

    public String[] asignarCartasTableroTemporal(int cartasTotales, String[] arregloParCartas, int[] arregloNumerosAleatorios ){
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
        return  asignarCartasTablero;
    }

    public String[][] llenarMatrizGlobal(String[] asignarCartasTablero, String[][] matriz){
        int contador = 0;
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[0].length ; j++) {
                matriz[i][j] = asignarCartasTablero[contador];
                contador++;
            }
        }
        return matriz;
    }

    public int[] numeroAleatoriosNoRepetidos(int[] arreglo) {
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

    public int[] crearArregloInt(int cantidad) {
        return new int [cantidad];
    }

    public String[] arregloNoRepetido(String[] arregloCartas, String[] cartas) {
        arregloCartas[0] = cartas[randomNum.nextInt(cartas.length)];
        for (int i = 1; i <arregloCartas.length; i++) {
            arregloCartas[i] = cartas[randomNum.nextInt(cartas.length)];
            for (int j = 0; j < i; j++) {
                if(arregloCartas[i].equals(arregloCartas[j])){
                    i--;
                }
            }
        }
        return arregloCartas;
    } //BIEN

    public String[][] llenarFilaColumnaExterna(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][0] = Integer.toString(i);
        }
        for (int i = 0; i < matriz[0].length; i++){
            matriz[0][i] = Integer.toString(i);
        }
        return matriz;
    } //BIEN

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
    }// MUCHAS FUNCIONES --> HACERLO MAS CORTO

    public String[][] mostrarSimple(String[][] matriz) {
        for (String[] strings : matriz) {
            for (String string : strings) {
                System.out.print("[" + string + "]");
            }
            System.out.println();
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

    public String[] getCartas() {
        return cartas;
    }

    public void setCartas(String[] cartas) {
        this.cartas = cartas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}