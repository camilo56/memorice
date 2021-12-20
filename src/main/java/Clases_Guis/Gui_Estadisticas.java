package Clases_Guis;

import Clases_Dominio.Datos;
import Manejo_Archivos.GestorArchivo;
import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Estadisticas extends Modelo implements ActionListener {

    private final GestorArchivo gestorArchivo = new GestorArchivo();
    private final GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();
    private final Datos datos = new Datos();

    private Container ventana;

    private JPanel panelPrincipal;
    private JPanel panelSuperior;
    private JPanel panelCentral;
    private JButton botonVolver;
    private JScrollPane scrollPane;
    private JTable tabla;

    String[][] datosTabla;

    public Gui_Estadisticas(Container container) {
        this.ventana = container;
        crearComponentes();
        actualizarPaneles();
    }

    private void crearComponentes() {
        crearPaneles();
        crearTabla();
        crearJScrollPane();
        crearBotones();
        crearEtiquetas();
    }

    private String[] definirColumnas() {
        return datos.getNombresColumnas().split(";");
    }

    private String[][] definirDatos() {
        if (gestorArchivo.existeArchivo(datos.getRutaArchivo())) {
            String[] lineas = gestorArchivo.obtenerLineasArchivo(datos.getRutaArchivo());
            datosTabla = new String[lineas.length - 1][5];
            for (int i = 1; i < lineas.length; i++) {
                String[] datoTemporal = lineas[i].split(";");
                for (int j = 0; j < datoTemporal.length; j++) {
                    datosTabla[i - 1][j] = datoTemporal[j];
                }
            }
        }
        return datosTabla;
    }

    private void crearJScrollPane() {
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBorder(new TitledBorder("Estadisticas"));
        scrollPane.setOpaque(false);
        panelCentral.add(scrollPane, BorderLayout.CENTER);
    }

    private void crearTabla() {
        DefaultTableModel model = new DefaultTableModel(definirDatos(), definirColumnas());
        tabla = new JTable(model);
        tabla.setOpaque(false);
    }

    private void crearEtiquetas() {
        JLabel jLabelEstadistica = new JLabel("Estadistica", SwingConstants.CENTER);
        jLabelEstadistica = modelarEtiqueta(jLabelEstadistica, 200, 20, 200, 25, Color.white, getFuente());
        panelSuperior.add(jLabelEstadistica, BorderLayout.CENTER);
    }

    private void crearPaneles() {
        panelPrincipal = new JPanel();
        panelPrincipal.setVisible(true);
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setOpaque(false);
        ventana.add(panelPrincipal);


        panelSuperior = new JPanel();
        panelSuperior.setVisible(true);
        panelSuperior.setOpaque(false);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        panelCentral = new JPanel();
        panelCentral.setVisible(true);
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BorderLayout());
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
    }

    private void actualizarPaneles() {
        panelPrincipal.updateUI();
        panelSuperior.updateUI();
        panelCentral.updateUI();
    }

    private void crearBotones() {
        botonVolver = botonImagenVolver(botonVolver,15, 15);
        botonVolver.addActionListener(this);
        panelSuperior.add(botonVolver, FlowLayout.LEFT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {

            panelPrincipal.setVisible(false);
            panelSuperior.validate();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
    }
}
