
import java.util.HashSet;
import java.util.Set;


/* @author Vitor Marques */
public class Calculadora {
    private double numero01;
    private double numero02;
    private double resultado;
    
    public Calculadora()
    {
        this (0,0,0);
    }
    
    public Calculadora (double numero01,double numero02,double resultado)
    {
        this.numero01 = numero01;
        this.numero02 = numero02;
        this.resultado = resultado;
    }
    
    //---------------GETTERS E SETTERS--------------- 
    
    //----------Get e Set num 1---------
    public double getNumero01() 
    {
        return numero01;
    }
    
    public void setNumero01(double numero01)
    {
        this.numero01 = numero01;
    }
    
    //----------Get e Set Num 2---------
    public double getNumero02() 
    {
        return numero02;
    }
    
    public void setNumero02(double numero02)
    {
        this.numero02 = numero02;
    }
    
    //----------Get e Set Resultado---------
    public double getResultado() 
    {
        return resultado;
    }
    
    public void setResultado(double resultado)
    {
        this.resultado = resultado;
    }
    
    //---------------OPERAÇÕES---------------
    
    //----------Somar----------
    public void somar(double numero01,double numero02)
    {
        setResultado (this.getNumero01() + this.getNumero02());
    }
    
    //----------Subtrair----------
    public void subtrair(double numero01,double numero02)
    {
        setResultado (this.getNumero01() - this.getNumero02());
    }

    //----------Multiplicar----------
    public void multiplicar(double numero01,double numero02)
    {
        setResultado (this.getNumero01() * this.getNumero02());
    }
    
    //----------Dividir----------
    public void dividir(double numero01,double numero02)
    {
        setResultado (this.getNumero01() / this.getNumero02());
    }
    
    //----------SAIR----------
    public void sair()
    {
        System.exit(0);
    }    
}
