package Clases_Dominio;

import java.util.Scanner;

public class Validaciones {

    public int pedirNumero(){
        Scanner teclado = new Scanner(System.in);
        int numero;
        do {
            try {
                numero = teclado.nextInt();
                break;
            } catch (Exception e){
                System.out.println("Indique un número y/o carácter válido");
                teclado.nextLine();
            }
        } while (true);
        return  numero;
    } // PIDE INPUT DE UN NUMERO, ESTA VALIDADO

    public int pedirNumeroLimitado(int min, int max){
        //System.out.println("Indique un numero (entre: " + min + " y " + max + ")");
        int num;
        do {
            num = pedirNumero();
            if(!limitesNumero(num, min, max)){
                System.out.println("Indique un número y/o carácter válido");
            }
        } while (!limitesNumero(num, min, max));
        return num;
    }// PIDE INPUT DE UN NUMERO, LLAMANDO A
    //"pedirNumero()" PERO ESTE LIMITADO ENTRE DOS NUMEROS(LLAMANDO A "limitesNumero(min, max);")
    // ESTA VALIDADO

    public boolean limitesNumero(int num, int min ,int max) {
        return (min <= num && num <= max);
    }
    //RETORNA true O false SI EL NUMERO SE ENCUENTRA ENTRE "max" Y "min"
}
