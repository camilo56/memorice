import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

    private final String ruta = "src/main/resources/Jugadores.txt";
    private final File archivo = new File(ruta);
    private String valor = "";


    public Archivo(){

    }

    private void crearArchivo(){

        try {
            boolean b = archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo(){

        if(!archivo.exists()){
            crearArchivo();
        }try {
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(valor);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setValor(String valor) {

        this.valor = valor;
    }

    public File getArchivo() {
        return archivo;
    }

}