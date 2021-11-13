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

    private final String[] colores = {"gris claro", "gris", "azul", "verde-azulado", "verde", "rosa","amarillo", "blanco", "rojo"};

    public Gui_Configuraciones(Container ventana) {
        this.ventana = ventana;
        this.panel = crearPanel(ventana);
        this.panel.setVisible(true);
        crearComponentes();
    }

    private void crearComponentes() {
        crearBotones();
    }

    private void crearBotones() {
        listaDespegable = new JComboBox(colores);
        listaDespegable.setBounds(200, 40, 100, 50);
        listaDespegable.addActionListener(this);
        panel.add(listaDespegable);
        cambiarColor();

        botonVolver = new JButton();
        botonVolver.setBounds(15, 15, 100,30);
        ImageIcon volver = new ImageIcon("src/main/java/Imagenes/volver.png");
        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setVisible(true);
        botonVolver.addActionListener(this);
        panel.add(botonVolver);
    }

    private void cambiarColor() {
        String colorElegido = listaDespegable.getSelectedItem().toString();

        if (colorElegido.equals(colores[0])) {
            panel.setBackground(Color.lightGray);
        } else if (colorElegido.equals(colores[1])) {
            panel.setBackground(Color.gray);
        } else if (colorElegido.equals(colores[2])) {
            panel.setBackground(Color.blue);
        } else if (colorElegido.equals(colores[3])) {
            panel.setBackground(Color.cyan);
        } else if (colorElegido.equals(colores[4])) {
            panel.setBackground(Color.green);
        } else if (colorElegido.equals(colores[5])) {
            panel.setBackground(Color.pink);
        } else if (colorElegido.equals(colores[6])) {
            panel.setBackground(Color.yellow);
        } else if (colorElegido.equals(colores[7])) {
            panel.setBackground(Color.white);
        } else if (colorElegido.equals(colores[8])) {
            panel.setBackground(Color.red);
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
