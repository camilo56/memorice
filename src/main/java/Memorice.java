/*vComentarios:
Entrada: nombre de jugador, selecion de opcciones del opcionesMenuPrincipal, seleccion de carta de juego

desarrollo:

Crear la cantidad de celdas de filas y columnas debe ser variable y la puede parametrizar el usuario, en ciertos rangos pre definidos por la App, por ej 2x5, 3x4, 2x10 y 3x10

 tener modalidades de juego, ej. libre (sin restricciones de tiempo) o contra reloj (en la cual hay un tiempo acotado para jugar y depende del avance se otorga un puntaje), un versus entre 2 jugadores o vs CPU

Usando i y ii, definir niveles de establecerDificultad, por ej. fácil, intermedio, difícil, muy difícil, experto, etc...

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
import java.util.List;
import java.util.Scanner;

public class Memorice {

    private Validaciones validar = new  Validaciones();
    private List<Estadisticas> estadisticas;

    private Tableros tableros;
    private final int [][] rangosTableros = {{2, 5}, {3, 4}, {2, 10}, {3, 10}, {5, 10}};



    public Memorice() {
        this.estadisticas = new ArrayList<>();
    //    this.personas = new ArrayList<>();
        this.tableros=new Tableros();
    }

    public void mostarMenuPrincipal() {
        System.out.println("***********************************************************");
        System.out.println("*                      Iniciar Juego                      *");
        System.out.println("*   [a] Partida Nueva                                     *");
        System.out.println("*   [b] Cargar Partida                                    *");
        System.out.println("*   [c] Ver Estadisticas                                  *");
        System.out.println("*   [d] Configuraciones                                   *");
        System.out.println("*   [e] Creditos                                          *");
        System.out.println("*   [s] Salir                                             *");
        System.out.println("***********************************************************");
    }//LISTO

    public void opcionesMenuPrincipal(){
        String opcion;
        try {
            do {
                mostarMenuPrincipal();
                opcion = leerOpcion();
                switch (opcion) {
                    case "a" -> casoNuevaPartida();
                    case "b" -> mostrarString(enDesarrollo());
                    case "c" -> mostrarString(enDesarrollo());
                    case "d" -> mostrarString(enDesarrollo());
                    case "e" -> mostrarString(enDesarrollo());
                    case "s" -> mostrarString(salirDelJuego());
                    default -> System.out.println("La opcion ingresada es incorrecta");
                }
            } while(!opcion.equals("s"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }// VALIDADO

    public void mostrarMenuPartidaNueva(){
        System.out.println("***********************************************************");
        System.out.println("*             Selecione nivel de dificultad               *");
        System.out.println("*[a]facil(Tablero de 2X5,sin limite de tiempo)            *");
        System.out.println("*[b]intermedio(Tablero de 3X4,limite de tiempo moderado)  *");
        System.out.println("*[c]difícil (Tablero de 2X10, limite de tiempo corto )    *");
        System.out.println("*[d]muy difícil (Tablero de 3X10, limite de tiempo corto) *");
        System.out.println("*[e]Experto  (Tablero de 5X10, limite de tiempo corto )   *");
        System.out.println("*[f]                  pesonalizado                        *");
        System.out.println("*[s]                volver al menu                        *");
        System.out.println("***********************************************************");
    }//LISTO

    public void casoNuevaPartida(){
        try {
            Estadisticas jugador = new Estadisticas(inputScannerNextLine("Ingrese un nick "));
            estadisticas.add(jugador);
            establecerDificultad();
        }catch (Exception e){
            e.printStackTrace();
        }
    } //LISTO, quiza es necesario contar con un tipo de retorno

    public void establecerDificultad(){
        String opcion;
        try {
            do{
                mostrarMenuPartidaNueva();
                opcion = leerOpcion();
                switch (opcion) {
                    case "a" -> generarPartidaNueva(rangosTableros[0][0], rangosTableros[0][1]);//2x5
                    case "b" -> generarPartidaNueva(rangosTableros[1][0], rangosTableros[1][1]);//3x4
                    case "c" -> generarPartidaNueva(rangosTableros[2][0], rangosTableros[2][1]);//2x10
                    case "d" -> generarPartidaNueva(rangosTableros[3][0], rangosTableros[3][1]);//3x10
                    case "e" -> generarPartidaNueva(rangosTableros[4][0], rangosTableros[4][1]);//5x10
                    case "f" -> generarPartidaPersonalizada();//personalizada
                    case "s" -> mostrarString(volverMenu());//volver a opcionesMenuPrincipal
                    default -> System.out.println("La opcion ingresada es incorrecta");
                }
            }while(!opcion.equals("s"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }//VALIDADO

    public void generarPartidaNueva(int filas, int columnas){
        //Cronometro cronometro= new Cronometro();
        tableros.crearTablero(filas, columnas);
        String[][] matrizCartas = tableros.mostrarSimple(tableros.asignarCartas());
        int x = 1;
        do{
            tableros.coordenadas(matrizCartas);
            //cronometro.runa();
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
        System.out.println("\nFelicidades, has completado este nivel");
    }

    public void generarPartidaPersonalizada(){
        System.out.println("Debe ingresar filas y columnas (la multiplicaion de estas debe ser a lo mas de 52)");
        System.out.println("ingrese cantidad de filas");
        int filas = validar.pedirNumeroLimitado(1, 7);
        int columnas;
        if((filas % 2) == 0){
            System.out.println("ingrese cantidad de columnas");
            columnas = validar.pedirNumeroLimitado(1, 6);
        } else{
            System.out.println("ingrese cantidad de columnas (debe ser numero par)");
            do {
                columnas = validar.pedirNumeroLimitado(1, 6);
            }while (!((columnas % 2) == 0));
        }
        generarPartidaNueva(filas,columnas);
    }




    // INPUT

    public String leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese opcion:");
        return scanner.nextLine();
    }//INPUT DE LINEA

    public String inputScannerNextLine(String instruccion){
        Scanner scanner = new Scanner(System.in);
        System.out.println(instruccion);
        return scanner.nextLine();
    }



    // OUTPUT

    private String enDesarrollo(){
        return "En Desarrollo...";
    }

    private String volverMenu() {
        return "Volviendo al menu principal...";
    }

    private String salirDelJuego(){
        return "Adios, gracias por jugar";
    }


    // OUTPUT DE SALIDA DE VARIABLES DE TIPOS DE DATOS

    private void mostrarString(String cadena){
        System.out.println(cadena);
    }



}

