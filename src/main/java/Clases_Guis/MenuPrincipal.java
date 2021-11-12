package Clases_Guis;

import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends Modelo implements ActionListener {

    private final GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private Container ventana;
    private JPanel panel;
    private JButton botonNuevaPartida, botonCargarPartida, botonVerEstadisticasPartida, botonConfiguraciones, botonCreditos, botonSalir;

    private final int altoBoton = 200; // width
    private final int anchoBoton = 20;// heigth

    public MenuPrincipal(Container ventana) {
        this.ventana = ventana;
        this.panel = crearPanel(ventana);
        this.panel.setVisible(true);
        crearComponentes();
    }

    private void crearComponentes() {
        crearBotones();
    }

    private void crearBotones() {
        botonNuevaPartida = new JButton("Nueva Partida");
        botonNuevaPartida.setBounds(200,20  ,altoBoton ,anchoBoton );
        botonNuevaPartida.setHorizontalAlignment(SwingConstants.CENTER);
        botonNuevaPartida.setFont(getFuente()); // getFuente es metodo  de clase Modelo
        botonNuevaPartida.addActionListener(this);
        panel.add(botonNuevaPartida);

        botonCargarPartida = new JButton("Cargar Partida");
        botonCargarPartida.setBounds(200,60  ,altoBoton ,anchoBoton );
        botonCargarPartida.setHorizontalAlignment(SwingConstants.CENTER);
        botonCargarPartida.setFont(getFuente()); // getFuente es metodo  de clase Modelo
        panel.add(botonCargarPartida);

        botonVerEstadisticasPartida = new JButton("Ver Estadisticas");
        botonVerEstadisticasPartida.setBounds(200,100  ,altoBoton ,anchoBoton );
        botonVerEstadisticasPartida.setHorizontalAlignment(SwingConstants.CENTER);
        botonVerEstadisticasPartida.setFont(getFuente()); // getFuente es metodo  de clase Modelo
        panel.add(botonVerEstadisticasPartida);

        botonConfiguraciones = new JButton("Configuraciones");
        botonConfiguraciones.setBounds(200, 140 ,altoBoton ,anchoBoton );
        botonConfiguraciones.setHorizontalAlignment(SwingConstants.CENTER);
        botonConfiguraciones.setFont(getFuente()); // getFuente es metodo  de clase Modelo
        botonConfiguraciones.addActionListener(this);
        panel.add(botonConfiguraciones);

        botonCreditos = new JButton("Creditos");
        botonCreditos.setBounds(200,180  ,altoBoton ,anchoBoton );
        botonCreditos.setHorizontalAlignment(SwingConstants.CENTER);
        botonCreditos.setFont(getFuente()); // getFuente es metodo  de clase Modelo
        panel.add(botonCreditos);

        botonSalir = new JButton("Salir");
        botonSalir.setBounds(200,220, altoBoton ,anchoBoton );
        botonSalir.setHorizontalAlignment(SwingConstants.CENTER);
        botonSalir.setFont(getFuente()); // getFuente es metodo  de clase Modelo
        botonSalir.addActionListener(this);
        panel.add(botonSalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonNuevaPartida) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarMenuElegirDificultad(ventana);
        }
        if (e.getSource() == this.botonSalir) {
            System.exit(0);
        }
        if (e.getSource() == this.botonConfiguraciones) {
            panel.setVisible(false);
            panel.validate();
            gestorDeVentanas.ejecutarConfiguraciones(ventana);
        }
    }
}
