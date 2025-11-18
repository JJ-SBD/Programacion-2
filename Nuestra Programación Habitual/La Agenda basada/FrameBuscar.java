import javax.swing.*;
import java.awt.*;

public class FrameBuscar extends JFrame {
    private JPanel pan1; 
    private JLabel lblA;
    private JTextField tfA;
    private JButton BBuscar;
    private JButton BCancelar;

    public FrameBuscar() {
        super("3er Frame");

        pan1 = new JPanel();

        lblA = new JLabel("Apellidos");
        tfA = new JTextField();

        BBuscar = new JButton("Buscar");
        BCancelar = new JButton("Cancelar");
    }

    public void acomodar() {
        pan1.setLayout(new GridLayout(3, 2));

        pan1.add(lblA);
        pan1.add(tfA);

        pan1.add(BBuscar);
        pan1.add(BCancelar);

        add(pan1); // añadimos el panel directamente al JFrame

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // se cierra solo esta ventana
    }
}
