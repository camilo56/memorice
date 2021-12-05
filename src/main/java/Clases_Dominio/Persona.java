package Clases_Dominio;

public class Persona {

    private String nick;

    public Persona(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}