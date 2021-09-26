
package sistema.telas;

/* @author Vitor */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.*;
import java.util.logging.*;
import javax.swing.text.MaskFormatter;
import sistema.BancoDeDados;
import sistema.Navegador;
import sistema.entidades.Cargo;
import sistema.entidades.Funcionario;

public class FuncionariosInserir extends JPanel{
    
    //--------------------ATRIBUTOS--------------------
    
    JLabel LTitulo,LNome,LSobrenome,LDataN,LEmail,LCargo,LSalario;
    JTextField CNome,CSobrenome,CEmail;
    JFormattedTextField CDataN,CSalario;
    JComboBox CCargo;
    JButton btGravar;
    
    public FuncionariosInserir(){
        criarComponentes();
        criarEventos();
        Navegador.habilitaMenu();
    }
    
    //---------------INSTANCIAÇÃO DOS COMPONENTES----------------

    private void criarComponentes(){
        setLayout(null);
        
        //Instanciação dos rótulos
        LTitulo = new JLabel("Cadastro de funcionários");
        LTitulo.setFont(new Font (LTitulo.getFont().getName(),Font.PLAIN, 20 ));
        
        LNome = new JLabel("Nome: ",JLabel.LEFT);
        LSobrenome = new JLabel("Sobrenome: ",JLabel.LEFT);
        LDataN = new JLabel("Data de Nascimento: ",JLabel.LEFT);
        LEmail = new JLabel("Email: ",JLabel.LEFT);
        LCargo = new JLabel("Cargo: ",JLabel.LEFT);
        LSalario = new JLabel("Salário: ",JLabel.LEFT);
        
        //Instanciação dos campos
        CNome = new JTextField();
        CSobrenome = new JTextField();
        
        CDataN = new JFormattedTextField();
        //mascara para data de nascimento
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(CDataN);
        } catch (Exception ex) {
            Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        CEmail = new JTextField();
        CCargo = new JComboBox();
        
        //mascara para o salário
        DecimalFormat formmater = new DecimalFormat("###0.000",new DecimalFormatSymbols(new 
            Locale("pt","BR")));
        
        CSalario = new JFormattedTextField(formmater);
        CSalario.setValue(0.00);
        
        //Botões
        btGravar = new JButton("Salvar");
        
        //---------------POSIÇÕES E TAMANHOS---------------
        //Rótulos
        LTitulo.setBounds(20, 20, 660, 40);
        LNome.setBounds(150, 80, 400, 20);
        LSobrenome.setBounds(150, 140, 400, 20);
        LDataN.setBounds(150, 200, 400, 20);
        LEmail.setBounds(150, 260, 400, 20);
        LCargo.setBounds(150, 320, 400, 20);
        LSalario.setBounds(150, 380, 400, 20);
        
        //Campos
        CNome.setBounds(150, 100, 400, 40);
        CSobrenome.setBounds(150, 160, 400, 40);
        CDataN.setBounds(150, 220, 400, 40);
        CEmail.setBounds(150, 280, 400, 40);
        CCargo.setBounds(150, 340, 400, 40);
        CSalario.setBounds(150, 400, 400, 40);
        
        //Botões
        btGravar.setBounds(560, 400, 130, 40);
        
        //------------------ADICIONA OS COMPONENTES------------------
        //Rótulos
        add(LTitulo);
        add(LNome);
        add(LSobrenome);
        add(LDataN);
        add(LEmail);
        add(LCargo);
        add(LSalario);
        
        //Campos
        add(CNome);
        add(CSobrenome);
        add(CDataN);
        add(CEmail);
        add(CCargo);
        add(CSalario);
        
        //Botões
        add(btGravar);
        
        
        sqlCarregarCargos();
        
        //--------------------CONFIGURAÇÕES DA TELA-------------------
        setVisible(true);       
    }
    
        //---------------ADICIONA EVENTOS---------------
    
