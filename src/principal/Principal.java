/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import grafo.Grafo;
import metaheuristica.Cluster;
import metaheuristica.ClusteringSearch;
import metaheuristica.Constantes;
import metaheuristica.Solucao;

/**
 *
 * @author administrador
 */
public class Principal
{
    public static void main(String[] args) 
    {
        Grafo g = new Grafo();
        ClusteringSearch cs = new ClusteringSearch();
        Cluster novoCluster = new Cluster();
        Solucao solucaoInicial;
        Solucao solucaoVizinha;
        Solucao solucaoFinal = new Solucao();
        g.abreArquivo("Entrada/A-n33-k5.vrp");
        g.leDados();
        solucaoInicial = g.geraSolucaoInicial();
        novoCluster.adicionaNovaSolucao(solucaoInicial);
        cs.adicionaCluster(novoCluster);        
        
        // Criação dos Clusters inciais
        for ( int i = 0; i < Constantes.MAX_NUM_CLUSTERS - 1; i++ )
        {
            novoCluster = new Cluster();
            solucaoVizinha = g.embaralhaSolucao(solucaoInicial);
            novoCluster.adicionaNovaSolucao(solucaoInicial);
            cs.adicionaCluster(novoCluster);            
        }
        
        solucaoFinal = cs.executarSimulatedAnneling(g, solucaoInicial);
        System.out.println("Custo solução final: " + solucaoFinal.getCustoTotal() );
        
        /*for ( Cluster c: cs.getClusters() )
        {
            c.getSolucoes().get(0).imprimeCaminhoes();
            System.out.println("Custo toal: " + c.getSolucoes().get(0).getCustoTotal() );
        }*/
        //System.out.println("CS: " + cs.getClusters().size() );
    }
    
    
    public void replicaTestadora( String arquivoEntrada )
    {
        Grafo g = new Grafo();
        ClusteringSearch cs = new ClusteringSearch();
        Cluster novoCluster = new Cluster();
        Solucao solucaoInicial;
        Solucao solucaoVizinha;
        Solucao solucaoFinal = new Solucao();
        g.abreArquivo(arquivoEntrada);
        g.leDados();
        solucaoInicial = g.geraSolucaoInicial();
        novoCluster.adicionaNovaSolucao(solucaoInicial);
        cs.adicionaCluster(novoCluster);        
        
        // Criação dos Clusters inciais
        for ( int i = 0; i < Constantes.MAX_NUM_CLUSTERS - 1; i++ )
        {
            novoCluster = new Cluster();
            solucaoVizinha = g.embaralhaSolucao(solucaoInicial);
            novoCluster.adicionaNovaSolucao(solucaoInicial);
            cs.adicionaCluster(novoCluster);            
        }
        
        solucaoFinal = cs.executarSimulatedAnneling(g, solucaoInicial);
        System.out.println("Custo solução final: " + solucaoFinal.getCustoTotal() );
    }
    
}
