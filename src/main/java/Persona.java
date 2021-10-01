public class Persona {

    String nick;
    int puntaje = 0;
    int nVeces=0;

    public Persona(String nick) {
        this.nick = nick;
    }

    public Persona(String nick, int puntaje, int nVeces) {
        this.nick = nick;
        this.puntaje = puntaje;
        this.nVeces = nVeces;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getnVeces() {
        return nVeces;
    }

    public void setnVeces(int nVeces) {
        this.nVeces = nVeces;
    }
}
