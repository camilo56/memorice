package Clases_Dominio;
import Manejo_Archivos.GestorArchivo;

public class Jugador {

    private String nick;
    private int idPartida = 0;
    private String dificultad;
    private int puntaje;
    private String tiempo;

    public Jugador(){
    }

    public Jugador(String nick, String dificultad, int puntaje, String tiempo){
        this.nick = nick;
        this.idPartida = getIdPartida();
        this.dificultad = dificultad;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
    }

    public String generarDatos() {
        String datos = getNick()+ ";" + getIdPartida() + ";" + getDificultad() + ";" + getPuntaje() + ";" + getTiempo();
        return datos;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
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
