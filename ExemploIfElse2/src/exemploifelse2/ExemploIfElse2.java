package exemploifelse2;

/* @author Vitor */
public class ExemploIfElse2 {

    public static void main(String[] args) 
    {
        int limitecheque,saldomedio = 2500;
        
        if (saldomedio > 5000)
            {
                limitecheque = 1000;
            }
            else if (saldomedio > 3000 && saldomedio <= 5000)
                {
                    limitecheque = 800;
                }
                else if (saldomedio > 2000 && saldomedio <= 3000)
                    {
                        limitecheque = 600;
                    }
                    else if (saldomedio > 1000 && saldomedio <=2000)
                        {
                            limitecheque = 400;
                        }
        else    
        {
            limitecheque = 0;
        }
        
        System.out.println("Limite do cheque especial é "+ limitecheque);
        
    }
    
}
