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
    
    public int getidArrayString(String nom,String tipus) {
        return SG.getidArrayString(nom, tipus);
    }
    
    public Node getNodeIessim(int id, String tipus) {
        return SG.getNodeIessim(id, tipus);
    }
    
    public int getidArrayint(int id, String tipus) {
        return SG.getidArrayint(id, tipus);
    }
    
    public String getNomNode(int id, String tipus) {
        return SG.getNomNode(id, tipus);
    }
    
    public double getValorNode(int id, String tipus) {
        return SG.getValorNode(id, tipus);
    }
    
    public int GetIDnode(int id, String tipus) {
        return SG.GetIDnode(id, tipus);
    }
    
    public boolean existeixnode(String nom, String tipus) {
        return SG.existeixnode(nom, tipus);
    }
    
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
