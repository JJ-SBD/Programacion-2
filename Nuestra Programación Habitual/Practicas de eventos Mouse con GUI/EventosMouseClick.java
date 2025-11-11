import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouseClick extends JFrame
{
    private JLabel lblSaludo;
    
    public EventosMouseClick()
    {
        lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // añadir un listener de tipo Mouse
        MouseListener listener = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.isAltDown()){
                    lblSaludo.setText("clic + alt");//lo imprime en la interfaz
                    System.out.println("clic + alt");//lo imprime tambien en la terminal
                }
                else if(e.isControlDown()){
                    lblSaludo.setText("clic + Control");
                    System.out.println("clic + Control");
                }
                else if(e.isShiftDown()){
                    lblSaludo.setText("clic + Shift");
                    System.out.println("clic + Shift");
                }
                else if(e.isMetaDown()){
                    lblSaludo.setText("clic derecho");
                    System.out.println("clic derecho");
                }
                //si no es ninguna de las anterirores marca que es un evento mouseclicked normalito
                else {
                    lblSaludo.setText("clic izquierdo");
                    System.out.println("clic izquierdo");
                }

                // validar doble clic
                if(e.getClickCount() == 2) {
                    lblSaludo.setText("doble clic");
                    System.out.println("doble clic");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        // agregar el listener al boton y al campoSaludo
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[])
    {
        EventosMouseClick objEventoMouse = new EventosMouseClick();
    }
}