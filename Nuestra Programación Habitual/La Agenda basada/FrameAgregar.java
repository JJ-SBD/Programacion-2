import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAgregar extends JFrame implements ActionListener {
    private JPanel panTitulo,panTextfields,panBotonesSur; // panel principal
    private JLabel lblTitle, lblNc, lblN, lblA, lblAm, lblD, lblC, lblT, lblE, lblEma, lblNac, lblLic, lblSem; // etiquetas
    private JTextField tfNc, tfN, tfA, tfAm, tfE, tfD, tfC, tfT, tfEma, tfNac, tfLic, tfSem; // campos de texto
    private JButton BGuardar, BLeer, BCancelar, BLimpiar; // botones

    public FrameAgregar() {
        super("Agregar contactos"); // JFrame con título

        panTitulo = new JPanel();
        panTextfields = new JPanel();
        panBotonesSur = new JPanel();

        lblTitle = new JLabel("Agregar nuevo contacto");
        lblNc = new JLabel("Numero de cuenta");
        lblN = new JLabel("Nombre");
        lblA = new JLabel("Apellido Paterno");
        lblAm = new JLabel("Apellido Materno");
        lblE = new JLabel("Edad");
        lblD = new JLabel("Direccion");
        lblC = new JLabel("Ciudad");
        lblT = new JLabel("Telefono");
        lblEma = new JLabel("E-mail");
        lblNac = new JLabel("Nacionalidad");
        lblLic = new JLabel("Licenciatura");
        lblSem = new JLabel("Semestre");

        tfNc = new JTextField();
        tfN = new JTextField();
        tfA = new JTextField();
        tfAm = new JTextField();
        tfE = new JTextField();
        tfD = new JTextField();
        tfC = new JTextField();
        tfT = new JTextField();
        tfEma = new JTextField();
        tfNac = new JTextField();
        tfLic = new JTextField();
        tfSem = new JTextField();

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

        panTextfields.setLayout(new GridLayout( 12, 2));

        panTextfields.add(lblNc); panTextfields.add(tfNc);
        panTextfields.add(lblN); panTextfields.add(tfN);
        panTextfields.add(lblA); panTextfields.add(tfA);
        panTextfields.add(lblAm); panTextfields.add(tfAm);
        panTextfields.add(lblE); panTextfields.add(tfE);
        panTextfields.add(lblD); panTextfields.add(tfD);
        panTextfields.add(lblC); panTextfields.add(tfC);
        panTextfields.add(lblT); panTextfields.add(tfT);
        panTextfields.add(lblEma); panTextfields.add(tfEma);
        panTextfields.add(lblNac); panTextfields.add(tfNac);
        panTextfields.add(lblLic); panTextfields.add(tfLic);
        panTextfields.add(lblSem); panTextfields.add(tfSem);

        panBotonesSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        // Agregamos botones
        panBotonesSur.add(BGuardar);
        panBotonesSur.add(BLeer);
        panBotonesSur.add(BCancelar);
        panBotonesSur.add(BLimpiar);

        add(panTitulo, BorderLayout.NORTH);
        add(panTextfields, BorderLayout.CENTER);
        add(panBotonesSur, BorderLayout.SOUTH); // agregamos el panel al JFrame

        setSize(1000, 500);
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
            int cuenta = Integer.parseInt(tfNc.getText());
            String nombre = tfN.getText();
            String apellidoP = tfA.getText();
            String apellidoM = tfAm.getText();
            int edad = Integer.parseInt(tfE.getText());
            String direccion = tfD.getText();
            String ciudad = tfC.getText();
            String telefono = tfT.getText();
            String email = tfEma.getText();
            String nacionalidad = tfNac.getText();
            String licenciatura = tfLic.getText();
            int semestre = Integer.parseInt(tfSem.getText());

    try {
    // crear y llenar objeto Alumno (usa los setters)
    Alumno alumno = new Alumno();
    alumno.setCuenta(Integer.parseInt(tfNc.getText()));
    alumno.setNombre(tfN.getText());
    alumno.setApellidoP(tfA.getText());
    alumno.setApellidoM(tfAm.getText());
    alumno.setEdad(Integer.parseInt(tfE.getText()));
    alumno.setDireccion(tfD.getText());
    alumno.setCiudad(tfC.getText());
    alumno.setTelefono(tfT.getText());
    alumno.setEmail(tfEma.getText());
    alumno.setNacionalidad(tfNac.getText());
    alumno.setLicenciatura(tfLic.getText());
    alumno.setSemestre(Integer.parseInt(tfSem.getText()));

    // insertar en la BD usando ProcesosBD
    ProcesosBD procesos = new ProcesosBD();
    procesos.setAlumno(alumno);
    procesos.insertarRegistro(); // si lanzar excepción, irá al catch

    JOptionPane.showMessageDialog(this, "Contacto guardado exitosamente.");
    limpiarCampos();

    } catch (NumberFormatException nfe) {
    JOptionPane.showMessageDialog(this, "Verifica los campos numéricos (cuenta, edad, semestre).",
            "Error de formato", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos.\n" + ex.getMessage(),
            "Error BD", JOptionPane.ERROR_MESSAGE);
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
        tfNc.setText("");
        tfN.setText("");
        tfA.setText("");
        tfAm.setText("");
        tfE.setText("");
        tfD.setText("");
        tfC.setText("");
        tfT.setText("");
        tfEma.setText("");
        tfNac.setText("");
        tfLic.setText("");
        tfSem.setText("");
        }
}