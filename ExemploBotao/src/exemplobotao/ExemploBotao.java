package exemplobotao;

/**
 *
 * @author Vitor
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploBotao extends JFrame
{
    JButton botao1,botao2,botao3,botao4;
    
    public ExemploBotao () 
    {   
        //Cria o conteiner(Tela)
        super ("Exemplo com vários botões");
        Container tela = getContentPane();
        setLayout(null);
        
        //Cria os botões
        botao1 = new JButton ("Procurar");
        botao2 = new JButton ("Voltar >>");
        botao3 = new JButton ("Próximo >>");
        botao4 = new JButton ("Sair");
        
        //Cria eventos para os botões
        botao1.setMnemonic(KeyEvent.VK_P);
        botao2.setMnemonic(KeyEvent.VK_V);
        botao3.setMnemonic(KeyEvent.VK_X);
        botao4.setMnemonic(KeyEvent.VK_S);
        getRootPane().setDefaultButton(botao1);
        
        //Define as posições dos botões
        botao1.setBounds(50,20,100,20);
        botao2.setBounds(50,60,100,20);
        botao3.setBounds(50,100,100,20);
        botao4.setBounds(50,140,100,20);
        
        //Define a cor de fundo do botão
        /*botao1.setBackground(Color.yellow);
        botao2.setBackground(Color.red);
        botao3.setBackground(Color.blue);
        botao4.setBackground(Color.white);*/
        
        //Define a cor da fonte do botão
        botao1.setForeground(Color.blue);
        botao2.setForeground(Color.green);
        botao3.setForeground(Color.red);
        botao4.setForeground(Color.pink);
        
        //Adiciona os botões na tela
        tela.add(botao1);
        tela.add(botao2);
        tela.add(botao3);
        tela.add(botao4);
        
        //Configurações da tela
        setSize(400,250);
        setVisible(true);
    }
}