    private void criarEventos(){
        btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Funcionario novoFuncionario = new Funcionario();
                
                novoFuncionario.setNome(CNome.getText());
                novoFuncionario.setSobrenome(CSobrenome.getText());
                novoFuncionario.setDataNascimento(CDataN.getText());
                novoFuncionario.setEmail(CEmail.getText());
                
                Cargo cargoSelecionado = (Cargo) CCargo.getSelectedItem();
                if (cargoSelecionado != null) novoFuncionario.setCargo(cargoSelecionado.getId());
                
                novoFuncionario.setSalario(Double.valueOf(CSalario.getText().replace(",","."
                )));
                
                sqlInserirFuncionario (novoFuncionario);
            }
        });
    }
    
    //---------------CONEXÃO COM O BANCO DE DADOS---------------
    
    private void sqlCarregarCargos(){
        //Conexão
        Connection conexao;
        //Instrução SQL
        Statement instrucaoSQL;
        //Resultados
        ResultSet resultados;
        
        try {
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao,
                    BancoDeDados.usuario,BancoDeDados.senha);
            
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            
            resultados  = instrucaoSQL.executeQuery("SELECT * FROM cargos order by nome asc");
            CCargo.removeAll();
            
            while (resultados.next()){
                Cargo cargo = new Cargo();
                cargo.setId(resultados.getInt("id"));
                cargo.setNome(resultados.getString("nome"));
                CCargo.addItem(cargo);
            }
            CCargo.updateUI();
            
            conexao.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao carregar os cargos");
            Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    //--------------VALIDAÇÃO---------------
    private void sqlInserirFuncionario(Funcionario novoFuncionario){
        //Validando nome
        if(CNome.getText().length() <= 3){
            JOptionPane.showMessageDialog(null,"Por favor,preencha o nome corretamente.");
            return;
        }
        //Validando Sobrenome
        if(CSobrenome.getText().length() <= 3){
            JOptionPane.showMessageDialog(null,"Por favor,preencha o sobrenome corretamente.");
        }
        
        //Validando Salário
        if (Double.parseDouble(CSalario.getText().replace(",",".")) <=100) {
            JOptionPane.showMessageDialog(null,"Por favor,preencha o salário corretamente.");
        }
        //Validando Email
        Boolean emailValidado = false;
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_'{|}--]+@((\\[[0-9]{1-3}\\.[0-9]"
                + "{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(CEmail.getText());
        emailValidado = m.matches();
        
        if(!emailValidado){
            JOptionPane.showMessageDialog(null,"Por favor, preencha o email corretamente.");
        }
        
        Connection conexao;
        
        PreparedStatement instrucaoSQL;
        
        try {
            conexao = DriverManager.getConnection(BancoDeDados.stringDeConexao,
                    BancoDeDados.usuario,BancoDeDados.senha);
            
            String template = "INSERT INTO funcionarios (nome,sobrenome,dataNascimento,"
                    + "email,cargo,salario)";
            
                    template = template+" VALUES (?,?,?,?,?,?)";
                    
                    instrucaoSQL = conexao.prepareStatement(template);
                    instrucaoSQL.setString (1,novoFuncionario.getNome());
                    instrucaoSQL.setString (2,novoFuncionario.getSobrenome());
                    instrucaoSQL.setString (3,novoFuncionario.getDataNascimento());
                    instrucaoSQL.setString (4,novoFuncionario.getEmail());
                    
                    if (novoFuncionario.getCargo() > 0) {                   
                       instrucaoSQL.setInt (5,novoFuncionario.getCargo()); 
                    }else{
                        instrucaoSQL.setNull (5, java.sql.Types.INTEGER);
                    }
                    
                    instrucaoSQL.setString (6,Double.toString(novoFuncionario.getSalario()));
                    instrucaoSQL.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null,"Funcionário adicionado com sucesso");
                    
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao adicionar o Funcionário.");
            Logger.getLogger(FuncionariosInserir.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
