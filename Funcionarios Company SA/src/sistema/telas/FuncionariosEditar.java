package sistema.telas;

/* @author Vitor */

import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import sistema.BancoDeDados;
import sistema.Navegador;
import sistema.entidades.Cargo;
import sistema.entidades.Funcionario;

public class FuncionariosEditar extends JPanel {
    
    //---------------ATRIBUTOS--------------
    Funcionario funcionarioAtual;
    JLabel LTitulo,LNome,LSobrenome,LDataNascimento,LEmail,LCargo,LSalario;
    JTextField CNome, CSobrenome, CEmail;
    JFormattedTextField CDataNascimento, CSalario;
    JComboBox<Cargo> CBCargo;
    JButton BTGravar;  
            
    public FuncionariosEditar(Funcionario funcionario){
        funcionarioAtual = funcionario;
        criarComponentes();
        criarEventos();
        Navegador.habilitaMenu();
    }

    //---------------INSTANCIAÇÃO DOS COMPONENTES----------------
    private void criarComponentes() {
        setLayout(null);
        
        //Rótulos
        String textoLabel = "Editar Funcionario "+funcionarioAtual.getNome()+" "+funcionarioAtual.getSobrenome();
        LTitulo = new JLabel(textoLabel, JLabel.CENTER);
        LTitulo.setFont(new Font(LTitulo.getFont().getName(), Font.PLAIN, 20));      
        LNome = new JLabel("Nome:", JLabel.LEFT);
        LSobrenome = new JLabel("Sobrenome:", JLabel.LEFT);
        LDataNascimento = new JLabel("Data de Nascimento:", JLabel.LEFT);
        LEmail = new JLabel("E-mail:", JLabel.LEFT);
        LCargo = new JLabel("Cargo:", JLabel.LEFT);
        LSalario = new JLabel("Salário:", JLabel.LEFT);
        DecimalFormat formatter = new DecimalFormat("###0.00", new DecimalFormatSymbols
        (new Locale("pt", "BR")));
        
        //Campos
        CNome = new JTextField(funcionarioAtual.getNome());      
        CSobrenome = new JTextField(funcionarioAtual.getSobrenome());     
        CDataNascimento = new JFormattedTextField(funcionarioAtual.getDataNascimento());
        try {
            MaskFormatter dateMask= new MaskFormatter("##/##/####");
            dateMask.install(CDataNascimento);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
        CEmail = new JTextField(funcionarioAtual.getEmail());     
        CBCargo = new JComboBox();     
        CSalario = new JFormattedTextField(formatter);
        CSalario.setValue(funcionarioAtual.getSalario());
        BTGravar = new JButton("Salvar");
        
        //---------------POSIÇÕES E TAMANHOS---------------
        //Rótulos
        LTitulo.setBounds(20, 20, 660, 40);
        LNome.setBounds(150, 80, 400, 20);
        LSobrenome.setBounds(150, 140, 400, 20);
        LDataNascimento.setBounds(150, 200, 400, 20); 
        LEmail.setBounds(150, 260, 400, 20);
        LCargo.setBounds(150, 320, 400, 20);
        LSalario.setBounds(150, 380, 400, 20);
        
        //Campos
        CNome.setBounds(150, 100, 400, 40);
        CSobrenome.setBounds(150, 160, 400, 40);
        CDataNascimento.setBounds(150, 220, 400, 40);
        CEmail.setBounds(150, 280, 400, 40);
        CBCargo.setBounds(150, 340, 400, 40);
        CSalario.setBounds(150, 400, 400, 40);
        
        //Botões
        BTGravar.setBounds(560, 400, 130, 40); 
        
        
        //------------------ADICIONAR OS COMPONENTES------------------
        //Rótulos
        add(LTitulo);
        add(LNome);
        add(LSobrenome);
        add(LDataNascimento);
        add(LEmail);
        add(LCargo);
        add(LSalario);
        
        //Campos
        add(CNome); 
        add(CSobrenome);
        add(CDataNascimento);        
        add(CEmail);       
        add(CBCargo);   
        add(CSalario);
        
        //Botões
        add(BTGravar);
        
        sqlCarregarCargos(funcionarioAtual.getCargo());
        
        //--------------------CONFIGURAÇÕES DA TELA-------------------
        setVisible(true);
    }

    //--------------------ADICIONAR EVENTOS--------------------
    
    private void criarEventos() {
        BTGravar.addActionListener(new ActionListener()     
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                funcionarioAtual.setNome(CNome.getText());
                funcionarioAtual.setSobrenome(CSobrenome.getText());
                funcionarioAtual.setDataNascimento(CDataNascimento.getText());
                funcionarioAtual.setEmail(CEmail.getText());
                Cargo cargoSelecionado = (Cargo) CBCargo.getSelectedItem();
                if(cargoSelecionado != null) funcionarioAtual.setCargo(cargoSelecionado.getId());
                funcionarioAtual.setSalario(Double.valueOf(CSalario.getText().replace(",", ".")));
                
                sqlAtualizarFuncionario();
                        
            }
        });
    }

    //---------------CONEXÃO COM O BANCO DE DADOS---------------
    
    private void sqlCarregarCargos(int cargoAtual) {        
        // conexão
        Connection conexao;
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, BancoDeDados.usuario, BancoDeDados.senha);
            
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultados = instrucaoSQL.executeQuery("SELECT * from cargos order by nome asc");
            CBCargo.removeAll();          
            
            while (resultados.next()) {
                Cargo cargo = new Cargo();
                cargo.setId(resultados.getInt("id"));
                cargo.setNome(resultados.getString("nome"));
                CBCargo.addItem(cargo);
                
                if(cargoAtual == cargo.getId()) CBCargo.setSelectedItem(cargo);
            }
            CBCargo.updateUI();
            
            conexao.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar os cargos.");
            Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sqlAtualizarFuncionario() {
        
        // validando nome
        if(CNome.getText().length() <= 3){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o nome corretamente.");
            return;
        }
        
        // validando sobrenome
        if(CSobrenome.getText().length() <= 3){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o sobrenome corretamente.");
            return;
        }
        
        // validando sobrenome
        if(Double.parseDouble(CSalario.getText().replace(",", ".")) <= 100){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o salário corretamente.");
            return;
        }
        
        // validando email
        Boolean emailValidado = false;
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(CEmail.getText());
        emailValidado = m.matches();
        
        if(!emailValidado){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o email corretamente.");
            return;
        }
        
        // conexão
        Connection conexao;
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
        try 
        {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao, 
                    BancoDeDados.usuario, BancoDeDados.senha);
            
            String template = 
            "UPDATE funcionarios set nome=?, sobrenome=?, dataNascimento=?, email=?, cargo=?, salario=?";
            
            template = template+" WHERE id="+funcionarioAtual.getId();
            instrucaoSQL = conexao.prepareStatement(template);
            instrucaoSQL.setString(1, CNome.getText());
            instrucaoSQL.setString(2, CSobrenome.getText());
            instrucaoSQL.setString(3, CDataNascimento.getText());
            instrucaoSQL.setString(4, CEmail.getText());
            Cargo cargoSelecionado = (Cargo) CBCargo.getSelectedItem();
            
            if(cargoSelecionado != null)
            {
                instrucaoSQL.setInt(5, cargoSelecionado.getId());
            }
            else
            {
                instrucaoSQL.setNull(5, java.sql.Types.INTEGER);
            }
            
            instrucaoSQL.setString(6, CSalario.getText().replace(",", "."));
            instrucaoSQL.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso!");
            Navegador.inicio();
            
            conexao.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao editar o Funcionario.");
            Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}