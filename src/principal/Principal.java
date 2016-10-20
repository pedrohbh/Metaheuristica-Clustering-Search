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
        g.abreArquivo("Entrada/A-n33-k5.vrp");
        g.leDados();
        //g.imprimeTabelaDistancias();
        solucaoInicial = g.geraSolucaoInicial();
        novoCluster.adicionaNovaSolucao(solucaoInicial);
        cs.adicionaCluster(novoCluster);        
        //solucaoInicial.imprimeCaminhoes();
        //System.out.println("Custo toal: " + solucaoInicial.getCustoTotal() );
        // Criação dos Clusters inciais
        for ( int i = 0; i < Constantes.MAX_NUM_CLUSTERS - 1; i++ )
        {
            novoCluster = new Cluster();
            solucaoInicial = g.embaralhaSolucao(solucaoInicial);
            novoCluster.adicionaNovaSolucao(solucaoInicial);
            cs.adicionaCluster(novoCluster);            
        }
        for ( Cluster c: cs.getClusters() )
        {
            c.getSolucoes().get(0).imprimeCaminhoes();
            System.out.println("Custo toal: " + c.getSolucoes().get(0).getCustoTotal() );
        }
        //System.out.println("CS: " + cs.getClusters().size() );
    }
    
}
