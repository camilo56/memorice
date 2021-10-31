import java.util.ArrayList;

public class Persona {

    private String nick;
    private String puntaje;
    private String nVeces;



    public Persona() {

    }

    public Persona(String nick, String puntaje,String nVeces) {
        this.nick = nick;
        this.puntaje = puntaje;
        this.nVeces=nVeces;

    }


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getnVeces() {
        return nVeces;
    }

    public void setnVeces(String nVeces) {
        this.nVeces = nVeces;
    }



    @Override
    public String toString() {
        return "Jugador(*" + "Nick='" + nick + '\'' + ", Puntaje='" + puntaje + '\''  + ",Cantidad de partidas='" + nVeces + '\''+ "*)";
    }

}
