package coresrgb;

import javax.swing.*;
import java.awt.*;
/* @author Vitor */

public class Cor1 extends JFrame{
    
    public Cor1 (){
        
    super ("Mudando a cor da tela");
    Container tela = getContentPane();
    tela.setBackground (new Color(255,120,120));
    setSize (300,150);
    setVisible(true);
    setExtendedState(ICONIFIED); 
    setResizable(true);
    setLocationRelativeTo(null);
    
    }

    public static void main(String[] args) {
        Cor1 app = new Cor1(); 
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

