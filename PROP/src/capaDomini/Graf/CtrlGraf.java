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
    private Graf SG = new Graf();
    
    CtrlBaseDades ctrl = new CtrlBaseDades();
    
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
    
    public int afegirNode(String tipus,String nom) {
        return SG.afegirNode(tipus, nom);
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
    
    public void load(ArrayList<Node> paper, ArrayList<Node> autor, ArrayList<Node> terme, ArrayList<Node> conf, ArrayList<Aresta> pc, ArrayList<Aresta> pa, ArrayList<Aresta> pt) {
        ctrl.load(paper, autor, terme, conf, pc, pa, pt);
    }
    
    public void saveAutor(ArrayList<Node> Autor) {
        ctrl.saveAutor(Autor);
    }
    
    public void saveConf(ArrayList<Node> conf) {
        ctrl.saveConf(conf);
    }
    
    public void saveTerme(ArrayList<Node> terme) {
        ctrl.saveTerme(terme);
    }
    
    public void saveArticle(ArrayList<Node> article) {
        ctrl.saveArticle(article);
    }
    
    public void savepa(ArrayList<Aresta> pa) {
        ctrl.savepa(pa);
    }
    
    public void savept(ArrayList<Aresta> pt) {
        ctrl.savept(pt);
    }
    
    public void savepc(ArrayList<Aresta> pc) {
        ctrl.savepc(pc);
    }
}
