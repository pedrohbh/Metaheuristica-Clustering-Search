/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metaheuristica;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author administrador
 */
public class ClusteringSearch 
{
    private List<Cluster> clusters = new LinkedList<>();
    
    
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
