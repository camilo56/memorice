package Clases_Guis;

import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends Modelo implements ActionListener {

    private GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();

    private JPanel panel;
    private JButton botonNuevaPartida, botonCargarPartida, botonVerEstadisticasPartida, botonConfiguraciones, botonCreditos, botonSalir;

    private int altoBoton = 200; // width
    private int anchoBoton = 20;// heigth
    /*
    ESTA GUI BUSCA MOSTRAR ESTAS SECCIONES (BOTONES QUE DAN PASO A OTRAS GUI's)
        System.out.println("***********************************************************");
        System.out.println("*                      Iniciar Juego                      *");
        System.out.println("*   [a] Partida Nueva                                     *");
        System.out.println("*   [b] Cargar Partida                                    *");
        System.out.println("*   [c] Ver Estadisticas                                  *");
        System.out.println("*   [d] Configuraciones                                   *");
        System.out.println("*   [e] Creditos                                          *");
        System.out.println("*   [s] Salir                                             *");
        System.out.println("***********************************************************");
     */
    public MenuPrincipal() {
        crearVentana();
        panel = crearPanel();
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
            gestorDeVentanas.ejecutarMenuElegirDificultad();
            setVisible(false); //cierra la ventana actual -> le da paso a la otra ventana
        }
        if (e.getSource() == this.botonSalir) {
            System.exit(0);
        }
    }
}
