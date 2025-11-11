//package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Dialogo 
extends JDialog 
implements ActionListener, ChangeListener {
    
    private Color color;
    
    private JPanel pnlLeft;
        private JPanel pnlSliderNames;
            private JLabel lblRed;
            private JLabel lblGreen;
            private JLabel lblBlue;
        private JPanel pnlSliders;
            private JSlider sldRed;
            private JSlider sldGreen;
            private JSlider sldBlue;
    
    private JPanel pnlLabels;
        private JLabel lblBefore;
        private JLabel lblAfter;
    
    private JButton btnOk;
     
     // Crea una nueva instancia de dialogo tomando la ventana Main pasada como 
     // parametro como el padre.
     //
     // en param parent La ventana Main que va a ser utilizada como padre de este 
     //               dialogo
     
    public Dialogo(Main parent) {
        
         // Con super() podemos mandar llamar un metodo de la super clase 
         // (JDialog), el metodo que estamos llamando aqui es el constructor con
         // el padre como primer parametro y un valor booleano que indica si la 
         // ventana es modal (bloquea la ventana padre)
         //
        super(parent, true);//esto de true se hace para que no puedas volver a la interfaz anteriror si no haz cerrado esta
        //esto se llama ltrabajar de manera modal
        //los cambios que ocurren en un cambio de dialogo no se notan hasta que salimos de el
        getContentPane().setLayout(new BorderLayout());

        pnlLeft = new JPanel(new BorderLayout());
        pnlSliderNames = new JPanel(new GridLayout(3, 1));
        pnlSliders = new JPanel(new GridLayout(3, 1));
        pnlLabels = new JPanel(new GridLayout(2, 1));
        
        Color back = parent.getButtonForeground();
        
        lblRed = new JLabel("Rojo");
        pnlSliderNames.add(lblRed);
        
        lblGreen = new JLabel("Verde");
        pnlSliderNames.add(lblGreen);
        
        lblBlue = new JLabel("Azul");
        pnlSliderNames.add(lblBlue);
        
        pnlLeft.add(pnlSliderNames, BorderLayout.WEST);
        
        sldRed = new JSlider(0, 255, back.getRed());
        sldRed.addChangeListener(this);
        pnlSliders.add(sldRed);
        
        sldGreen = new JSlider(0, 255, back.getGreen());
        sldGreen.addChangeListener(this);
        pnlSliders.add(sldGreen);
        
        sldBlue = new JSlider(0, 255, back.getBlue());
        sldBlue.addChangeListener(this);
        pnlSliders.add(sldBlue);
        
        pnlLeft.add(pnlSliders, BorderLayout.CENTER);
        
        getContentPane().add(pnlLeft, BorderLayout.CENTER);
        
        lblBefore = new JLabel("Antes");
        lblBefore.setOpaque(true);
        lblBefore.setBackground(back);
        pnlLabels.add(lblBefore);
        
        lblAfter = new JLabel("Despues");
        lblAfter.setOpaque(true);
        lblAfter.setBackground(back);
        pnlLabels.add(lblAfter);
        
        getContentPane().add(pnlLabels, BorderLayout.EAST);
        
        btnOk = new JButton("Ok");
        btnOk.addActionListener(this);
        getContentPane().add(btnOk, BorderLayout.SOUTH);
        
        this.setSize(400, 200);
        this.setTitle("Cambiar color de la letra");
    }

     // Devuelve un objeto Color que representa el color que se selecciono en 
     // este JDialog
     // 
     // en return El color que se selecciono

    public Color getColor() {
        return color;
    }
    
     // Maneja el evento en el que se cierra el JDialog
     // en param e El evento que ocurrio
     //
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    
     // Maneja el evento en que cambia el valor de los JSlider
     // en param e El evento que ocurrio
     
    public void stateChanged(ChangeEvent e) {
        color = new Color(sldRed.getValue(), 
                          sldGreen.getValue(), 
                          sldBlue.getValue());
        
        lblAfter.setBackground(color);
    }
}
