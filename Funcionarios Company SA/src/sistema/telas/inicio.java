package sistema.telas;

/**
 *
 * @author Vitor
 */

import javax.swing.*;

public class Inicio extends JPanel{
    
    JLabel titulo;
    
    public Inicio(){
        criarComponentes();
        criarEventos();
    }
    
    private void criarComponentes(){
        setLayout(null);
        
        //Identa o rótulo
        titulo = new JLabel("Escolha uma opção no menu superior",JLabel.CENTER);
        
        //Posiciona o rótulo
        titulo.setBounds(20,100,660,40);
        
        //Adiciona o rótulo na tela
        add(titulo);
        
        //Deixa a tela visível
        setVisible(true);
    } 
    
    private void criarEventos(){
        
    }
}
