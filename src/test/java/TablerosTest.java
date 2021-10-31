
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TablerosTest {

    Tableros tablero = new Tableros();

    @Test
    public void testCrearTablero(){
        int filas = 51;
        int columnas = 23;

        String[][] esperado = new String[filas + 1][columnas + 1];
        esperado = tablero.llenarFilaColumnaExterna(esperado);

        assertArrayEquals(esperado, tablero.crearTablero(filas, columnas));
    }// crea una matriz de (filas + 1) * (columnas + 1), (el "+ 1" es para
    //  crear indices para acceder a matriz)

    @Test
    public void testCantidadCartasTotalesTablero(){
        String[][] matriz = new String [10][12];
        int esperado = 9 * 11;
        assertEquals(esperado, tablero.canTotalTablero(matriz));
    }// metodo que devuelve (filas - 1) * (columnas -1)

    @Test
    public void testGenerarArregloCartasPares(){
        String [] cartas =  {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int cartasTotales = 52;
        boolean verificar = true;
        String[] cartasNoRepetidas = tablero.generarCartasPares(cartasTotales, cartas);

        for (int i = 0; i < cartasNoRepetidas.length; i++) {
            for (int j = 0; j < i; j++) {
                if(cartasNoRepetidas[i].equals(cartasNoRepetidas[j])){
                    verificar = false;
                    break;
                }
            }
        }
        assertTrue(verificar);
    }// ES SOLO UN CONSTRUCTOR, crea un arreglo y llama a otro metodo para llenarlo
    //  (genera arreglo aleatorio de largo N donde todas las cartas son diferentes)

    @Test
    public void testGenerarArregloNumerosNoRepetidos(){
        int cantidad = 845;
        boolean verificar = true;
        int[] arreglo =tablero.generarNumNoRepetidos(cantidad);

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arreglo[i] == arreglo[j]) {
                    verificar = false;
                    break;
                }
            }
        }
        assertTrue(verificar);
    }// ES SOLO UN "CONSTRUCTOR", llama a un metodo para crear arreglo, luego
    //  llama a otro para llenarlo de numeros aleatorios no repetidos
    //  (dado un arreglo de largo N, lo llena llamando a otro metosdo y lo
    //  devulve)

    @Test
    public void testNumeroAleatoriosNoRepetidos(){
        int[] arreglo = new int [10000];
        arreglo = tablero.numRandomNoRepetidos(arreglo);

        boolean verificar = true;
        for (int i = 0; i <arreglo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arreglo[i] == arreglo[j]) {
                    verificar = false;
                    break;
                }
            }
        }
        assertTrue(verificar);
    }// genera un arreglo de largo N con numeros no repetidos desde 0 a N

    @Test
    public void testGenerarArregloInt(){
        int largo = 100;
        assertArrayEquals(new int[largo], tablero.crearArregloInt(largo));
    }

    @Test
    public void testArregloNoRepetido(){
        String[] arreglo = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String[] nuevoArreglo = new String[arreglo.length];
        nuevoArreglo = tablero.NoRepetido(nuevoArreglo, arreglo);

        boolean verficar = true;
        for (int i = 0; i < arreglo.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (nuevoArreglo[i].equals(nuevoArreglo[j])) {
                    verficar = false;
                    break;
                }
            }
        }
        assertTrue(verficar);
    }// el metodo (al cual se le hace UT) recibe un arregloString1 de las posibles
    //  string, y un arregloString2 (no mayor a el largo del arreglo string), luego este
    //  metodo genera string aleatorios del arregloString1 (con el objetivo de
    //  que esten desordenados), los guarda en arregloString2 y verifica que no
    //  se repitan

    @Test
    public void testLlenarFilaColumnaExterna(){
        String[][] matriz = new String[496][412];
        matriz = tablero.llenarFilaColumnaExterna(matriz);

        boolean verificar = true;
        for (int i = 0; i < matriz.length; i++) {
            if(!matriz[i][0].equals(Integer.toString(i))){
                verificar = false;
            }
            for (int j = 0; j < matriz[i].length; j++) {
                if(!matriz[0][j].equals(Integer.toString(j))){
                    verificar = false;
                }
            }
        }
        assertTrue(verificar);
    }// este metodo recibe un arregloBiDimenString, llena la primera fila con numeros
    //  numeros desde el 0 hasta el largo de la fila en orden ascendente
    //  realiza lo mismo con la su primera columna

}