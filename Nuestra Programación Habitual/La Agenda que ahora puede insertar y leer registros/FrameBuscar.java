import javax.swing.*;

public class FrameBuscar extends JFrame {

    public FrameBuscar() {
    JFrame ventanaB = new JFrame("Buscar contacto");
       String apellido = "";
            apellido = (String) JOptionPane.showInputDialog(ventanaB, "Ingrese el apellido del alumno", "Buscar", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(ventanaB, "Ha sido encontrado el apellido: " + apellido);
}
}
