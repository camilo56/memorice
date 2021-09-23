public class Launcher {
    public static void main(String[] args) {
        String tableros[][];
        MemoriceThread memorice =new MemoriceThread();

        memorice.start();// el metodo start() es para iniciar el codigo en otro hilo que este dentro del metodo run() en la clase MemoriceThread
        memorice.menu();
    }
}