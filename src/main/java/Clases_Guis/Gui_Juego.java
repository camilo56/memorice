package Clases_Guis;

import Clases_Dominio.Tablero;
import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gui_Juego extends Modelo implements ActionListener {

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();
    private Tablero tablero = new Tablero();
    private Container ventana;
    private JPanel panel;

    private JButton botonVolver;
    private List<JButton> cartas;

    public Gui_Juego(Container ventana) {
        this.ventana = ventana;
        this.panel = crearPanel(this.ventana);
        this.panel.setVisible(true);
        crearComponentes();
        panel.updateUI();
    }

    private void crearComponentes() {
        crearBotones();
        crearEtiquetas();
        crearCartas();
    }

    private void crearBotones() {
        botonVolver = botonImagenVolver(botonVolver, 15, 15);
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    private void crearEtiquetas() {
        JLabel etiquetaTiempo = new JLabel("Tiempo restante: ", SwingConstants.CENTER);
        etiquetaTiempo = modelarEtiqueta(etiquetaTiempo, 160, 20, 140, 25, Color.white, getFuente());
        panel.add(etiquetaTiempo);
    }

    private void crearCartas() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
    }
}
