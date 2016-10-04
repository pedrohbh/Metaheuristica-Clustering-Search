/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author administrador
 */
public class Aresta 
{
    private int vertice1;
    private int vertice2;
    private double peso;

    /**
     * @return the vertice1
     */
    public int getVertice1() {
        return vertice1;
    }

    /**
     * @param vertice1 the vertice1 to set
     */
    public void setVertice1(int vertice1) {
        this.vertice1 = vertice1;
    }

    /**
     * @return the vertice2
     */
    public int getVertice2() {
        return vertice2;
    }

    /**
     * @param vertice2 the vertice2 to set
     */
    public void setVertice2(int vertice2) {
        this.vertice2 = vertice2;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
}
