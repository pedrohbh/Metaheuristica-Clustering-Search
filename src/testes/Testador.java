/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import metaheuristica.Solucao;
import principal.Principal;

/**
 *
 * @author administrador
 */
public class Testador 
{
    private static Formatter output;
    
    public static void openFile()
    {
        try
        {
            output = new Formatter("/home/administrador/Documentos/Metaheurística/Implementação/Exemplo/saida/Resultado.csv");
            output.format("instâncias;valorMédio;melhor;pior;desvioPadrão%n");
            
        }
        catch ( FileNotFoundException f )
        {
            System.err.println("Error opening file \"Resultado.csv\". Encerrando o programa");
            System.exit(1);
        }
        catch ( SecurityException se )
        {
            System.err.println("Write permission denied for \"Resultado.csv\". Encerrando programa");
            System.exit(1);
        }
        catch ( FormatterClosedException e )
        {
            System.err.println("Erro ao escrever no arquivo. Terminando.");
            System.exit(1);
        }
    }
    
    public static void closeFile()
    {
        if ( output != null )
            output.close();
    }
    
    public static void adicionaDados( String nomeInstancia, int media, int melhor, int pior, double desvio )
    {
        try
        {
            output.format("%s;%d;%d;%d;%.2f%n", nomeInstancia, media, melhor, pior, desvio );
        }
        catch ( FormatterClosedException e )
        {
            System.err.println("Error ao escrever no arquivo. Terminando");
            System.exit(1);
        }
    }
    
    
    
    public static void main(String[] args) throws IOException 
    {
        
        
        openFile();
        //int i = 0;
        //Principal p = new Principal();
        //p.replicaTestadora("Entrada/A-n33-k5.vrp");
        try ( Stream<Path> paths = Files.walk(Paths.get("/home/administrador/Documentos/Metaheurística/Implementação/Exemplo/A-VRP")))
        {
            paths.forEach( filePath -> 
            {
                if ( Files.isRegularFile(filePath))
                {
                    Solucao solucaoAtual;
                    int melhorSolucao = 0;
                    int piorSolucao = 0;
                    int mediaSolucao = 0;
                    double desvioPadrao = 0;
                    List<Integer> resultados = new LinkedList<>();
                    for ( int i = 0; i < 5; i++ )
                    {
                        Principal p = new Principal();
                        solucaoAtual = p.replicaTestadora(filePath.toString());
                        if ( i == 0 )
                        {
                            mediaSolucao = melhorSolucao = piorSolucao = solucaoAtual.getCustoTotal();
                        }
                        else
                        {
                            if ( solucaoAtual.getCustoTotal() < melhorSolucao )
                                melhorSolucao = solucaoAtual.getCustoTotal();
                            if ( solucaoAtual.getCustoTotal() > piorSolucao )
                                piorSolucao = solucaoAtual.getCustoTotal();
                            mediaSolucao += solucaoAtual.getCustoTotal();
                            resultados.add(solucaoAtual.getCustoTotal());
                            
                        }
                    }
                    mediaSolucao = mediaSolucao / 5;
                    for ( Integer i: resultados)
                    {
                        desvioPadrao += Math.pow(( i - mediaSolucao ), 2);
                    }
                    desvioPadrao = desvioPadrao / 5;
                    desvioPadrao = Math.sqrt(desvioPadrao);
                    adicionaDados(filePath.getFileName().toString(), mediaSolucao, melhorSolucao, piorSolucao, desvioPadrao );
                    //filePath.
                    System.out.println(filePath.getFileName());
                    
                }
                
                
            });
            
            closeFile();
        }
        
    }
}
