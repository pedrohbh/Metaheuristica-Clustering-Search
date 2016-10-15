/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import grafo.Grafo;
import grafo.Vertice;

/**
 *
 * @author administrador
 */
public class Principal
{
    public static void main(String[] args) 
    {
        Grafo g = new Grafo();
        
        g.abreArquivo("Entrada/A-n33-k5.vrp");
        g.leDados();
        
        //System.out.println("DDDDD: " + g.getDistancias()[ 0 ][ 6 ] );
        /*System.out.printf("ID\tDemanda\tCordenada X\tCordenada Y%n");
        Vertice []v = g.getVerticesGrafo();
        for ( int i = 0; i < g.getDimensao(); i++ )
            v[ i ].imprimeDados();*/
        
    }
    
}
