
public class Cronometro  {

    public Cronometro() {
    }

    public void run() {
        int minutos = 0;
        int segundo;
        for (segundo = 1; segundo < 15; segundo++) {
            System.out.println(minutos + ":" + segundo);
            delaySegundo();
        }
    }//Todo el codigo agregado en este metodo es ejecuta en el main de manera independiente y en en otro hilo

    public void temporizador(){
     for (int segundo = 3; segundo >= 1; segundo--) {
            System.out.println("Generando tablero en: " + segundo);
            delaySegundo();
        }
    }// cuenta regresiva desde el 3.

    private static void delaySegundo(){
        try{
            Thread.sleep(1000);//1000 velocidad normal
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
