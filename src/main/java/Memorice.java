
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Memorice {
    Scanner teclado = new Scanner(System.in);
    private ArrayList<Persona> personas;

    public Memorice() {
        this.personas = new ArrayList<>();
    }


    public static String leerOpcion() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese opcion:");
        return scanner.nextLine();
    }

    public static void mostarMenu() {
                    System.out.println("*********************************************************\n░░▄███▄███▄\n" +
                                                                                               "░░█████████\n" +
                                                                                               "░░▒▀█████▀░\n" +
                                                                                               "░░▒░░▀█▀\n" +
                                                                                               "░░▒░░█░\n" +
                                                                                               "░░▒░█\n" +
                                                                                               "░░░█\n" +
                                                                                               "░░█░░░░███████\n" +
                                                                                               "░██░░░██▓▓███▓██▒\n" +
                                                                                               "██░░░█▓▓▓▓▓▓▓█▓████\n" +
                                                                                               "██░░██▓▓▓(◐)▓█▓█▓█\n" +
                                                                                               "███▓▓▓█▓▓▓▓▓█▓█▓▓▓▓█\n" +
                                                                                               "▀██▓▓█░██▓▓▓▓██▓▓▓▓▓█\n" +
                                                                                               "░▀██▀░░█▓▓▓▓▓▓▓▓▓▓▓▓▓█\n" +
                                                                                               "░░░░▒░░░█▓▓▓▓▓█▓▓▓▓▓▓█\n" +
                                                                                               "░░░░▒░░░█▓▓▓▓█▓█▓▓▓▓▓█\n" +
                                                                                               "░▒░░▒░░░█▓▓▓█▓▓▓█▓▓▓▓█\n" +
                                                                                               "░▒░░▒░░░█▓▓▓█░░░█▓▓▓█\n" +
                                                                                              "░▒░░▒░░██▓██░░░██▓▓██\n" +
                                                                                              "██████████████████████████\n"+
                                                                                              "██  ████  █ ███ █  ████  █\n" +
                                                                                              "███ █  █ ████ ████ █  █ ██\n" +
                                                                                              "███ ████ ██ ███ ██ ████ ██\n" +
                                                                                              "██████████████████████████\n");

        System.out.println("**********************************************************");
        System.out.println("*                      Iniciar Juego                     *");
        System.out.println("*   [a] Partida Nueva                                    *");
        System.out.println("*   [b] Cargar Partida                                   *");
        System.out.println("*   [c] Ver Estadisticas                                 *");
        System.out.println("*   [d] Configuraciones                                  *");
        System.out.println("*   [d] Creditos                                         *");
        System.out.println("*   [s] Salir                                            *");
        System.out.println("**********************************************************");
    }

    public String darNick(){
        System.out.println(" nick:");
        String nick= teclado.nextLine();
        return nick;
    }

    public void crearPersona() {
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


    // simular el ingreso de datos con valores aleatorios entre 0.0 y 9.9 y retorna el arreglo.

    public static void imprimirNumero(double numero) {
        System.out.println("El numero es: " + numero);

    }



    public static double[] crearArreglo() {
        Random rnum = new Random();

        double[] arr = new double[70];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnum.nextDouble();

        }
        return arr;
    }
    public static void imprimirNumDecimal(int numero) {
        System.out.println("El numero en decimal es: " + numero);
    } // imprime un mensaje como String, en el cual se muestra el número en


public void menu(){
    while(true) {

        mostarMenu();
        var option = leerOpcion();

        switch (option) {
            case "a":
                crearPersona();
                break;
            case "b":
                System.out.println("Error!");
                break;
            case "c":
                System.out.println("Error!");
                break;
            case "s":
return;
            default:
                System.out.println("La opcion ingresada es incorrecta");
        }
    }



}








}
