import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*; // el * importa todas las clases de swing por si acaso
import java.awt.*; // el * importa todas las clases de awt por si acaso
import java.awt.event.*; // todas las clases del paquete event

public class CrearArchivoTexto // declaramos que componentes existiran
{
    private JFrame ventana; //nombre del frame
    private JPanel panSaludo, panRuta, panTexto, panBotones; //nombre del panel
    private JLabel lblSaludo, lblRuta, lblTexto; //los labels son etiquetas con texto
    private JTextField tfRuta, tfTexto; // textfields
    private JButton BSeleccionar, BCrear, BSalir; //boton salir

    public CrearArchivoTexto() //metodo constructor donde creamos nuestros componentes junto con lo que van mostrar
    {
        ventana = new JFrame("Crea tu archivo de texto");

        panSaludo = new JPanel();

        panRuta = new JPanel();
        panTexto = new JPanel();
        panBotones = new JPanel();
        
        lblSaludo = new JLabel("Saludos Usuario. Con este programa seleccionaras la ruta y nombre para crear un archivo de texto");
        
        lblRuta = new JLabel("Ruta donde se creara tu archivo:");
        BSeleccionar = new JButton("Seleccionar");
        tfRuta = new JTextField();

        lblTexto = new JLabel("Texto a escribir:");

        
        tfTexto = new JTextField();

        
        BCrear = new JButton("Crear");
        BSalir = new JButton("Salir");

        BSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(ventana, "Seleccionar archivo", FileDialog.SAVE);
                //este es el responsable de abrir el explorador de archivos en el navegador
                fd.setVisible(true);
                String directorio = fd.getDirectory();
                String nombre = fd.getFile();

                if (directorio != null && nombre != null) {
                    tfRuta.setText(directorio + nombre);
                }
            }
        });

        BCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta = tfRuta.getText().trim();
                String texto = tfTexto.getText().trim();

                if (ruta.isEmpty()) {
                    JOptionPane.showMessageDialog(ventana, "Selecciona una ruta o escriba una que sea valida.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try (PrintWriter salida = new PrintWriter(new FileWriter(ruta))) {
                    salida.println(texto);
                    JOptionPane.showMessageDialog(ventana, "El archivo se creo correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(ventana, "Ocurrio un error al crear o escribir el archivo.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        BSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(-1);
            }
        });
    }

    public void acomodar()
    {
        panSaludo.setLayout(new GridLayout( 1, 1));

        panSaludo.add(lblSaludo);

        panRuta.setLayout(new GridLayout( 1, 3));

        panRuta.add(lblRuta); panRuta.add(tfRuta); panRuta.add(BSeleccionar);

        panTexto.setLayout(new GridLayout( 1, 2));

        panTexto.add(lblTexto); panTexto.add(tfTexto);

        panBotones.setLayout(new GridLayout( 1, 2));
        panBotones.add(BCrear); panBotones.add(BSalir);

        ventana.add(panSaludo, BorderLayout.NORTH);
        ventana.add(panRuta, BorderLayout.CENTER);
        ventana.add(panTexto, BorderLayout.EAST);
        ventana.add(panBotones, BorderLayout.SOUTH);
        

        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public static void main(String[] args)
    {
        CrearArchivoTexto ventana = new CrearArchivoTexto();
        ventana.acomodar();
    }
}