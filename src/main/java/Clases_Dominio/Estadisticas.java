package Clases_Dominio;
import Manejo_Archivos.GestorArchivo;

public class Estadisticas {

    private Persona persona;
    private int idPartida = 0;
    private int puntaje;
    
    private String rutaArchivo = "Estadisticas.csv";

    public Estadisticas(String nick){
        this.persona = new Persona(nick);
        this.idPartida = getIdPartida();
        this.puntaje = getPuntaje();
    }

    public Boolean guardarEstadisticas() {
        GestorArchivo gestorArchivo = new GestorArchivo();
        String ruta = "Estadisticas.csv";
        try {
            if(!gestorArchivo.existeArchivo(ruta)){
                gestorArchivo.crearArchivo(ruta);
                gestorArchivo.escribirEnArchivo(ruta, crearEstructuraArchivo());
            }
            gestorArchivo.escribirEnArchivo(ruta, crearDatos());
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
        String datos = getPersona().getNick() + ";" + getIdPartida() + ";" + getPuntaje();
        return datos;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
