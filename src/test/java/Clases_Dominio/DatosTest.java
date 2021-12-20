package Clases_Dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatosTest {

    @Test
    void testGuardarDatosJugador() {
        Datos datos=new Datos();
        assertTrue(datos.guardarDatosJugador());
    }
}