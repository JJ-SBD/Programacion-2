import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
//importar paquetes adicionales
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouse extends JFrame
{
    private JLabel lblSaludo;
    private JTextField campoSaludo;
    private JButton boton;
    
    public EventosMouse()
    {
        //creamos objetos que soportan a los componentes graficos
        lblSaludo = new JLabel();
        //x,y la localizacion donde se va a dibujar, width,height cuanto medira
        lblSaludo.setBounds(25, 10, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // añadir un listener de tipo Mouse
        //creamos la clase anonima para implementar la interfaz mouseListener
        //el objeto e es de tipo mouse event
        MouseListener listener = new MouseListener(){
            @Override
            //aqui estamos detectando el componente fuente donde se obtuvo el evento
            public void mouseClicked(MouseEvent e) {
                //que hacer si el objeto de tipo event source es de campo saludo
                if(e.getSource() == campoSaludo){
                    lblSaludo.setText("MouseClicked dentro de campo saludo");
                }
                //que hacer si el objeto de tipo event source es de boton
                if(e.getSource() == boton){
                    lblSaludo.setText("MouseClicked dentro de boton");
                }
            }
            //si yo no quiero que los metodos implementados hagan algo porque no los necesito, los comento, no puedo borrarlos
            //porque al implementar una interfaz debes poner todos sus metodos
            @Override
            public void mousePressed(MouseEvent e) {
                //lblSaludo.setText("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //lblSaludo.setText("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //lblSaludo.setText("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //lblSaludo.setText("mouseExited");
            }
        };

        /* agregar el listener al boton y al campo de texto */
        //tu boton va a requerir que le implementes el addMouseListener() usando como parametro la referencia al objeto que creaste (listener)
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        //todo esto se esta añadiendo al frame no a la interfaz
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
        EventosMouse objEventoMouse = new EventosMouse();
    }
}