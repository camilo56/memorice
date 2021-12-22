package Clases_Dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void testGenerarDatos() {
        Jugador dato=new Jugador();
        String datoActual = dato.generarDatos();
        String datoEsperado=  dato.getNick()+ ";" + dato.getIdPartida() + ";" + dato.getDificultad() + ";" + dato.getPuntaje() + ";" + dato.getTiempo();
        assertEquals(datoEsperado,datoActual);
    }
}