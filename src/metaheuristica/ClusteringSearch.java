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
    
    public int alocaSolucaoACluster( Solucao solAtual )
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
        return indiceMax;
        //clusters.get(indiceMax)
    }
    
    public Solucao executarSimulatedAnneling( Grafo grafo, Solucao solucaoInicial )
    {
        double temperatura = Constantes.T0;
        int iteracoes;
        int indiceClusterAtual;
        Solucao solucaoVinzinha = null;
        Solucao solucaoFinal = null;
        
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
            indiceClusterAtual = alocaSolucaoACluster(solucaoVinzinha);
            if ( clusters.get(indiceClusterAtual).getVolume() == Constantes.VOLUME_MAX )
            {
                clusters.get(indiceClusterAtual).setVolume( 0 );
                solucaoInicial = grafo.embaralhaSolucao(clusters.get(indiceClusterAtual).getCentro());
                if ( solucaoInicial.getCustoTotal() == clusters.get(indiceClusterAtual).getCentro().getCustoTotal() )
                {
                    clusters.get(indiceClusterAtual).setBeta(clusters.get(indiceClusterAtual).getBeta() + 1);
                    if ( clusters.get(indiceClusterAtual).getBeta() == Constantes.BETA_MAX)
                    {
                        clusters.get(indiceClusterAtual).setBeta(0);
                        clusters.get(indiceClusterAtual).setCentro(grafo.embaralhaSolucao(clusters.get(indiceClusterAtual).getCentro()));
                    }
                }
                else
                    clusters.get(indiceClusterAtual).setVolume(0);
            }
            solucaoFinal = achaMaximaSolucao();
            
        }
        return solucaoFinal;
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

    private Solucao achaMaximaSolucao() 
    {
        int i = 0;
        int indiceMenor = 0;
        int menorCusto = clusters.get( 0 ).getCentro().getCustoTotal();
        for ( Cluster c: clusters )
        {
            if ( c.getCentro().getCustoTotal() < menorCusto )
                indiceMenor = i;
            i++;
        }
        
        return clusters.get(indiceMenor).getCentro();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
