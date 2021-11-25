package Clases_Guis;

import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui_NuevaPartida extends Modelo implements ActionListener {

    private final GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private Container ventana;
    private JPanel panel;
    private JButton botonVolver, botonJugar;
    private JCheckBox tiempoLimite;
    private JRadioButton nivelFacil, nivelDificil, nivelExperto, nivelIntermedio, nivelMuyDificil, nivelPersonalizado;
    private ButtonGroup grupoRadioBotones;
    private JComboBox listaFilas, listaColumnas;
    private JTextField cajaNick;

    private final int anchoBoton = 200; // width
    private final int altoBoton = 20;// heigth  
    private int filas;
    private int columnas;
    private boolean tiempoLimitado;
    private String nick;

    public Gui_NuevaPartida(Container ventana) {
        this.ventana = ventana;
        this.panel = crearPanel(this.ventana);
        this.panel.setVisible(true);
        crearComponentes();
        panel.updateUI();
    }

    private void crearComponentes() {
        crearEtiquetas();
        crearCajaTexto();
        crearBotones();
        crearRadioBotones();
        agregarGrupoRadioBotones();
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
        cajaNick = new JTextField();
        cajaNick.setBounds(160, 80, 100, 20);
        cajaNick.setOpaque(true);//opcion de poder editar componentes internos de un JTextField
        cajaNick.setBackground(Color.white);
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
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    private void crearRadioBotones() {
        tiempoLimite = new JCheckBox("¿Tiempo Limitado?", false);
        tiempoLimite.setBounds(300, 80, 150, 20);
        panel.add(tiempoLimite);

        nivelFacil = new JRadioButton("Fácil", false);
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

    private void asignarFilas () {
        ocultarColumnas();
        String[] filas = {"1", "2", "3", "4", "5", "6"};// hasta el momento tendra que ser de max 6x6 ya que no tengo mas imagenes XD
        listaFilas = new JComboBox(filas);
        listaFilas.setBounds(300, 285, 60, 20);
        listaFilas.setVisible(true);
        listaFilas.addActionListener(this);
        panel.add(listaFilas);

        panel.updateUI();
    }

    private void ocultarFilasColumnas() {
        ocultarFilas();
        ocultarColumnas();
        panel.updateUI();
    }

    private void ocultarFilas() {
        if (listaFilas != null) {
            if (listaFilas.getSelectedItem() != null) {
                listaFilas.resetKeyboardActions();
            }
            listaFilas.setVisible(false);
        }
        panel.validate();
    }

    private void ocultarColumnas() {
        if (listaColumnas != null) {
            if (listaColumnas.getSelectedItem() != null) {
                listaColumnas.resetKeyboardActions();
            }
            listaColumnas.setVisible(false);
        }
        panel.validate();
    }

    private void asignarColumnas () {
        String[] columnas;
        /*
        if ((Integer.parseInt(listaFilas.getSelectedItem().toString()) % 2) == 0) {
            columnas = new String[]{"1", "2", "3", "4", "5", "6"};
        } else {
            columnas = new String[]{"2", "4", "6"};
        }
         */
        columnas = new String[]{"2", "4", "6"};
        listaColumnas = new JComboBox(columnas);
        listaColumnas.setBounds(365, 285, 60, 20);
        listaColumnas.addActionListener(this);
        listaColumnas.setVisible(true);
        panel.add(listaColumnas);

        panel.updateUI();
    }

    private void combinacionJuego() {
        filas = (int) listaFilas.getSelectedItem();
        columnas = (int) listaColumnas.getSelectedItem();
        tiempoLimitado = tiempoLimite.isSelected();
        nick = cajaNick.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
        if (e.getSource() == this.listaFilas) {
            asignarColumnas();
        }
        if (e.getSource() == this.listaColumnas) {

        }
        if (e.getSource() == this.nivelFacil) {
            ocultarFilasColumnas();
        }
        if (e.getSource() == this.nivelIntermedio) {
            ocultarFilasColumnas();
        }
        if (e.getSource() == this.nivelDificil) {
            ocultarFilasColumnas();
        }
        if (e.getSource() == this.nivelMuyDificil) {
            ocultarFilasColumnas();
        }
        if (e.getSource() == this.nivelExperto) {
            ocultarFilasColumnas();
        }
        if (e.getSource() == this.nivelPersonalizado) {
            asignarFilas();
        }
        if (e.getSource() == this.botonJugar) {
            panel.setVisible(false);
            panel.validate();
            combinacionJuego();
            gestorDeVentanas.ejecutarJuego(ventana);
        }
    }
}
