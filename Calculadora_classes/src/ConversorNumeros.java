/* @author Vitor Marques */
public class ConversorNumeros 
{
    //---------------STRING --> INTEIROS--------------
    public Integer StringToInt (String num)   
    {
        int conversor = Integer.parseInt(num);
        return (conversor);
    }
    
    //--------------STRING --> DOUBLE---------------
    public Double stringToDouble (String num)
    {
        double conversor = Double.parseDouble(num);
        return conversor;
    }
}
