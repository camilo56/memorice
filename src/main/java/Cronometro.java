public class Cronometro {

    public Cronometro() {
    }

    public void run() {

        int minutos = 0;
        int segundo = 0;


        for (segundo = 0; segundo < 60; segundo++) {
            System.out.println(minutos + ":" + segundo);
            delaySegundo();

        }


    }//Todo el codigo agregado en este metodo es ejecuta en el main de manera independiente y en en otro hilo




    private static void delaySegundo(){
        try{Thread.sleep(1000);
        }catch(InterruptedException e){}
    }
}
