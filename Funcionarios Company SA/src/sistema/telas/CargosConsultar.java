package sistema.telas;

/*Vitor*/

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;
import sistema.BancoDeDados;
import sistema.Navegador;
import sistema.entidades.Cargo;

public class CargosConsultar extends JPanel {
    
    //--------------------ATRIBUTOS--------------------
    
    Cargo cargoAtual;
    JLabel LTitulo, LCargo;
    JTextField CCargo;
    JButton BTPesquisar, BTEditar, BTExcluir;
    DefaultListModel<Cargo> listasCargosModelo = new DefaultListModel();
    JList<Cargo> listaCargos;
            
    public CargosConsultar(){
        criarComponentes();
        criarEventos();
        Navegador.habilitaMenu();
    }
    
    //---------------INSTANCIAÇÃO DOS COMPONENTES----------------
    
    private void criarComponentes() {
        setLayout(null);
        
        //Rótulos
        LTitulo = new JLabel("Consulta de Cargos", JLabel.CENTER);
        LTitulo.setFont(new Font(LTitulo.getFont().getName(), Font.PLAIN, 20));      
        LCargo = new JLabel("Nome do cargo", JLabel.LEFT);
        
        //Campos
        CCargo = new JTextField();
        
        //Botões
        BTPesquisar = new JButton("Pesquisar Cargo");
        BTEditar = new JButton("Editar Cargo");
        BTEditar.setEnabled(false);
        BTExcluir = new JButton("Excluir Cargo");
        BTExcluir.setEnabled(false);
        
        //Listas
        listasCargosModelo = new DefaultListModel();
        listaCargos = new JList();
        listaCargos.setModel(listasCargosModelo);
        listaCargos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        //---------------POSIÇÕES E TAMANHOS---------------
        //Rótulos
        LTitulo.setBounds(20, 20, 660, 40);
        LCargo.setBounds(150, 120, 400, 20);
        
        //Campos
        CCargo.setBounds(150, 140, 400, 40);
        
        //Botões
        BTPesquisar.setBounds(560, 140, 130, 40); 
        BTEditar.setBounds(560, 360, 130, 40); 
        BTExcluir.setBounds(560, 400, 130, 40);
        
        //Listas
        listaCargos.setBounds(150, 200, 400, 240);
        
        //------------------ADICIONAR OS COMPONENTES------------------
        //Rótulos
        add(LTitulo);
        add(LCargo);
        
        //Campos
        add(CCargo);
        
        //Listas
        add(listaCargos);
        
        //Botões
        add(BTPesquisar);
        add(BTEditar);
        add(BTExcluir);
        
        //--------------------CONFIGURAÇÕES DA TELA-------------------
        setVisible(true);
    }

        
    //---------------ADICIONA EVENTOS---------------
    
    private void criarEventos() {
        //Botões
        BTPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqlPesquisarCargos(CCargo.getText());
            }
        });
        BTEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Navegador.cargosEditar(cargoAtual);
            }
        });
        BTExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqlDeletarCargo();
            }
        });
        
        //Listas
        listaCargos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                cargoAtual = listaCargos.getSelectedValue();
                if(cargoAtual == null){
                    BTEditar.setEnabled(false);
                    BTExcluir.setEnabled(false);
                }else{
                    BTEditar.setEnabled(true);
                    BTExcluir.setEnabled(true);
                }
            }
        });
    }
    
    //---------------CONEXÃO COM O BANCO DE DADOS---------------
    private void sqlPesquisarCargos(String nome) {
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
            resultados = instrucaoSQL.executeQuery("SELECT * FROM cargos WHERE nome like '%"+nome+"%'");
            
            listasCargosModelo.clear();

            while (resultados.next()) {                
                Cargo cargo = new Cargo();
                cargo.setId(resultados.getInt("id"));
                cargo.setNome(resultados.getString("nome"));
                
                listasCargosModelo.addElement(cargo);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar os Cargos.");
            Logger.getLogger(CargosInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sqlDeletarCargo() {
        
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Cargo "+cargoAtual.getNome()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
        if(confirmacao == JOptionPane.YES_OPTION){

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
                instrucaoSQL.executeUpdate("DELETE cargos WHERE id="+cargoAtual.getId()+"");            

                JOptionPane.showMessageDialog(null, "Cargo deletado com sucesso!");
                Navegador.inicio();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o Cargo.");
                Logger.getLogger(CargosInserir.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
