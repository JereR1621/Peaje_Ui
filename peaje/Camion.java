/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peaje;

/**
 *
 * @author diver
 */
public class Camion extends Vehiculo {
    
    private int n_Ejes;

    public Camion(int n_Ejes, String placa) {
        super(placa);
        this.n_Ejes = n_Ejes;
    }

    
    
    public int getN_Ejes() {
        return n_Ejes;
    }

    public void setN_Ejes(int n_Ejes) {
        this.n_Ejes = n_Ejes;
    }
    
    
    
    
    
    
}
