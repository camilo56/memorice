package Clases_Guis;

import Manejo_Archivos.GestorArchivo;
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
    private String Seleccion;

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
        panel.setOpaque(false); //vuelve trasnparente el jpanel ay que hacerlo a todos los jpanel
        panel.setLayout(null);
        ventana.add(panel);
    }

    private void crearBotones() {
        listaDespegable = new JComboBox(colores);
        listaDespegable.setBounds(200, 40, 100, 50);
        listaDespegable.addActionListener(this);
        panel.add(listaDespegable);
        cambiarColor();
        cambiarColor();


        botonVolver = botonImagenVolver(botonVolver, 15, 15);
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    public void cambiarColor() {
        String colorElegido = listaDespegable.getSelectedItem().toString();
        if (colorElegido.equals(colores[0])) {
            ventana.setBackground(Color.lightGray);
            this.Seleccion ="0";
        } else if (colorElegido.equals(colores[1])) {
            ventana.setBackground(Color.gray);
            this.Seleccion ="1";
        } else if (colorElegido.equals(colores[2])) {
            ventana.setBackground(Color.blue);
            this.Seleccion ="2";
        } else if (colorElegido.equals(colores[3])) {
            ventana.setBackground(Color.cyan);
            this.Seleccion ="3";
        } else if (colorElegido.equals(colores[4])) {
            ventana.setBackground(Color.green);
            this.Seleccion ="4";
        } else if (colorElegido.equals(colores[5])) {
            ventana.setBackground(Color.pink);
            this.Seleccion ="5";
        } else if (colorElegido.equals(colores[6])) {
            ventana.setBackground(Color.yellow);
            this.Seleccion ="6";
        } else if (colorElegido.equals(colores[7])) {
            ventana.setBackground(Color.white);
            this.Seleccion ="7";
        } else if (colorElegido.equals(colores[8])) {
            ventana.setBackground(Color.red);
            this.Seleccion ="8";
        }



        //System.out.println(panel.getBackground());
        /*
        setColor(panel.getBackground());
        System.out.println("color: " + getColor());
         */

        //guardarColor(panel.getBackground());

    }






    /*
    private boolean guardarColor(Color color) {
        GestorArchivo gestorArchivo = new GestorArchivo();
        String rutaColor = "src/main/java/Datos/color.txt";
        gestorArchivo.reEscribirArchivo(rutaColor, String.valueOf(color.get));
        return true;
    }

     */

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