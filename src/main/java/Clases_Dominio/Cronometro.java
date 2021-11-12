package Clases_Dominio;

public class Cronometro extends Thread {

    public Cronometro() {
    }

    public void run() {
        int minutos = 0;
        int segundo = 0;
        for (segundo = 0; segundo < 10; segundo++) {
            System.out.println(minutos + ":" + segundo);
            delaySegundo();
        }
    }//Todo el codigo agregado en este metodo es ejecuta en el main de manera independiente y en en otro hilo

    public void runa(){
        int minutos = 0;
        int segundo = 0;
        for (segundo = 0; segundo < 250; segundo++) {
            System.out.println("Cargando pantalla listo en:"+minutos + ":" + segundo);
            delaySegundo();
        }
    }

    public void runa2(){
     for (int segundo = 3; segundo >= 1; segundo--) {
            System.out.println("Generando tablero en: " + segundo);
            delaySegundo();
        }
    }// cuenta regresiva desde el 3.

    private static void delaySegundo(){
        try{
            Thread.sleep(0,000001);//1000 velocidad normal
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
