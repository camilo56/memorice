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
    private JButton botonNuevaPartida, botonVerEstadisticasPartida, botonConfiguraciones, botonCreditos, botonSalir;

    private final int anchoBoton = 200; // width
    private final int altoBoton = 20;// heigth

    public Gui_MenuPrincipal(Container container) {
        this.ventana = container;
        crearComponentes();
        panel.updateUI();
    }

    private void crearComponentes() {
        crearPaneles();
        crearBotones();
    }

    private void crearPaneles() {
        panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setOpaque(false);
        ventana.add(panel);
    }

    private void crearBotones() {
        botonNuevaPartida = crearBoton(botonNuevaPartida,"Nueva Partida", getFuente(),200,20  , anchoBoton, altoBoton);
        botonNuevaPartida.addActionListener(this);
        panel.add(botonNuevaPartida);

        botonVerEstadisticasPartida = crearBoton(botonVerEstadisticasPartida, "Ver Estadisticas", getFuente(),200,60  , anchoBoton, altoBoton);
        botonVerEstadisticasPartida.addActionListener(this);
        panel.add(botonVerEstadisticasPartida);

        botonConfiguraciones = crearBoton(botonConfiguraciones, "Configuraciones", getFuente(), 200,100 , anchoBoton, altoBoton);
        botonConfiguraciones.addActionListener(this);
        panel.add(botonConfiguraciones);

        botonCreditos = crearBoton(botonCreditos, "Creditos", getFuente(), 200, 140  , anchoBoton, altoBoton);
        panel.add(botonCreditos);

        botonSalir = crearBoton(botonSalir, "Salir", getFuente(), 200,180, anchoBoton, altoBoton);
        botonSalir.addActionListener(this);
        panel.add(botonSalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonNuevaPartida) {
            panel.setVisible(false);
            panel.updateUI();
            gestorDeVentanas.ejecutarMenuElegirDificultad(ventana);
        }
        if (e.getSource() == this.botonConfiguraciones) {
            panel.setVisible(false);
            panel.updateUI();
            gestorDeVentanas.ejecutarConfiguraciones(ventana);
        }
        if (e.getSource() == this.botonVerEstadisticasPartida) {
            panel.setVisible(false);
            panel.updateUI();
            gestorDeVentanas.ejecutarEstadisticas(ventana);
        }
        if (e.getSource() == this.botonSalir) {
            System.exit(0);
        }

    }
}
