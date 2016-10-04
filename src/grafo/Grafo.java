package grafo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

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
    private Aresta []arestas;
    
    

    
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
      /*  try
        {
            while ( input.hasNext() )
            {
                nomeInstancia = input.nextLine();
                //nomeInstancia = nomeInstancia.
                //nomeInstancia = nomeInstancia.substring(7);
                //System.out.println("Nome: " + nomeInstancia);
            }
        }
        catch*/
                
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
     * @return the arestas
     */
    public Aresta[] getArestas() {
        return arestas;
    }

    /**
     * @param arestas the arestas to set
     */
    public void setArestas(Aresta[] arestas) {
        this.arestas = arestas;
    }
    
    
    
}
