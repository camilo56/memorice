import java.util.Random;

public class Tableros {

        private int[][] matriz;
        private int cartas;
        private boolean enemigo;
        private String nombre;

        public Tableros() {
            this.matriz = new int[10][10];
            this.cartas = 10;
            this.nombre = "";
        }


        public void asignarCartas() {
            boolean[] arreglo = new boolean[100]; //asigno arreglo de 100

            Random rnum = new Random();

            for (int i = 0; i < arreglo.length; i++) {   //esta lleno de falsos
                arreglo[i] = false;
            }


            for (int i = 0; i < 10;) {                  //solo 10 de ellos de forma aleatoria van a ser verdaderos
                int aux = rnum.nextInt(arreglo.length);
                if (!arreglo[aux]) {
                    arreglo[aux]=true;
                    i++;
                }
            }
            int contador = 0;
            for (int i = 0; i < matriz.length; i++) {       //de los 10 valores verdaros los asigno con 1: en total de los 100 valores los asigno con 0 y 1
                for (int j = 0; j < matriz.length; j++) {
                    if (arreglo[contador]) {
                        matriz[i][j] = 1;
                    } else {
                        matriz[i][j] = 0;
                    }
                    contador++;
                }
            }

        }

        public void mostrarSimple(int[][] matriz) {

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print("[" + matriz[i][j] + "]");

                }
                System.out.println("");
            }
        }

        public int[][] getMatriz() {
            return matriz;
        }

        public void setMatriz(int[][] matriz) {
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

