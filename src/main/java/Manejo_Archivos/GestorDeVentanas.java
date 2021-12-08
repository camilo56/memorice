package Manejo_Archivos;

import Clases_Guis.*;

import java.awt.*;



import Clases_Guis.*;

import java.awt.*;

public class GestorDeVentanas {

    private Container ventana;

    public void ejecutar() {
        Modelo modelo = new Modelo();
        ventana = modelo.crearVentana();
        ejecutarVentanaMenuPrincipal(ventana);
    }

    public void ejecutarVentanaMenuPrincipal(Container ventana) {
        Gui_MenuPrincipal guiMenuPrincipal = new Gui_MenuPrincipal(ventana);
    }

    public void ejecutarMenuElegirDificultad(Container ventana) {
        Gui_NuevaPartida guiNuevaPartida = new Gui_NuevaPartida(ventana);
    }

    public void ejecutarConfiguraciones(Container ventana) {
        Gui_Configuraciones configuraciones = new Gui_Configuraciones(ventana);
    }

    public void ejecutarJuego(Container ventana, int cartasTotales) {
        Gui_Juego juego = new Gui_Juego(ventana, cartasTotales);
    }

    public Container getVentana() {
        return ventana;
    }
}