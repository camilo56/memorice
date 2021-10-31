package Manejo_Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorArchivo {

    //SE CREARON MÉTODOS BOOLEANOS PARA CONFIRMAR SI LO QUE HACE CADA MÉTODO SE REALIZO CON ÉXITO

    public boolean crearArchivo(String ruta){
        File archivoNuevo = new File(ruta);
        if(!archivoNuevo.exists()){
            try {
                archivoNuevo.createNewFile();
                System.out.println("Archivo creado.");
                return true;
            } catch (IOException e) {
                System.out.println("El archivo no pudo ser creado.");
                e.printStackTrace();
                return false;
            }
        }else{
            System.out.println("Error, archivo ya existe.");
            return false;
        }
    }//CREA ARCHIVO(confirma si se creo, o no -> por algún error o si ya existe)

    public boolean existeArchivo(String ruta){
        File archivo = new File(ruta);
        if(!ruta.equals(".")) {
            return archivo.exists();
        }else{
            return false;
        }
    }//VERIFICA SI EXISTE EL ARCHIVO

    public boolean mostrarArchivo(String ruta){
        try {
            Scanner scanner = new Scanner(new File(ruta));
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("archivo no encontrado");
            return false;
        }
    }//LEE EL ARCHIVO LINEA POR LINA(confirma si se puede leer)

    public boolean renombrarArchivo(String rutaActual, String rutaNueva){
        File archivoActual = new File(rutaActual);
        File archivoNuevo = new File(rutaNueva);
        if(existeArchivo(rutaActual) && !existeArchivo(rutaNueva)){
            archivoActual.renameTo(archivoNuevo);
            return archivoActual.getName().equals(rutaNueva);
        }else{
            return false;
        }
    }//RENOMBRA ARCHIVO, cambia rutaActual por rutaNueva

    public boolean escribirEnArchivo(String ruta, String datos){
        Scanner scanner = new Scanner(System.in);
        File archivo = new File(ruta);
        if(existeArchivo(ruta)){
            try {
                FileWriter escribir = new FileWriter(archivo.getAbsoluteFile(),true);
                if(archivo.length() == 0){
                    escribir.write(datos);
                }else{
                    escribir.write("\n" + datos);
                }
                escribir.close();
                return true;
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error.");
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
    }//ESCRIBE EN ARCHIVO (agrega lineas según las lineas que contenga el archivo)
}

