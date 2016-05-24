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
    
    public void load(ArrayList<Node> paper, ArrayList<Node> autor, ArrayList<Node> terme, ArrayList<Node> conf, ArrayList<Aresta> pc, ArrayList<Aresta> pa, ArrayList<Aresta> pt) {
        BaseDades.load(paper, autor, terme, conf, pc, pa, pt);
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
