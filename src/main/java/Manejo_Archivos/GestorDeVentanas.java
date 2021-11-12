package Manejo_Archivos;

import Clases_Guis.Gui_Configuraciones;
import Clases_Guis.MenuElegirDificultad;
import Clases_Guis.MenuPrincipal;
import Clases_Guis.Modelo;

import java.awt.*;

public class GestorDeVentanas {

    private MenuPrincipal menuPrincipal;
    private MenuElegirDificultad menuElegirDificultad;
    private Gui_Configuraciones configuraciones;
    private Container ventana;

    public void ejecutar() {
        Modelo modelo = new Modelo();
        this.ventana = modelo.crearVentana();
        ejecutarVentanaMenuPrincipal(getVentana());
    }

    public void ejecutarVentanaMenuPrincipal(Container ventana) {
        menuPrincipal = new MenuPrincipal(ventana);
    }

    public void ejecutarMenuElegirDificultad(Container ventana) {
        menuElegirDificultad = new MenuElegirDificultad(ventana);
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

    /*
    public Container activarVisivilidadVentana(boolean T) {
        ventana.setVisible(T);
        return ventana;
    }
     */
}
