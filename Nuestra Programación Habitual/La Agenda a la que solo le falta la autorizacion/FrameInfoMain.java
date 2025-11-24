
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class FrameInfoMain extends JFrame implements ActionListener
{
    public static FrameInfoMain instance;

    private JFrame ventanaInfo;
    private JPanel panTitulo, panTextfields, panBotonesLaterales, panPanelesSur, panBotonesSur, panBotonSalirSur;
    private JLabel lblTitle, lblN, lblA, lblD, lblC, lblT, lblE;
    private JTextField tfN, tfA, tfD, tfC, tfT, tfE;
    private JButton BBuscar, BAgregar, BModificar, BEliminar;
    private JButton BPrimero, BAnterior, BSiguiente, BUltimo;
    private JButton BSalir;
    private JButton BLimpiar;

    // para manejar resultados de búsqueda y edición
    public List<Alumno> listaResultados = new ArrayList<>();
    public int indiceActual = -1;
    private Alumno alumnoActual = null;

    public FrameInfoMain()
    {
        // referencia global
        instance = this;

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
        tfN.setEditable(false);
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
        // IMPORTANT: add ActionListener so the button reacts
        BModificar.addActionListener(this);

        BEliminar = new JButton("Eliminar");
        BEliminar.addActionListener(this);


        BPrimero = new JButton("Primero");
        BAnterior = new JButton("Anterior");
        BSiguiente = new JButton("Siguiente");
        BUltimo = new JButton("Ultimo");

        BPrimero.addActionListener(e -> irAlPrimero());
        BAnterior.addActionListener(e -> irAlAnterior());
        BSiguiente.addActionListener(e -> irAlSiguiente());
        BUltimo.addActionListener(e -> irAlUltimo());

        BSalir = new JButton("Salir");
        BLimpiar = new JButton("Limpiar");
        BLimpiar.addActionListener(this);
    }

    public void acomodar()
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
        panBotonSalirSur.add(BLimpiar);
        BLimpiar.addActionListener(new ManagerBotonLimpiar());
        panBotonSalirSur.add(BSalir);
        BSalir.addActionListener(new ManagerBotonSalir());

        ventanaInfo.add(panTitulo, BorderLayout.NORTH);
        ventanaInfo.add(panTextfields, BorderLayout.CENTER);
        ventanaInfo.add(panBotonesLaterales, BorderLayout.EAST);
        ventanaInfo.add(panPanelesSur, BorderLayout.SOUTH);
        panPanelesSur.add(panBotonesSur);
        panPanelesSur.add(panBotonSalirSur);

        ventanaInfo.setSize(550, 550);
        ventanaInfo.setLocationRelativeTo(null);
        ventanaInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaInfo.setVisible(true);
    }

    public static void main(String[] args)
    {
        FrameInfoMain ventanaInfo = new FrameInfoMain();
        ventanaInfo.acomodar();
    }

    class ManagerBotonSalir implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(-1);
        }
    }

    class ManagerBotonLimpiar implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent) {
            tfN.setText("");
            tfA.setText("");
            tfD.setText("");
            tfC.setText("");
            tfT.setText("");
            tfE.setText("");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BBuscar) {
            FrameBuscar ventanaBuscar = new FrameBuscar();
            ventanaBuscar.setLocationRelativeTo(ventanaInfo);
            ventanaBuscar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else if(e.getSource() == BAgregar) {
            FrameAgregar ventanaAgregar = new FrameAgregar();
            ventanaAgregar.acomodar();
            ventanaAgregar.setLocationRelativeTo(ventanaInfo);
            ventanaAgregar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (e.getSource() == BModificar) {
            // Abre la ventana de modificación; FrameModificar maneja el resto
            FrameModificar ventanaModificar = new FrameModificar();
            // centrar respecto a la ventana principal
            ventanaModificar.setLocationRelativeTo(ventanaInfo);
            ventanaModificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } else if (e.getSource() == BEliminar) {
            FrameEliminar ventanaEliminar = new FrameEliminar();
            ventanaEliminar.setLocationRelativeTo(ventanaInfo);
            ventanaEliminar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        
    }

    // --- Métodos para manejar resultados de búsqueda y navegación ---

    public void cargarAlumno(Alumno a) {
        if (a == null) {
            tfN.setText("");
            tfA.setText("");
            tfD.setText("");
            tfC.setText("");
            tfT.setText("");
            tfE.setText("");
            alumnoActual = null;
            return;
        }

        alumnoActual = a;

        tfN.setText(a.getNombre() != null ? a.getNombre() : "");
        String apellidos = "";
        if (a.getApellidoP() != null) apellidos += a.getApellidoP();
        if (a.getApellidoM() != null && !a.getApellidoM().isEmpty()) {
            if (!apellidos.isEmpty()) apellidos += " ";
            apellidos += a.getApellidoM();
        }
        tfA.setText(apellidos);
        tfD.setText(a.getDireccion() != null ? a.getDireccion() : "");
        tfC.setText(a.getCiudad() != null ? a.getCiudad() : "");
        tfT.setText(a.getTelefono() != null ? a.getTelefono() : "");
        tfE.setText(a.getEmail() != null ? a.getEmail() : "");
    }

    public void cargarLista(List<Alumno> lista) {
        if (lista == null || lista.isEmpty()) {
            listaResultados.clear();
            indiceActual = -1;
            cargarAlumno(null);
            return;
        }
        this.listaResultados = lista;
        this.indiceActual = 0;
        cargarAlumno(listaResultados.get(indiceActual));
    }

    public void irAlAnterior() {
        if (listaResultados == null || listaResultados.isEmpty()) return;
        if (indiceActual > 0) {
            indiceActual--;
            cargarAlumno(listaResultados.get(indiceActual));
        } else {
            JOptionPane.showMessageDialog(ventanaInfo, "Ya estás en el primer registro.");
        }
    }

    public void irAlSiguiente() {
        if (listaResultados == null || listaResultados.isEmpty()) return;
        if (indiceActual < listaResultados.size() - 1) {
            indiceActual++;
            cargarAlumno(listaResultados.get(indiceActual));
        } else {
            JOptionPane.showMessageDialog(ventanaInfo, "Ya estás en el último registro.");
        }
    }

    public void irAlPrimero() {
        if (listaResultados == null || listaResultados.isEmpty()) return;
        indiceActual = 0;
        cargarAlumno(listaResultados.get(indiceActual));
    }

    public void irAlUltimo() {
        if (listaResultados == null || listaResultados.isEmpty()) return;
        indiceActual = listaResultados.size() - 1;
        cargarAlumno(listaResultados.get(indiceActual));
    }

    /** Permite activar/desactivar la edición de los textfields */
    public void habilitarEdicion(boolean habilitar) {
        tfN.setEditable(habilitar);
        tfA.setEditable(habilitar);
        tfD.setEditable(habilitar);
        tfC.setEditable(habilitar);
        tfT.setEditable(habilitar);
        tfE.setEditable(habilitar);
    }

    /**
     * Construye y retorna un objeto Alumno con los datos actualmente
     * visibles en los textfields. Preserva la cuenta del alumno cargado
     * en memoria (alumnoActual) para usarla como clave en la actualización.
     */
    public Alumno obtenerAlumnoDesdeCampos() {
        if (alumnoActual == null) return null;

        Alumno a = new Alumno();
        a.setCuenta(alumnoActual.getCuenta()); // mantener la PK

        a.setNombre(tfN.getText().trim());

        // dividir campo de apellidos en paterno y materno (si hay)
        String ap = tfA.getText().trim();
        if (ap.isEmpty()) {
            a.setApellidoP("");
            a.setApellidoM("");
        } else {
            String[] partes = ap.split("\\s+", 2);
            a.setApellidoP(partes[0]);
            if (partes.length > 1) a.setApellidoM(partes[1]);
            else a.setApellidoM("");
        }

        a.setDireccion(tfD.getText().trim());
        a.setCiudad(tfC.getText().trim());
        a.setTelefono(tfT.getText().trim());
        a.setEmail(tfE.getText().trim());

        return a;
    }
}
