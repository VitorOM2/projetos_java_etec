package coresrgb;

import javax.swing.*;
import java.awt.*;

/* @author Vitor */
    
public class Cor2 extends JFrame{
    
    public Cor2 (){
        
    super ("Mudando a cor da tela");
    Container tela = getContentPane();
    tela.setBackground (new Color(128,125,150));
    setSize (300,150);
    setVisible(true);
    setExtendedState(ICONIFIED); 
    setResizable(true);
    setLocationRelativeTo(null);
    
    }

    public static void main(String[] args) {
        Cor2 app = new Cor2(); 
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
    
    

