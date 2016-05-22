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
    
    private int maxAutor;
    private int maxConf;
    private int maxTerme;
    private int maxArticle;
    
    
    public Graf() {
       BaseDades bd = new BaseDades();
       paper = new ArrayList<>();
       autor = new ArrayList<>();
       conf = new ArrayList<>();
       terme = new ArrayList<>();
       pc = new ArrayList<>();
       pa = new ArrayList<>();
       pt = new ArrayList<>();
       maxAutor = maxConf = maxTerme = maxArticle = 0;
       bd.load(paper,autor,terme,conf,pc,pa,pt);
       for (int i=0; i<autor.size(); ++i) {
           if (autor.get(i).getId() > maxAutor) maxAutor = autor.get(i).getId();
       }
       for (int i=0; i<paper.size(); ++i) {
           if (paper.get(i).getId() > maxArticle) maxArticle = paper.get(i).getId();
       }
       for (int i=0; i<terme.size(); ++i) {
           if (terme.get(i).getId() > maxTerme) maxTerme = terme.get(i).getId();
       }
       for (int i=0; i<conf.size(); ++i) {
           if (conf.get(i).getId() > maxConf) maxConf = conf.get(i).getId();
       }
       for (int i=0; i<pc.size(); ++i) {
           int node1 = pc.get(i).getNode1();
           int node2 = pc.get(i).getNode2();
           int id = getidArrayint(node1,"Article");
           int id2 = getidArrayint(node2,"Conferencia");
           paper.get(id).afegirnodeadjacent(node2,"Conferencia");
           conf.get(id2).afegirnodeadjacent(node1,"Article");
       }
       for (int i=0; i<pa.size(); ++i) {
           int node1 = pa.get(i).getNode1();
           int node2 = pa.get(i).getNode2();
           int id = getidArrayint(node1,"Article");
           int id2 = getidArrayint(node2,"Autor");
           paper.get(id).afegirnodeadjacent(node2,"Autor");
           autor.get(id2).afegirnodeadjacent(node1,"Article");
       }
       for (int i=0; i<pt.size(); ++i) {
           int node1 = pt.get(i).getNode1();
           int node2 = pt.get(i).getNode2();
           int id = getidArrayint(node1,"Article");
           int id2 = getidArrayint(node2,"Terme");
           paper.get(id).afegirnodeadjacent(node2,"Terme");
           terme.get(id2).afegirnodeadjacent(node1,"Article");
       }
       pagerank();
    };

    public boolean afegirAresta(String nom1, String nom2, String tipus) {
        int id = getidArrayString(nom1,"Article");
        int id1 = getidArrayString(nom2,tipus);
        if (id == 0) return true;
        if (id1 == 0) return true;
        int Node1 = GetIDnode(id,"Article");
        int Node2 = GetIDnode(id1,tipus);
        Boolean existeix = false;
        Aresta a;
        switch (tipus) {
            case "Autor":
                for (int i=0; i<pa.size(); ++i) {
                    if (pa.get(i).getNode1() == Node1) {
                        if (pa.get(i).getNode2() == Node2) {
                            existeix = true;
                        }
                    }
                }
                if (!existeix) {
                    a = new Aresta(Node1,Node2);
                    pa.add(a);
                }
                break;
            case "Terme":
                for (int i=0; i<pt.size(); ++i) {
                    if (pt.get(i).getNode1() == Node1) {
                        if (pt.get(i).getNode2() == Node2) {
                            existeix = true;
                        }
                    }
                }
                if (!existeix) {
                    a = new Aresta(Node1,Node2);
                    pt.add(a);
                }
                break;
            case "Conferencia":
                for (int i=0; i<pc.size(); ++i) {
                    if (pc.get(i).getNode1() == Node1) {
                        if (pc.get(i).getNode2() == Node2) {
                            existeix = true;
                        }
                    }
                }
                if (!existeix) {
                    a = new Aresta(Node1,Node2);
                    pc.add(a);
                }
                break;
                
        }
        if (!existeix) actualitzar = true;
        return existeix;
    }
    
    public boolean eliminarAresta(String nom1, String nom2, String tipus) {
        int id, id1, node1, node2;
        id = getidArrayString(nom1,"Article");
        id1 = getidArrayString(nom2,tipus);
        if (id == -1) return true;
        if (id1 == -1) return true;
        node1 = GetIDnode(id,"Article");
        node2 = GetIDnode(id1,tipus);
        Boolean existeix = true;
        Boolean primer,segon;
        switch (tipus) {
            case "Autor":
                for (int i=0; i<pa.size(); ++i) {
                    if (pa.get(i).getNode1() == node1) {
                        if (pa.get(i).getNode2() == node2) {
                            pa.remove(i);
                            existeix = false;
                        }
                    }
                }
                primer = false;
                segon  = false;
                if (!existeix) {
                    for (int i=0; i<pa.size(); ++i) {
                        if (pa.get(i).getNode1() == node1) {
                            primer = true;
                        }
                        if (pa.get(i).getNode2() == node2) {
                            segon = true;
                        }
                    }
                    if (!primer) eliminarNode(getNomNode(id,"Article"),"Article");
                    if (!segon) eliminarNode(getNomNode(id,"Autor"),"Autor");
                } 
                break;

            case "Conferencia":
                for (int i=0; i<pc.size(); ++i) {
                    if (pc.get(i).getNode1() == node1) {
                        if (pc.get(i).getNode2() == node2) {
                            pc.remove(i);
                            existeix = false;
                        }
                    }
                }
                primer = false;
                segon  = false;
                if (!existeix) {
                    for (int i=0; i<pc.size(); ++i) {
                        if (pc.get(i).getNode1() == node1) {
                            primer = true;
                        }
                        if (pc.get(i).getNode2() == node2) {
                            segon = true;
                        }
                    }
                    if (!primer) eliminarNode(getNomNode(id,"Article"),"Article");
                    if (!segon) eliminarNode(getNomNode(id,"Conferencia"),"Conferencia");
                }
                break;

            case "Terme":
                for (int i=0; i<pt.size(); ++i) {
                    if (pt.get(i).getNode1() == node1) {
                        if (pt.get(i).getNode2() == node2) {
                            pt.remove(i);
                            existeix = false;
                        }
                    }
                }
                primer = false;
                segon  = false;
                if (!existeix) {
                    for (int i=0; i<pt.size(); ++i) {
                        if (pt.get(i).getNode1() == node1) {
                            primer = true;
                        }
                        if (pt.get(i).getNode2() == node2) {
                            segon = true;
                        }
                    }
                    if (!primer) eliminarNode(getNomNode(id,"Article"),"Article");
                    if (!segon) eliminarNode(getNomNode(id,"Terme"),"Terme");
                }
                break;
        }
        if (!existeix) actualitzar = true;
        return existeix;
    }

    public Boolean afegirNode(String tipus,String nom) {
        Node n;
        Boolean existeix = false;
        switch (tipus) {
            case "Autor":
                for (int i=0; i<autor.size() && !existeix; ++i) {
                    if (autor.get(i).getNom().equals(nom)) existeix = true;
                }
                if (!existeix) { 
                    n = new Node(++maxAutor,nom,tipus);
                    autor.add(n);
                }
                break;
            case "Conferencia":
                for (int i=0; i<conf.size() && !existeix; ++i) {
                    if (conf.get(i).getNom().equals(nom)) existeix = true;
                }
                if (!existeix) {
                    n = new Node(++maxConf,nom,tipus);
                    conf.add(n);
                }
                break;
            case "Article":
                for (int i=0; i<paper.size() && !existeix; ++i) {
                    if (paper.get(i).getNom().equals(nom)) existeix = true;
                }
                if (!existeix) {
                    n = new Node(++maxArticle,nom,tipus);
                    paper.add(n);
                }
                break;
            case "Terme":
                for (int i=0; i<terme.size() && !existeix; ++i) {
                    if (terme.get(i).getNom().equals(nom)) existeix = true;
                }
                if (!existeix) {
                    n = new Node(++maxTerme,nom,tipus);
                    terme.add(n);
                }
                break;
        }
        if (!existeix) actualitzar = true;
        return existeix;
    }
    
    public Boolean eliminarNode(String nom, String tipus) {
        int id = getidArrayString(nom,tipus);
        if (id == -1) return true;
        else { 
            int node = GetIDnode(id,tipus);
            switch (tipus) {
                case "Autor":
                    for (int i=0; i<autor.size(); ++i) {
                        if (autor.get(i).getId() == node)  autor.remove(i);
                    } 
                    for (int i = 0; i<pa.size(); ++i) {
                        if (pa.get(i).getNode2() == node) pa.remove(i);
                    }  
                    break;
                case "Conferencia":
                    for (int i=0; i<conf.size(); ++i) {
                        if (conf.get(i).getId() == node){
                            conf.remove(i);
                            System.out.println("eliminat");
                        }
                     }  
                    for (int i = 0; i<pc.size(); ++i) {
                        if (pc.get(i).getNode2() == node) pc.remove(i);
                    }   
                    break;
                case "Article":
                    for (int i=0; i<paper.size(); ++i) {
                        if (paper.get(i).getId() == node) paper.remove(i);
                    }  
                    for (int i = 0; i<pa.size(); ++i) {
                        if (pa.get(i).getNode1() == node) pa.remove(i);
                    }  
                    for (int i = 0; i<pt.size(); ++i) {
                        if (pt.get(i).getNode1() == node) pt.remove(i);
                    }
                    for (int i = 0; i<pc.size(); ++i) {
                        if (pc.get(i).getNode1() == node) pc.remove(i);
                    }
                    break;
                case "Terme":
                    for (int i=0; i<terme.size(); ++i) {
                        if (terme.get(i).getId() == node) terme.remove(i);
                    }
                    for (int i = 0; i<pt.size(); ++i) {
                        if (pt.get(i).getNode2() == node) pt.remove(i);
                    }   
                    break;
            }
            actualitzar = true;
            return false;
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
        switch (tipus) {
            case "Autor":
                return autor.get(id).getNom();
            case "Conferencia":
                return conf.get(id).getNom();
            case "Article":
                return paper.get(id).getNom();
            case "Terme":
                return terme.get(id).getNom();
        }
        return "";
    }
    
    public int GetIDnode(int id, String tipus) {
        switch (tipus) {
            case "Autor":
                return autor.get(id).getId();
            case "Conferencia":
                return conf.get(id).getId();
            case "Article":
                return paper.get(id).getId();
            case "Terme":
                return terme.get(id).getId();
        }
        return -1;
    }
    
    private void pagerank() {
        double prob_Autor = 0.2;
        double prob_Conf = 0.3;
        double prob_Article = 0.1;
        double d = 0.85;
        int id = 0;
        double prob;
        for (int i=0; i<paper.size(); ++i) {
            prob = 0;
            for (int j=0; j<paper.get(i).getsize(); ++j) {
                int node = paper.get(i).nodeiessimFirst(j);
                String tipus = paper.get(i).nodeiessimSecond(j);
                id = getidArrayint(node,tipus);
                switch (tipus) {
                    case "Autor":
                        prob += prob_Autor/getNumAdj(id,tipus);
                        break;
                    case "Conferencia":
                        prob += prob_Conf/getNumAdj(id,tipus);
                        break;
                }
            }
            paper.get(i).setValor((1-d)+(d*prob));
        }
        for (int i=0; i<conf.size(); ++i) {
            prob = 0;
            for (int j=0; j<conf.get(i).getsize(); ++j) {
                int node = conf.get(i).nodeiessimFirst(j);
                String tipus = conf.get(i).nodeiessimSecond(j);
                id = getidArrayint(node,tipus);
                prob += prob_Article/getNumAdj(id,tipus);
            }
            conf.get(i).setValor((1-d)+(d*prob));
        }
        for (int i=0; i<autor.size(); ++i) {
            prob = 0;
            for (int j=0; j<autor.get(i).getsize(); ++j) {
                int node = autor.get(i).nodeiessimFirst(j);
                String tipus = autor.get(i).nodeiessimSecond(j);
                id = getidArrayint(node,tipus);
                prob += prob_Article/getNumAdj(id,tipus);
            }
            autor.get(i).setValor((1-d)+(d*prob));
        }
        for (int i=0; i<terme.size(); ++i) {
            terme.get(i).setValor(getNumAdj(i,"Terme"));
        }
    }
    
    public int getidArrayint(int id, String tipus) {
        int idArray = 0;
        Boolean acabat = false;
        switch (tipus) {
            case "Article":
                acabat = false;
                for (int i=0; i<paper.size() && !acabat; ++i) {
                    if (paper.get(i).getId() == id) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
            case "Autor":
                acabat = false;
                for (int i=0; i<autor.size() && !acabat; ++i) {
                    if (autor.get(i).getId() == id) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
            case "Conferencia":
                acabat = false;
                for (int i=0; i<conf.size() && !acabat; ++i) {
                    if (conf.get(i).getId() == id) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
            case "Terme":
                acabat = false;
                for (int i=0; i<terme.size() && !acabat; ++i) {
                    if (terme.get(i).getId() == id) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
        }
        return idArray;
    }
    
    public int getidArrayString(String nom, String tipus) {
        int idArray = -1;
        Boolean acabat = false;
        switch (tipus) {
            case "Article":
                acabat = false;
                for (int i=0; i<paper.size() && !acabat; ++i) {
                    if (paper.get(i).getNom().equals(nom)) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
            case "Autor":
                acabat = false;
                for (int i=0; i<autor.size() && !acabat; ++i) {
                    if (autor.get(i).getNom().equals(nom)) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
            case "Conferencia":
                acabat = false;
                for (int i=0; i<conf.size() && !acabat; ++i) {
                    if (conf.get(i).getNom().equals(nom)) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
            case "Terme":
                acabat = false;
                for (int i=0; i<terme.size() && !acabat; ++i) {
                    if (terme.get(i).getNom().equals(nom)) {
                        idArray = i;
                        acabat = true;
                    }
                }
                break;
        }
        return idArray;
    }
    
    private double getNumAdj(int id, String tipus) {
        switch (tipus) {
            case "Autor":
                return autor.get(id).getsize();
            case "Conferencia":
                return conf.get(id).getsize();
            case "Article":
                return paper.get(id).getsize();
            case "Terme":
                return terme.get(id).getsize();
        }
        return -1;
    }
    
    public Node getNodeIessim(int id, String tipus) {
        switch (tipus) {
            case "Autor":
                return autor.get(id);
            case "Conferencia":
                return conf.get(id);
            case "Article":
                return paper.get(id);
            case "Terme":
                return terme.get(id);
        }
        return null;
    }
    
    public Boolean existeixnode(String nom, String tipus) {
        switch(tipus) {
            case "Autor":
                for (int i=0; i<autor.size(); ++i) {
                    if (autor.get(i).getNom().equals(nom)) return true;
                }
            case "Article":
                for (int i=0; i<paper.size(); ++i) {
                    if (paper.get(i).getNom().equals(nom)) return true;
                }
            case "Conferencia":
                for (int i=0; i<conf.size(); ++i) {
                    if (conf.get(i).getNom().equals(nom)) return true;
                }
            case "Terme":
                for (int i=0; i<terme.size(); ++i) {
                    if (terme.get(i).getNom().equals(nom)) return true;
                }
        }
        return false;
    }
    
    public Boolean getActualitzar() {
        return actualitzar;
    }
    
    public void actualitzar() {
        BaseDades bd1 = new BaseDades();
        bd1.save(autor,conf,paper,terme,pa,pc,pt);
    }
}
