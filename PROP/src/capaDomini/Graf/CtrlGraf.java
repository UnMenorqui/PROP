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
    private Graf_PageRank SG = new Graf_PageRank();
    
    public int getID(String nom) {
        return SG.GetID(nom);
    }
    
    public String getNom(int id) {
        return SG.getNomNode(id);
    }
    
    public int[][] getMadj() {
        return SG.GetMadj();
    }
    
    public int size() {
        return SG.size();
    }
    
    public String getTipusNode(int id) {
        return SG.getTipusNode(id);
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
