import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameInfo extends JFrame implements ActionListener
{
    // declaramos que componentes existiran en nuestra ventana
    private JFrame ventanaInfo; //nombre del frame
    private JPanel panTitulo, panTextfields, panBotonesLaterales, panPanelesSur, panBotonesSur, panBotonSalirSur; //nombre del panel
    private JLabel lblTitle, lblN, lblA, lblD, lblC, lblT, lblE; //los labels son etiquetas con texto
    private JTextField tfN, tfA, tfD, tfC, tfT, tfE; // textfields
    private JButton BBuscar, BAgregar, BModificar, BEliminar; //botones laterales
    private JButton BPrimero, BAnterior, BSiguiente, BUltimo; //botones inferiores
    private JButton BSalir; //boton salir

    public FrameInfo() //metodo constructor donde creamos nuestros componentes junto con lo que van mostrar
    {
        ventanaInfo = new JFrame("Mostrar informacion");

        panTitulo = new JPanel();
        panTextfields = new JPanel();
        panBotonesLaterales = new JPanel();
        panBotonesSur = new JPanel();
        panBotonSalirSur = new JPanel();
        panPanelesSur = new JPanel();

        lblTitle = new JLabel("Agenda de contactos");
        lblN = new JLabel("Nombre");
        lblA = new JLabel("Apellidos");
        lblD = new JLabel("Direccion");
        lblC = new JLabel("Ciudad");
        lblT = new JLabel("Telefono");
        lblE = new JLabel("E-mail");

        tfN = new JTextField();
        tfN.setEditable(false); //no añadiremos limite de chars
        tfA = new JTextField();
        tfA.setEditable(false);
        tfD = new JTextField();
        tfD.setEditable(false);
        tfC = new JTextField();
        tfC.setEditable(false);
        tfT = new JTextField();
        tfT.setEditable(false);
        tfE = new JTextField();
        tfE.setEditable(false);

        BBuscar = new JButton("Buscar");
        BBuscar.addActionListener(this);

        BAgregar = new JButton("Agregar");
        BAgregar.addActionListener(this);

        BModificar = new JButton("Modificar");
        BEliminar = new JButton("Eliminar");

        BPrimero = new JButton("Primero");
        BAnterior = new JButton("Anterior");
        BSiguiente = new JButton("Siguiente");
        BUltimo = new JButton("Ultimo");

        BSalir = new JButton("Salir");
    }

    public void acomodar() //ahora los vamos a acomodar
    {
        panTitulo.setLayout(new GridLayout( 1, 1));

        panTitulo.add(lblTitle);

        panTextfields.setLayout(new GridLayout( 6, 2));

        panTextfields.add(lblN); panTextfields.add(tfN);
        panTextfields.add(lblA); panTextfields.add(tfA);
        panTextfields.add(lblD); panTextfields.add(tfD);
        panTextfields.add(lblC); panTextfields.add(tfC);
        panTextfields.add(lblT); panTextfields.add(tfT);
        panTextfields.add(lblE); panTextfields.add(tfE);

        panBotonesLaterales.setLayout(new GridLayout( 4, 1));

        panBotonesLaterales.add(BBuscar);
        panBotonesLaterales.add(BAgregar);
        panBotonesLaterales.add(BModificar);
        panBotonesLaterales.add(BEliminar);

        panPanelesSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        panBotonesSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        panBotonesSur.add(BPrimero);
        panBotonesSur.add(BAnterior);
        panBotonesSur.add(BSiguiente);
        panBotonesSur.add(BUltimo);

        panBotonSalirSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        panBotonSalirSur.add(BSalir);
        // el action Listener para el boton
        BSalir.addActionListener(new ManagerBotonSalir());

        ventanaInfo.add(panTitulo, BorderLayout.NORTH);
        ventanaInfo.add(panTextfields, BorderLayout.CENTER);
        ventanaInfo.add(panBotonesLaterales, BorderLayout.EAST);
        ventanaInfo.add(panPanelesSur, BorderLayout.SOUTH);
        panPanelesSur.add(panBotonesSur);
        panPanelesSur.add(panBotonSalirSur);
        

        ventanaInfo.setSize(500, 500);
        ventanaInfo.setLocationRelativeTo(null);
        ventanaInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaInfo.setVisible(true);
    }

    public static void main(String[] args)
    {
        FrameInfo ventanaInfo = new FrameInfo();
        ventanaInfo.acomodar();
    }
    
    //la implementacion de la interfaz ActionListener para detectar el evento del boton salir

    class ManagerBotonSalir implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(-1);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BBuscar) {
            String apellido = "";
            apellido = (String) JOptionPane.showInputDialog(ventanaInfo, "Apellido", "Buscar", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(ventanaInfo, "Ha sido encontrado el apellido: " + apellido);
        }
        else if(e.getSource() == BAgregar) {
            FrameAgregar ventanaAgregar = new FrameAgregar();
            ventanaAgregar.acomodar();
            ventanaAgregar.setLocationRelativeTo(ventanaInfo);
            ventanaAgregar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}