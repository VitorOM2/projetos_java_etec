package exemplolabel;

/* @author Vitor */

import javax.swing.*;
import java.awt.*;

public class ExemploLabel extends JFrame{
    JLabel rotulo1,rotulo2,rotulo3,rotulo4;//Determina os rotulos como variaveis

    public ExemploLabel(){

        super ("Exemplo com label");
        Container tela = getContentPane();
        setLayout(null);
        
        //cria o conteudo do rótulo
        rotulo1 = new JLabel ("Nome");
        rotulo2 = new JLabel ("Idade");
        rotulo3 = new JLabel ("Telefone");
        rotulo4 = new JLabel ("Celular");
        
        //Define a coordenadas do rótulo
        rotulo1.setBounds(50,20,80,20);
        rotulo2.setBounds(50,60,80,20);
        rotulo3.setBounds(50,100,80,20);  
        rotulo4.setBounds(50,140,80,20);
        
        //Define a cor dos rótulos
        rotulo1.setForeground(Color.red);
        rotulo2.setForeground(Color.blue);
        rotulo3.setForeground(new Color (190,152,142));
        rotulo4.setForeground(new Color (201,200,100));
        
        //Define a fonte dos rótulos
        rotulo1.setFont(new Font ("Arial",Font.BOLD,14));
        rotulo2.setFont(new Font ("Comic Sans MS",Font.BOLD,16));
        rotulo3.setFont(new Font ("Courier New",Font.BOLD,18));
        rotulo4.setFont(new Font ("Times New Roman",Font.BOLD,20));
        
        //adiciona o rótulo na tela
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(rotulo3);
        tela.add(rotulo4);
        
        //Configurações da tela
        setSize(400,250);
        setVisible(true);
        setLocationRelativeTo(null);
}
    
    public static void main(String[] args) {
        ExemploLabel app = new ExemploLabel();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
