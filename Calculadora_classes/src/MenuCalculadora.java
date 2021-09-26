
/* @author Vitor Marques */
//---------------MENU---------------
public class MenuCalculadora 
{
    
    private Calculadora calculadora;
    private int opcao;
    private ConversorNumeros conversor;
    private EntradaSaidaDados io;
    
    //----------MÉTODO PARA CRIAR O MENU----------
    public MenuCalculadora()
    {
      this.calculadora = new Calculadora();
      this.opcao = -1;
      this.conversor = new ConversorNumeros();
      this.io = new EntradaSaidaDados();
    }
    
    //----------MÉTODO PARA EXECUTAR A CALCULADORA----------
    public void executarCalculadora()
    {       
        do 
        {
            this.executarMenuPrincipal();
            this.avaliarOpcaoEscolhida();
        } while (this.opcao != 0);        
    }
    
    private void executarMenuPrincipal()
    {
        String mensagemMenu = "Selecione uma opção "
                
                +"\n 1 - SOMAR"
                +"\n 2 - SUBTRAIR"
                +"\n 3 - MULTIPLICAR"
                +"\n 4 - DIVIDIR"
                +"\n 5 - SAIR";
        
        String entradaDados = io.entradaDados (mensagemMenu);
        this.opcao = conversor.StringToInt (entradaDados);
    }
    
    //---------------CHECA AS OPÇÕES DO MENU---------------
    private void avaliarOpcaoEscolhida()
    {
        String saida;
        double num1 = 0,num2 = 0;
        
        //----------Opções válidas----------
        if (this.opcao !=0 && this.opcao<=4)
        {
            String mensagemEntrada = "Digite o 1º número";
            num1 = conversor.stringToDouble(io.entradaDados(mensagemEntrada));
            calculadora.setNumero01(num1);
            
            mensagemEntrada = "Digite o 2º número";
            num2 = conversor.stringToDouble(io.entradaDados(mensagemEntrada));
            calculadora.setNumero02(num2);
            
            
            switch(this.opcao){
                //-----Somar-----
                case 1:
                    calculadora.somar (num1,num2);
                    saida = "Resultado da soma: " + calculadora.getResultado();
                    io.saidaDados(saida);
                    break;
                //-----Subtrair-----
                case 2:
                    calculadora.subtrair (num1,num2);
                    saida = "Resultado da subtração: " + calculadora.getResultado();
                    io.saidaDados(saida);
                    break;
                //-----Multiplicar-----
                case 3:
                    calculadora.multiplicar (num1,num2);
                    saida = "Resultado da multiplicação: " + calculadora.getResultado();
                    io.saidaDados(saida);
                    break;
                //-----Dividir-----    
                case 4:
                    calculadora.dividir (num1,num2);
                    saida = "Resultado da divisão: " + calculadora.getResultado();
                    io.saidaDados(saida);
                    break;
                //-----Sair-----    
                case 5:
                    calculadora.sair();
                    
                //--------------OPÇÕES INVALIDAS---------------    
                default:
                    io.saidaDados("Opção invalida");
                    break;
            }
        }
    }
}
