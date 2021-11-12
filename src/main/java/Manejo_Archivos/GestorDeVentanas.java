package Manejo_Archivos;

import Clases_Guis.MenuElegirDificultad;
import Clases_Guis.MenuPrincipal;

public class GestorDeVentanas {

    private MenuPrincipal menuPrincipal;
    private MenuElegirDificultad menuElegirDificultad;

    public void ejecutarVentanaMenuPrincipal() {
        menuPrincipal = new MenuPrincipal();
    }

    public void ejecutarMenuElegirDificultad() {
        menuElegirDificultad = new MenuElegirDificultad();
    }


}
