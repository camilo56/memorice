package Clases_Guis;


import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_NuevaPartida extends Modelo implements ActionListener {

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private Container ventana;
    private JPanel panel;
    private JButton botonVolver, botonJugar;
    private JRadioButton radioBoton1;

    private final int anchoBoton = 200; // width
    private final int altoBoton = 20;// heigth

    public Gui_NuevaPartida(Container ventana) {
        this.ventana = ventana;
        this.panel = crearPanel(ventana);
        this.panel.setVisible(true);
        crearComponentes();
    }

    private void crearComponentes() {
        crearEtiquetas();
        crearCajaTexto();
        crearBotones();
        crearRadioBotones();
    }

    private void crearEtiquetas() {
        JLabel etiquetaDificultad = new JLabel("DIFICULTAD", SwingConstants.CENTER);
        etiquetaDificultad.setBounds(200, 20, 200, 25);
        etiquetaDificultad.setOpaque(true);
        etiquetaDificultad.setBackground(Color.white);
        etiquetaDificultad.setFont(getFuente());
        panel.add(etiquetaDificultad);

        JLabel etiquetaNick = new JLabel("Nick: ", SwingConstants.CENTER);
        etiquetaNick.setBounds(100, 80, 59, 20);
        etiquetaNick.setOpaque(true);
        etiquetaNick.setBackground(Color.white);
        etiquetaNick.setFont(getFuente());
        panel.add(etiquetaNick);
    }

    private void crearCajaTexto() {
        JTextField cajaNick = new JTextField();
        cajaNick.setBounds(160, 80, 100, 20);
        cajaNick.setOpaque(true);
        cajaNick.setBackground(Color.white);
        String nick = cajaNick.getText();
        panel.add(cajaNick);
    }

    private void crearBotones() {
        botonJugar = crearBoton("Jugar");
        botonJugar.setBounds(200, 420, anchoBoton, altoBoton);
        botonJugar.addActionListener(this);
        panel.add(botonJugar);


        //getImageVolver() --> logo volver, herencia de clase Modelo
        botonVolver = new JButton();
        botonVolver.setBounds(15, 15, 100,30);
        botonVolver.setIcon(new ImageIcon(getImagenVolver().getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setVisible(true);
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    private void crearRadioBotones() {
        JCheckBox tiempoLimite = new JCheckBox("¿Tiempo Limitado?", false);
        tiempoLimite.setBounds(300, 80, 150, 20);
        panel.add(tiempoLimite);

        JRadioButton nivelFacil = new JRadioButton("Fácil", false);
        nivelFacil.setBounds(100, 140, 100, 20);
        panel.add(nivelFacil);

        JRadioButton nivelDificil = new JRadioButton("Difícil", false);
        nivelDificil.setBounds(100, 200, 100, 20);
        panel.add(nivelDificil);

        JRadioButton nivelExperto = new JRadioButton("Experto", false);
        nivelExperto.setBounds(100, 260, 100, 20);
        panel.add(nivelExperto);

        JRadioButton nivelIntermedio = new JRadioButton("Intermedio", false);
        nivelIntermedio.setBounds(300, 140, 100, 20);
        panel.add(nivelIntermedio);

        JRadioButton nivelMuyDificil = new JRadioButton("Muy Difícil", false);
        nivelMuyDificil.setBounds(300, 200, 100, 20);
        panel.add(nivelMuyDificil);

        JRadioButton nivelPersonalizado = new JRadioButton("Personalizado", false);
        nivelPersonalizado.setBounds(300, 260, 100, 20);
        panel.add(nivelPersonalizado);

        ButtonGroup grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(nivelFacil);
        grupoRadioBotones.add(nivelIntermedio);
        grupoRadioBotones.add(nivelDificil);
        grupoRadioBotones.add(nivelMuyDificil);
        grupoRadioBotones.add(nivelExperto);
        grupoRadioBotones.add(nivelPersonalizado); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
        if (e.getSource() == this.botonJugar) {
            JOptionPane.showMessageDialog(null, "funciona");
            //codigoo....
        }
    }
}
