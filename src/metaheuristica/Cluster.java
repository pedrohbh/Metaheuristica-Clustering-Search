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
    private int beta; // Responsável por contabilizar os local Search
    
    public Cluster()
    {
        volume = 0;
        centro = null;
        beta = 0;
    }
    
    public void adicionaNovaSolucao( Solucao s0 )
    {
        if ( getCentro() == null )
        {
            setCentro(s0);
            volume += 1;
            getSolucoes().add(s0);
        }
        else
        {
            if ( s0.getCustoTotal() < getCentro().getCustoTotal() )
                setCentro(s0);
            getSolucoes().add(s0);
            volume += 1;
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

    /**
     * @return the centro
     */
    public Solucao getCentro() {
        return centro;
    }

    /**
     * @return the beta
     */
    public int getBeta() {
        return beta;
    }

    /**
     * @param beta the beta to set
     */
    public void setBeta(int beta) {
        this.beta = beta;
    }

    /**
     * @param centro the centro to set
     */
    public void setCentro(Solucao centro) {
        this.centro = centro;
    }
    
}
