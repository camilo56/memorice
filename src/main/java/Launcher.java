public class Launcher {
    public static void main(String[] args) {
        String tableros[][];
        MemoriceThread memorice =new MemoriceThread();
        Cronometro cronometro = new Cronometro();
        memorice.menu();
        cronometro.start();




    }
}