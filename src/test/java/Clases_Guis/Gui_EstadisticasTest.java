package Clases_Guis;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Gui_EstadisticasTest {

    @Test
    void testcrearBotones(){
        Gui_Estadisticas datos=new Gui_Estadisticas();

        int x= datos.getX();
        int y= datos.getY();

        assertEquals(0,x);
        assertEquals(0,y);
    }//valida los parametros de la clase para confirmar los volres adecuados para su uso en el metodo
}//crearBotones()