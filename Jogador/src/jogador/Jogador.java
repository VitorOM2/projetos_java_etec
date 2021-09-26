package jogador;

/**
 *
 * @author Vitor
 */
public class Jogador 

{

    private int numero;
    private String nome;
     
        public String getnome()//Método para pegar o valor da variável nome
        {
            return nome;
        }
        
        public int getnumero()//Método para pegar o valor da variável nome
        {
            return numero;  
        }
        
        public void setnome (String nome)//Método para mudar o valor da variável
        {
            this.nome = nome;
        }
        
        public void setnumero (int numero)//Método para mudar o valor da variável
        {
            this.numero = numero;
        }            
}
