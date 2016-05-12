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
    
    private Boolean actualitzar = false;    //en cas de canvi posar a true;
    
    int idnou = 500000;
    
    
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
       for (int i=0; i<pc.size(); ++i) {
           int node1 = pc.get(i).getNode1();
           int node2 = pc.get(i).getNode2();
           String nomnode1 = getNomNode(node1,"Conferencia");
           String nomnode2 = getNomNode(node2,"Conferencia");
           for (int j=0; j<paper.size(); ++j) {
               if (paper.get(j).getId() == node1) {
                   paper.get(j).afegirnodeadjacent(nomnode2);
               }
           }
           for (int j=0; j<conf.size(); ++j) {
               if (conf.get(j).getId() == node2) {
                   conf.get(j).afegirnodeadjacent(nomnode1);
               }
           }
           
       }
       for (int i=0; i<pa.size(); ++i) {
           int node1 = pa.get(i).getNode1();
           int node2 = pa.get(i).getNode2();
           String nomnode1 = getNomNode(node1,"Autor");
           String nomnode2 = getNomNode(node2,"Autor");
           for (int j=0; j<paper.size(); ++j) {
               if (paper.get(j).getId() == node1) {
                   paper.get(j).afegirnodeadjacent(nomnode2);
               }
           }
           for (int j=0; j<autor.size(); ++j) {
               if (autor.get(j).getId() == node2) {
                   autor.get(j).afegirnodeadjacent(nomnode1);
               }
           }
       }
       for (int i=0; i<pt.size(); ++i) {
           int node1 = pt.get(i).getNode1();
           int node2 = pt.get(i).getNode2();
           String nomnode1 = getNomNode(node1,"Terme");
           String nomnode2 = getNomNode(node2,"Terme");
           for (int j=0; j<paper.size(); ++j) {
               if (paper.get(j).getId() == node1) {
                   paper.get(j).afegirnodeadjacent(nomnode2);
               }
           }
           for (int j=0; j<terme.size(); ++j) {
               if (terme.get(j).getId() == node2) {
                   terme.get(j).afegirnodeadjacent(nomnode1);
               }
           }
       }
       System.out.println("Estamos vivos. Espera un poco porfavor");
       pagerank();
    };

    public void afegirAresta(String nom1, String nom2) {
        int idNode1 = GetIDnode(nom1);
        int idNode2 = GetIDnode(nom2);
        Aresta a = new Aresta(idNode1,idNode2);
        String tipus = getTipusNode(idNode2,nom2);
        if (tipus.equals("Autor")) pa.add(a);
        else if (tipus.equals("Conferencia")) pc.add(a);
        else pt.add(a);
        actualitzar = true;
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        int node1, node2;
        node1 = GetIDnode(nom1);
        node2 = GetIDnode(nom2);
        if(node1 == -1) System.out.println("El primer node no existeix");
        else if (node2 == -1) System.out.println("El segon node no existeix");
        else {
            String tipus = getTipusNode(node2,nom2);
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
        actualitzar = true;
    }
    
    public void afegirNode(String tipus,String nom) {
        Node n = new Node(idnou,nom,tipus);
        ++idnou;
        switch (tipus) {
            case "Autor":
                autor.add(n);
                break;
            case "Conferencia":
                conf.add(n);
                break;
            case "Article":
                paper.add(n);
                break;
            case "Terme":
                terme.add(n);
                break;
        }
        actualitzar = true;
    }
    
    public void eliminarNode(String nomNode) {
        int id = GetIDnode(nomNode);
        if(id == -1) System.out.println("Aquest node no existeix");
        else { 
            String tipus = getTipusNode(id,nomNode);
            switch (tipus) {
                case "Autor":
                    for (int i=0; i<autor.size(); ++i) {
                        if (autor.get(i).getId() == id) autor.remove(i);
                    } 
                    for (int i = 0; i<pa.size(); ++i) {
                        if (pa.get(i).getNode2() == id) pa.remove(i);
                    }  
                    break;
                case "Conferencia":
                    for (int i=0; i<conf.size(); ++i) {
                        if (conf.get(i).getId() == id) conf.remove(i);
                    }  
                    for (int i = 0; i<pc.size(); ++i) {
                        if (pc.get(i).getNode2() == id) pc.remove(i);
                    }   
                    break;
                case "Article":
                    for (int i=0; i<paper.size(); ++i) {
                        if (paper.get(i).getId() == id) paper.remove(i);
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
                case "Terme":
                    for (int i=0; i<terme.size(); ++i) {
                        if (terme.get(i).getId() == id) terme.remove(i);
                    }
                    for (int i = 0; i<pt.size(); ++i) {
                        if (pt.get(i).getNode2() == id) pt.remove(i);
                    }   
                    break;
            }
            actualitzar = true;
        }
    }
    
    public double getValorNode(int id, String nom) {
        String tipus = getTipusNode(id,nom);
        double valor = 0;
        switch(tipus) {
            case "Autor":
                for (int i =0; i<autor.size();++i) {
                    if (autor.get(i).getId() == id) {
                        valor = autor.get(i).getValor();
                    }
                }
                break;
            case "Conferencia":
                for (int i =0; i<conf.size();++i) {
                    if (conf.get(i).getId() == id) {
                        valor = conf.get(i).getValor();
                    }
                }
                break;
            case "Article":
                for (int i =0; i<paper.size();++i) {
                    if (paper.get(i).getId() == id) {
                        valor = paper.get(i).getValor();
                    }
                }
                break;
            case "Terme":
                for (int i =0; i<terme.size();++i) {
                    if (terme.get(i).getId() == id) {
                        valor = terme.get(i).getValor();
                    }
                }
                break;
        }
        return valor;
    }
    
    public String getTipusNode(int id, String nom) {
        String tipus = "";
        Boolean acabat = false;
        for (int i=0; i<paper.size() && !acabat; ++i) {
            if (paper.get(i).getId() == id) {
                if (paper.get(i).getNom().equals(nom)) {
                    tipus = paper.get(i).getTipus();
                    acabat = true;
                }
            }
        }
        for (int i=0; i<conf.size() && !acabat; ++i) {
            if (conf.get(i).getId() == id) {
                if (conf.get(i).getNom().equals(nom)) {
                    tipus = conf.get(i).getTipus();
                    acabat = true;
                }
            }
        }
        for (int i=0; i<autor.size() && !acabat; ++i) {
            if (autor.get(i).getId() == id) {
                if (autor.get(i).getNom().equals(nom)) {
                    tipus = autor.get(i).getTipus();
                    acabat = true;
                }
            }
        }
        for (int i=0; i<terme.size() && !acabat; ++i) {
            if (terme.get(i).getId() == id) {
                if (terme.get(i).getNom().equals(nom)) {
                    tipus = terme.get(i).getTipus();
                    acabat = true;
                }
            }
        }
        return tipus;
    }
    
    public String getNomNode(int id, String tipus) {
        String nom = "";
        switch (tipus) {
            case "Autor":
                for (int i=0; i<autor.size(); ++i) {
                    if (autor.get(i).getId() == id) {
                        nom = autor.get(i).getNom();
                    }
                }
                break;
            
            case "Conferencia":
                for (int i=0; i<conf.size(); ++i) {
                    if (conf.get(i).getId() == id) {
                        nom = conf.get(i).getNom();
                    }
                }
                break;
                
            case "Article":
                for (int i=0; i<paper.size(); ++i) {
                    if (paper.get(i).getId() == id) {
                        nom = paper.get(i).getNom();
                    }
                }
                break;
                
            case "Terme":
                for (int i=0; i<terme.size(); ++i) {
                    if (terme.get(i).getId() == id) {
                        nom = terme.get(i).getNom();
                    }
                }
                break;
        }
        return nom;
    }
    
    public int GetIDnode(String nom) {
        Integer id = 0;
        Boolean acabat = false;
        for (int i=0; i<paper.size() && !acabat; ++i) {
            if (paper.get(i).getNom().equals(nom)) {
                id = paper.get(i).getId();
                acabat = true;
            }
        }
        for (int i=0; i<conf.size() && !acabat; ++i) {
            if (conf.get(i).getNom().equals(nom)) {
                id = conf.get(i).getId();
                acabat = true;
            }
        }
        for (int i=0; i<autor.size() && !acabat; ++i) {
            if (autor.get(i).getNom().equals(nom)) {
                id = autor.get(i).getId();
                acabat = true;
            }
        }
        for (int i=0; i<terme.size() && !acabat; ++i) {
            if (terme.get(i).getNom().equals(nom)) {
                id = terme.get(i).getId();
                acabat = true;
            }
        }
        return id;
    }
    
    private void pagerank() {
        double prob_Autor = 0.2;
        double prob_Conf = 0.3;
        double prob_Article = 0.1;
        double d = 0.85;
        ArrayList<String> nodesadjacents = new ArrayList<>();
        int id1 = 0;
        double prob = 0;
        String tipus = "";
        for (int i=0; i<paper.size(); ++i) {
            nodesadjacents = paper.get(i).getnodesadjacents();
            for (int j=0; j<nodesadjacents.size(); ++j) {
                id1 = GetIDnode(nodesadjacents.get(j));
                tipus = getTipusNode(id1,nodesadjacents.get(j));
                switch (tipus) {
                    case "Autor":
                        prob += prob_Autor/getNumAdj(id1,nodesadjacents.get(j));
                        break;
                    case "Conferencia":
                        prob += prob_Conf/getNumAdj(id1,nodesadjacents.get(j));
                        break;
                }
            }
            paper.get(i).setValor((1-d)+(d*prob));
        }
        System.out.println("Articles acabats");
        for (int i=0; i<conf.size(); ++i) {
            nodesadjacents = conf.get(i).getnodesadjacents();
            prob = 0;
            for (int j=0; j<nodesadjacents.size(); ++j) {
                id1 = GetIDnode(nodesadjacents.get(j));
                prob += prob_Article/getNumAdj(id1,nodesadjacents.get(j));
            }
            conf.get(i).setValor((1-d)+(d*prob));
        }
        System.out.println("Conferencies acabats");
        for (int i=0; i<autor.size(); ++i) {
            nodesadjacents = autor.get(i).getnodesadjacents();
            prob = 0;
            for (int j=0; j<nodesadjacents.size(); ++j) {
                id1 = GetIDnode(nodesadjacents.get(j));
                prob += prob_Article/getNumAdj(id1,nodesadjacents.get(j));
            }
            autor.get(i).setValor((1-d)+(d*prob));
        }
        System.out.println("Autors acabats");
        for (int i=0; i<terme.size(); ++i) {
            id1 = terme.get(i).getId();
            nodesadjacents = terme.get(i).getnodesadjacents();
            terme.get(i).setValor(getNumAdj(id1,terme.get(i).getNom()));
        }
    }
    
    private double getNumAdj(int id, String nom) {
        double numAdj = 0;
        String tipus = getTipusNode(id,nom);
        Boolean acabat = false;
        switch (tipus) {
            case "Autor":
                for (int i=0; i<autor.size() && !acabat; ++i) {
                    if (autor.get(i).getId() == id) {
                        autor.get(i).getsize();
                        acabat = true;
                    }
                }
                break;
                
            case "Conferencia":
                for (int i=0; i<conf.size() && !acabat; ++i) {
                    if (conf.get(i).getId() == id) {
                        conf.get(i).getsize();
                        acabat = true;
                    }
                }
                break;
                
            case "Terme":
                for (int i=0; i<terme.size() && !acabat; ++i) {
                    if (terme.get(i).getId() == id) {
                        terme.get(i).getsize();
                        acabat = true;
                    }
                }
                break;
            
            case "Article":
                for (int i=0; i<paper.size() && !acabat; ++i) {
                    if (paper.get(i).getId() == id) {
                        paper.get(i).getsize();
                        acabat = true;
                    }
                }
                break;
        }
        return numAdj;
    }
}
