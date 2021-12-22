package Clases_Dominio;

public class Jugador {

    private String nick;
    private int idPartida = 0;
    private String dificultad;
    private int puntaje;
    private String tiempo;

    public Jugador(String nick, String dificultad, int puntaje, String tiempo){
        this.nick = nick;
        this.idPartida = getIdPartida();
        this.dificultad = dificultad;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
    }

    public Jugador() {

    }

    public String generarDatos() {
        String datos = getNick()+ ";" + getIdPartida() + ";" + getDificultad() + ";" + getPuntaje() + ";" + getTiempo();
        return datos;
    }

    public String getNick() {
        return nick;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getTiempo() {
        return tiempo;
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
}
