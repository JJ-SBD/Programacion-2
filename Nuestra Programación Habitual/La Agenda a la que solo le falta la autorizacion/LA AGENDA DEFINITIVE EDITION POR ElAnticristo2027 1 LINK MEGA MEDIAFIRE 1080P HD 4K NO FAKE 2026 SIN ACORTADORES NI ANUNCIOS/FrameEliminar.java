import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * FrameEliminar: pide un apellido, busca coincidencias, carga resultados en FrameInfoMain
 * y abre una mini-ventana con botones Eliminar / Cancelar. 
 *
 * Flujo:
 * - 0 coincidencias -> mensaje "El apellido no existe"
 * - 1 coincidencia -> carga en FrameInfoMain, habilita navegación y permite eliminar
 * - >1 coincidencia -> carga lista en FrameInfoMain, muestra mensaje sobre navegación, permite seleccionar y eliminar
 */
public class FrameEliminar extends JFrame {

    private JButton btnEliminar;
    private JButton btnCancelar;
    private JFrame ventanaControl;

    public FrameEliminar() {
        // Pedir apellido
        String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del alumno a eliminar:", "Eliminar", JOptionPane.QUESTION_MESSAGE);

        if (apellido == null) {
            // canceló
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

            // Obtener o crear la ventana principal (FrameInfoMain)
            FrameInfoMain fmain;
            if (FrameInfoMain.instance != null) {
                fmain = FrameInfoMain.instance;
            } else {
                fmain = new FrameInfoMain();
                fmain.acomodar();
            }

            // Cargar la lista en la ventana principal y deshabilitar edición (solo para ver)
            fmain.cargarLista(resultados);
            fmain.habilitarEdicion(false); // no queremos edición en eliminar, sólo visualizar

            if (resultados.size() == 1) {
                JOptionPane.showMessageDialog(null, "Se encontró 1 registro. Use Eliminar para borrarlo.");
            } else {
                JOptionPane.showMessageDialog(null, "Fue encontrada más de una coincidencia, use los botones anterior o siguiente para navegar a través de ellas. Cuando esté en el registro correcto, presione Eliminar.");
            }

            // Creamos la mini-ventana de control (Eliminar / Cancelar)
            ventanaControl = new JFrame("Eliminar");
            ventanaControl.setLayout(new FlowLayout());
            btnEliminar = new JButton("Eliminar");
            btnCancelar = new JButton("Cancelar");
            ventanaControl.add(btnEliminar);
            ventanaControl.add(btnCancelar);
            ventanaControl.setSize(360, 110);
            ventanaControl.setResizable(false);

            ventanaControl.setSize(300, 100);   // o ventana.pack()
            ventanaControl.setVisible(true);

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = screen.width - ventanaControl.getWidth();
            int y = 100;

            ventanaControl.setLocation(x, y);

            
            ventanaControl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            btnEliminar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // obtener alumno actualmente seleccionado en la UI principal
                    Alumno aEliminar = FrameInfoMain.instance.obtenerAlumnoDesdeCampos();
                    if (aEliminar == null) {
                        JOptionPane.showMessageDialog(ventanaControl, "No hay un alumno seleccionado para eliminar.");
                        return;
                    }

                    int confirm = JOptionPane.showConfirmDialog(ventanaControl,
                            "¿Seguro que desea eliminar al alumno:\n" +
                                    (aEliminar.getNombre() != null ? aEliminar.getNombre() : "") + " " +
                                    (aEliminar.getApellidoP() != null ? aEliminar.getApellidoP() : "") + " ?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (confirm != JOptionPane.YES_OPTION) return;

                    try {
                        ProcesosBD pb2 = new ProcesosBD();
                        boolean ok = pb2.eliminarRegistro(aEliminar);
                        if (ok) {
                            JOptionPane.showMessageDialog(ventanaControl, "Registro eliminado correctamente.");

                            // Actualizar listaResultados en FrameInfoMain: quitar el elemento eliminado
                            if (FrameInfoMain.instance.listaResultados != null) {
                                // buscar por cuenta y eliminar de la lista local
                                int idx = -1;
                                for (int i = 0; i < FrameInfoMain.instance.listaResultados.size(); i++) {
                                    if (FrameInfoMain.instance.listaResultados.get(i).getCuenta() == aEliminar.getCuenta()) {
                                        idx = i;
                                        break;
                                    }
                                }
                                if (idx != -1) {
                                    FrameInfoMain.instance.listaResultados.remove(idx);
                                    // ajustar indiceActual
                                    if (FrameInfoMain.instance.listaResultados.isEmpty()) {
                                        FrameInfoMain.instance.indiceActual = -1;
                                        FrameInfoMain.instance.cargarAlumno(null);
                                    } else {
                                        if (FrameInfoMain.instance.indiceActual >= FrameInfoMain.instance.listaResultados.size()) {
                                            FrameInfoMain.instance.indiceActual = FrameInfoMain.instance.listaResultados.size() - 1;
                                        }
                                        FrameInfoMain.instance.cargarAlumno(FrameInfoMain.instance.listaResultados.get(FrameInfoMain.instance.indiceActual));
                                    }
                                } else {
                                    // si no lo encontró por alguna razón, simplemente recargamos el primer registro (si existe)
                                    if (!FrameInfoMain.instance.listaResultados.isEmpty()) {
                                        FrameInfoMain.instance.indiceActual = 0;
                                        FrameInfoMain.instance.cargarAlumno(FrameInfoMain.instance.listaResultados.get(0));
                                    } else {
                                        FrameInfoMain.instance.cargarAlumno(null);
                                    }
                                }
                            } else {
                                FrameInfoMain.instance.cargarAlumno(null);
                            }

                            ventanaControl.dispose();
                        } else {
                            JOptionPane.showMessageDialog(ventanaControl, "No se eliminó el registro (verifica la clave).");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(ventanaControl, "Error al eliminar: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            });

            btnCancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // recargar la fila actual para descartar cambios (no aplica) y cerrar
                    if (FrameInfoMain.instance != null && FrameInfoMain.instance.listaResultados != null && FrameInfoMain.instance.indiceActual >= 0) {
                        FrameInfoMain.instance.cargarAlumno(FrameInfoMain.instance.listaResultados.get(FrameInfoMain.instance.indiceActual));
                    }
                    ventanaControl.dispose();
                }
            });

            ventanaControl.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
