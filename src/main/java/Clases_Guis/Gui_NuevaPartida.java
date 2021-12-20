package Clases_Guis;

import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Gui_NuevaPartida extends Modelo implements ActionListener {

    private final GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private Container ventana;
    private JPanel panel;
    private JButton botonVolver, botonJugar;
    private JCheckBox tiempoLimite;
    private JRadioButton nivelFacil, nivelDificil, nivelExperto, nivelIntermedio, nivelMuyDificil, nivelPersonalizado;
    private ButtonGroup grupoRadioBotones;
    private JComboBox elegirCantidadCartas;
    private JTextField cajaNick;
    private JLabel infoEleccionCartas;

    private final int[] arregloCantidadCartas = {12, 16, 20, 36, 40};
    private String[] arregloCantidadCartasPersonalizadas = new String[10];
    private int cantidadCartas;
    private final int anchoBoton = 200;
    private final int altoBoton = 20;
    private boolean tiempoLimitado;
    private String nick;
    private String dificultad;

    public Gui_NuevaPartida(Container container) {
        this.ventana = container;
        crearComponentes();
        panel.updateUI();
    }

    private void crearComponentes() {
        crearPaneles();
        crearEtiquetas();
        crearCajaTexto();
        crearBotones();
        crearRadioBotones();
        agregarGrupoRadioBotones();
    }

    private void crearPaneles() {
        panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setOpaque(false);
        ventana.add(panel);
    }

    private void crearEtiquetas() {
        JLabel etiquetaDificultad = new JLabel("DIFICULTAD", SwingConstants.CENTER);
        etiquetaDificultad = modelarEtiqueta(etiquetaDificultad,200, 20, 200, 25, Color.white, getFuente());
        panel.add(etiquetaDificultad);

        JLabel etiquetaNick = new JLabel("Nick: ", SwingConstants.CENTER);
        etiquetaNick = modelarEtiqueta(etiquetaNick, 100, 80, 59, 20, Color.white, getFuente());
        panel.add(etiquetaNick);
    }

    private void crearCajaTexto() {
        cajaNick = new JTextField();
        cajaNick.setBounds(160, 80, 100, 20);
        cajaNick.setOpaque(true);
        cajaNick.setBackground(Color.white);
        panel.add(cajaNick);
    }

    private void crearBotones() {
        botonJugar = crearBoton(botonJugar, "Jugar", getFuente(), 200, 420, anchoBoton, altoBoton);
        botonJugar.addActionListener(this);
        panel.add(botonJugar);

        botonVolver = botonImagenVolver(botonVolver,15, 15);
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    private void crearRadioBotones() {
        tiempoLimite = new JCheckBox("¿Tiempo Limitado?", false);
        tiempoLimite.setBounds(300, 80, 150, 20);
        panel.add(tiempoLimite);

        nivelFacil = new JRadioButton("Fácil", true);
        nivelFacil.setBounds(100, 140, 100, 20);
        nivelFacil.addActionListener(this);
        panel.add(nivelFacil);

        nivelDificil = new JRadioButton("Difícil", false);
        nivelDificil.setBounds(100, 200, 100, 20);
        nivelDificil.addActionListener(this);
        panel.add(nivelDificil);

        nivelExperto = new JRadioButton("Experto", false);
        nivelExperto.setBounds(100, 260, 100, 20);
        nivelDificil.addActionListener(this);
        panel.add(nivelExperto);

        nivelIntermedio = new JRadioButton("Intermedio", false);
        nivelIntermedio.setBounds(300, 140, 100, 20);
        nivelIntermedio.addActionListener(this);
        panel.add(nivelIntermedio);

        nivelMuyDificil = new JRadioButton("Muy Difícil", false);
        nivelMuyDificil.setBounds(300, 200, 100, 20);
        nivelMuyDificil.addActionListener(this);
        panel.add(nivelMuyDificil);

        nivelPersonalizado = new JRadioButton("Personalizado", false);
        nivelPersonalizado.setBounds(300, 260, 110, 20);
        nivelPersonalizado.setEnabled(true);
        nivelPersonalizado.addActionListener(this);
        panel.add(nivelPersonalizado);
    }

    private void agregarGrupoRadioBotones() {
        grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(nivelFacil);
        grupoRadioBotones.add(nivelIntermedio);
        grupoRadioBotones.add(nivelDificil);
        grupoRadioBotones.add(nivelMuyDificil);
        grupoRadioBotones.add(nivelExperto);
        grupoRadioBotones.add(nivelPersonalizado);
    }

    private void ocultarListaElegirCartas() {
        if (elegirCantidadCartas != null) {
            infoEleccionCartas.setVisible(false);
            if (elegirCantidadCartas.getSelectedItem() != null) {
                elegirCantidadCartas.resetKeyboardActions();
            }
            elegirCantidadCartas.setVisible(false);
        }
        panel.updateUI();
    }

    private void elegirCantidadCartas() {
        infoEleccionCartas = new JLabel("Cantidad de cartas: ", SwingConstants.CENTER);
        infoEleccionCartas = modelarEtiqueta(infoEleccionCartas, 300, 285, 120, 20, Color.white, getFont());
        infoEleccionCartas.setVisible(true);
        panel.add(infoEleccionCartas);
        for (int i = 0; i < arregloCantidadCartasPersonalizadas.length; i++) {
            arregloCantidadCartasPersonalizadas[i] = String.valueOf((i + 1) * 4);
        }
        elegirCantidadCartas = new JComboBox(arregloCantidadCartasPersonalizadas);
        elegirCantidadCartas.setBounds(425, 285, 60, 20);
        elegirCantidadCartas.setVisible(true);
        elegirCantidadCartas.addActionListener(this);
        panel.add(elegirCantidadCartas);

        panel.updateUI();
    }

    private void asignarVariablesJuego() {
        if (grupoRadioBotones.isSelected(nivelPersonalizado.getModel())) {
            cantidadCartas = Integer.parseInt(Objects.requireNonNull(elegirCantidadCartas.getSelectedItem()).toString());
            dificultad = "Personalizado";
        } else if (grupoRadioBotones.isSelected(nivelFacil.getModel())) {
            cantidadCartas = arregloCantidadCartas[0];
            dificultad = "Facil";
        } else if (grupoRadioBotones.isSelected(nivelIntermedio.getModel())) {
            cantidadCartas = arregloCantidadCartas[1];
            dificultad = "Intermedio";
        } else if (grupoRadioBotones.isSelected(nivelDificil.getModel())) {
            cantidadCartas = arregloCantidadCartas[2];
            dificultad = "Dificil";
        } else if (grupoRadioBotones.isSelected(nivelMuyDificil.getModel())) {
            cantidadCartas = arregloCantidadCartas[3];
            dificultad = "Muy Dificil";
        } else { // nivelExperto
            cantidadCartas = arregloCantidadCartas[4];
            dificultad = "Experto";
        }
        this.tiempoLimitado = tiempoLimite.isSelected();
        if (cajaNick.getText().length() > 0) {
            this.nick = cajaNick.getText();
        } else {
            this.nick = "Invitado";
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
        if (e.getSource() == this.botonJugar) {
            panel.setVisible(false);
            panel.validate();
            asignarVariablesJuego();
            gestorDeVentanas.ejecutarJuego(ventana, cantidadCartas, nick, dificultad);
        }
        if (e.getSource() == this.nivelFacil) ocultarListaElegirCartas();
        if (e.getSource() == this.nivelIntermedio) ocultarListaElegirCartas();
        if (e.getSource() == this.nivelDificil) ocultarListaElegirCartas();
        if (e.getSource() == this.nivelMuyDificil) ocultarListaElegirCartas();
        if (e.getSource() == this.nivelExperto) ocultarListaElegirCartas();
        if (e.getSource() == this.nivelPersonalizado) elegirCantidadCartas();
    }

    public String getNick() {
        return nick;
    }

    public String getDificultad() {
        return dificultad;
    }
}
