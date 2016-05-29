/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;
import capaPersistencia.BD.CtrlBaseDades;
import java.util.ArrayList;

/**
 *
 * @author Toni
 */

public class CtrlGraf {
    
    CtrlBaseDades ctrl = new CtrlBaseDades();
    
    private Graf SG = new Graf(CtrlGraf.this);
    
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
    
    public int afegirNode(String nom,String tipus) {
        return SG.afegirNode(nom, tipus);
    }
    
    public int eliminarNode(String nomNode, String tipus) {
        return SG.eliminarNode(nomNode, tipus);
    }
    
    public int eliminarAresta(String nom1, String nom2, String tipus) {
        return SG.eliminarAresta(nom1, nom2, tipus);
    }
    
    public int afegirAresta(String nom1, String nom2, String tipus) {
        return SG.afegirAresta(nom1, nom2, tipus);
    }
    
    public Boolean getActualitzar() {
        return SG.getActualitzar();
    }
    
    public void actualitzar() {
        SG.actualitzar();
    }
    
    public void load_autor(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.load_autor(id,noms);
    }
    public void load_conf(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.load_conf(id,noms);
    }
    public void load_paper(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.load_paper(id,noms);
    }
    public void load_terme(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.load_terme(id,noms);
    }
    
    public void load_pa(ArrayList<Integer> id, ArrayList<Integer> id1) {
        ctrl.load_pa(id,id1);
    }
    
    public void load_pc(ArrayList<Integer> id, ArrayList<Integer> id1) {
        ctrl.load_pc(id,id1);
    }
    
    public void load_pt(ArrayList<Integer> id, ArrayList<Integer> id1) {
        ctrl.load_pt(id,id1);
    }
    
    public void saveAutor(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.saveAutor(id,noms);
    }
    
    public void saveConf(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.saveConf(id,noms);
    }
    
    public void saveTerme(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.saveTerme(id,noms);
    }
    
    public void saveArticle(ArrayList<Integer> id, ArrayList<String> noms) {
        ctrl.saveArticle(id,noms);
    }
    
    public void savepa(ArrayList<Integer> id, ArrayList<Integer> id1) {
        ctrl.savepa(id,id1);
    }
    
    public void savept(ArrayList<Integer> id, ArrayList<Integer> id1) {
        ctrl.savept(id,id1);
    }
    
    public void savepc(ArrayList<Integer> id, ArrayList<Integer> id1) {
        ctrl.savepc(id,id1);
    }
}
