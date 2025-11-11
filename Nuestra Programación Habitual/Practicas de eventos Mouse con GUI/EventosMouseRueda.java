import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseMotionListener;//detecta los mvimientos del mouse

public class EventosMouseRueda extends JFrame
{
    private JLabel lblSaludo;
    private JLabel lblMovedX, lblMovedY, lblDraggedX, lblDraggedY; //estas etiquetas son para desplegar cada vez que se mueve el mouse
    
    public EventosMouseRueda()
    {
        // Etiquetas para coordenadas
        lblMovedX = new JLabel("Moved x: ");
        lblMovedX.setBounds(25, 10, 100, 30);

        lblMovedY = new JLabel("y: ");
        lblMovedY.setBounds(230, 10, 100, 30);

        lblDraggedX = new JLabel("Dragged x: ");
        lblDraggedX.setBounds(25, 40, 110, 30);

        lblDraggedY = new JLabel("y: ");
        lblDraggedY.setBounds(230, 40, 100, 30);
        
        lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 70, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Listener para eventos básicos del mouse
        MouseListener listener = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.isAltDown()){
                    lblSaludo.setText("clic + alt");
                    System.out.println("clic + alt");
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

        // Listener para la rueda del mouse
        MouseWheelListener wheel = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("mouse wheel");
                if(e.getPreciseWheelRotation() < 0){
                    System.out.println("rueda hacia arriba");
                }
                if(e.getPreciseWheelRotation() > 0){
                    System.out.println("rueda hacia abajo");
                }
            }
        };

        // Listener para movimiento del mouse
        MouseMotionListener motionListener = new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("dragged");
                lblDraggedX.setText("Dragged x: " + e.getX());
                lblDraggedY.setText("y: " + e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("moved");
                lblMovedX.setText("Moved x: " + e.getX());
                lblMovedY.setText("y: " + e.getY());
            }
        };

        // Agregar listeners al Frame
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);
        campoSaludo.addMouseWheelListener(wheel);
        this.addMouseMotionListener(motionListener);//la palabra this hace referencia ala clase la cual es una extension de JFrame
        //osea que la clase es el Frame

        // Agregar componentes al frame
        add(lblMovedX);
        add(lblMovedY);
        add(lblDraggedX);
        add(lblDraggedY);
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
        EventosMouseRueda objEventoMouse = new EventosMouseRueda();
    }
}