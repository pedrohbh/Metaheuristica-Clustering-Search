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
    
    public void adicionaCaminhao( Caminhao novoCaminhao )
    {
        custoTotal += novoCaminhao.getCustoRota();
        caminhoes.add(novoCaminhao);
    }
    
    public void imprimeCaminhoes()
    {
        for ( Caminhao c: caminhoes)
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
    
}
