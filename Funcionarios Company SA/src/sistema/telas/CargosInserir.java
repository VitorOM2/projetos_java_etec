package sistema.telas;

/*Vitor*/

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import sistema.BancoDeDados;
import sistema.entidades.Cargo;

public class CargosInserir extends JPanel {
    
    //--------------------ATRIBUTOS--------------------
    JLabel LTitulo, LCargo;
    JTextField CCargo;
    JButton BTGravar;        
            
    public CargosInserir(){
        criarComponentes();
        criarEventos();
    }

    //---------------INSTANCIAÇÃO DOS COMPONENTES----------------    
    private void criarComponentes() {
        setLayout(null);
        
        //Rótulos
        LTitulo = new JLabel("Cadastro de Cargo", JLabel.CENTER);
        LTitulo.setFont(new Font(LTitulo.getFont().getName(), Font.PLAIN, 20)); 
        LCargo = new JLabel("Nome do cargo", JLabel.LEFT);
        
        //Campos
        CCargo = new JTextField();
        
        //Botões
        BTGravar = new JButton("Adicionar Cargo");
        
        //---------------POSIÇÕES E TAMANHOS---------------
        //Rótulos
        LTitulo.setBounds(20, 20, 660, 40);
        LCargo.setBounds(150, 120, 400, 20);
        
        //Campos
        CCargo.setBounds(150, 140, 400, 40);
        
        //Botões
        BTGravar.setBounds(250, 380, 200, 40); 
        
        //------------------ADICIONA OS COMPONENTES------------------
        //Rótulos
        add(LTitulo);
        add(LCargo);
        
        //Campos
        add(CCargo);
        
        //Botões
        add(BTGravar);
        
        //--------------------CONFIGURAÇÕES DA TELA-------------------
        setVisible(true);
    }

    //---------------ADICIONA EVENTOS---------------
    private void criarEventos() {
        BTGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cargo novoCargo = new Cargo();
                novoCargo.setNome(CCargo.getText());
                
                sqlInserirCargo(novoCargo);
                        
            }
        });
    }

    //---------------CONEXÃO COM O BANCO DE DADOS---------------
    private void sqlInserirCargo(Cargo novoCargo) {
        
        // validando nome
        if(CCargo.getText().length() <= 3){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o nome corretamente.");
            return;
        }
        
        // conexão
        Connection conexao;
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.senha);
            
            // criando a instrução SQL
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            instrucaoSQL.executeUpdate("INSERT INTO cargos (nome) VALUES ('"+novoCargo.getNome()+"')");            
            
            JOptionPane.showMessageDialog(null, "Cargo adicionado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o Cargo.");
            Logger.getLogger(CargosInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
