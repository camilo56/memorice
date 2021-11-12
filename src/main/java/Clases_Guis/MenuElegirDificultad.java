package Clases_Guis;


import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuElegirDificultad extends Modelo implements ActionListener {
    /*
        System.out.println("***********************************************************");
        System.out.println("*             Selecione nivel de dificultad               *");
        System.out.println("*[a]facil(Tablero de 2X5,sin limite de tiempo)            *");
        System.out.println("*[b]intermedio(Tablero de 3X4,limite de tiempo moderado)  *");
        System.out.println("*[c]difícil (Tablero de 2X10, limite de tiempo corto )    *");
        System.out.println("*[d]muy difícil (Tablero de 3X10, limite de tiempo corto) *");
        System.out.println("*[e]Experto  (Tablero de 5X10, limite de tiempo corto )   *");
        System.out.println("*[f]                  pesonalizado                        *");
        System.out.println("*[s]                volver al menu                        *");
        System.out.println("***********************************************************");
     */

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private JPanel panel;
    private JButton botonVolver;

    public MenuElegirDificultad() {
        crearVentana();
        panel = crearPanel();
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
            gestorDeVentanas.ejecutarVentanaMenuPrincipal();
            setVisible(false);
        }
    }
}
