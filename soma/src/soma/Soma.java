
package soma;

import javax.swing.JOptionPane;
/**
 *
 * @author Vitor
 */
public class Soma {

    public static void main(String[] args) {
        
        int a = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um valor: "));
        int b = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um outro valor: "));
        int s = 0;
        
        s = a + b;
        
        JOptionPane.showMessageDialog(null,"A soma é: "+s);
    } 
    
}
