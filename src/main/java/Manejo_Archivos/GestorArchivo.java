package Manejo_Archivos;

import java.io.*;
import java.util.Scanner;

public class GestorArchivo {


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
    }

    public boolean existeArchivo(String ruta){
        File archivo = new File(ruta);
        if(!ruta.equals(".")) {
            return archivo.exists();
        }else{
            return false;
        }
    }

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
    }

    public String[] obtenerLineasArchivo(String ruta){
        String[] lineasDatos = new String[cantidadLineasArchivo(ruta)];
        try {
            Scanner scanner = new Scanner(new File(ruta));
            int contador = 0;
            while (scanner.hasNextLine()){
                lineasDatos[contador] = scanner.nextLine();
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("archivo no encontrado");
        }
        return lineasDatos;
    }

    public boolean renombrarArchivo(String rutaActual, String rutaNueva){
        File archivoActual = new File(rutaActual);
        File archivoNuevo = new File(rutaNueva);
        if(existeArchivo(rutaActual) && !existeArchivo(rutaNueva)){
            archivoActual.renameTo(archivoNuevo);
            return archivoActual.getName().equals(rutaNueva);
        }else{
            return false;
        }
    }

    public boolean escribirEnArchivo(String ruta, String datos){
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
    }

    public boolean reEscribirArchivo(String ruta, String datos) {
        File archivo = new File(ruta);
        if (existeArchivo(ruta)) {
            try {
                FileWriter escribir = new FileWriter(archivo);
                escribir.write(datos);
                escribir.close();
                return true;
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error.");
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

    }

    public int cantidadLineasArchivo(String ruta){
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            return (int) br.lines().count();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

