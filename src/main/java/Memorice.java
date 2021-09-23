/*vComentarios:
Entrada: nombre de jugador, selecion de opcciones del menu, seleccion de carta de juego

desarrollo:

Crear la cantidad de celdas de filas y columnas debe ser variable y la puede parametrizar el usuario, en ciertos rangos pre definidos por la App, por ej 2x5, 3x5, 2x10 y 3x10

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
import java.util.Random;
import java.util.Scanner;

public class Memorice {
    Scanner teclado = new Scanner(System.in);
    private ArrayList<Persona> personas;
    private Tableros tableros;

    public Memorice() {
        this.personas = new ArrayList<>();
        this.tableros=new Tableros();
    }


    public static String leerOpcion() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese opcion:");
        return scanner.nextLine();
    }

    public static void mostarMenu() {
        System.out.println("**********************************************************");
        System.out.println("*                      Iniciar Juego                     *");
        System.out.println("*   [a] Partida Nueva                                    *");
        System.out.println("*   [b] Cargar Partida                                   *");
        System.out.println("*   [c] Ver Estadisticas                                 *");
        System.out.println("*   [d] Configuraciones                                  *");
        System.out.println("*   [e] Creditos                                         *");
        System.out.println("*   [s] Salir                                            *");
        System.out.println("**********************************************************");
    }

    public static void menuPartidaNueva(){
        System.out.println("*********************************************************");
        System.out.println("*             Selecione nivel de dificuatad             *");
        System.out.println("*[a]facil(Columans y filas de 2X5,sin limite de tiempo) *");
        System.out.println("*[b]intermedio(tablero de 3X5,limite de tiempo moderado)*");
        System.out.println("*[c]difícil (Tablero de 2X10, Liite de tiempo corto )   *");
        System.out.println("*[d]muy difícil (Tablero de 3X10, Liite de tiempo corto)*");
        System.out.println("*[e]Experto  (Tablero de 5X10, Liite de tiempo corto )   *");
        System.out.println("*[f]                  pesonalizado                      *");
        System.out.println("*********************************************************");


    }


    public String darNick(){
        System.out.println("Ingrese un nuevo nick:");
        String nick= teclado.nextLine();
        return nick;
    }

    public  void crearPersona() {
        String nombre = darNick();
        int nCeldas=0;
        int nCasillas=0;

        Persona persona = new Persona(nombre);
        personas.add(persona);
        System.out.println("Nick Creado");

    }//Aun falta agregar contraseña y validar los datos ingresados

    public static int leerNumero() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese numero:");
        return scanner.nextInt();
    } //permite capturar el número ingresado por usuario




    public static void imprimirNumero(double numero) {
        System.out.println("El numero es: " + numero);

    }



    public static int[][] tablero() {
        Random rnum = new Random();
        int[][] arr = new int[10][10];

        for (int i = 0; i < arr.length; i++) {
            for (int j=0; j< arr[i].length;j++){
                arr[i][j]=rnum.nextInt(100)+1;
            }

        }

        return arr;
    }
    public static void imprimirNumDecimal(int numero) {
        System.out.println("El numero en decimal es: " + numero);
    } // imprime un mensaje como String, en el cual se muestra el número en


public void dificultad(){

    String option;
        while(true){
            option = leerOpcion();
            switch (option) {
                case "a":
                    int arr[][]=tablero();
                    tableros.mostrarSimple(arr);




System.out.println("wa");

                break;
            case "b":
                System.out.println("Error!");
                break;
            case "c":
                System.out.println("Error!");
                break;
            case "s":
                System.out.println("Err");

            default:
                System.out.println("La opcion ingresada es incorrecta");
        }

    }
}

public void menu(){

    String tableros[][];
    String option;
    mostarMenu();

    while(true) {
        option = leerOpcion();

        switch (option) {
            case "a":
                crearPersona();
                menuPartidaNueva();
                dificultad();

                break;
            case "b":
                System.out.println("Error!");
                break;
            case "c":
                System.out.println("Error!");
                break;
            case "s":
                System.out.println("Err");

            default:
                System.out.println("La opcion ingresada es incorrecta");
        }
    }
}//La ciclo while esta como true por efecto de comodidad par no estar abriendo
// el programa nuevamente cuando se cierra porque no ay un validados
}
