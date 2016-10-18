package grafo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import metaheuristica.Solucao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author administrador
 */
public class Grafo 
{
    
    private static Scanner input;
    
    private String nomeInstancia; // Nome da instância do problema
    private int dimensao;
    private int capacidade;
    private final List<Integer> depositos = new LinkedList<>();
    private Vertice []verticesGrafo;
    private int [][]distancias;
    
    
    public Solucao geraSolucaoInicial()
    {
        boolean sucessoAdicionarRota = true;
        Solucao s0 = new Solucao();
        Vertice []v = new Vertice[ verticesGrafo.length ];
        System.arraycopy(verticesGrafo, 0, v, 0, verticesGrafo.length );
        Arrays.sort(v);
        int sentinelaRota = 0;
        
        Caminhao novoCaminhao = new Caminhao();
        while ( sentinelaRota < v.length )
        {
            sucessoAdicionarRota = novoCaminhao.adicionaRota(v[ sentinelaRota ], capacidade, distancias );
            if ( sucessoAdicionarRota )
            {
                sentinelaRota++;                
            }
            else
            {
                s0.adicionaCaminhao(novoCaminhao);
                novoCaminhao = new Caminhao();
            }          
            
        }
        s0.adicionaCaminhao(novoCaminhao);
        
        s0.imprimeCaminhoes();
        System.out.println("Custo total da solução: " + s0.getCustoTotal() );   
        
        return s0;
    }
    
    
    private void calculaDistancias()
    { 
        distancias = new int[ dimensao ][ dimensao ];
        int N = dimensao;
        int xd;
        int yd;
        for ( int i = 0; i < N; i++ )
        {
            for ( int j = 0; j < N; j++ )
            {
                xd = verticesGrafo[ i ].getCordenadaX() - verticesGrafo[ j ].getCordenadaX();
                yd = verticesGrafo[ i ].getCordenadaY() - verticesGrafo[ j ].getCordenadaY();
                distancias[ i ][ j ] = (int) Math.sqrt(xd*xd + yd*yd );                
//                System.out.printf("%d ", getDistancias()[ i ][ j ] );
            }
//            System.out.printf("%n");
        }
        
        //for ( int i = 0; i < N; i++ )
            
    }
    
    private int processaEntrada(String palavraChave, String linha, int atribuicao )
    {
        String []tokens = linha.split("\\s+");
        
        for ( String token : tokens )
        {
            if ( !token.equals(palavraChave) && !token.equals(":") )
                atribuicao = Integer.parseInt(token);
        }
        return atribuicao;
    }

    
    public void abreArquivo( String nomeArquivo )
    {
        try
        {
            input = new Scanner(Paths.get(nomeArquivo));
        }
        catch ( IOException e )
        {
            System.err.println("Erro ao abrir o arquivo \"" + nomeArquivo + "\". Verifique se o mesmo existe ou está correto. Encerrando o programa...");
            System.exit( 1 );
        }
    }
    
    public void leDados()
    {
        String linha;
        //String []tokens;
        try
        {
            while ( input.hasNext() )
            {
                linha = input.nextLine();
                
                if ( linha.contains("NAME") )
                {
                     String []tokens = linha.split("\\s+");
        
                    for ( String token : tokens )
                    {
                        if ( !token.equals("NAME") && !token.equals(":") )
                            nomeInstancia = token;
                    }
                }
                else if ( linha.contains("DIMENSION") )
                    this.dimensao = processaEntrada("DIMENSION", linha, this.dimensao );
                else if ( linha.contains("CAPACITY") )
                    this.capacidade = processaEntrada("CAPACITY", linha, this.capacidade );
                else if ( linha.contains("NODE_COORD_SECTION") )
                {
                    verticesGrafo = new Vertice[dimensao];
                    
                    for ( int i = 0; i < dimensao; i++ )
                    {
                        Vertice novoVertice = new Vertice();
                        novoVertice.setId( input.nextInt() );
                        novoVertice.setCordenadaX( input.nextInt() );
                        novoVertice.setCordenadaY( input.nextInt() );
                        verticesGrafo[ i ] = novoVertice;
                    }
                }
                else if ( linha.contains("DEMAND_SECTION") )
                {
                    for ( int i = 0; i < dimensao; i++ )
                    {
                        getVerticesGrafo()[ input.nextInt() - 1 ].setDemanda( input.nextInt() );
                    }
                }
                else if ( linha.contains("DEPOT_SECTION") )
                {
                    int valor = input.nextInt();
                    while ( valor != -1 )
                    {
                        depositos.add(valor);
                        valor = input.nextInt();
                    }
                }               
            }
            
            calculaDistancias();
        }
        catch ( NoSuchElementException e )
        {
            System.err.println("O arquivo de entrada não possui o formato de entrada esperado.");
            System.exit( 1 );
        }
        catch ( IllegalStateException e )
        {
            System.err.println("O arquivo de entrada não pode ser lido");
            System.exit( 1 );
        }
    }
    
    
    /**
     * @return the nomeInstancia
     */
    public String getNomeInstancia() {
        return nomeInstancia;
    }

    /**
     * @param nomeInstancia the nomeInstancia to set
     */
    public void setNomeInstancia(String nomeInstancia) {
        this.nomeInstancia = nomeInstancia;
    }

    /**
     * @return the dimensao
     */
    public int getDimensao() {
        return dimensao;
    }

    /**
     * @param dimensao the dimensao to set
     */
    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    /**
     * @return the capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    } 

    /**
     * @return the verticesGrafo
     */
    public Vertice[] getVerticesGrafo() {
        return verticesGrafo;
    }

    /**
     * @return the distancias
     */
    public int[][] getDistancias() {
        return distancias;
    }
    
}
