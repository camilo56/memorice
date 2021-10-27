public class Persona {

    /*
    creo que esta clase solo debe  tener datos de persona (solo el nick),
    en otra clase guardar las estadisticas de cada persona en un List<Persona> persona = new ...
    ya que en esta  se guardarian los datos referentes a cada partidad que juegue una persona
     */

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
