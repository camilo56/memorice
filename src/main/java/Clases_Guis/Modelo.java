package Clases_Guis;

import javax.swing.*;
import java.awt.*;

public class Modelo extends JFrame {

    private final int ancho = 600;
    private final int alto = 500;
    private final String titulo= "MeMO";

    private final Font fuente = new Font("arial",2, 15);

    private JPanel panel;

    public void crearVentana() {
        setTitle(titulo);// definir titulo de ventana
        setSize(ancho, alto);// definir tamaño de ventana
        //setIconImage(new ImageIcon(getClass().getResource("logo.jpg")).getImage()); //NO FUNCIONA, NO SÉ POR QUÉ!
        setResizable(false);// opcion de maximizar/minimizar ventana
        setVisible(true);// opcion de visibilidad de la ventana
        setLocationRelativeTo(null);// opcion de "donde quieres que aparezca la ventana", el "null" centra la ventana a la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);//al cerrar la ventana, termina ejecucion de programa
    }

    public JPanel crearPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        return getPanel();
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public String getTitulo() {
        return titulo;
    }

    public Font getFuente() {
        return fuente;
    }

    public JPanel getPanel() {
        return panel;
    }
}
