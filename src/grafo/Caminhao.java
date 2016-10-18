/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author administrador
 */
public class Caminhao
{
    private final int idCaminhao;
    private int cargaTotal;
    private int custoRota;
    private List<Integer> rota = new LinkedList<>();
    private static int contadorIdCaminhao = 0;
    
    public void imprimeRota()
    {
        System.out.print("Caminhão " + idCaminhao + ": ");
        for ( Integer r: rota )
        {
            System.out.print(r + " - " );
        }
        System.out.printf("Carga: %d - custoRota: %d%n", cargaTotal, custoRota );
    }

    public boolean adicionaRota( Vertice v, int capacidade, int [][]tabelaCustos )
    {
        if ( cargaTotal + v.getDemanda() <= capacidade )
        {
            cargaTotal += v.getDemanda();
            if ( rota.isEmpty() )
            {
                rota.add( 1 );
                rota.add(v.getId());
                custoRota += tabelaCustos[ 0 ][ v.getId() - 1 ];
            }
            else
            {
                custoRota += tabelaCustos[ rota.get(rota.size() -1) -1 ][ v.getId() - 1 ];
                rota.add(v.getId());
            }
            
            
            return true;
        }
        else
            return false;
    }
    
    public Caminhao()
    {
        cargaTotal = 0;
        custoRota = 0;
        idCaminhao = contadorIdCaminhao++;
    }
    /**
     * @return the cargaTotal
     */
    public int getCargaTotal() {
        return cargaTotal;
    }

    /**
     * @param cargaTotal the cargaTotal to set
     */
    public void setCargaTotal(int cargaTotal) {
        this.cargaTotal = cargaTotal;
    }

    /**
     * @return the idCaminhao
     */
    public int getIdCaminhao() {
        return idCaminhao;
    }

    /**
     * @return the custoRota
     */
    public int getCustoRota() {
        return custoRota;
    }
    
    
}
