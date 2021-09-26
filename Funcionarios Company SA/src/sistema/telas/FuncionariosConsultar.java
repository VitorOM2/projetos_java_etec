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
import sistema.entidades.Funcionario;

public class FuncionariosConsultar extends JPanel {
    
    //--------------------ATRIBUTOS--------------------
    Funcionario funcionarioAtual;
    JLabel LTitulo, LFuncionario;
    JTextField CFuncionario;
    JButton BTPesquisar, BTEditar, BTExcluir;
    DefaultListModel<Funcionario> listasFuncionariosModelo = new DefaultListModel();
    JList<Funcionario> listaFuncionarios;
            
    public FuncionariosConsultar(){
        criarComponentes();
        criarEventos();
        Navegador.habilitaMenu();
    }

    //---------------INSTANCIAÇÃO DOS COMPONENTES----------------
    private void criarComponentes() {
        setLayout(null);
        
        //Rótulos
        LTitulo = new JLabel("Consulta de Funcionarios", JLabel.CENTER);
        LTitulo.setFont(new Font(LTitulo.getFont().getName(), Font.PLAIN, 20));      
        LFuncionario = new JLabel("Nome do funcionario", JLabel.LEFT);
        
        //Campos
        CFuncionario = new JTextField();
        
        //Botões
        BTPesquisar = new JButton("Pesquisar Funcionario");
        BTEditar = new JButton("Editar Funcionario");
        BTEditar.setEnabled(false);
        BTExcluir = new JButton("Excluir Funcionario");
        BTExcluir.setEnabled(false);
        
        //Listas
        listasFuncionariosModelo = new DefaultListModel();
        listaFuncionarios = new JList();
        listaFuncionarios.setModel(listasFuncionariosModelo);
        listaFuncionarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        //---------------POSIÇÕES E TAMANHOS---------------
        //Rótulos
        LTitulo.setBounds(20, 20, 660, 40);
        LFuncionario.setBounds(150, 120, 400, 20);
        
        //Campos
        CFuncionario.setBounds(150, 140, 400, 40);
        
        //Botões
        BTPesquisar.setBounds(560, 140, 130, 40);  
        BTEditar.setBounds(560, 360, 130, 40); 
        BTExcluir.setBounds(560, 400, 130, 40);
        
        //listas
        listaFuncionarios.setBounds(150, 200, 400, 240);
        
        //------------------ADICIONA OS COMPONENTES------------------
        //Rótulos
        add(LTitulo);
        add(LFuncionario);
        
        //Campos
        add(CFuncionario);
        
        //Listas
        add(listaFuncionarios);
        
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
                sqlPesquisarFuncionarios(CFuncionario.getText());
            }
        });
        BTEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Navegador.funcionariosEditar(funcionarioAtual);
            }
        });
        BTExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqlDeletarFuncionario();
            }
        });
        
        //Listas
        listaFuncionarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                funcionarioAtual = listaFuncionarios.getSelectedValue();
                if(funcionarioAtual == null){
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
    private void sqlPesquisarFuncionarios(String nome) {        
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
            resultados = instrucaoSQL.executeQuery("SELECT * FROM funcionarios WHERE nome like '%"+nome+"%' order by nome ASC");
            
            listasFuncionariosModelo.clear();

            while (resultados.next()) {                
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultados.getInt("id"));
                funcionario.setNome(resultados.getString("nome"));
                funcionario.setSobrenome(resultados.getString("sobrenome"));
                funcionario.setDataNascimento(resultados.getString("dataNascimento"));
                funcionario.setEmail(resultados.getString("email"));
                if(resultados.getString("cargo") != null) funcionario.setCargo(Integer.parseInt(resultados.getString("cargo")));
                funcionario.setSalario(Double.parseDouble(resultados.getString("salario")));
                
                listasFuncionariosModelo.addElement(funcionario);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao consultar funcionários.");
            Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sqlDeletarFuncionario() {
        String pergunta = "Deseja realmente excluir o Funcionario "+funcionarioAtual.getNome()+"?";
        int confirmacao = JOptionPane.showConfirmDialog(null, pergunta, "Excluir", JOptionPane.YES_NO_OPTION);
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
                instrucaoSQL.executeUpdate("DELETE funcionarios WHERE id="+funcionarioAtual.getId()+"");            

                JOptionPane.showMessageDialog(null, "Funcionario deletado com sucesso!");
                Navegador.inicio();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir Funcionario.");
                Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}