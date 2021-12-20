package Clases_Dominio;
import Manejo_Archivos.GestorArchivo;

public class Estadisticas {

    private String nick="";
    private int idPartida = 0;
    private int puntaje=0;

    private String rutaArchivo = "src/main/java/Datos/Estadisticas.csv";

    public Estadisticas(String nick, int idPartida, int puntaje ){
        this.nick = nick;
        this.idPartida = idPartida;
        this.puntaje = puntaje;
    }

    public Boolean guardarEstadisticas() {
        GestorArchivo gestorArchivo = new GestorArchivo();
        try {
            if(!gestorArchivo.existeArchivo(rutaArchivo)){
                gestorArchivo.crearArchivo(rutaArchivo);
                gestorArchivo.escribirEnArchivo(rutaArchivo, crearEstructuraArchivo());
            }
            gestorArchivo.escribirEnArchivo(rutaArchivo, crearDatos());
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar datos");
            e.printStackTrace();
            return  false;
        }
    }

    private String crearEstructuraArchivo(){
        String nombresColumnas = "Nick;Id Partida;Puntaje.";
        return nombresColumnas;
    }

    private String crearDatos(){
        String datos = getnick() + ";" + getIdPartida() + ";" + getPuntaje();
        return datos;
    }

    public String getnick() {
        return nick;
    }

    public void setnick(String nick) {
        this.nick = nick;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
