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

public class MemoriceThread extends Thread {


    Scanner teclado = new Scanner(System.in);
    private ArrayList<Persona> personas;
    private Tableros tableros;

    public MemoriceThread() {
        this.personas = new ArrayList<>();
        this.tableros=new Tableros();
    }

    public static String leerOpcion() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese opcion:");
        return scanner.nextLine();
    }//listo, input usuario

    public static void mostarMenu() {
        System.out.println("***********************************************************");
        System.out.println("*                      Iniciar Juego                      *");
        System.out.println("*   [a] Partida Nueva                                     *");
        System.out.println("*   [b] Cargar Partida                                    *");
        System.out.println("*   [c] Ver Estadisticas                                  *");
        System.out.println("*   [d] Configuraciones                                   *");
        System.out.println("*   [e] Creditos                                          *");
        System.out.println("*   [s] Salir                                             *");
        System.out.println("***********************************************************");
    }//listo, muestra menu principal

    public static void menuPartidaNueva(){
        System.out.println("***********************************************************");
        System.out.println("*             Selecione nivel de dificuatad               *");
        System.out.println("*[a]facil(Tablero de 2X5,sin limite de tiempo)            *");
        System.out.println("*[b]intermedio(Tablero de 3X5,limite de tiempo moderado)  *");
        System.out.println("*[c]difícil (Tablero de 2X10, limite de tiempo corto )    *");
        System.out.println("*[d]muy difícil (Tablero de 3X10, limite de tiempo corto) *");
        System.out.println("*[e]Experto  (Tablero de 5X10, limite de tiempo corto )   *");
        System.out.println("*[f]                  pesonalizado                        *");
        System.out.println("*[s]                volver al menu                        *");
        System.out.println("***********************************************************");
    }//listo, muestra submenu de mostrarMenu() opcion "a"

    public String darNick(){
        System.out.println("Ingrese un nuevo nick:");
        return teclado.nextLine();
    }//listo, pide ingresar sobrenombre(nick) solamente

    public void crearPersona() {
        Persona persona = new Persona(darNick());
        personas.add(persona);
        System.out.println("Nick Creado");
    }//llama a darNick(). Aun falta agregar contraseña y validar los datos ingresados

    public void dificultad(){
        Scanner scanner = new Scanner(System.in);
        /* AUN NO COMPLETAMENTE FUNCIONAL
        while(true){
            opcion = leerOpcion();
            if(leerOpcion().equals(opcion)){
                Cronometro cronometro= new Cronometro();
                cronometro.runa();
            }
         */
        String opcion;
        do{
            opcion = scanner.nextLine();
            switch (opcion) {
                case "a" -> casoPartidaNuevaFacil();
                case "b" -> casoPartidaNuevaIntermedio();
                case "c" -> casoPartidaNuevaDificil();
                case "d" -> casoPartidaNuevaMuyDificil();
                case "e" -> casoPartidaNuevaExperto();
                case "f" -> casoPartidaNuevaPersonalizado();
                case "s" -> volverMenu();
                default -> System.out.println("La opcion ingresada es incorrecta");
            }
        }while(!opcion.equals("s"));
    }//Este metodo ejecuta el arrglo especifo y el cronometro especifo  de acuerdo a la difilcultad deseada
    //SE CREARON METODOS PARA CADA CASO, ESTE METODO EN ESTE PUNTO ES SOLO UN 'DIRECCIONADOR' POR DECIR ALGO

    public void casoPartidaNuevaFacil(){
        Cronometro cronometro= new Cronometro();
        String[][] matrizCartas =tableros.mostrarSimple(tableros.asignarCartas());
        int x=1;

        do{tableros.coordenadas(matrizCartas);
            cronometro.runa();
            tableros.mostrarSimple(matrizCartas);

        }while(x==1);

        System.out.println("aun falta agregar la opcion de elegir coordenadas");
    }

    public void casoPartidaNuevaIntermedio(){
        System.out.println("En desarrollo...");
    }

    public void casoPartidaNuevaDificil(){
        System.out.println("En desarrollo...");
    }

    public void casoPartidaNuevaMuyDificil(){
        System.out.println("En desarrollo...");
    }

    public void casoPartidaNuevaExperto(){
        System.out.println("En desarrollo...");
    }

    public void casoPartidaNuevaPersonalizado(){
        System.out.println("En desarrollo...");
    }

    public void volverMenu() {
        System.out.println("Volviendo a menu...");
    }

    public void menu(){
        //String tableros[][]; // no se ocupa
        String opcion;
        do {
            mostarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case "a" -> casoNuevaPartida();
                case "b" -> casoCargarPartida();
                case "c" -> casoVerEstadisticas();
                case "d" -> casoConfiguraciones();
                case "e" -> casoCreditos();
                case "s" -> casoSalir();
                default -> System.out.println("La opcion ingresada es incorrecta");
            }
        } while(!opcion.equals("s"));
    }//La ciclo while esta como true por efecto de comodidad par no estar abriendo
    // el programa nuevamente cuando se cierra porque no ay un validados
    //ARREGLE LO ANTERIOR, A CADA CASO LE ASIGNE UN METODO 'CONSTRUCTOR'

    public void casoNuevaPartida(){
        crearPersona();
        menuPartidaNueva();
        dificultad();
    }

    public void casoCargarPartida(){
        System.out.println("En desarrollo...");
    }

    public void casoVerEstadisticas(){
        System.out.println("En desarrollo...");
    }

    public void casoConfiguraciones(){
        System.out.println("En desarrollo...");
    }

    public void casoCreditos(){
        System.out.println("En desarrollo...");
    }

    public void casoSalir(){
        System.out.println("adios...");
    }

    /*
    public static String[][] tablero() {
        Random rnum = new Random();
        String[][] arr = new String[10][10];

        for (int i = 0; i < arr.length; i++) {
            for (int j=0; j< arr[i].length;j++){
                arr[i][j]="*";
            }
        }
        return arr;
    }//Actualmente no esta en uso si l van a usar por favor aclarar en este comentario


    public static void imprimirNumDecimal(int numero) {
        System.out.println("El numero en decimal es: " + numero);
    } // imprime un mensaje como String, en el cual se muestra el número en

    */ //METODOS NO USADOS, PERO PORSIBLEMENTE A USAR2
}

