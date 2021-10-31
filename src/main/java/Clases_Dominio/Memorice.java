package Clases_Dominio;

/*

MEJORAS DEL AVANCE 1 (RETROALIMENTACION)
i. el diseño inicial de las clases mostrado en el reporte es muy confuso y uds. lo reconocen al final del documento, que requiere un re diseño, arovechen ahora lo de UML y POO para re ordenar esta propuesta pensando en informe 2

ii. ojo! con las buenas prácticas a la hora de definir la cantidad de parámetros de entrada, hay métodos con hasta 3 parámetros y de tipos arreglos!

iii. los test debieran "exigir un poco más", los casos de prueba debieran ir al límite del sistema y ver como se comporta éste.

REQUISITOS AVANCE 2
- incorporar las consideraciones y correcciones del informe 01 (indicar qué cambia y cómo afecta en el desarrollo de la solución)

- diferencias entre la planificación inicial y el resultado final ¿por qué? ¿qué medidas se tomaron? ¿nueva planificación?
- descripción de las clases que forman de su proyecto, que considera:
  a. descripción atributos: nombre, tipo y nivel de encapsulamiento.
  b. descripción de métodos: nombre, tipo de retorno y nivel de encapsulamiento
(considere el uso de herramientas de apoyo en la documentación)

- modelo UML de las clases de su dominio problema, ponga énfasis en las relaciones entre éstas (dependencia, asociación, composición, agregación, así como los roles y multiplicidades). Esto considera el uso de herramientas CASE, p.ej. Visual Paradigm (no hacer diagramas "a mano"!!!!)

- definición y diseño de todas las GUIs con herramientas moqups o JFrame de su proyecto: a partir del avance logrado, refinar el diseño de GUIs.

a. establecer un mapa de navegación entre las diferentes GUIs

b. decir para que sirve y que hace cada GUI

- definición de la gestión de datos que hará su programa: a partir del avance logrado, refinar la definición de datos a usar o almacenar por sus sistema.

a. archivos a usar por su aplicación (XLS, TXT, XML, JSON, etc...)

b. datos que se almacenarán en su archivo (tipos de datos de cada columna), estructura del archivo (que almacenará en cada columna y que representan)
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Memorice {

    private Validaciones validar = new  Validaciones();
    private List<Estadisticas> estadisticas;
    private Estadisticas jugador;

    private Tablero tableros;
    private final int [][] rangosTableros = {{2, 5}, {3, 4}, {2, 10}, {3, 10}, {5, 10}};



    public Memorice() {
        this.estadisticas = new ArrayList<>();
        this.tableros=new Tablero();
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
            jugador = new Estadisticas(inputScannerNextLine("Ingrese un nick "));
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
        String[][] tablero = tableros.generarTablero(filas, columnas);
        int x = 1;
        System.out.println("Ingrese las coordenadas de las cartas que quiera (segun ejes X y Y)");
        do{
            tableros.mostrarMatriz(tablero);
            tableros.coordenadas(tablero);
            //cronometro.runa();
            for (int i = 1; i < tablero.length; i++) {
                for (int j = 1; j < tablero[0].length; j++) {
                    if(tablero[i][j].equals("=")){
                        x = 0;
                    }else{
                        x = 1;
                        break;
                    }
                }
            }
        } while(x==1);
        System.out.println("\nFelicidades, has completado este nivel\n");
        actualizarEstadisticas(12);
    }

    public boolean actualizarEstadisticas(Integer puntaje){

        try {
            jugador.setVecesJugadas(jugador.getVecesJugadas() + 1);
            jugador.ingresarPuntaje(puntaje);
            jugador.guardarEstadisticas();
            estadisticas.add(jugador);
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar datos");
            e.printStackTrace();
            return false;
        }
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

