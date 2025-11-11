import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class EventosTeclado extends JFrame
{
    private JLabel lblSaludo;
    
    public EventosTeclado()
    {
        lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Listener para eventos del teclado
        KeyListener keyL = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent event) {
                System.out.println("keyTyped: " + event.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent event) {
                System.out.println("keyPressed - Código: " + event.getKeyCode());

                // Detectar teclas específicas
                if(event.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("Has presionado ENTER");
                    lblSaludo.setText("Presionaste ENTER");
                }
                else if(event.getKeyCode() == KeyEvent.VK_F1){
                    System.out.println("Has presionado la tecla F1");
                    lblSaludo.setText("Presionaste F1");
                }
                else if(event.getKeyCode() == KeyEvent.VK_A){
                    System.out.println("Has presionado la tecla A");
                    lblSaludo.setText("Presionaste A");
                }
                else if(event.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.out.println("Has presionado ESC");
                    lblSaludo.setText("Presionaste ESC");
                }
                else {
                    lblSaludo.setText("Tecla: " + KeyEvent.getKeyText(event.getKeyCode()));
                }
                
                // Detectar combinaciones de teclas
                if(event.isControlDown() && event.getKeyCode() == KeyEvent.VK_C){
                    System.out.println("Ctrl + C presionado");
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {
                System.out.println("keyReleased: " + event.getKeyChar());
            }
        };

        // agregar el listener al componente campoSaludo
        campoSaludo.addKeyListener(keyL);

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
        EventosTeclado objEventosTeclado = new EventosTeclado();
    }
}