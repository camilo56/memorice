public class Cronometro2 extends Thread {



    public Cronometro2() {
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
        int minutos = 0;
        int segundo = 0;


        for (segundo = 0; segundo < 15; segundo++) {
            System.out.println(minutos + ":" + segundo);
            delaySegundo();

        }

    }


    private static void delaySegundo(){
        try{Thread.sleep(0,000001);
        }catch(InterruptedException e){}
    }//1000 velocidad normal
}
