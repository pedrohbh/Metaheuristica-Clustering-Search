/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metaheuristica;

import grafo.Grafo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author administrador
 */
public class ClusteringSearch 
{
    private List<Cluster> clusters = new LinkedList<>();
    
    public void alocaSolucaoACluster( Solucao solAtual )
    {
        Solucao novaSolucao = new Solucao(solAtual.getCaminhoes(), solAtual.getCustoTotal() );
        int i = 0;
        int indiceMax = 0;
        int custoProximo = Math.abs(novaSolucao.getCustoTotal() - clusters.get(indiceMax).getCentro().getCustoTotal() );
        for ( Cluster c: clusters )
        {
            
            if ( custoProximo < Math.abs(novaSolucao.getCustoTotal() - c.getCentro().getCustoTotal() ) )
            {
                indiceMax = i;
                custoProximo = Math.abs(novaSolucao.getCustoTotal() - c.getCentro().getCustoTotal() );
            }
            i++;
                
        }
        
        clusters.get(indiceMax).adicionaNovaSolucao(novaSolucao);
        //clusters.get(indiceMax)
    }
    
    public void executarSimulatedAnneling( Grafo grafo, Solucao solucaoInicial )
    {
        double temperatura = Constantes.T0;
        int iteracoes;
        Solucao solucaoVinzinha = null;
        
        while ( temperatura > Constantes.Tc )
        {
            iteracoes = 0;
            while ( iteracoes < Constantes.NUM_MAX_ITER )
            {
                iteracoes++;
                solucaoVinzinha = grafo.embaralhaSolucao(solucaoInicial);
                if ( solucaoVinzinha.getCustoTotal() < solucaoInicial.getCustoTotal() )
                {
                    solucaoInicial = solucaoVinzinha;
                }
                else
                {
                    if ( Math.exp(-(solucaoInicial.getCustoTotal()-(solucaoVinzinha.getCustoTotal())) / temperatura ) > 0.5 )
                        solucaoInicial = solucaoVinzinha;
                }
            }
            temperatura = temperatura * Constantes.ALFA;
            alocaSolucaoACluster(solucaoVinzinha);
        }
    }
    
    
    public void adicionaCluster( Cluster novoCluster )
    {
        getClusters().add(novoCluster);
    }

    /**
     * @return the clusters
     */
    public List<Cluster> getClusters() {
        return clusters;
    }

    /**
     * @param clusters the clusters to set
     */
    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }
}
