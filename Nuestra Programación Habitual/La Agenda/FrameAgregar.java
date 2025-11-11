import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAgregar extends JFrame implements ActionListener{
    private JPanel panTitulo,panTextfields,panBotonesSur; // panel principal
    private JLabel lblTitle, lblN, lblA, lblD, lblC, lblT, lblE, lblEma, lblNac, lblSal; // etiquetas
    private JTextField tfN, tfA, tfD, tfC, tfT, tfE, tfEma, tfNac, tfSal; // campos de texto
    private JButton BGuardar, BLeer, BCancelar, BLimpiar; // botones

    public FrameAgregar() {
        super("Agregar contactos"); // JFrame con título

        panTitulo = new JPanel();
        panTextfields = new JPanel();
        panBotonesSur = new JPanel();

        lblTitle = new JLabel("Agregar nuevo contacto");
        lblN = new JLabel("Nombre");
        lblA = new JLabel("Apellidos");
        lblE = new JLabel("Edad");
        lblD = new JLabel("Direccion");
        lblC = new JLabel("Ciudad");
        lblT = new JLabel("Telefono");
        lblEma = new JLabel("E-mail");
        lblNac = new JLabel("Nacionalidad");
        lblSal = new JLabel("Salario");

        tfN = new JTextField();
        tfA = new JTextField();
        tfE = new JTextField();
        tfD = new JTextField();
        tfC = new JTextField();
        tfT = new JTextField();
        tfEma = new JTextField();
        tfNac = new JTextField();
        tfSal = new JTextField();

        BGuardar = new JButton("Guardar");
        BLeer = new JButton("Leer");
        BCancelar = new JButton("Cancelar");
        BLimpiar = new JButton("Limpiar");

        BGuardar.addActionListener(this);
        BLeer.addActionListener(this);
        BCancelar.addActionListener(this);
        BLimpiar.addActionListener(this);
    }
    //método para acomodar los elementos en el JFrame
    public void acomodar() {
        panTitulo.setLayout(new GridLayout( 1, 1));

        panTitulo.add(lblTitle);

        panTextfields.setLayout(new GridLayout( 9, 2));

        panTextfields.add(lblN); panTextfields.add(tfN);
        panTextfields.add(lblA); panTextfields.add(tfA);
        panTextfields.add(lblE); panTextfields.add(tfE);
        panTextfields.add(lblD); panTextfields.add(tfD);
        panTextfields.add(lblC); panTextfields.add(tfC);
        panTextfields.add(lblT); panTextfields.add(tfT);
        panTextfields.add(lblEma); panTextfields.add(tfEma);
        panTextfields.add(lblNac); panTextfields.add(tfNac);
        panTextfields.add(lblSal); panTextfields.add(tfSal);

        panBotonesSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        // Agregamos botones
        panBotonesSur.add(BGuardar);
        panBotonesSur.add(BLeer);
        panBotonesSur.add(BCancelar);
        panBotonesSur.add(BLimpiar);

        add(panTitulo, BorderLayout.NORTH);
        add(panTextfields, BorderLayout.CENTER);
        add(panBotonesSur, BorderLayout.SOUTH); // agregamos el panel al JFrame

        setSize(600, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cerrar solo esta ventana
    }
    //modelo de eventos
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == BCancelar) {
            dispose();
        }
        else if (e.getSource() == BGuardar)
        {
            //obtiene la información de los campos de texto
            String nombre = tfN.getText();
            String apellidos = tfA.getText();
            int edad = Integer.parseInt(tfE.getText());
            String direccion = tfD.getText();
            String ciudad = tfC.getText();
            String telefono = tfT.getText();
            String email = tfEma.getText();
            String nacionalidad = tfNac.getText();
            double salario = Double.parseDouble(tfSal.getText());

            //crea un objeto Persona con la información obtenida
            Persona personaASerializar = new Persona(nombre, apellidos, edad, direccion, ciudad, telefono, email, nacionalidad, salario);
            
            //guarda el objeto Persona en el archivo binario
            boolean exito = CrearArchivoBinario.guardarPersona(personaASerializar);
            
            //verifica si la creacion fue exitosa
            if (exito) {
                JOptionPane.showMessageDialog(this, "Contacto guardado exitosamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == BLimpiar)
        {
            limpiarCampos();
        }

        else if (e.getSource() == BLeer)
        {
        LeerArchivoBinario VentanaLector = new LeerArchivoBinario();
        VentanaLector.setLocationRelativeTo(this);
        VentanaLector.setVisible(true);
        }
    
    }
    public void limpiarCampos()
        {
        tfN.setText("");
        tfA.setText("");
        tfE.setText("");
        tfD.setText("");
        tfC.setText("");
        tfT.setText("");
        tfEma.setText("");
        tfNac.setText("");
        tfSal.setText("");
        }
}