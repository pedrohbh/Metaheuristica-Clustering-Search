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
public class Vertice 
{
    private int id;
    private int demanda;
    private int cordenadaX;
    private int cordenadaY;

    /**
     * @return the demanda
     */
    public int getDemanda() {
        return demanda;
    }

    /**
     * @param demanda the demanda to set
     */
    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    /**
     * @return the cordenadaX
     */
    public int getCordenadaX() {
        return cordenadaX;
    }

    /**
     * @param cordenadaX the cordenadaX to set
     */
    public void setCordenadaX(int cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    /**
     * @return the cordenadaY
     */
    public int getCordenadaY() {
        return cordenadaY;
    }

    /**
     * @param cordenadaY the cordenadaY to set
     */
    public void setCordenadaY(int cordenadaY) {
        this.cordenadaY = cordenadaY;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
