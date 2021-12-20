package Clases_Dominio;

import Manejo_Archivos.GestorArchivo;

public class Datos {

    private final GestorArchivo gestorArchivo = new GestorArchivo();

    private String datosJugador;
    private String rutaArchivo = "src/main/java/Datos/EstadisticasJugadores.csv";
    private String nombresColumnas = "Nick;Id Partida;Dificultad;Puntaje;Tiempo";

    public void crearJugador(String nick, String dificultad, int puntaje, String tiempo) {
        Jugador jugador = new Jugador(nick,dificultad,puntaje,tiempo);
        jugador.setIdPartida(1);
        //int i = buscarIdPartida();
        datosJugador = jugador.generarDatos();
        guardarDatosJugador();
    }
    /*
    private int buscarIdPartida() {
        GestorArchivo gestorArchivo = new GestorArchivo();
        String datos = gestorArchivo.obtenerLineasArchivo(rutaArchivo);
        for (int i = 0; i < ; i++) {

        }

    }
    private String nick;
    private int idPartida = 0;
    private String dificultad;
    private int puntaje;
    private String tiempo;

     */

    public boolean guardarDatosJugador() {
        try {
            if(!gestorArchivo.existeArchivo(rutaArchivo)){
                gestorArchivo.crearArchivo(rutaArchivo);
                gestorArchivo.escribirEnArchivo(rutaArchivo,nombresColumnas);
            }
            gestorArchivo.escribirEnArchivo(rutaArchivo, datosJugador);
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar datos");
            e.printStackTrace();
            return  false;
        }
    }

    public String getNombresColumnas() {
        return nombresColumnas;
    }
    /*
    public String obtenerEstadisticas(){
        GestorArchivo gestorArchivo = new GestorArchivo();
        String datos =  "****************************************\n";
        datos += "               Esdisticas               \n";
        datos += gestorArchivo.obtenerLineasArchivo(rutaArchivo);
        datos = datos.replace(";", "    ");
        datos += "****************************************\n";
        return datos;
    }
    */

    public String getRutaArchivo() {
        return rutaArchivo;
    }
}

