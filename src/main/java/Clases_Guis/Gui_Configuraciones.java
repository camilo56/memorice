package Clases_Guis;

import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Configuraciones extends  Modelo implements ActionListener {

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private Container ventana;
    private JPanel panel;
    private JButton botonVolver;
    private JComboBox listaDespegable;

    private final String[] colores = {"gris claro", "gris", "azul", "verde-azulado", "verde", "rosa","amarillo", "blanco", "rojo"};

    public Gui_Configuraciones(Container container) {
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
        listaDespegable = new JComboBox(colores);
        listaDespegable.setBounds(200, 40, 100, 50);
        listaDespegable.addActionListener(this);
        panel.add(listaDespegable);
        cambiarColor();

        botonVolver = botonImagenVolver(botonVolver, 15, 15);
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    private void cambiarColor() {
        String colorElegido = listaDespegable.getSelectedItem().toString();

        if (colorElegido.equals(colores[0])) {
            ventana.setBackground(Color.lightGray);
        } else if (colorElegido.equals(colores[1])) {
            ventana.setBackground(Color.gray);
        } else if (colorElegido.equals(colores[2])) {
            ventana.setBackground(Color.blue);
        } else if (colorElegido.equals(colores[3])) {
            ventana.setBackground(Color.cyan);
        } else if (colorElegido.equals(colores[4])) {
            ventana.setBackground(Color.green);
        } else if (colorElegido.equals(colores[5])) {
            ventana.setBackground(Color.pink);
        } else if (colorElegido.equals(colores[6])) {
            ventana.setBackground(Color.yellow);
        } else if (colorElegido.equals(colores[7])) {
            ventana.setBackground(Color.white);
        } else if (colorElegido.equals(colores[8])) {
            ventana.setBackground(Color.red);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
        if (e.getSource() == this.listaDespegable) {
            cambiarColor();
        }
    }
}
