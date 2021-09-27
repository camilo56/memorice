import java.util.Scanner;

public class Validaciones {


    public static int leerNumero() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese numero:");
        return scanner.nextInt();
    } //permite capturar el número ingresado por usuario


    public static void imprimirNumero(double numero) {
        System.out.println("El numero es: " + numero);
    }
}
