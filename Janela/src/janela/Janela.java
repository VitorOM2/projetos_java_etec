package janela;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

/*@author Vitor
 */
public class Janela extends JFrame{
    JLabel rotulo1,rotulo2,rotulo3,rotulo4,rotulo5,rotulo6,rotulo7,rotulo8,rotulo9;
    JTextField caixa1,caixa2,caixa3,caixa4,caixa5,caixa6,caixa7,caixa8;
    JButton botao1,botao2,botao3;
    ImageIcon icone1,icone2;
    MaskFormatter mascaracep,mascaratel,mascaracel,mascaracpf,mascaradata;

    public Janela (){
            
        super("Janela Principal");
        //Define a Imagem da página
        ImageIcon icone;
        icone = new ImageIcon ("user.png");
        setIconImage(icone.getImage());
        
        Container tela = getContentPane();
        setLayout(null);
        tela.setBackground(Color.lightGray);//muda a cor da tela
        
        //Verifica as caixas
        try
        {
            mascaracep = new MaskFormatter("#####-###");
            mascaratel = new MaskFormatter ("(##)####-####");
            mascaracel = new MaskFormatter ("(##)#####-####");
            mascaracpf = new MaskFormatter ("#########-##");
            mascaradata = new MaskFormatter ("##/##/####");
            mascaracep.setPlaceholderCharacter('_');
            mascaratel.setPlaceholderCharacter('_');
            mascaracel.setPlaceholderCharacter('_');
            mascaracpf.setPlaceholderCharacter('_');
            mascaradata.setPlaceholderCharacter('_');
            
        }
        catch(ParseException excp){}
        
        //----------ADICIONAR IMAGENS PARA OS BOTÕES----------

        icone1 = new ImageIcon ("enviar.png");
        icone2 = new ImageIcon ("sair.png");
        
        //---------------INSTANCIAÇÃO DOS COMPONENTES---------------
        
        //rótulos
        rotulo1 = new JLabel ("Nome");
        rotulo2 = new JLabel ("data de nascimento");
        rotulo3 = new JLabel ("Telefone");
        rotulo4 = new JLabel ("Celular");
        rotulo5 = new JLabel ("CPF:");
        rotulo6 = new JLabel ("Endereço:");
        rotulo7 = new JLabel ("CEP:");
        rotulo8 = new JLabel ("Estado:");
        rotulo9 = new JLabel ("Cadastro Clientes");
        
        //botões
        botao1 = new JButton ("Enviar");
        botao2 = new JButton ("Enviar",icone1);
        botao3 = new JButton ("Sair",icone2);
        
        //campos
        caixa1 = new JTextField(50);
        caixa2 = new JFormattedTextField(mascaradata);
        caixa3 = new JFormattedTextField(mascaratel);
        caixa4 = new JFormattedTextField(mascaracel);
        caixa5 = new JFormattedTextField(mascaracpf);
        caixa6 = new JTextField(50);
        caixa7 = new JFormattedTextField(mascaracep);
        caixa8 = new JTextField(20);
        
        //---------------POSIÇÕES E TAMANHOS---------------
        
        //Define as cordenadas dos rótulos
        rotulo1.setBounds(50,50,80,20);
        rotulo2.setBounds(50,90,200,20);
        rotulo3.setBounds(50,130,80,20);  
        rotulo4.setBounds(50,170,80,20);
        rotulo5.setBounds(50,210,80,20);
        rotulo6.setBounds(50,250,80,20);
        rotulo7.setBounds(50,290,80,20);
        rotulo8.setBounds(50,330,80,20);
        rotulo9.setBounds(220,20,200,20);
        
        //Define as posições dos botões
        botao1.setBounds(50,380,100,20);
        botao2.setBounds(250,380,100,20);
        botao3.setBounds(450,380,100,20);
        
        //Define a posição das caixas de textos
        caixa1.setBounds (140,50,200,20);
        caixa2.setBounds (220,90,67,20);
        caixa3.setBounds (140,130,87,20);
        caixa4.setBounds (140,170,94,20);
        caixa5.setBounds (140,210,86,20);
        caixa6.setBounds (140,250,80,20);
        caixa7.setBounds (140,290,65,20);
        caixa8.setBounds (140,330,80,20);
        
        //----------CONFIGURAÇÕES DE APARÊNCIA DOS COMPONENTES----------
        
        //Define a cor dos rótulos
        rotulo1.setForeground(Color.darkGray);
        rotulo2.setForeground(Color.darkGray);
        rotulo3.setForeground(Color.darkGray);
        rotulo4.setForeground(Color.darkGray);
        rotulo5.setForeground(Color.darkGray);
        rotulo6.setForeground(Color.darkGray);
        rotulo7.setForeground(Color.darkGray);
        rotulo8.setForeground(Color.darkGray);
        rotulo9.setForeground(Color.BLACK);
        
        //Define a cor das letras nas caixas
        caixa1.setForeground(Color.black);
        caixa2.setForeground(Color.black);
        caixa3.setForeground(Color.black);
        caixa4.setForeground(Color.black);
        caixa5.setForeground(Color.black);
        caixa6.setForeground(Color.black);
        caixa7.setForeground(Color.black);
        caixa8.setForeground(Color.black);
        
        //Define a cor das caixas
        caixa1.setBackground(Color.white);
        caixa2.setBackground(Color.white);
        caixa3.setBackground(Color.white);
        caixa4.setBackground(Color.white);
        caixa5.setBackground(Color.white);
        caixa6.setBackground(Color.white);
        caixa7.setBackground(Color.white);
        caixa8.setBackground(Color.white);
        
        //Define a cor da fonte do botão
        botao1.setForeground(Color.blue);
        
        //Define a fonte dos rótulos
        rotulo1.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo2.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo3.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo4.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo5.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo6.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo7.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo8.setFont(new Font ("Arial",Font.BOLD,16));
        rotulo9.setFont(new Font ("Arial",Font.BOLD,18));
        

        
        //---------------ADICIONAR EVENTOS---------------
        
        botao3.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                }
        );
       
        //--------------------ADICIONAR COMPONENTES--------------------
        
        //Apresenta os rótulos na tela
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(rotulo3);
        tela.add(rotulo4);
        tela.add(rotulo5);
        tela.add(rotulo6);
        tela.add(rotulo7);
        tela.add(rotulo8);
        tela.add(rotulo9);
        
        //Apresenta as caixas de textos na tela
        tela.add(caixa1);
        tela.add(caixa2);
        tela.add(caixa3);
        tela.add(caixa4);
        tela.add(caixa5);
        tela.add(caixa6);
        tela.add(caixa7);
        tela.add(caixa8);
        
        //Adiciona os botões na tela
        tela.add(botao1);
        tela.add(botao2);
        tela.add(botao3);
        
        //----------CONFIGURAÇÕES DO TAMANHO DA TELA---------
        
        setSize(600,550);
        setVisible(true);
        //setExtendedState(MAXIMIZED_BOTH);// Abre a tela de forma maximizada
        //setExtendedState(ICONIFIED); // Só abre a tela se o icone for minimizada
        setResizable(false); //Não pode mudar o tamanho da janela nem maximizar
        setLocationRelativeTo(null);//Deixa a tela centralizada
       
    }

}