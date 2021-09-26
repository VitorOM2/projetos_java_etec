/* @author Vitor Marques */

import javax.swing.JOptionPane;

public class EntradaSaidaDados 
{
    //---------------ENTRADA---------------
    public String entradaDados (String mensagemEntrada)
    {
        return JOptionPane.showInputDialog(mensagemEntrada);
    }
    
    //---------------SAÍDA---------------
    public void saidaDados(String mensagemSaida)
    {
        JOptionPane.showMessageDialog(null, mensagemSaida);
    }
}
