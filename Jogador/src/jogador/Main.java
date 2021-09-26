package jogador;

/**
 *
 * @author Vitor
 */
public class Main {
    
    public static void main(String[] args) 
    {
        Jogador jogador = new Jogador ();
        jogador.setnumero(10);
        jogador.setnome("Pelé");
        
        System.out.println("O "+ jogador.getnome()+" foi um dos melhores camisa "
        + jogador.getnumero() + " de todos os tempos");
    }
    
}
