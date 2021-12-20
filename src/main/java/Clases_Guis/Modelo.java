package Clases_Guis;

import javax.swing.*;
import java.awt.*;

public class Modelo extends JFrame {

    private final int ancho = 600;
    private final int alto = 500;
    private final String titulo= "MeMO";
    private final ImageIcon logoMeMO = new ImageIcon("src/main/java/Imagenes/logo.png");
    private final ImageIcon imagenVolver = new ImageIcon("src/main/java/Imagenes/volver.png");

    private final Font fuente = new Font("arial",2, 15);

    public Container crearVentana() {
        setTitle(titulo);// definir titulo de ventana
        setSize(ancho, alto);// definir tamaño de ventana
        setIconImage(logoMeMO.getImage());// cambia icono de JFrame
        setResizable(false);// opcion de maximizar/minimizar ventana
        setVisible(true);// opcion de visibilidad de la ventana
        setLocationRelativeTo(null);// opcion de "donde quieres que aparezca la ventana", el "null" centra la ventana a la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);//al cerrar la ventana, termina ejecucion de programa
        return getContentPane();
    }


    public JButton crearBoton(JButton button, String text,  Font font, int x, int y, int width, int height) {
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFont(font);
        return button;
    }

    public JButton botonImagenVolver(JButton button, int x, int y) {
        button = new JButton();
        button.setBounds(x, y, 50, 30);
        button.setIcon(new ImageIcon(getImagenVolver().getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH)));
        return button;
    }

    public JLabel modelarEtiqueta(JLabel jLabel, int x, int y, int width, int height, Color color, Font font) {
        jLabel.setBounds(x, y, width, height);
        jLabel.setOpaque(true);
        jLabel.setBackground(color);
        jLabel.setFont(font);
        return jLabel;
    }

    public Font getFuente() {
        return fuente;
    }

    public ImageIcon getImagenVolver() {
        return imagenVolver;
    }
}
