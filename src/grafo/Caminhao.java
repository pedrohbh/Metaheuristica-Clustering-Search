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
        for ( Integer r: getRota() )
        {
            System.out.print(r + " - " );
        }
        System.out.printf("Carga: %d - custoRota: %d%n", cargaTotal, custoRota );
    }
    
    public void adicionaRetornoARota( int [][]tabelaDeCustos )
    {
        //System.out.println("Custo atual: " + custoRota + " tabela: " + tabelaDeCustos[ rota.get(rota.size() -1) -1 ][ rota.get( 0 ) - 1 ] + " x: " + (rota.get(rota.size() -1) -1) + " y: " + (rota.get( 0 ) - 1));
        custoRota += tabelaDeCustos[ getRota().get(getRota().size() -1) -1 ][ getRota().get( 0 ) - 1 ];
        getRota().add(getRota().get( 0 ) );
    }

    public boolean adicionaRota( Vertice v, int capacidade, int [][]tabelaCustos, List<Integer> depositos )
    {
        if ( cargaTotal + v.getDemanda() <= capacidade )
        {
            cargaTotal += v.getDemanda();
            if ( getRota().isEmpty() )
            {
                int max = tabelaCustos[ 0 ][ v.getId() - 1 ];
                int maxId = 1;
                for ( Integer d : depositos )
                {
                    if ( max < tabelaCustos[ d - 1 ][ v.getId() - 1 ] )
                    {
                        max = tabelaCustos[ d - 1 ][ v.getId() - 1 ];
                        maxId = d;
                    }
                }
                
                getRota().add( maxId );
                getRota().add(v.getId());
                custoRota += tabelaCustos[ maxId - 1 ][ v.getId() - 1 ];
            }
            else
            {
                custoRota += tabelaCustos[ getRota().get(getRota().size() -1) -1 ][ v.getId() - 1 ];
                getRota().add(v.getId());
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

    /**
     * @return the rota
     */
    public List<Integer> getRota() {
        return rota;
    }
    
    
}
