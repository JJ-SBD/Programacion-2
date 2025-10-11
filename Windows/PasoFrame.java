
import java.awt.*;
import java.awt.event.*;

class PasoFrame extends Frame
{
    Frame vent1, vent2;
    Button bUno, bDos, bSalir;

    public PasoFrame() {
        bSalir = new Button("Salir");
        bSalir.setBounds(150,105,100,25);
        bSalir.setBackground(Color.red);
        bSalir.setForeground(Color.white);

        bSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        vent1 = new Frame("Esta es la ventana 1");
        //se divide entre 2 porque no entendi bien :(
        vent1.setBounds((1024/2),(750/2),400,200);
        //se llama a la clase color
        vent1.setBackground(Color.blue);
        vent1.setLayout(null);
        vent1.setVisible(true);
        //boton de la ventana 1        
        bUno = new Button("Ventana 2");
        bUno.setBounds(150,75,100,25);
        bUno.setBackground(Color.yellow);
        //color del primer plano
        bUno.setForeground(Color.black);
                
        vent1.add(bUno);
        vent1.add(bSalir);

        bUno.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vent2.show();
                vent1.hide(); 
            }
        });

        vent2 = new Frame("Esta es la Ventana 2");
        vent2.setBounds((1024/2),(750/2),400,200);
        vent2.setBackground(Color.yellow);
        vent2.setLayout(null);
        vent2.setVisible(false);
        //boton de la ventana 2        
        bDos = new Button("Ventana 1");
        bDos.setBounds(150,75,100,25);
        bDos.setBackground(Color.blue);
        bDos.setForeground(Color.white);
        vent2.add(bDos);
        vent2.add(bSalir);

        bDos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vent1.show();
                vent2.hide(); 
            }
        });
    }

    public static void main(String a[]){
        PasoFrame ventana = new PasoFrame();
        ventana.validate();
    }
}
