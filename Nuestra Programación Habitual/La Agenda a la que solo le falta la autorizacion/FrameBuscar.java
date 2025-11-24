
// ------------------- FrameBuscar.java (modificado) -------------------
import javax.swing.*;
import java.util.List;

public class FrameBuscar extends JFrame {

    public FrameBuscar() {
        // método simplificado: cuando se crea la ventana de búsqueda, pedimos el apellido
        String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del alumno:", "Buscar", JOptionPane.QUESTION_MESSAGE);

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

            if (resultados.size() == 1) {
                // cargar en la ventana principal (FrameInfoMain)
                if (FrameInfoMain.instance != null) {
                    FrameInfoMain.instance.cargarAlumno(resultados.get(0));
                } else {
                    // si no existe la instancia, abrimos una nueva (opcional)
                    FrameInfoMain f = new FrameInfoMain();
                    f.cargarAlumno(resultados.get(0));
                    f.setVisible(true);
                }

            } else {
                // mas de una coincidencia
                if (FrameInfoMain.instance != null) {
                    FrameInfoMain.instance.cargarLista(resultados);
                    JOptionPane.showMessageDialog(null, "Fue encontrada más de una coincidencia, use los botones anterior o siguiente para navegar a través de ellas");
                } else {
                    FrameInfoMain f = new FrameInfoMain();
                    f.cargarLista(resultados);
                    f.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Fue encontrada más de una coincidencia, use los botones anterior o siguiente para navegar a través de ellas");
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}