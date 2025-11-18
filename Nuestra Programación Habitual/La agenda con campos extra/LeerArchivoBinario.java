import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LeerArchivoBinario extends JFrame {

    private ObjectInputStream entrada;
    private DefaultTableModel modelo;

    public LeerArchivoBinario() {
        super("Leer Archivo");
        modelo = new DefaultTableModel();
        modelo.addColumn("Cuenta");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Edad");
        modelo.addColumn("Direccion");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Licenciatura");
        modelo.addColumn("Semestre");

        JTable table = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(table);

        JButton boton = new JButton("Cargar Datos");
        boton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargar();
            }
        }   );

        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }   );

        this.add(scroll);
        this.add(boton);
        this.add(botonCerrar);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
    }

    // Método público que abre, lee y cierra el archivo
    public void cargar() {

        modelo.setRowCount(0); // limpiar la tabla antes de cargar
        File archivo = new File("Personas.bin"); // usa la misma ruta relativa que CrearArchivoBinario
        if (!archivo.exists()) {
            // si quieres, muestra un diálogo; aquí solo retornamos
            System.err.println("No existe " + archivo.getAbsolutePath());
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                Persona objPersona = (Persona) ois.readObject();
                
                int cuenta = objPersona.getCuenta();
                String nombre = objPersona.getNombre();
                String apellidoP = objPersona.getApellidoP();
                String apellidoM = objPersona.getApellidoM();
                int edad = objPersona.getEdad();
                String direccion = objPersona.getDireccion();
                String ciudad = objPersona.getCiudad();
                String telefono = objPersona.getTelefono();
                String email = objPersona.getEmail();
                String nacionalidad = objPersona.getNacionalidad();
                String licenciatura = objPersona.getLicenciatura();
                int semestre = objPersona.getSemestre();

                Object[] datosPersona = {
                    String.valueOf(cuenta),
                    nombre,
                    apellidoP,
                    apellidoM,
                    String.valueOf(edad),
                    direccion,
                    ciudad,
                    telefono,
                    email,
                    nacionalidad,
                    licenciatura,
                    String.valueOf(semestre)
                };
                modelo.addRow(datosPersona);
            }
        } catch (EOFException e) {
            // fin del archivo: comportamiento normal

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }
    }

}
