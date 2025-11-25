import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class FrameModificar extends JFrame {

    private JButton btnGuardar;
    private JButton btnCancelar;

    public FrameModificar() {
        // Constructor llamado desde FrameInfoMain: new FrameModificar();
        // Primero pedimos el apellido
        String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del alumno a modificar:", "Modificar", JOptionPane.QUESTION_MESSAGE);

        if (apellido == null) {
            // usuario canceló
            return;
        }
        apellido = apellido.trim();
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un apellido.");
            return;
        }

        try {
            ProcesosBD pb = new ProcesosBD();
            List<Alumno> resultados = pb.buscarPorApellido(apellido);

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El apellido no existe");
                return;
            }

            // Obtener o crear la ventana principal
            FrameInfoMain fmain;
            if (FrameInfoMain.instance != null) {
                fmain = FrameInfoMain.instance;
            } else {
                fmain = new FrameInfoMain();
                fmain.acomodar();
            }

            // Cargar la lista en la ventana principal y permitir edición
            fmain.cargarLista(resultados);
            fmain.habilitarEdicion(true);

            if (resultados.size() == 1) {
                JOptionPane.showMessageDialog(null, "Se encontró 1 registro. Puedes editar los campos y presionar Guardar.");
            } else {
                JOptionPane.showMessageDialog(null, "Fue encontrada más de una coincidencia, use los botones anterior o siguiente para navegar a través de ellas. Cuando tenga el registro correcto, presione Guardar.");
            }

            // Creamos la mini-ventana de control (Guardar / Cancelar)
            JFrame ventana = new JFrame("Guardar cambios");
            ventana.setLayout(new FlowLayout());
            btnGuardar = new JButton("Guardar");
            btnCancelar = new JButton("Cancelar");
            ventana.add(btnGuardar);
            ventana.add(btnCancelar);
            ventana.setSize(300, 100);
            ventana.setResizable(false);

            ventana.setSize(300, 100);   // o ventana.pack()
            ventana.setVisible(true);

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = screen.width - ventana.getWidth();
            int y = 100;

            ventana.setLocation(x, y);

            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            btnGuardar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Obtener el alumno con los datos editados desde FrameInfoMain
                        Alumno actualizado = FrameInfoMain.instance.obtenerAlumnoDesdeCampos();
                        if (actualizado == null) {
                            JOptionPane.showMessageDialog(ventana, "No hay un alumno cargado para guardar.");
                            return;
                        }

                        ProcesosBD pb2 = new ProcesosBD();
                        boolean ok = pb2.actualizarRegistro(actualizado);
                        if (ok) {
                            JOptionPane.showMessageDialog(ventana, "Registro actualizado correctamente.");
                            // deshabilitar edición
                            FrameInfoMain.instance.habilitarEdicion(false);
                            // opcional: refrescar la lista recargando desde BD el registro actual
                            ventana.dispose();
                        } else {
                            JOptionPane.showMessageDialog(ventana, "No se actualizó ningún registro (verifica la clave).");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(ventana, "Error al guardar: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            });

            btnCancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // recargar la fila actual para descartar cambios y desactivar edición
                    if (FrameInfoMain.instance != null && FrameInfoMain.instance.listaResultados != null && FrameInfoMain.instance.indiceActual >= 0) {
                        FrameInfoMain.instance.cargarAlumno(FrameInfoMain.instance.listaResultados.get(FrameInfoMain.instance.indiceActual));
                        FrameInfoMain.instance.habilitarEdicion(false);
                    }
                    ventana.dispose();
                }
            });

            ventana.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
