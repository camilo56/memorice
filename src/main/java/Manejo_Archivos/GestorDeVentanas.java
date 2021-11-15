package Manejo_Archivos;

import Clases_Guis.Gui_Configuraciones;
import Clases_Guis.Gui_NuevaPartida;
import Clases_Guis.Gui_MenuPrincipal;
import Clases_Guis.Modelo;

import java.awt.*;

public class GestorDeVentanas {

    private Gui_MenuPrincipal guiMenuPrincipal;
    private Gui_NuevaPartida guiNuevaPartida;
    private Gui_Configuraciones configuraciones;
    private Container ventana;

    public void ejecutar() {
        Modelo modelo = new Modelo();
        this.ventana = modelo.crearVentana();
        ejecutarVentanaMenuPrincipal(getVentana());
    }

    public void ejecutarVentanaMenuPrincipal(Container ventana) {
        guiMenuPrincipal = new Gui_MenuPrincipal(ventana);
    }

    public void ejecutarMenuElegirDificultad(Container ventana) {
        guiNuevaPartida = new Gui_NuevaPartida(ventana);
    }

    public void ejecutarConfiguraciones(Container ventana) {
        configuraciones = new Gui_Configuraciones(ventana);
    }

    public Container getVentana() {
        return ventana;
    }

    public void setVentana(Container ventana) {
        this.ventana = ventana;
    }

}
