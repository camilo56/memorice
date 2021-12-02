package Clases_Guis;

import Clases_Dominio.Tablero;
import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Gui_Juego extends Modelo implements ActionListener, MouseListener {

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();
    private Tablero tablero = new Tablero();
    private Container ventana;
    private JPanel panelCentral, panelSuperior, panelInferior;

    private ImageIcon question = new ImageIcon("src/main/java/Imagenes/question.png");
    private ImageIcon[] imagenes;
    private JLabel[] arregloEtiquetasImagenes;
    private JLabel[] arregloEtiquetasIncognitas;
    private JButton botonVolver;

    private final int filas;
    private final int columnas;
    private final int altoCarta = 65;
    private final int anchoCarta = 65;

    public Gui_Juego(Container container, int filas, int columnas) {
        this.ventana = container;
        this.filas = filas;
        this.columnas = columnas;
        arregloEtiquetasImagenes = new JLabel[this.filas * this.columnas];
        arregloEtiquetasIncognitas = new JLabel[this.filas * this.columnas];
        crearComponentes();
        actualizarPaneles();
    }

    private void crearComponentes() {
        crearPaneles();
        crearBotones();
        crearEtiquetas();
        crearCartasIncognitas();
        crearCartas();
    }

    private void crearCartasIncognitas() {
        for (int i = 0; i < arregloEtiquetasIncognitas.length; i++) {
            arregloEtiquetasIncognitas[i] = new JLabel();
            arregloEtiquetasIncognitas[i].setBounds(0, 0,anchoCarta, altoCarta);
            arregloEtiquetasIncognitas[i].setIcon(new ImageIcon(question.getImage().getScaledInstance(anchoCarta, altoCarta, Image.SCALE_SMOOTH)));
            arregloEtiquetasIncognitas[i].setOpaque(true);
            arregloEtiquetasIncognitas[i].setBackground(Color.gray);
            arregloEtiquetasIncognitas[i].addMouseListener(this);
            panelCentral.add(arregloEtiquetasIncognitas[i]);
        }
    }

    private void crearCartas() {
        imagenes = tablero.dimensiones(filas, columnas);
        for (int i = 0; i < imagenes.length; i++) {
            arregloEtiquetasImagenes[i] = new JLabel();
            arregloEtiquetasImagenes[i].setBounds(0,0,anchoCarta, altoCarta);
            arregloEtiquetasImagenes[i].setIcon(new ImageIcon(imagenes[i].getImage().getScaledInstance(anchoCarta, altoCarta, Image.SCALE_SMOOTH)));
            arregloEtiquetasImagenes[i].setOpaque(true);
            arregloEtiquetasImagenes[i].setBackground(Color.white);
            //panelCentral.add(arregloEtiquetasImagenes[i]);
        }
    }

    private void crearPaneles() {
        panelCentral = new JPanel();
        panelCentral.setVisible(true);
        panelCentral.setBackground(Color.pink);//ELIMINAR ESTO DESPUES
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));//new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS)

        panelSuperior = new JPanel();
        panelSuperior.setVisible(true);
        panelSuperior.setBackground(Color.green);//ELIMINAR ESTO DESPUES
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));

        panelInferior = new JPanel();
        panelInferior.setVisible(true);
        panelInferior.setBackground(Color.cyan);//ELIMINAR ESTO DESPUES
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER));


        ventana.add(panelSuperior, BorderLayout.PAGE_START);
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(panelInferior, BorderLayout.PAGE_END);
    }

    private void crearBotones() {
        botonVolver = botonImagenVolver(botonVolver, 15, 15);
        botonVolver.addActionListener(this);
        panelSuperior.add(botonVolver);
    }

    private void crearEtiquetas() {
        JLabel etiquetaTiempo = new JLabel("Tiempo restante: ", SwingConstants.CENTER);
        etiquetaTiempo = modelarEtiqueta(etiquetaTiempo, 160, 20, 140, 25, Color.white, getFuente());
        panelSuperior.add(etiquetaTiempo);

        JLabel etiquetaPuntaje = new JLabel("Puntaje: ", SwingConstants.CENTER);
        etiquetaPuntaje = modelarEtiqueta(etiquetaPuntaje, 0, 0, 140, 25, Color.white, getFuente());
        panelInferior.add(etiquetaPuntaje);
    }

    private void actualizarPaneles() {
        panelCentral.updateUI();
        panelSuperior.updateUI();
        panelInferior.updateUI();
    }

    private void visibilidadPaneles(boolean visible) {
        panelCentral.setVisible(visible);
        panelSuperior.setVisible(visible);
        panelInferior.setVisible(visible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {
            visibilidadPaneles(false);
            actualizarPaneles();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < arregloEtiquetasIncognitas.length; i++) {
            if (e.getSource() == arregloEtiquetasIncognitas[i]) {
                arregloEtiquetasIncognitas[i] = arregloEtiquetasImagenes[i];
                panelCentral.add(arregloEtiquetasImagenes[i], i);
                panelCentral.remove(i + 1);
                actualizarPaneles();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
