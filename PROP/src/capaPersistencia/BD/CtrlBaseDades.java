/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia.BD;

import capaDomini.Graf.Aresta;
import capaDomini.Graf.Node;
import java.util.ArrayList;


public class CtrlBaseDades {
    
    public void load_autor(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_autor(id,noms);
    }
    public void load_conf(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_conf(id,noms);
    }
    public void load_paper(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_paper(id,noms);
    }
    public void load_terme(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_terme(id,noms);
    }
    
    public void load_pa(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.load_pa(id,id1);
    }
    
    public void load_pc(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.load_pc(id,id1);
    }
    
    public void load_pt(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.load_pt(id,id1);
    }
    
    public void saveAutor(ArrayList<Node> autor) {
        BaseDades.saveAutor(autor);
    }
    
    public void saveConf(ArrayList<Node> conf) {
        BaseDades.saveConf(conf);
    }
    
    public void saveArticle(ArrayList<Node> article) {
        BaseDades.saveArticle(article);
    }
    
    public void saveTerme(ArrayList<Node> terme) {
        BaseDades.saveTerme(terme);
    }
    
    public void savepa(ArrayList<Aresta> pa) {
        BaseDades.savepa(pa);
    }
    
    public void savept(ArrayList<Aresta> pt) {
        BaseDades.savept(pt);
    }
    
    public void savepc(ArrayList<Aresta> pc) {
        BaseDades.savepc(pc);
    }
    
}
