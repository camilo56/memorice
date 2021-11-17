package Clases_Guis;

import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gui_Juego extends Modelo implements ActionListener {

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

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
        botonVolver = new JButton();
        botonVolver.setBounds(15, 15, 100,30);
        botonVolver.setIcon(new ImageIcon(getImagenVolver().getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    private void crearEtiquetas() {
        JLabel etiquetaTiempo = new JLabel("Tiempo restante: ", SwingConstants.CENTER);
        etiquetaTiempo.setBounds(160, 20, 140, 25);
        etiquetaTiempo.setOpaque(true);
        etiquetaTiempo.setBackground(Color.white);
        etiquetaTiempo.setFont(getFuente());
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
