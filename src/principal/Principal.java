/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import grafo.Grafo;

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
        
    }
    
}
