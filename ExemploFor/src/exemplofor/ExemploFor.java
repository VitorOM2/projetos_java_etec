package exemplofor;

/* @author Vitor */
public class ExemploFor {

    public static void main(String[] args) 
            
    {
        // Forma 1: Valor inicial declarado externamente
        System.out.println("----------------------------------------");
        System.out.println("   ");
        System.out.println("Forma 1: Valor inicial para x=10 declarado externamente");
        
            int x=10;
        
        for (;x<=20; x++)
            
        {
            System.out.println("Intervalo aleatorio e fracionario para x entre 10 e 20 : " + Math.random()*x);
        }
        
        // Forma 2: condicional controlada por if x>25
        System.out.println("----------------------------------------");
        System.out.println("   ");
        System.out.println("Forma 2: condicional controlada no final do loop por if x>25");
        
        for (x=20; ;x++)
            
        {
            System.out.println("Intervalo aleatorio e fracionario para x entre 20 e 25: " + Math.random()*x);
            if (x>25) break;
        }
        
        // Forma 4: aninhamento de for para os acumuladores x e y
        System.out.println("----------------------------------------");
        System.out.println("   ");
        System.out.println("Forma 4: aninhamento de for para os acumuladores x e y");
           int y=1; // valor-inicial declarado para y
           for (x=1; x<=10; x++) // Aninhamento de laços - valor-inicial declarado internamente para x
                {
                
                for (; y<=5; y++) // valor-inicial declarado externamente para y no início da Forma 4
                     {
                      System.out.println("Valor incrementado de 1 em 1 para y entre 1 e 5: " + y);
                     }
        System.out.println("Intervalo aleatorio e fracionario para x entre 1 e 10: " + Math.random()*x);
                } 
        
        // Forma 5: decremento de 5 em 5
        System.out.println("----------------------------------------");
        System.out.println("   ");
        System.out.println("Forma 5: decremento de 5 em 5 para x");
		for (x=50; x>=5; x-=5)
		     {
		     System.out.println("Valor decrescente de 5 em 5 para x entre 50 e 5: " + x);
		     } 
 
 } // finalizando o bloco do public static void main
 } // finalizando o bloco do public class forFormas


