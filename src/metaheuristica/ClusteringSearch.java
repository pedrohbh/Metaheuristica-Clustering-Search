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
        clusters.add(novoCluster);
    }
}
