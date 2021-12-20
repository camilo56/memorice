package Clases_Guis;

import javax.swing.*;
import java.awt.*;

public abstract class Modelo extends JFrame {

    //private Color color;
    private final int ancho = 600;
    private final int alto = 500;
    private final String titulo= "MeMOfhffhjfhfc";
    private final ImageIcon logoMeMO = new ImageIcon("src/main/java/Imagenes/logo.png");
    private final ImageIcon imagenVolver = new ImageIcon("src/main/java/Imagenes/volver.png");

    private final Font fuente = new Font("arial",2, 15);

    public Container crearVentana() {
        setTitle(titulo);// definir titulo de ventana
        setSize(ancho, alto);// definir tamaño de ventana,establece el tamaño del componente.
        setIconImage(logoMeMO.getImage());// cambia icono de JFrame
        setResizable(true);// opcion de maximizar/minimizar ventana
        setVisible(true);// opcion de visibilidad de la ventana
        setLocationRelativeTo(null);// opcion de "donde quieres que aparezca la ventana", el "null" centra la ventana a la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);//al cerrar la ventana, termina ejecucion de programa
        // La función del parámetro: 0: no se cerrará el cuadro de diálogo del botón Cerrar;
        // 1: haga clic en el botón Cerrar para cerrar el cuadro de diálogo inmediatamente, pero el programa siempre está abierto;
        // 2: el cuadro de diálogo se cerrará inmediatamente después de hacer clic en el botón Cerrar, pero el programa finalizará después de unos segundos;
        // 3: Después de hacer clic en el botón Cerrar, tanto el cuadro de diálogo como el programa se cierran inmediatamente; otros números informarán un error de parámetro ilegal.

        return getContentPane();
    }
    /*
    public JPanel crearPanel(Container ventana) {
        //obtenerColorPanel();
        panel = new JPanel();
        panel.setLayout(null);
        //panel.setBackground(getColor());
        ventana.add(panel);
        return getPanel();
    }
     */

    public static JButton crearBoton(JButton button, String text, Font font, int x, int y, int width, int height) {
        button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setHorizontalAlignment(SwingConstants.CENTER);//Establece la alineación del contenido de la etiqueta a lo largo del eje X.JLabel
        button.setFont(font);
        return button;
    }

    public JButton botonImagenVolver(JButton button, int x, int y) {
        button = new JButton();
        button.setBounds(x, y, 50, 30);//setBounds se utiliza para definir el rectángulo delimitador de un componente.
        // Esto incluye su posición y tamaño. El se usa en varios lugares dentro del marco. Lo utiliza el administrador de diseño para definir la posición y el tamaño
        // de un componente dentro de su contenedor principal.
        button.setIcon(new ImageIcon(getImagenVolver().getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH)));
        return button;
    }

    public JLabel modelarEtiqueta(JLabel jLabel, int x, int y, int width, int height, Color color, Font font) {
        jLabel.setBounds(x, y, width, height);
        jLabel.setOpaque(true);//Si es verdadero, el componente pinta cada píxel dentro de sus límites.
        // De lo contrario, es posible que el componente no pinte algunos o todos sus píxeles, permitiendo que los píxeles subyacentes se vean.
        // en resumen es la opcacidad de un componente con respecto al color gtenral del jframe
        jLabel.setBackground(color);//establecer el color de fondo
        jLabel.setFont(font);//La clase Font nos permite cambiar la familia de fuentes y el estilo de las letras que utilizamos para
        // construir las palabras en la interfaz de usuario de nuestra aplicación, su uso es muy similar en forma a la clase Color
        // y reside en el paquete java.
        return jLabel;
    }

    /* NO HE PODIDO IMPLEMENTAR LO DE CAMBIAR EL COLOR A NIVEL GLOBAL
    private void obtenerColorPanel() {
        GestorArchivo ga = new GestorArchivo();
        String rutaColor = "src/main/java/Datos/color.txt";
        this.color = Color.ga.obtenerLineasArchivo(rutaColor);
        //System.out.println(ga.obtenerLineasArchivo("src/main/java/Datos/color.txt"));
        //System.out.println(Color.gaobtenerLineasArchivo(rutaColor));
    }
     */

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



    /*
    public Color getColor() {
        return color;
    }

    public  void setColor(Color color) {

        this.color = color;
    }
 */

    public ImageIcon getImagenVolver() {
        return imagenVolver;
    }

    public abstract JPanel getPanel();
}