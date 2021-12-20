package Clases_Guis;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ModeloTest {

    private Modelo dato =new Modelo();

    int x = (int) Math.floor(Math.random()*1000+1);
    int y = (int) Math.floor(Math.random()*1000+1);
    int ancho = (int) Math.floor(Math.random()*1000+1);
    int alto = (int) Math.floor(Math.random()*1000+1);


    @Test
    void testCrearBoton() {
        JButton button=new JButton();
        String titulo= "MeMO";
        Font fuente = new Font("arial",2, 15);
        String text="";

        assertNotNull(dato.crearBoton( button,  text,  fuente,  x,  y,  ancho,  alto));

    }

    @Test
    void botonImagenVolver() {
        JButton button=new JButton();
        dato.botonImagenVolver(button,x,y);
        assertNotNull(dato.botonImagenVolver(button,x,y));
    }

    @Test
    void modelarEtiqueta() {
        JLabel jLabel=new JLabel();
        Font fuente = new Font("arial",2, 15);
        Color color = null;
        assertNotNull(dato.modelarEtiqueta( jLabel,  x,  y,  ancho,  alto,  color,  fuente));
    }
}