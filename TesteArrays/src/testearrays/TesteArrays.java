package testearrays;

/* @author Vitor */

public class TesteArrays {

    //Leitura de 4 notas e apresentação da média de cada disciplina
    
    public static void main(String[] args) 
            
    {
        
        //ENTRADA DE DADOS E DEFINIÇÃO DAS VARIAVEIS
        
        //Array unidimensional para armazenamento dos nomes das duas disciplinas
       String [] cursos;
       cursos = new String[2];
       cursos [0] = "Sistemas";
       cursos [1] = "Internet";  
        //Array multidimensional para armazenamento das 4 notas de cada disciplina
        double [][] notas = new double [2][4];  
        notas [0][0] = 8.0;
        notas [0][1] = 7.5;
        notas [0][2] = 9.0;
        notas [0][3] = 8.5;
        
        notas [1][0] = 9.5;
        notas [1][1] = 8.5;
        notas [1][2] = 8.0;
        notas [1][3] = 9.0;
        //Definição da variavel média
        double media = 0.0;
        
        //PROCESSAMENTO DE DADOS
        
        /*Rótulo*/
        System.out.println("\n");
        System.out.println("MEDIAS:");
        
        //Controle de busca por disciplina através da variavel l
        for (int l=0; l<notas.length;l++)
        {
            //Controle de busca das 4 notas de cada disciplina através da variavel c
            for (int c=0; c<notas[l].length;c++)
            {
                //Acumulador das 4 notas de cada disciplina na variavel media
                media = media + notas[l][c];
            }
            media = media / 4;
            
            //SAIDA DE DADOS
            //Apresentacao do resultado apos o processamento com concatenacao de string e variaveis
            System.out.println(cursos[l] + " = " + media);
            media = 0 ;
        }
        
        System.out.println("\n");
        
    }
    
}
