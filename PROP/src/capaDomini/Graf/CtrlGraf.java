/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;

/**
 *
 * @author Toni
 */
public class CtrlGraf {
    private Graf SG = new Graf();
    
    public void afegirNode(String tipus,String nom) {
        SG.afegirNode(tipus, nom);
    }
    
    public void eliminarNode(String nomNode, String tipus) {
        SG.eliminarNode(nomNode, tipus);
    }
    
    public void eliminarAresta(String nom1, String nom2, String tipus) {
        SG.eliminarAresta(nom1, nom2, tipus);
    }
    
    public void afegirAresta(String nom1, String nom2, String tipus) {
        SG.afegirAresta(nom1, nom2, tipus);
    }
}
