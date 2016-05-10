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
 * @author marc
 */

public class Graf {
    
    //arraylist amb totes les arestes del graf
    protected ArrayList<Aresta> arestes;
    
    //arraylist amb tots els nodes del graf
    protected ArrayList<Node> nodes;
    
    //arraylist amb els nodes autor del graf
    protected ArrayList<Node> autor;
    
    //arraylist amb els nodes conferencia del graf
    protected ArrayList<Node> conf;
    
    //arraylist amb els nodes articles del graf
    protected ArrayList<Node> paper;
    
    //arraylist amb els nodes terme del graf
    protected ArrayList<Node> terme;
    
    //arraylist amb les arestes article-conferencia del graf
    protected ArrayList<Aresta> pc;
    
    //arraylist amb les arestes article-autor del graf
    protected ArrayList<Aresta> pa;
    
    //arraylist amb les arestes article-terme del graf
    protected ArrayList<Aresta> pt;
    
    
    public Graf() {
       BaseDades bd = new BaseDades();
       paper = new ArrayList<>();
       autor = new ArrayList<>();
       conf = new ArrayList<>();
       terme = new ArrayList<>();
       pc = new ArrayList<>();
       pa = new ArrayList<>();
       pt = new ArrayList<>();
       bd.load(paper,autor,terme,conf,pc,pa,pt);
       arestes = new ArrayList<>();
       nodes = new ArrayList<>();
       int i = 0;
       while (i<paper.size()) nodes.add(paper.get(i++));
       i = 0;
       while (i<autor.size()) nodes.add(autor.get(i++));
       i = 0;
       while (i<conf.size()) nodes.add(conf.get(i++));
       i = 0;
       while (i<terme.size()) nodes.add(terme.get(i++));
       i = 0;
       while (i<pc.size()) arestes.add(pc.get(i++));
       i = 0;
       while (i<pc.size()) arestes.add(pa.get(i++));
       i = 0;
       while (i<pc.size()) arestes.add(pt.get(i++));
       pagerank();
    };
    
    public void afegirAresta(String nom1, String nom2) {
        int a = GetIDnode(nom1);
        int b = GetIDnode(nom2);
        aAresta(a,b);
    }
    
    private void aAresta(int idNode1, int idNode2) {
        Aresta a = new Aresta(arestes.size(),idNode1,idNode2);
        arestes.add(a);
        String tipus = getTipusNode(idNode2);
        if (tipus.equals("Autor")) pa.add(a);
        else if (tipus.equals("Conferencia")) pc.add(a);
        else pt.add(a);
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        int node1, node2;
        node1 = GetIDnode(nom1);
        node2 = GetIDnode(nom2);
        if(node1 == -1) System.out.println("El primer node no existeix");
        else if (node2 == -1) System.out.println("El segon node no existeix");
        else {
            String tipus = getTipusNode(node1);
            for (int i=0; i<arestes.size(); ++i) {
                if (arestes.get(i).getNode1() == node1) {
                    if (arestes.get(i).getNode2() == node2) {
                        arestes.remove(i);
                    }
                }
            }
            switch (tipus) {
                case "Autor":
                    for (int i=0; i<pa.size(); ++i) {
                        if (pa.get(i).getNode1() == node1) {
                            if (pa.get(i).getNode2() == node2) {
                                pa.remove(i);
                            }
                        }
                    }
                    break;
                
                case "Conferencia":
                    for (int i=0; i<pc.size(); ++i) {
                        if (pc.get(i).getNode1() == node1) {
                            if (pc.get(i).getNode2() == node2) {
                                pc.remove(i);
                            }
                        }
                    }
                    break;
                
                case "Terme":
                    for (int i=0; i<pt.size(); ++i) {
                        if (pt.get(i).getNode1() == node1) {
                            if (pt.get(i).getNode2() == node2) {
                                pt.remove(i);
                            }
                        }
                    }
                    break;
            }
        }
    }
    
    public int GetArestesSize() {
        return arestes.size();
    }
    
    public ArrayList<Aresta> GetVA() {
        return arestes;
    }
    
    public void afegirNode(String tipus,String nom) {
        Node n = new Node(nodes.size(),nom,tipus);
        nodes.add(n);
        if (tipus.equals("Autor")) autor.add(n);
        else if (tipus.equals("Conferencia")) conf.add(n);
        else if (tipus.equals("Article")) paper.add(n);
        else terme.add(n);
    }
    
