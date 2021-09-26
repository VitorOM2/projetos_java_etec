package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* @author Vitor */

public class Calculadora extends JFrame {
    
    JLabel rotulo1,rotulo2,exibir;
    JTextField caixa1,caixa2;
    JButton somar,multiplicar,divir,subtrair;
    ImageIcon iconeS,iconeM,iconeD,iconesub;
    
    public Calculadora(){
        
        super("Exemplo de calculadora");
        //Define a Imagem da página
        ImageIcon icone;
        icone = new ImageIcon ("calculator.png");
        setIconImage(icone.getImage());
        Container tela = getContentPane();
        setLayout(null);
        
        rotulo1 = new JLabel("1º numero: ");
        rotulo2 = new JLabel("2º numero: ");
        caixa1 = new JTextField(5);
        caixa2 = new JTextField(5);
        exibir = new JLabel("");
        somar = new JButton("Somar");
        multiplicar = new JButton("Multiplicar");
        divir = new JButton("Dividir");
        subtrair = new JButton("Subtrair");
        
        //Adiciona as posições
        rotulo1.setBounds(200,20,100,20);rotulo2.setBounds(200,60,100,20);
        caixa1.setBounds(290,20,200,20);caixa2.setBounds(290,60,200,20);
        exibir.setBounds(50,120,200,20);somar.setBounds(150,100,80,20);
        multiplicar.setBounds(250,100,100,20);divir.setBounds(370,100,80,20);
        subtrair.setBounds(470,100,80,20);
        
        //Adiciona ações para os botões
        somar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        int numero1,numero2,soma;
                        soma = 0;
                        numero1 = Integer.parseInt(caixa1.getText());
                        numero2 = Integer.parseInt(caixa2.getText());
                        soma = numero1 + numero2;
                        exibir.setVisible(true);
                        exibir.setText("O resultado da soma é: "+soma);
                    }
                }
        );
        
        multiplicar.addActionListener(
                new ActionListener(){
                    public void actionPerformed (ActionEvent e) {
                        int numero1,numero2,multi;
                        multi = 0;
                        numero1 = Integer.parseInt(caixa1.getText());
                        numero2 = Integer.parseInt(caixa2.getText());
                        multi = numero1 * numero2;
                        exibir.setVisible(true);
                        exibir.setText("O resultado da multiplicação é: "+multi);
                    }
                }
        );
        
        divir.addActionListener(
                new ActionListener(){
                    public void actionPerformed (ActionEvent e){
                        float numero1,numero2,div;
                        div = 0;
                        numero1 = Integer.parseInt(caixa1.getText());
                        numero2 = Integer.parseInt(caixa2.getText());
                        div = numero1/numero2;
                        exibir.setVisible(true);
                        exibir.setText("O resultado da divisão é: "+div);
                    }
                }
        );

        subtrair.addActionListener(
            new ActionListener() {          
                public void actionPerformed(ActionEvent e) {
                    int numero1,numero2,sub;
                    sub = 0;
                    numero1 = Integer.parseInt(caixa1.getText());
                    numero2 = Integer.parseInt(caixa2.getText());
                    sub = numero1-numero2;
                    exibir.setVisible(true);
                    exibir.setText("O resultado da subtração é: "+sub);
                }
            }
        );
        exibir.setVisible(false);
        
        //Adicona na tela
        tela.add(rotulo1);tela.add(rotulo2);
        tela.add(caixa1);tela.add(caixa2);
        tela.add(exibir);tela.add(somar);tela.add(multiplicar);tela.add(divir);
        tela.add(subtrair);
        
        setSize(650,250);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
