package Clases_Guis;


import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuElegirDificultad extends Modelo implements ActionListener {

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private Container ventana;
    private JPanel panel;
    private JButton botonVolver;

    public MenuElegirDificultad(Container ventana) {
        this.ventana = ventana;
        this.panel = crearPanel(ventana);
        this.panel.setVisible(true);
        crearComponentes();
    }

    private void crearComponentes() {
        crearBotones();
    }

    private void crearBotones() {
        botonVolver = new JButton();
        botonVolver.setBounds(15, 15, 100,30);
        ImageIcon volver = new ImageIcon("volver.png");
        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setVisible(true);
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
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
