import java.awt.*; // el * importa todas las clases de awt por si acaso
import java.awt.event.*; // todas las clases del paquete event
import javax.swing.*;

public class SumaGUI
{
    private Frame frog; //declaramos los elementos de la GUI
    private Panel pan1, pan2, pan3; //3 paneles
    private JLabel lblIns, lblIns2, lbl2, lbl3, lblRes; //3 labels
    private TextField tf1,tf2,tfRes;
    private Button theHardestButtonToButton;
    private Button theLightestButtonToButton;

    public SumaGUI()
    {
        frog = new Frame("suma de dos numeros");
        pan1 = new Panel();
        pan2 = new Panel();
        pan3 = new Panel();

        lblIns =  new JLabel("Hola");
        lblIns2 =  new JLabel("¿Que numeros vamos a sumar hoy Ferb?" + "Ponlos en los cuadros de texto y pucha el boton");
        lbl2 = new JLabel("<html>Primer Numero<html>");
        lbl3 = new JLabel("<html>Segundo Numero<html>");
        lblRes = new JLabel("<html>Resultado<html>");

        tf1 = new TextField(5);//5 es limite de caracteres a tomar en cuenta
        tf2 = new TextField(5);
        tfRes = new TextField(8);
        
        tfRes.setEditable(false);//para que el usuario no se pueda editar

        theHardestButtonToButton = new Button("Calcular");
        theLightestButtonToButton = new Button("Salir");

    }

    public void acomodarEnFrame()
    {
        theHardestButtonToButton.addActionListener(new ManagerBotonCalcular());
        theLightestButtonToButton.addActionListener(new ManagerBotonSalir());
        frog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent wwe) {
                System.exit(0);// se le pone 0 porque no es un control que creamos nosotros
                //todo esto se le esta pasando al sistema operativo
            }
        });

        pan1.setLayout(new GridLayout(3,2)); //definimos esquema de ordenacion con el Grid Layout
        //3 filas 2 columnas

        pan1.add(lblIns); //Hola
        pan1.add(lblIns2); //que numeros vamos a sumar?
        pan1.add(lbl2); //primer numero
        pan1.add(tf1); //textfield 1
        pan1.add(lbl3); //segundo numero
        pan1.add(tf2); //textfield 2

        frog.add(pan1, BorderLayout.NORTH); //los estoy añadiendo a mi frame

        pan2.add(lblRes);//no le pongo layou porque solo son 2 cosas, mejor que se impriman uno tras otro
        pan2.add(tfRes);

        frog.add(pan2, BorderLayout.CENTER); //

        pan3.setLayout(new GridLayout(1,2)); //una fila 2 columnas
        pan3.add(theHardestButtonToButton);
        pan3.add(theLightestButtonToButton);

        frog.add(pan3, BorderLayout.SOUTH);

        //hasta aqui ya acomodamos todo, falta mostralo

        frog.setSize(300, 300); //tamaño de la ventana
        frog.setVisible(true); //permiso para mostrar

        //falta crear un objeto para que finalmente se muestre

    }

    class ManagerBotonCalcular implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent actionEvent) //crea un objeto llamado actionEvent
        {
            double n1, n2, res;

            n1 = Double.valueOf(tf1.getText());//lo que se obtenga en tf1 se convierte a valor double
            n2 = Double.valueOf(tf2.getText());
            res = n1 + n2;
            tfRes.setText(Double.toString(res));//setText quiere un valor string pero le vamos a dar uno double con ese trucazo
        }
    }

    class ManagerBotonSalir implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent actionEvent)
        {
            System.exit(-1);//el -1 indica que fue el usuario el que cerro
        }
    }

    public static void main(String[] args) {

        SumaGUI ventanaSuma = new SumaGUI();
        ventanaSuma.acomodarEnFrame(); 
        
    }

    
}