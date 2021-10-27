import java.util.List;

public class Estadisticas {

    private Persona persona;
    private int vecesJugadas = 0;
    private List<Integer> puntajes;

    public Estadisticas(String nick){
        this.persona = new Persona(nick);
        this.vecesJugadas = getVecesJugadas();
        this.puntajes = getPuntajes();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getVecesJugadas() {
        return vecesJugadas;
    }

    public void setVecesJugadas(int vecesJugadas) {
        this.vecesJugadas = vecesJugadas;
    }

    public List<Integer> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(List<Integer> puntajes) {
        this.puntajes = puntajes;
    }
}
