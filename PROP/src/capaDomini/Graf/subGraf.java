/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;
import capaPersistencia.BD.BaseDades;
import java.util.*;

/**
 *
 * @author aleixabrieprat
 */
public class subGraf extends Graf 
{
    //ultim article de la matriu d'adjacencies.
    
    
    
    
    
    /*
    public void load() {
        
    }
    */
    
    public subGraf() {
       ArrayList<Node> paper = new ArrayList<>();
       ArrayList<Node> autor = new ArrayList<>();
       ArrayList<Node> terme = new ArrayList<>();
       ArrayList<Node> conf = new ArrayList<>();
       ArrayList<Aresta> pc = new ArrayList<>();
       ArrayList<Aresta> pa = new ArrayList<>();
       ArrayList<Aresta> pt = new ArrayList<>();
       BaseDades bd = new BaseDades();
       bd.load(paper,autor,terme,conf,pc,pa,pt);
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
       numTotalNode = nodes.size()-1;
       numTotalAresta = arestes.size()-1;
       adj = new int[numarticles][numTotalNode-numarticles]; 
       initMadj();
       iniAdj();
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
