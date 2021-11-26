import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana (){
        this.setSize(500,500);
        setTitle("MeMo");
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        //panel.setBackground(Color.CYAN);
        panel.setLayout(null);//desactivando el diseño
        this.getContentPane().add(panel);


        JLabel etiqueta = new JLabel();
        etiqueta.setText("HOLA"); // establecemos al texto de la etiqueta
        etiqueta.setBounds(20,20,100,40);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//Estableze la alineasion horizontal del texto
        etiqueta.setForeground(Color.blue); //establecemos el color de la letra
        etiqueta.setOpaque(true);//establecemos pintar el fondo de la etiqueta
        etiqueta.setBackground(Color.yellow);//cambiamos el color del fondo de la etiqueta
        etiqueta.setFont(new Font("arial",Font.ITALIC,20));//establemos la fuente del texto
        panel.add(etiqueta); //agregamos la etiqueta al panel


        //etiqueta 2-etiqueta tipo imagen
    }
}
