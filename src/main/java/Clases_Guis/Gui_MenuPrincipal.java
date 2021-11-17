package Clases_Guis;

import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_MenuPrincipal extends Modelo implements ActionListener {

    private final GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private Container ventana;
    private JPanel panel;
    private JButton botonNuevaPartida, botonCargarPartida, botonVerEstadisticasPartida, botonConfiguraciones, botonCreditos, botonSalir;

    private final int anchoBoton = 200; // width
    private final int altoBoton = 20;// heigth

    public Gui_MenuPrincipal(Container ventana) {
        this.ventana = ventana;
        this.panel = crearPanel(this.ventana);
        this.panel.setVisible(true);
        crearComponentes();
        panel.updateUI();
    }

    private void crearComponentes() {
        crearBotones();

    }

    private void crearBotones() {
        botonNuevaPartida = crearBoton("Nueva Partida");
        botonNuevaPartida.setBounds(200,20  , anchoBoton, altoBoton);
        botonNuevaPartida.addActionListener(this);
        panel.add(botonNuevaPartida);

        botonCargarPartida = crearBoton("Cargar Partida");
        botonCargarPartida.setBounds(200,60  , anchoBoton, altoBoton);
        panel.add(botonCargarPartida);

        botonVerEstadisticasPartida = crearBoton("Ver Estadisticas");
        botonVerEstadisticasPartida.setBounds(200,100  , anchoBoton, altoBoton);
        panel.add(botonVerEstadisticasPartida);

        botonConfiguraciones = crearBoton("Configuraciones");
        botonConfiguraciones.setBounds(200, 140 , anchoBoton, altoBoton);
        botonConfiguraciones.addActionListener(this);
        panel.add(botonConfiguraciones);

        botonCreditos = crearBoton("Creditos");
        botonCreditos.setBounds(200,180  , anchoBoton, altoBoton);
        panel.add(botonCreditos);

        botonSalir = crearBoton("Salir");
        botonSalir.setBounds(200,220, anchoBoton, altoBoton );
        botonSalir.addActionListener(this);
        panel.add(botonSalir);

        panel.validate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonNuevaPartida) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarMenuElegirDificultad(ventana);
        }
        if (e.getSource() == this.botonConfiguraciones) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarConfiguraciones(ventana);
        }
        if (e.getSource() == this.botonSalir) {
            System.exit(0);
        }

    }
}
