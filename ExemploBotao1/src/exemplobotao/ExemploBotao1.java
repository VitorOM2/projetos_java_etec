package exemplobotao;

import javax.swing.*;
import java.awt.*;

/* @author Vitor */

//Exemplo de botões com imagens
public class ExemploBotao1 extends JFrame {

    JButton botao1,botao2,botao3;
    ImageIcon icone1;
    
    public ExemploBotao1 () {
        
        super ("Exemplo com Jbutton com Imagens");
        
        Container tela = getContentPane();   
        setLayout(null);
        
        //imagem para os botões
        icone1 = new ImageIcon ("Abrir.png");
        
        
        //Cria os botões
        botao1 = new JButton("Procurar");
        botao2 = new JButton("Abrir",icone1);
        botao3 = new JButton(icone1);
        
        //Posição dos botões
        botao1.setBounds(50,20,100,20);
        botao2.setBounds(50,60,100,20);
        botao3.setBounds(50,100,100,20);
        
        //Adiciona cor para o botão
        botao1.setBackground(Color.yellow);
        
        //Adiciona os botões na tela
        tela.add (botao1);
        tela.add (botao2);
        tela.add (botao3);
        
        setSize(300,150);
        setVisible(true);
    }
    
}
