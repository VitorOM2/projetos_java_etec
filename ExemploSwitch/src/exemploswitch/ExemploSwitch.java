package exemploswitch;

/* @author Vitor */
public class ExemploSwitch {

    public static void main(String[] args)
    {
        
        char indice = 'b';
        
        String resultado = "";
        
        switch (indice)
            
        {
            case 'a':
                resultado += 'A';
                break;
            
            case 'b':
                resultado += 'B';
                break;
                
            case 'c':
                resultado += 'C';
                break;
                
            case 'd':
                resultado += 'D';
                break;  
        }
        
        System.out.println(resultado);
        
    }
    
}
