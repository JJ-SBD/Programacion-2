import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * FrameLogin - ventana de login inicial.
 * Valida contra la tabla `usuarios` en la base de datos `bdalumno`.
 *
 * Mensajes:
 *  - usuario incorrecto  -> cuando no existe el nombre
 *  - contraseña incorrecta -> cuando existe usuario pero pass no coincide
 *  - Bienvenido <nombre> -> cuando ambos coinciden
 *
 * Después de login exitoso abre FrameInfoMain y aplica permisos según el campo 'tipo'.
 */
public class FrameLogin extends JFrame {

    private JTextField tfUsuario;
    private JPasswordField pfPassword;
    private JButton bLogin;
    private JButton bCancelar;

    public FrameLogin() {
        super("Login - Agenda de contactos");
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(8,8));

        JPanel pCenter = new JPanel(new GridLayout(2,2,5,5));
        pCenter.add(new JLabel("Usuario:"));
        tfUsuario = new JTextField();
        pCenter.add(tfUsuario);

        pCenter.add(new JLabel("Contraseña:"));
        pfPassword = new JPasswordField();
        pCenter.add(pfPassword);

        JPanel pSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        bLogin = new JButton("Entrar");
        bCancelar = new JButton("Cancelar");
        pSur.add(bLogin);
        pSur.add(bCancelar);

        add(new JLabel("Introduce tu usuario y contraseña"), BorderLayout.NORTH);
        add(pCenter, BorderLayout.CENTER);
        add(pSur, BorderLayout.SOUTH);

        bLogin.addActionListener(e -> intentarLogin());
        bCancelar.addActionListener(e -> System.exit(0));

        setSize(380,170);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void intentarLogin() {
        String usuario = tfUsuario.getText().trim();
        String password = new String(pfPassword.getPassword());

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un usuario.");
            return;
        }

        // Consulta a la BD
        String SQL = "SELECT pass, tipo FROM usuarios WHERE nombre = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            // usando tu clase ConexionBD para obtener la conexión
            ConexionBD cb = new ConexionBD();
            conn = cb.obtenerConexion();

            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, usuario);
            rst = pstm.executeQuery();

            if (!rst.next()) {
                // no existe usuario
                JOptionPane.showMessageDialog(this, "usuario o contraeña incorrecta");
                return;
            }

            String passEnBD = rst.getString("pass");
            String tipo = rst.getString("tipo");

            if (passEnBD == null) passEnBD = "";
            if (!passEnBD.equals(password)) {
                JOptionPane.showMessageDialog(this, "usuario o contraeña incorrecta");
                return;
            }

            // login exitoso
            JOptionPane.showMessageDialog(this, "Bienvenido " + usuario);

            // abrir ventana principal y aplicar permisos según tipo
            FrameInfoMain main = FrameInfoMain.instance != null ? FrameInfoMain.instance : new FrameInfoMain();
            main.acomodar(); // asegura que la UI esté creada
            main.aplicarRol(tipo);

            // cerrar login
            this.dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al validar usuario: " + ex.getMessage());
        } finally {
            try {
                if (rst != null) rst.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // lanzar la ventana de login como primera ventana
        SwingUtilities.invokeLater(() -> new FrameLogin());
    }
}
