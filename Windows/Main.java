//package ventanas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

 // Estas son un grupo de ventanas que nos van a servir para aprender a manejar 
 // muchas ventanas en nuestras aplicaciones.

public class Main 
extends JFrame 
implements ActionListener {
    
    private JButton btnVentana1;
    private JButton btnVentana2;
    private JButton btnVentana3;
    private JButton btnVentana4;
    private JButton btnVentana5;
    
    /** Creates a new instance of Main */
    public Main() {
        //definimos un esquema de ordenacion
        setLayout(new GridLayout(2,3));
        
        btnVentana1 = new JButton("Abrir una ventana");
        btnVentana1.addActionListener(this); //detecta las acciones que ocurran en este boton particular
        getContentPane().add(btnVentana1);
        
        btnVentana2 = new JButton("Abrir un dialogo");
        btnVentana2.addActionListener(this);
        getContentPane().add(btnVentana2);
        
        btnVentana3 = new JButton("Abrir MessageDialog");
        btnVentana3.addActionListener(this);
        getContentPane().add(btnVentana3);
        
        btnVentana4 = new JButton("Abrir InputDialog");
        btnVentana4.addActionListener(this);
        getContentPane().add(btnVentana4);
        
        btnVentana5 = new JButton("Abrir InputDialog con opciones");
        btnVentana5.addActionListener(this);
        getContentPane().add(btnVentana5);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventanas!");
        setSize(700,150);
        setVisible(true);
    }
    
    public Color getButtonBackground() {
        return btnVentana1.getBackground();
    }
    
    public Color getButtonForeground() {
        return btnVentana1.getForeground();
    }
    
    public void setButtonBackground(Color c) {
        btnVentana1.setBackground(c);
        btnVentana2.setBackground(c);
        btnVentana3.setBackground(c);
        btnVentana4.setBackground(c);
        btnVentana5.setBackground(c);
    }
    
    public void setButtonForeground(Color c) {
        btnVentana1.setForeground(c);
        btnVentana2.setForeground(c);
        btnVentana3.setForeground(c);
        btnVentana4.setForeground(c);
        btnVentana5.setForeground(c);
    }
        
     // en param args the command line arguments

    public static void main(String[] args) {
        Main app = new Main();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVentana1) {
            
             // Como puedes ver mostrar otra ventana es muy sencillo, lo unico 
             // que tienes que hacer es crear una clase que implemente JFrame 
             // como ya sabemos hacerlo y mandarla llamar desde otra forma 
             // creando un nuevo objeto de esa clase.
            
            Ventana v = new Ventana(this);// debe tener una clase llamada ventana
            
             // Este metodo nos permite establecer la localizacion de la ventana 
             // al crearse, queremos que este cerca de la ventana principal 
             // entonces mandamos el parametro this, pero podriamos ponerlo sobre 
             // de cualquier componente
              
            v.setLocationRelativeTo(this);
            v.setVisible(true);
            
        } else if (e.getSource() == btnVentana2) {
            
             // Un dialogo es una ventana que no te permite continuar 
             // interactuando con la ventana que la manda llamar, ademas esto 
             // detiene el codigo en la primera ventana por lo que podemos 
             // recibir informacion de la ventana de manera directa.
             
            Dialogo d = new Dialogo(this);//los cuadros de dialogo son contenedores con botones definidos
            d.setLocationRelativeTo(this);// hace que cuando abramos dialogo se muestre en una posicion relativa a la ventana Main
            d.setVisible(true);
            
            setButtonForeground(d.getColor());
            
            d.dispose();
        } else if (e.getSource() == btnVentana3) {//aqui es donde se crea en message dialog

             // JOptionPane es un control que me permite mostrar una dialogo con 
             // informacion. El metodo que usamos a continuacion se llama 
             // showMessageDialog y nos muestra una ventana con un mensaje 
             // informativo.
             
             //pasa el cursor sobre la firma del metodo para que veas que parametros pide para funcionar
            JOptionPane.showMessageDialog(this, "WARNING", "MessageDialog", JOptionPane.WARNING_MESSAGE);
            
        } else if (e.getSource() == btnVentana4) {
            String nombre = "";
    
             // Otro dialogo muy similar al MessageDialog que mostramos arriba es 
             // el InputDialog. Para construirlo utilizamos el componente padre 
             // al que seguiremos mandando this...
             
             //input dialog tambien muestra info pero tambien permite escribir cosas
            nombre = (String) JOptionPane.showInputDialog(this, "Cual es tu nombre?", "Log in", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Bienvenido " + nombre);
            
        } else if (e.getSource() == btnVentana5) {
            String edad = "";
            String[] edades = { "0-14", "15-20", "21-30", "31-60", "61+" };//array de edades
    
             // Otra opcion para mandar llamar el InputDialog es utilizando un 
             // constructor que ademas de lo que usamos arriba tambien pide un 
             // arreglo con los valores posibles.
             
            edad = (String) JOptionPane.showInputDialog(this, 
                    "Cual es tu edad?", "Edades", 
                    JOptionPane.QUESTION_MESSAGE, null, edades, 3);
            
            if (edad.equals(edades[0])) {
                JOptionPane.showMessageDialog(this, "Todavia eres joven");
            } else if (edad.equals(edades[1])) {
                JOptionPane.showMessageDialog(this, "Eres un adolescente");
            } else if (edad.equals(edades[2])) {
                JOptionPane.showMessageDialog(this, "Eres un adulto joven");
            } else if (edad.equals(edades[3])) {
                JOptionPane.showMessageDialog(this, "Eres un adulto");
            } else if (edad.equals(edades[4])) {
                JOptionPane.showMessageDialog(this, "Eres un adulto mayor");
            }
        }
    }
}
