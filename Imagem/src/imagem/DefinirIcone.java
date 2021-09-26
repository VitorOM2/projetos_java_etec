package imagem;

/* @author Vitor */ 

    import javax.swing.*;
    import java.awt.*;

public class DefinirIcone extends JFrame {
   
    public DefinirIcone (){
    
        super ("Como definir o icone para a janela");
        Container tela = getContentPane();
        ImageIcon icone = new ImageIcon ("teste.png");
        setIconImage(icone.getImage());
        tela.setBackground (Color.blue);
        setSize(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {

        DefinirIcone app = new DefinirIcone();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
