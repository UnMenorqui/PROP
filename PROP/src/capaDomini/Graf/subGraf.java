/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;
import java.util.*;

/**
 *
 * @author aleixabrieprat
 */
public class subGraf extends Graf 
{
    //ultim article de la matriu d'adjacencies.
    private int numarticles = 0;
    private int numautors = 0;
    private int numconf = 0;
    
    
    
    public subGraf() {
        
    }
    
    /*
    public void load() {
        
    }
    */
    
    public subGraf(ArrayList<Node> paper, ArrayList<Node> autor, ArrayList<Node> terme, ArrayList<Node> conf, ArrayList<Aresta> pc, ArrayList<Aresta> pa, ArrayList<Aresta> pt) 
    {
       numTotalNode = paper.size() + autor.size() + terme.size() + conf.size();
       numTotalAresta = pc.size() + pt.size() + pa.size();
       arestes = new ArrayList<>();
       nodes = new ArrayList<>();
       numarticles = paper.size();
       numautors = autor.size();
       numconf = conf.size();
       int i = 0;
       while (i < paper.size()) nodes.add(paper.get(i++));
       i = 0;
       while (i < autor.size()) nodes.add(autor.get(i++));
       i = 0;
       while (i < terme.size()) nodes.add(terme.get(i++));
       i = 0;
       while (i < conf.size()) nodes.add(conf.get(i++));
       i = 0;
       while (i < pc.size()) arestes.add(pc.get(i++));
       i = 0;
       while (i < pa.size()) arestes.add(pa.get(i++));
       i = 0;
       while (i < pt.size()) arestes.add(pt.get(i++));
       adj = new int[numTotalNode][numTotalNode]; 
       initMadj();
       iniAdj();
       iniAdjAC();
       iniAdjAT();
       iniAdjCT();
    }
    
    public int getnumAutors() {
        return numautors-1;
    }
    
    public int getnumArticles() {
        return numarticles-1;
    }
    
    public int getnumConf() {
        return numconf-1;
    }
    
}
