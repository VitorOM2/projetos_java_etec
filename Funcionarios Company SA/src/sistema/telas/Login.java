package sistema.telas;

/**
 *
 * @author Vitor
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel{

    JLabel labelUsuario,labelSenha;
    JTextField campoUsuario;
    JPasswordField campoSenha;
    JButton entrar;
    
    public Login(){
        
        criarComponentes();
        criarEventos(); 
        
    }
    
    private void criarComponentes(){
        setLayout(null);
        
        //---------------INSTANCIAÇÃO DOS COMPONENTES---------------
        
        JLabel labelTitulo = new JLabel ("Seja bem vindo ao sistema da company SA",JLabel.CENTER);
        
        labelTitulo.setFont(new Font (labelTitulo.getFont().getName(),Font.PLAIN, 18) );
        
        //Instanciação dos rótulos
        labelUsuario = new JLabel("Usuário",JLabel.LEFT);
        labelSenha = new JLabel("Senha",JLabel.LEFT);
        
        //Instanciação dos campos
        campoUsuario = new JTextField();
        campoSenha = new JPasswordField();
        
        //Instanciação do botão
        entrar = new JButton("Entrar");
        
        //--------------------POSIÇÕES E TAMANHOS--------------------
        
        //rótulos
        labelTitulo.setBounds (20,100,660,40);
        labelUsuario.setBounds (250,220,200,20);
        labelSenha.setBounds (250,280,200,20);
        
        //campos
        campoUsuario.setBounds(250,240,200,40);
        campoSenha.setBounds (250,300,200,40);
        
        //botões
        entrar.setBounds(250,350,200,40);
        
        //------------------ADICIONAR OS COMPONENTES------------------
        
        //rótulos
        add (labelTitulo);
        add (labelUsuario);
        add (labelSenha);
        
        //campos
        add (campoUsuario);
        add (campoSenha);
        
        //Botões
        add (entrar);
        
        //--------------------CONFIGURAÇÕES DA TELA-------------------
        setVisible(true);
        
    }
    
    //--------------------ADICIONAR EVENTOS--------------------
    private void criarEventos(){
        
        entrar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
            
        });
    }
    
}
