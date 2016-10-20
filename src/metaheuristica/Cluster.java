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
public class Cluster 
{
    private List<Solucao> solucoes = new LinkedList<>();
    private Solucao centro; // Corresponde a solução que representa o cluster
    private int volume; // Corresponde ao número de soluções presentes naquele cluster
    
    public Cluster()
    {
        volume = 0;
        centro = null;
    }
    
    public void adicionaNovaSolucao( Solucao s0 )
    {
        if ( centro == null )
        {
            centro = s0;
            volume += 1;
            getSolucoes().add(s0);
        }
        else
        {
            if ( s0.getCustoTotal() < centro.getCustoTotal() )
                centro = s0;
            getSolucoes().add(s0);
        }       
        
    }
    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the solucoes
     */
    public List<Solucao> getSolucoes() {
        return solucoes;
    }
    
}
