package testearrays2;

import java.util.*;
/* @author Vitor */
public class TesteArrays2 {

    public static void main(String[] args) 
    {
         /* Definição dos valores numéricos de um array Unidimensional */
        int idx[] = {1, 9, 5, 2, 8};
        
        /* Apresentação dos valores de um array ANTES da classificação */
        System.out.println("Valores de um array para ORDENAR/CLASSIFICAR:");
        
        for (int valor : idx)
        {
            System.out.println(valor + "\t");
        }
        
        /* Execução do método sort para classificação/ordenação do array */
        Arrays.sort(idx);
        
        /* Impressão com quebra de 2 linhas vazias */
        System.out.println(" ");
        System.out.println(" ");

        
        /* Apresentação dos valores numéricos ORDENADOS/CLASSIFICADOS de um
        array utilizando o método sort */
        
        System.out.println("Valores de um array ORDENADO/CLASSIFICADO:");
        
        for (int valor : idx) 
        {
            System.out.print(valor + "\t");
        }
        
        /* Impressão com quebra de 2 linhas vazias */ 
        System.out.println(" ");
        System.out.println(" ");

    }
    
}
