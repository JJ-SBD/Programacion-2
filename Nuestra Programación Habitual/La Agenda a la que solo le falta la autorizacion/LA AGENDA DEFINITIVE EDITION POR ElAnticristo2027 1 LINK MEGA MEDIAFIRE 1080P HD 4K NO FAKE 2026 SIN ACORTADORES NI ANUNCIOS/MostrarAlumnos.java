import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.BorderLayout;

public class MostrarAlumnos {

    public static void mostrar() {

        String URL = "jdbc:mysql://localhost:3306/bdalumno?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String USR = "root";
        String PSWD = "kronos";

        String SQL = "SELECT * FROM alumno";
        //String SQL = "SELECT cuenta, nombre, edad FROM alumno";

        DefaultTableModel modelo = new DefaultTableModel();

        try (Connection conn = DriverManager.getConnection(URL, USR, PSWD);
             Statement stm = conn.createStatement();
             ResultSet rst = stm.executeQuery(SQL)) {

            ResultSetMetaData meta = rst.getMetaData();
            int columnas = meta.getColumnCount();

            // agregar columnas
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(meta.getColumnName(i));
            }

            // agregar filas
            while (rst.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = rst.getObject(i);
                }
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return;
        }

        // tabla y ventana para mostrar
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        JFrame ventana = new JFrame("Lista de alumnos");
        ventana.add(scroll);
        ventana.setSize(1000, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

        JButton BRegresar = new JButton("Regresar");
        BRegresar.addActionListener(e -> ventana.dispose());
        ventana.add(BRegresar, BorderLayout.SOUTH);
    }
}
