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
    private StubGraf SG = new StubGraf();
    
    
    public int simula_id (String nom) {
        return SG.simula_id(nom);
    }
    
    public int getID(String nom) {
        return SG.getID(nom);
    }
    
    public String getNom(int id) {
        return SG.getNom(id);
    }
    
    public int[][] getMadj() {
        return SG.getMadj();
    }
    
    public int size() {
        return SG.size();
    }
    
    public String getTipusNode(int id) {
        return SG.getTipusNode(id);
    }
    
    public String simula_nom_entitat (int id) {
        return SG.simula_nom_entitat(id);
    }
    
    public void afegirNode(String tipus,String nom) {
        SG.afegirNode(tipus, nom);
    }
    
    
    public void eliminarNode(String nomNode) {
        SG.eliminarNode(nomNode);
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        SG.eliminarAresta(nom1, nom2);
    }
    
    public void afegirAresta(String nom1, String nom2) {
        SG.afegirAresta(nom1, nom2);
    }
}
