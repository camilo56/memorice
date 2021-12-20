package Clases_Guis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Gui_EstadisticasTest {

    @Test
    void testcrearBotones(){
        Gui_Estadisticas datos=new Gui_Estadisticas();
        
        int x= datos.getX();
        int y= datos.getY();

        assertEquals(15,x);
        assertEquals(15,y);
    }
}