    public void eliminarNode(String nomNode) {
        int id = GetIDnode(nomNode);
        if(id == -1) System.out.println("Aquest node no existeix");
        else { 
            String tipus = getTipusNode(id);
            for (int i=0; i<nodes.size(); ++i) {
                if (nodes.get(i).getId() == id) nodes.remove(i);
            }
            switch (tipus) {
                case "Autor":
                    for (int i=0; i<autor.size(); ++i) {
                        if (autor.get(i).getId() == id) autor.remove(i);
                    }
                    for (int i = 0; i<arestes.size(); ++i) {
                        if (arestes.get(i).getNode2() == id) arestes.remove(i);
                    }   
                    for (int i = 0; i<pa.size(); ++i) {
                        if (pa.get(i).getNode2() == id) pa.remove(i);
                    }  
                    break;
                case "Conferencia":
                    for (int i=0; i<conf.size(); ++i) {
                        if (conf.get(i).getId() == id) conf.remove(i);
                    }
                    for (int i = 0; i<arestes.size(); ++i) {
                        if (arestes.get(i).getNode2() == id) arestes.remove(i);
                    }   
                    for (int i = 0; i<pc.size(); ++i) {
                        if (pc.get(i).getNode2() == id) pc.remove(i);
                    }   
                    break;
                case "Article":
                    for (int i=0; i<paper.size(); ++i) {
                        if (paper.get(i).getId() == id) paper.remove(i);
                    }
                    for (int i = 0; i<arestes.size(); ++i) {
                        if (arestes.get(i).getNode2() == id) arestes.remove(i);
                    }   
                    for (int i = 0; i<pa.size(); ++i) {
                        if (pa.get(i).getNode1() == id) pa.remove(i);
                    }  
                    for (int i = 0; i<pt.size(); ++i) {
                        if (pt.get(i).getNode1() == id) pt.remove(i);
                    }
                    for (int i = 0; i<pc.size(); ++i) {
                        if (pc.get(i).getNode1() == id) pc.remove(i);
                    }
                    break;
                default:
                    for (int i=0; i<terme.size(); ++i) {
                        if (terme.get(i).getId() == id) terme.remove(i);
                    }
                    for (int i = 0; i<arestes.size(); ++i) {
                        if (arestes.get(i).getNode2() == id) arestes.remove(i);
                    }   
                    for (int i = 0; i<pt.size(); ++i) {
                        if (pt.get(i).getNode2() == id) pt.remove(i);
                    }   
                    break;
            }
        }
    }
    
    public int GetVNsize() {
        return nodes.size();
    }
    
    public ArrayList<Node> GetVN() {
        return nodes;
    }
    
    public double getValorNode(int id) {
        for (int i=0; i<nodes.size(); ++i) {
            if (nodes.get(i).getId() == id) {
                return nodes.get(i).getValor();
            }
        }
        return 0;
    }
    
    public String getTipusNode(int id) {
        for (int i=0; i<nodes.size(); ++i) {
            if (nodes.get(i).getId() == id) {
                return nodes.get(i).getTipus();
            }
        }
        return "";
    }
    
    public String getNomNode(int id) {
        for (int i=0; i<nodes.size(); ++i) {
            if (nodes.get(i).getId() == id) {
                return nodes.get(i).getNom();
            }
        }
        return "";
    }
    
    public int GetIDnode(String nom) {
        for (int i = 0; i < nodes.size(); ++i) {
            if (nodes.get(i).getNom().equals(nom)) return nodes.get(i).getId();
        }
        return -1;
    }
    
    public void setValorNode(int id, double valor) {
        for (int i=0; i<nodes.size(); ++i) {
            if (nodes.get(i).getId() == id) {
                nodes.get(i).setValor(valor);
            }
        }
    }
    
    private void pagerank() {
        double prob_Autor = 100/autor.size();
        double prob_Conf = 100/conf.size();
        double prob_Article = 100/paper.size();
        double d = 0.5;
        int id;
        double prob;
        for (int i=0; i<paper.size(); ++i) {
            id = paper.get(i).getId();
            prob = 0;
            for (int j=0; j<pc.size(); ++j) {
                if (pc.get(j).getNode1() == id) {
                    prob += prob_Conf/getNumAdj(pc.get(j).getNode2());
                }
            }
            for (int j=0; j<pa.size(); ++j) {
                if (pa.get(j).getNode1() == id) {
                    prob += prob_Autor/getNumAdj(pa.get(j).getNode2());
                }
            }
            setValorNode(id,(1-d)+(d*prob));
        }
        for (int i=0; i<conf.size(); ++i) {
            id = conf.get(i).getId();
            prob = 0;
            for (int j=0; j<pc.size(); ++j) {
                if (pc.get(j).getNode2() == id) {
                    prob += prob_Article/getNumAdj(pc.get(j).getNode1());
                }
            }
            setValorNode(id,(1-d)+(d*prob));
        }
        for (int i=0; i<autor.size(); ++i) {
            id = autor.get(i).getId();
            prob = 0;
            for (int j=0; j<pa.size(); ++j) {
                if (pa.get(j).getNode2() == id) {
                    prob += prob_Article/getNumAdj(pa.get(j).getNode1());
                }
            }
            setValorNode(id,(1-d)+(d*prob));
        }
        for (int i=0; i<terme.size(); ++i) {
            id = terme.get(i).getId();
            setValorNode(id,getNumAdj(id));
        }
    }
    
    private double getNumAdj(int id) {
        double numAdj = 0;
        String tipus = getTipusNode(id);
        switch (tipus) {
            case "Autor":
                for (int i=0; i<pa.size(); ++i) {
                    if (pa.get(i).getNode2() == id) ++numAdj;
                }
                break;
                
            case "Conferencia":
                for (int i=0; i<pc.size(); ++i) {
                    if (pc.get(i).getNode2() == id) ++numAdj;
                }
                break;
                
            case "Terme":
                for (int i=0; i<pt.size(); ++i) {
                    if (pt.get(i).getNode2() == id) ++numAdj;
                }
                break;
            
            case "Article":
                for (int i=0; i<pt.size(); ++i) {
                    if (pt.get(i).getNode1() == id) ++numAdj;
                }
                
                for (int i=0; i<pc.size(); ++i) {
                    if (pc.get(i).getNode1() == id) ++numAdj;
                }
                
                for (int i=0; i<pa.size(); ++i) {
                    if (pa.get(i).getNode1() == id) ++numAdj;
                }
                break;
        }
        return numAdj;
    }
}
