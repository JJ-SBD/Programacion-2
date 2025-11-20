//Modulo de autenticación
//Autenticar.java
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import sun.jdbc.odbc.*;
public class Autenticar extends JFrame {
static final String CONTROLADOR = "com.mysql.jdbc.Driver";
static final String URL_BASEDEDATOS = "jdbc:mysql://localhost/bdSistema";
static final String USR="root";
static final String PSSWD="admin";
// declarar objetos Connection y Statement para
// acceder a la bd y realizar consultas
private Connection conexion;


private Statement instruccion;
private JTextField tfUsr;
private Label lblMensaje, lblUsuario, lblNip;
private JPasswordField tfUsrNip;
private JButton botonEnviar, botonSalir;

//el constructor se conecta a la bd, realiza la consulta,
//procesa los resultados y los muestra en ventana
public Autenticar()
{
super("Modulo de Autenticación");
lblMensaje = new Label("Introduzca sus datos y pulse el botón Continuar",1);

lblUsuario = new Label("ID DE USUARIO:", 2);
lblNip = new Label("NIP:", 2);
tfUsr = new JTextField();
tfUsrNip = new JPasswordField();
botonEnviar = new JButton("Continuar");
botonEnviar.setSize(10,15);
botonEnviar.setDefaultCapable(true);
botonSalir = new JButton("Salir");
botonSalir.setSize(10, 15);
Panel panel1 = new Panel();
Panel panel2 = new Panel();
Panel panel3 = new Panel();
Panel panel4 = new Panel();
Panel contP2P3 = new Panel();
//agregar controles a los contenedores Panels
panel1.setSize(400, 50);
panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
panel1.add(lblMensaje);
panel2.setSize(400,50);
panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
panel2.add(lblUsuario);
panel2.add(tfUsr);
tfUsr.setColumns(8);
tfUsr.setSize(5,10);
panel3.setSize(400,50);
panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
panel3.add(lblNip);
panel3.add(tfUsrNip);
tfUsrNip.setColumns(8);
tfUsrNip.setSize(5,10);
panel4.setSize(400,50);
panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
panel4.add(botonEnviar);
panel4.add(botonSalir);



contP2P3.setLayout(new GridLayout(2,1));
contP2P3.add(panel2);
contP2P3.add(panel3);
//agregar los Box al contenedor principal
Container contenedor = getContentPane();
contenedor.add(panel1, BorderLayout.NORTH);
contenedor.add(contP2P3, BorderLayout.CENTER);
contenedor.add(panel4, BorderLayout.SOUTH);
// declarar variables para realizar consulta
// crear componente de escucha de eventos para botonEnviar
botonEnviar.addActionListener(new ActionListener() {
public void actionPerformed( ActionEvent evento )
{
//System.out.println("Se empieza con la conexión a la BD");

String usuarioQuery;
String usuarioDevuelto="";
String nipQuery;
String nipDevuelto;
String nombreDevuelto;
String apellidoDevuelto;

// conectarse a la bd BDCajero y realzar consulta
try{
Class.forName( CONTROLADOR );
conexion =

DriverManager.getConnection( URL_BASEDEDATOS, USR, PSSWD );

instruccion = conexion.createStatement();
ResultSet conjuntoResultados;
usuarioQuery = tfUsr.getText();
nipQuery = tfUsrNip.getText();
//System.out.println("Parametro buscado: " +usuarioQuery);

conjuntoResultados = instruccion.executeQuery("SELECT id_usuario, nip, nombre, apellidosFROM usuarios WHERE id_usuario = '"
+ usuarioQuery + "'" );
conjuntoResultados.next();
//procesar los resultados de la consulta
usuarioDevuelto = conjuntoResultados.getString(1);
System.out.println("id de usuario devuelto: " +

usuarioDevuelto);

System.out.println("nip de usuario buscado: " +

nipQuery);


nipDevuelto = conjuntoResultados.getString(2);
System.out.println("nip de usuario devuelto: " +

nipDevuelto);

nombreDevuelto = conjuntoResultados.getString(3);
apellidoDevuelto = conjuntoResultados.getString(4);
if(! nipDevuelto.equals(nipQuery)){
JOptionPane.showMessageDialog( null, "EL NIP ES INCORRECTO FAVOR DE VERIFICAR",

"NIP INCORRECTO",

JOptionPane.INFORMATION_MESSAGE );
}
else
{
System.out.println("El usuario y nip es correcto, desplegar siguiente pantalla");

JOptionPane.showMessageDialog( null,

"BIENVENIDO\n"+ nombreDevuelto+

apellidoDevuelto+"\n" + "SU SESIÓN HA SIDO INICIADA CORRECTAMENTE",

"Bienvenida",

JOptionPane.INFORMATION_MESSAGE );

dispose();
AdminBD adminGUI = new AdminBD();

adminGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

adminGUI.establecerIdentifUsr(usuarioDevuelto, nombreDevuelto);

}
}
// atrapar posibles excepciones SQLException al realizar una nueva consulta

catch ( SQLException excepcionSQL ){
if(usuarioDevuelto == ""){
System.out.println("El usuario no fue encontrado");

JOptionPane.showMessageDialog( null, "EL USUARIO NO ESTA DADO DE ALTA\n"+

"EN LA BASE DE DATOS", "Usuario no valido",

JOptionPane.ERROR_MESSAGE );
System.exit( 1 );
}
JOptionPane.showMessageDialog( null,

excepcionSQL.getMessage(),

"Error en la base de datos",

JOptionPane.ERROR_MESSAGE );

System.exit( 1 );
}
catch ( ClassNotFoundException claseNoEncontrada ) {



JOptionPane.showMessageDialog(null,

claseNoEncontrada.getMessage(),

"No se encontró el controlador",

JOptionPane.ERROR_MESSAGE );

System.exit( 1 );
}
//asegurar que instruccion y conexion se cierren correctamente

finally {
try {
instruccion.close();
conexion.close();
}
// manejar posibles excepciones al cerrar instruccion y conexion

catch ( SQLException excepcionSql ) {
JOptionPane.showMessageDialog( null,
excepcionSql.getMessage(), "Error en base de datos", JOptionPane.ERROR_MESSAGE );

System.exit( 1 );
}
}
}
}
);
botonSalir.addActionListener(new ActionListener(){
public void actionPerformed( ActionEvent evento2 )
{
//try{
//instruccion.close();
//conexion.close();
System.exit(1);
//}
//catch ( SQLException excepcionSql ) {
// JOptionPane.showMessageDialog( null, excepcionSql.getMessage(), "Error al cerrar BD", JOptionPane.ERROR_MESSAGE );

// System.exit( 1 );
// }
}
});

// establecer tamaño de ventana y mostrarla en pantalla
setSize( 400, 150 );
setVisible( true );
} // fin del constructor autenticar
// ejecutar la aplicación
public static void main (String args[] )
{
Autenticar gui = new Autenticar();
gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
}
}