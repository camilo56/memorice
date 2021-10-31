/*vComentarios:
Entrada: nombre de jugador, selecion de opcciones del menu, seleccion de carta de juego

desarrollo:

Crear la cantidad de celdas de filas y columnas debe ser variable y la puede parametrizar el usuario, en ciertos rangos pre definidos por la App, por ej 2x5, 3x4, 2x10 y 3x10

 tener modalidades de juego, ej. libre (sin restricciones de tiempo) o contra reloj (en la cual hay un tiempo acotado para jugar y depende del avance se otorga un puntaje), un versus entre 2 jugadores o vs CPU

Usando i y ii, definir niveles de dificultad, por ej. fácil, intermedio, difícil, muy difícil, experto, etc...

iii. deben poder crearse perfiles de jugador, que almacenen los datos, por ej con al menos un nombre y nick para asociarlo a sus puntajes, estadísticas (veces que ha jugado, niveles que ha jugado, etc...)
 y algunas preferencias, como por ej. el tipo de imágenes para las "cartas"

 salidas:
 estadisticas,
 Puntajes:veces que ha jugado, niveles que ha jugado, etc...) y algunas preferencias, como por ej. el tipo de imágenes para las "cartas".
 menus:nivel de difilcutad, opcines a elegir,modalidades de juego, ej. libre (sin restricciones de tiempo) o contra reloj (en la cual hay
 un tiempo acotado para jugar y depende del avance se otorga un puntaje),un versus entre 2 jugadores o vs CPU.
  celdas de filas y columnas

estoy solo, no es divertido estar solo T_T.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Memorice {

    private Validaciones validar = new  Validaciones();
    private ArrayList<Persona> personas;
    private Tableros tableros;
    private Persona persona=new Persona();



    public Memorice() {
        this.personas = new ArrayList<>();
        this.tableros=new Tableros();
    }

    public void menu(){
        String opcion;
        try {
            do {
                mostarMenu();
                opcion = leerOpcion();
                switch (opcion) {
                    case "a" -> casoNuevaPartida();
                    case "b" -> Estadisticas();
                    case "s" -> casoSalir();
                    default -> System.out.println("La opcion ingresada es incorrecta");
                }
            } while(!opcion.equals("s"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void Estadisticas() {
        System.out.println(personas.toString());

    }

    public static String leerOpcion() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese opcion:");
        return scanner.nextLine();
    }

    public static void mostarMenu() {
        System.out.println("***********************************************************");
        System.out.println("*                      Iniciar Juego                      *");
        System.out.println("*   [a] Partida Nueva                                     *");
        System.out.println("*   [b] Ver Estadisticas                                  *");
        System.out.println("*   [s] Salir                                             *");
        System.out.println("***********************************************************");
    }//listo, muestra menu principal

    public static void menuPartidaNueva(){
        System.out.println("***********************************************************");
        System.out.println("*             Selecione nivel de dificuatad               *");
        System.out.println("*[a]facil(Tablero de 2X5,sin limite de tiempo)            *");
        System.out.println("*[b]intermedio(Tablero de 3X4,limite de tiempo moderado)  *");
        System.out.println("*[c]difícil (Tablero de 2X10, limite de tiempo corto )    *");
        System.out.println("*[d]muy difícil (Tablero de 3X10, limite de tiempo corto) *");
        System.out.println("*[e]Experto  (Tablero de 5X10, limite de tiempo corto )   *");
        System.out.println("*[f]                  pesonalizado                        *");
        System.out.println("*[s]                volver al menu                        *");
        System.out.println("***********************************************************");
    }//listo, muestra submenu de mostrarMenu() opcion "a"

    public static String darNick(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un nuevo nick:");
        return scanner.nextLine();
    }//listo, pide ingresar sobrenombre(nick) solamente

        public boolean crearPersona(int puntos,int nVeces) {
        String numCadena= String.valueOf(puntos);
        String numNveces= String.valueOf(nVeces);
        try {
            Persona persona = new Persona(darNick(),numCadena,numNveces);
            personas.add(persona);
            System.out.println("Nick Creado");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void casoNuevaPartida(){
        try {
            dificultad();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void  dificultad(){
        Scanner scanner = new Scanner(System.in);
        Archivo archivo = new Archivo();
        String opcion = "";
        int puntaje = 0;
        int nVeces =0;
        int[][] MxN = arregloMxN();
        try {
            do{
            menuPartidaNueva();
                opcion = scanner.nextLine();
                switch (opcion) {
                    case "a" -> {

                        //generarPartidaNueva(MxN[0][0], MxN[0][1]);
                        nVeces++;
                        puntaje ++;
                        //2x10
                    }//2x5 1 punto incial va aumentando de dos en dos
                    case "b" -> {
                        //generarPartidaNueva(MxN[1][0], MxN[1][1]);
                        nVeces++;
                        puntaje+=2;
                    }//3x4 2 puntos incial va aumentando de dos en dos
                    case "c" -> {
                        //generarPartidaNueva(MxN[2][0], MxN[2][1]);
                        nVeces++;
                        puntaje+=3;
                    }//2x10
                    case "d" -> {
                        generarPartidaNueva(MxN[3][0], MxN[3][1]);
                        nVeces++;
                        puntaje+=4;
                    }//3x10
                    case "e" -> {
                        generarPartidaNueva(MxN[4][0], MxN[4][1]);
                        nVeces++;
                        puntaje+=5;
                    }//5x10
                    case "f" -> generarPartidaPersonalizada();//personalizada
                    case "s" -> volverMenu();//volver a menu
                    default -> System.out.println("La opcion ingresada es incorrecta");


                }

                System.out.println("Puntaje actual"+puntaje);

            }while(!opcion.equals("s"));

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Total PUNTAJE:\n"+puntaje+"\n");

        crearPersona(puntaje,nVeces);

        archivo.setValor(toString());
        archivo.escribirArchivo();

    }

    public static int [][] arregloMxN(){
        return new int[][]{{2, 5}, {3, 4}, {2, 10}, {3, 10}, {5, 10}};
    }

    public void generarPartidaNueva(int filas, int columnas){
        Cronometro cronometro= new Cronometro();
        tableros.crearTablero(filas, columnas);
        String[][] matrizCartas =tableros.mostrarSimple(tableros.asignarCartas());
        int x = 1;
        do{
            tableros.coordenadas(matrizCartas);
            cronometro.temporizador();
            tableros.mostrarSimple(matrizCartas);
            for (int i = 1; i < matrizCartas.length; i++) {
                for (int j = 1; j < matrizCartas[0].length; j++) {
                    if(matrizCartas[i][j].equals("=")){
                        x = 0;
                    }else{
                        x = 1;
                        break;
                    }
                }
            }
        } while(x==1);
        System.out.println("Felicidades, has completado este nivel");
    }

    public void generarPartidaPersonalizada(){
        System.out.println("ingrese cantidad de filas");
        int filas = validar.pedirNumeroLimitado(1, 10);
        int columnas;
        if((filas % 2) == 0){
            System.out.println("ingrese cantidad de columnas");
            columnas = validar.pedirNumeroLimitado(1, 10);
        } else{
            System.out.println("ingrese cantidad de columnas (debe ser numero par)");
            do {
                columnas = validar.pedirNumeroLimitado(1, 10);
            }while (!((columnas % 2) == 0));
        }
        generarPartidaNueva(filas,columnas);
    }

    private static void desarrollo(){
        System.out.println("En desarrollo...");
    }

    private static void casoSalir(){
        System.out.println("adios...");
    }

    private static void volverMenu() {
        System.out.println("Volviendo a menu...");
    }
    @Override
    public String toString() {

        StringBuilder archivoGuardado = new StringBuilder();

        for (Persona contacto : personas) {
            archivoGuardado.append(contacto.toString());
        }
        return archivoGuardado.toString();
    }
}
