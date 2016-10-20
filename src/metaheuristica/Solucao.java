/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metaheuristica;

import grafo.Caminhao;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author administrador
 */
public class Solucao 
{
    private int custoTotal;
    private List<Caminhao> caminhoes = new LinkedList<>();
    
    public Solucao()
    {
        custoTotal = 0;
    }
    
    /*public Solucao pertubaSolucao()
    {
        
    }*/
    
    public void adicionaCaminhao( Caminhao novoCaminhao )
    {
        custoTotal += novoCaminhao.getCustoRota();
        getCaminhoes().add(novoCaminhao);
    }
    
    public int getNumeroCaminhoes()
    {
        return getCaminhoes().size();
    }
    
    public void imprimeCaminhoes()
    {
        for ( Caminhao c: getCaminhoes())
        {
            c.imprimeRota();
        }
    }

    /**
     * @return the custoTotal
     */
    public int getCustoTotal() {
        return custoTotal;
    }

    /**
     * @return the caminhoes
     */
    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }
    
}
