package sistema.telas;

/* @author Vitor */

import java.awt.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import sistema.Navegador;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import sistema.BancoDeDados;

public class RelatoriosCargos extends JPanel
{
    //---------------ATRIBUTOS---------------
    //Rótulos
    JLabel LTitulo,LDescricao;
    
    public RelatoriosCargos()
    {
       criarComponentes();
       criarEventos();
       Navegador.habilitaMenu();
    }
    
    //---------------INSTANCIAÇÃO DOS COMPONENTES---------------
    private void criarComponentes()
    {
        setLayout(null);
        
        //Rótulos
        LTitulo = new JLabel ("Relatórios",JLabel.CENTER);
        LTitulo.setFont(new Font (LTitulo.getFont().getName(), Font.PLAIN, 20 ) );
        
        LDescricao = new JLabel ("Esse gráfico representa a quantidade de funcionarios por cargo",
            JLabel.CENTER);
        
        //Gráfico
        DefaultPieDataset dadosGrafico = this.criarDadosGrafico();
        
        JFreeChart someChart = ChartFactory.createPieChart3D("", dadosGrafico, false, true, false);
        PiePlot plot = (PiePlot) someChart.getPlot();
        plot.setLabelBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(null);
        plot.setOutlinePaint(null);
        someChart.setBackgroundPaint(null);
        
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})",
                new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        
        ChartPanel chartPanel = new ChartPanel(someChart)
        {
          @Override
          public Dimension getPreferredSize()
            {
                return new Dimension (660,340);
            }
        };
        
        //---------------POSIÇÕES E TAMANHOS---------------
        //Rótulos
        LTitulo.setBounds (20, 20, 660, 40);
        LDescricao.setBounds (20, 50, 660, 40);
        //Graficos
        chartPanel.setBounds(20, 100, 660, 340);
        
        //---------------ADICIONA OS COMPONENTES NA TELA---------------
        //Rótulos
        add (LTitulo);
        add (LDescricao);
        //Gráficos
        add (chartPanel);
        
        //--------------------CONFIGURAÇÕES DA TELA-------------------
        setVisible(true);
    }
    
    //---------------ADICIONA EVENTOS---------------
    private void criarEventos()
    {
        
    }
    
    //---------------CONEXÃO COM O BANCO DE DADOS---------------
    private DefaultPieDataset criarDadosGrafico()
    {
        DefaultPieDataset dados = new DefaultPieDataset();
        
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
            
            String query = "SELECT cargos.nome, count(*) as quantidade FROM cargos,funcionarios ";
            query = query + "WHERE cargos.id = funcionarios.cargo group by cargos.nome order by nome ASC";
            resultados = instrucaoSQL.executeQuery(query);
            
            while (resultados.next())
            {
                dados.setValue(resultados.getString("nome"),resultados.getInt("quantidade"));
            }
            return dados;
            
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao criar o relatório.\n\n"+ex.getMessage());
            Navegador.inicio();
        }
        
        return null;
    }
}
