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
public class Caminhao
{
    private final int idCaminhao;
    private int cargaTotal;
    private static int contadorIdCaminhao = 0;

    public Caminhao()
    {
        cargaTotal = 0;
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
    
    
}
