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
       numarticles = (short) paper.size();
       numautors = (short) autor.size();
       numconf = (short) conf.size();
       short i = 0;
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
       numTotalNode = (short) nodes.size();
       numTotalAresta = (short) arestes.size()-1;
       adj = new short[numTotalNode][numTotalNode]; 
       initMadj();
       iniAdj();
    }
    
    public short getnumAutors() {
        return (short) (numautors-1);
    }
    
    public short getnumArticles() {
        return (short) (numarticles-1);
    }
    
    public short getnumConf() {
        return (short) (numconf-1);
    }
    
}
