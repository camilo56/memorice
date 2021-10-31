package Clases_Dominio;
import Manejo_Archivos.GestorArchivo;

import java.util.ArrayList;
import java.util.List;

public class Estadisticas {

    private Persona persona;
    private int vecesJugadas = 0;
    private List<Integer> puntajes;

    public Estadisticas(String nick){
        this.persona = new Persona(nick);
        this.vecesJugadas = getVecesJugadas();
        this.puntajes = new ArrayList<>();
    }

    public void ingresarPuntaje(Integer puntaje){
        puntajes.add(puntaje);
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

    /*
    private String crearDatos(){
        String datos = "Nick: " + getPersona().getNick() + "; Veces Jugadas: " + getVecesJugadas();
        for(Integer puntaje : getPuntajes()){
            datos += "; " + puntaje;
        }
        return datos;
    }
     */
    private String crearEstructuraArchivo(){
        String nombresColumnas = "Nick;Veces Jugadas";
        for (int i = 0; i < vecesJugadas; i++) {
            nombresColumnas += ";Puntaje Jugada Nº" + (i + 1);
        }
        return  nombresColumnas;
    }

    private String crearDatos(){
        String datos = getPersona().getNick() + ";" + getVecesJugadas();
        for(Integer puntaje : getPuntajes()){
            datos += ";" + puntaje;
        }
        return datos;
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
