import java.util.Random;

public class Tableros {

        private String[][] matriz;
        private int cartas;
        private String nombre;

        public Tableros() {
            this.matriz = new String[10][10];
            this.cartas = 10;
            this.nombre = "";
        }


        public String[][] asignarCartas() {
            boolean[] arreglo = new boolean[100]; //asigno arreglo de 100
            String[] cartas = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            Random randomNum = new Random();


            for (int i = 0; i < arreglo.length; i++) {   //esta lleno de falsos
                arreglo[i] = false;
            }


            for (int i = 0; i < 50;) {//solo 50 de ellos de forma aleatoria van a ser verdaderos

                int auxiliar = randomNum.nextInt(arreglo.length);

                if (!arreglo[auxiliar]) {
                    arreglo[auxiliar]=true;
                    i++;
                }//asignaicon de verdaderos
            }
            int contador2=0;
            int contador3=1;
            int contador1=0;


            for (int i = 0; i < 10; i++) {
                String numero2 = Integer.toString(contador2++);
                matriz[i][0]= numero2;
            }

            for (int i = 1; i < 10; i++) {
                String numero3 = Integer.toString(contador3++);
                matriz[0][i]=numero3;
            }


            for (int i = 1; i < matriz.length; i++) {       //de los 10 valores verdaros los asigno con : en total de los 100 valores los asigno con
                for (int j = 1; j < matriz.length; j++) {
                    if (arreglo[contador1]) {
                        matriz[i][j] = cartas[randomNum.nextInt(26)];
                    } else {
                        matriz[i][j] = cartas[randomNum.nextInt(26)];;
                    }
                    contador1++;
                }
            }
            return matriz;

        }

        public void mostrarSimple(String[][] matriz) {

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print("[" + matriz[i][j] + "]");

                }
                System.out.println("");
            }
        }

        public String[][] getMatriz() {
            return matriz;
        }

        public void setMatriz(String[][] matriz) {
            this.matriz = matriz;
        }

        public int getCartas() {
            return cartas;
        }

        public void setCartas(int barcos) {
            this.cartas = barcos;
        }


        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }



    }

