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
        panel.setBackground(Color.CYAN);
        this.getContentPane().add(panel);
    }
}
