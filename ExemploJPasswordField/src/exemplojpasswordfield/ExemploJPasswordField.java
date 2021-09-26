package exemplojpasswordfield;

/* @author Vitor*/

//Bibliotecas
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExemploJPasswordField extends JFrame
{
    //Atributos
    JPasswordField caixa;
    JLabel rotulo;
    
    //Método construtot
    public ExemploJPasswordField()
            
    {
        super ("Exemplo JPasswordField");//Cria uma chamada para a tela
        Container tela = getContentPane();//Cria a tela
        setLayout(null);//Define o layout da tela
        
        //Cria o rotulo "Senha" na tela
        rotulo = new JLabel ("Senha");
        
        //Cria o campo para digitar a senha 
        caixa = new JPasswordField(10);
        
        //Posições
        
        //Posição do rotulo
        rotulo.setBounds(50,20,100,20);
        
        //Posição da caixa de texto
        caixa.setBounds(50,60,100,20);
        
        //Adicona o rótulo e a caixa na tela
        tela.add(rotulo);
        tela.add(caixa);
        
        //Define o tamanho da tela
        setSize(400,250);
        
        //Define a tela como visivel
        setVisible(true);
    }
}
