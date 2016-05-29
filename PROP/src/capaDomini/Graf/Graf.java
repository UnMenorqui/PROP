/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaDomini.Graf;
import java.util.*;


/**
 *
 * @author marc
 */

public class Graf {
    
    CtrlGraf cg1;
    
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
    
    private Boolean autoractualitzat = false;
    private Boolean termeactualitzat = false;
    private Boolean articleactualitzat = false;
    private Boolean confactualitzat = false;
    private Boolean paactualitzat = false;
    private Boolean ptactualitzat = false;
    private Boolean pcactualitzat = false;
    
    public ArrayList<Integer> id;
    
    public ArrayList<String> noms;
    
    public ArrayList<Integer> id1;
    
    
    public Graf(CtrlGraf cg) {
       paper = new ArrayList<>();
       autor = new ArrayList<>();
       conf = new ArrayList<>();
       terme = new ArrayList<>();
       pc = new ArrayList<>();
       pa = new ArrayList<>();
       pt = new ArrayList<>();
       id = new ArrayList<>();
       id1 = new ArrayList<>();
       noms = new ArrayList<>();
       maxAutor = maxConf = maxTerme = maxArticle = 0;
       cg.load_autor(id,noms);
       cg1 = cg;
       for (int i = 0; i < id.size(); ++i) {
           autor.add(new Node(id.get(i),noms.get(i),"Autor"));
           if (id.get(i) > maxAutor) maxAutor = id.get(i);
       }
       id.clear();
       noms.clear();
       cg.load_conf(id,noms);
       for (int i = 0; i < id.size(); ++i) {
           conf.add(new Node(id.get(i),noms.get(i),"Conferencia"));
           if (id.get(i) > maxConf) maxConf = id.get(i);
       }
       id.clear();
       noms.clear();
       cg.load_paper(id,noms);
       for (int i = 0; i < id.size(); ++i) {
           paper.add(new Node(id.get(i),noms.get(i),"Article"));
           if (id.get(i) > maxArticle) maxArticle = id.get(i);
       }
       id.clear();
       noms.clear();
       cg.load_terme(id,noms);
       for (int i = 0; i < id.size(); ++i) {
           terme.add(new Node(id.get(i),noms.get(i),"Terme"));
           if (id.get(i) > maxTerme) maxTerme = id.get(i);
       }
       int id2,id3,node1,node2;
       id.clear();
       id1.clear();
       cg.load_pc(id,id1);
       for (int i = 0; i < id.size(); ++i) {
           pc.add(new Aresta(id.get(i),id1.get(i)));
           node1 = id.get(i);
           node2 = id1.get(i);
           id2 = getidArrayint(node1,"Article");
           id3 = getidArrayint(node2, "Conferencia");
           paper.get(id2).afegirnodeadjacent(node2,"Conferencia");
           conf.get(id3).afegirnodeadjacent(node1,"Article");
       }
       id.clear();
       id1.clear();
       cg.load_pa(id,id1);
       for (int i = 0; i < id.size(); ++i) {
           pa.add(new Aresta(id.get(i),id1.get(i)));
           node1 = id.get(i);
           node2 = id1.get(i);
           id2 = getidArrayint(node1,"Article");
           id3 = getidArrayint(node2, "Autor");
           paper.get(id2).afegirnodeadjacent(node2,"Autor");
           autor.get(id3).afegirnodeadjacent(node1,"Article");
       }
       id.clear();
       id1.clear();
       cg.load_pt(id,id1);
       for (int i = 0; i < id.size(); ++i) {
           pt.add(new Aresta(id.get(i),id1.get(i)));
           node1 = id.get(i);
           node2 = id1.get(i);
           id2 = getidArrayint(node1,"Article");
           id3 = getidArrayint(node2, "Terme");
           paper.get(id2).afegirnodeadjacent(node2,"Terme");
           terme.get(id3).afegirnodeadjacent(node1,"Article");
       }
       pagerank();
    };

    public int afegirAresta(String nom1, String nom2, String tipus) {
        int id = getidArrayString(nom1,"Article");
        int id1 = getidArrayString(nom2,tipus);
        if (id == -1) return 0;
        if (id1 == -1) return 1;
        int Node1 = GetIDnode(id,"Article");
        int Node2 = GetIDnode(id1,tipus);
        Boolean existeix = false;
        switch (tipus) {
            case "Autor":
                if (!existeixAresta(id,Node2,tipus)) {
                    pa.add(new Aresta(Node1,Node2));
                    existeix = true;
                    paactualitzat = true;
                }
                else return 2;
                break;
            case "Terme":
                if (!existeixAresta(id,Node2,tipus)) {
                    pt.add(new Aresta(Node1,Node2));
                    existeix = true;
                    ptactualitzat = true;
                }
                else return 2;
                break;
            case "Conferencia":
                if (!existeixAresta(id,Node2,tipus)) {
                    pt.add(new Aresta(Node1,Node2));
                    existeix = true;
                    pcactualitzat = true;
                }
                else return 2;
                break;
                
        }
        if (existeix) actualitzar = true;
        return 3;
    }
    
    public int eliminarAresta(String nom1, String nom2, String tipus) {
        int id, id1, node1, node2;
        id = getidArrayString(nom1,"Article");
        id1 = getidArrayString(nom2,tipus);
        if (id == -1) return 0; // Primer entitat no existent
        if (id1 == -1) return 1; // Segona entitat no existent
        node1 = GetIDnode(id,"Article");
        node2 = GetIDnode(id1,tipus);
        Boolean existeix = false;
        Boolean primer, segon;
        switch (tipus) {
            case "Autor":
                for (int i=0; i<pa.size(); ++i) {
                    if (pa.get(i).getNode1() == node1) {
                        if (pa.get(i).getNode2() == node2) {
                            pa.remove(i);
                            existeix = true;
                            paactualitzat = true;
                        }
                    }
                }
                if (existeix) {
                    //Busca si el node2(autor) te alguna altra aresta, si no es
                    //el cas, borra el node2
                    segon = false;
                    for (int i=0; i<pa.size() && !segon; ++i) {
                        if (pa.get(i).getNode2() == node2) {
                            segon = true;
                        }
                    }
                    if (!segon) {
                        eliminarNode(getNomNode(id1,"Autor"),"Autor");
                        autoractualitzat = true;
                    }
                    //Busca si el node1(article) te alguna altra aresta, si no es
                    //el cas, borra el node1
                    primer = false;
                    for (int i=0; i<pa.size() && !primer; ++i) {
                        if (pa.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    for (int i=0; i<pc.size() && !primer; ++i) {
                        if (pc.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    for (int i=0; i<pt.size() && !primer; ++i) {
                        if (pt.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    if (!primer)  {
                        eliminarNode(getNomNode(id,"Article"),"Article");
                        articleactualitzat = true;
                    }
                }
                else return 2;
                break;

            case "Conferencia":
                for (int i=0; i<pc.size(); ++i) {
                    if (pc.get(i).getNode1() == node1) {
                        if (pc.get(i).getNode2() == node2) {
                            pc.remove(i);
                            existeix = true;
                        }
                    }
                }
                if (existeix) {
                    //Busca si el node2(conferencia) te alguna altra aresta, si no es
                    //el cas, borra el node2
                    segon = false;
                    for (int i=0; i<pc.size() && !segon; ++i) {
                        if (pc.get(i).getNode2() == node2) {
                            segon = true;
                        }
                    }
                    if (!segon) {
                        eliminarNode(getNomNode(id1,"Conferencia"),"Conferencia");
                        confactualitzat = true;
                    }
                    //Busca si el node1(article) te alguna altra aresta, si no es
                    //el cas, borra el node1
                    primer = false;
                    for (int i=0; i<pa.size() && !primer; ++i) {
                        if (pa.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    for (int i=0; i<pc.size() && !primer; ++i) {
                        if (pc.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    for (int i=0; i<pt.size() && !primer; ++i) {
                        if (pt.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    if (!primer) {
                        eliminarNode(getNomNode(id,"Article"),"Article");
                        articleactualitzat = true;
                    }
                }
                else return 2;
                break;

            case "Terme":
                for (int i=0; i<pt.size(); ++i) {
                    if (pt.get(i).getNode1() == node1) {
                        if (pt.get(i).getNode2() == node2) {
                            pt.remove(i);
                            existeix = true;
                            ptactualitzat = true;
                        }
                    }
                }
                if (existeix) {
                    //Busca si el node2(terme) te alguna altra aresta, si no es
                    //el cas, borra el node2
                    segon = false;
                    for (int i=0; i<pt.size() && !segon; ++i) {
                        if (pt.get(i).getNode2() == node2) {
                            segon = true;
                        }
                    }
                    if (!segon) {
                        eliminarNode(getNomNode(id1,"Terme"),"Terme");
                        termeactualitzat = true;
                    }
                    //Busca si el node1(article) te alguna altra aresta, si no es
                    //el cas, borra el node1
                    primer = false;
                    for (int i=0; i<pa.size() && !primer; ++i) {
                        if (pa.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    for (int i=0; i<pc.size() && !primer; ++i) {
                        if (pc.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    for (int i=0; i<pt.size() && !primer; ++i) {
                        if (pt.get(i).getNode1() == node1) {
                            primer = true;
                        }
                    }
                    if (!primer) {
                        eliminarNode(getNomNode(id,"Article"),"Article");
                        articleactualitzat = true;
                    }
                }
                else return 2;
                break;
        }
        if (existeix) actualitzar = true;
        return 3;
    }
    
    public boolean existeixAresta(int id1, int node2, String tipus) {
        Node n = getNodeIessim(id1,"Article");
        for (int i=0; i<n.getsize();++i) {
            if (n.nodeiessimFirst(i) == node2) return true;
        }
        return false;
    }


    public int afegirNode(String nom,String tipus) {
        int id;
        id = getidArrayString(nom,tipus);
        if (id != -1) return 0; 
        switch (tipus) {
            case "Autor":
                autor.add(new Node(++maxAutor,nom,tipus));
                autoractualitzat = true;
                break;
            case "Conferencia":
                conf.add(new Node(++maxConf,nom,tipus));
                confactualitzat = true;
                break;
            case "Article":
                paper.add(new Node(++maxArticle,nom,tipus));
                articleactualitzat = true;
                break;
            case "Terme":
                terme.add(new Node(++maxTerme,nom,tipus));
                termeactualitzat = true;
                break;
        }
        if (!autoractualitzat && !confactualitzat && !articleactualitzat && !termeactualitzat) return 0;
        actualitzar = true;
        return 1;
    }
    
    public int eliminarNode(String nom, String tipus) {
        int id = getidArrayString(nom,tipus);
        if(id == -1) return 0;
        int node = GetIDnode(id,tipus);
        switch (tipus) {
            case "Autor":
                autor.remove(id);
                autoractualitzat = true;
                for (int i = 0; i<pa.size(); ++i) {
                    if (pa.get(i).getNode2() == node) {
                        pa.remove(i);
                        paactualitzat = true;
                    }
                }  
                break;
            case "Conferencia":
                conf.remove(id);
                confactualitzat = true;
                for (int i = 0; i<pc.size(); ++i) {
                    if (pc.get(i).getNode2() == node) {
                        pc.remove(i);
                        pcactualitzat = true;
                    }
                }   
                break;
            case "Article":
                paper.remove(id);
                articleactualitzat = true;
                for (int i = 0; i<pa.size(); ++i) {
                    if (pa.get(i).getNode1() == node) {
                        pa.remove(i);
                        paactualitzat = true;
                    }
                }  
                for (int i = 0; i<pt.size(); ++i) {
                    if (pt.get(i).getNode1() == node) {
                        pt.remove(i);
                        ptactualitzat = true;
                    }
                }
                for (int i = 0; i<pc.size(); ++i) {
                    if (pc.get(i).getNode1() == node) {
                        pc.remove(i);
                        pcactualitzat = true;
                    }
                }
                break;
            case "Terme":
                terme.remove(id);
                termeactualitzat = true;
                for (int i = 0; i<pt.size(); ++i) {
                    if (pt.get(i).getNode2() == node) {
                        pt.remove(i);
                        ptactualitzat = true;
                    }
                }   
                break;
        }
        actualitzar = true;
        return 1;
    }
    
    public Boolean existeixnode(String nom, String tipus) {
        switch(tipus) {
            case "Autor":
                for (int i=0; i<autor.size(); ++i) {
                    if (autor.get(i).getNom().equals(nom)) return true;
                }
                break;
            case "Article":
                for (int i=0; i<paper.size(); ++i) {
                    if (paper.get(i).getNom().equals(nom)) return true;
                }
                break;
            case "Conferencia":
                for (int i=0; i<conf.size(); ++i) {
                    if (conf.get(i).getNom().equals(nom)) return true;
                }
                break;
            case "Terme":
                for (int i=0; i<terme.size(); ++i) {
                    if (terme.get(i).getNom().equals(nom)) return true;
                }
                break;
        }
        return false;
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
        int idArray = -1;
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
    
    public Boolean getActualitzar() {
        return actualitzar;
    }
    
    public void actualitzar() {
        if (autoractualitzat) {
            id.clear();
            noms.clear();
            for (int i = 0; i < autor.size(); ++i) {
                id.add(autor.get(i).getId());
                noms.add(autor.get(i).getNom());
            }
            cg1.saveAutor(id,noms);
        }
        if (confactualitzat) {
            id.clear();
            noms.clear();
            for (int i = 0; i < conf.size(); ++i) {
                id.add(conf.get(i).getId());
                noms.add(conf.get(i).getNom());
            }
            cg1.saveConf(id,noms);
        }
        if (termeactualitzat) {
            id.clear();
            noms.clear();
            for (int i = 0; i < terme.size(); ++i) {
                id.add(terme.get(i).getId());
                noms.add(terme.get(i).getNom());
            }
            cg1.saveTerme(id,noms);
        }
        if (articleactualitzat) {
            id.clear();
            noms.clear();
            for (int i = 0; i < paper.size(); ++i) {
                id.add(paper.get(i).getId());
                noms.add(paper.get(i).getNom());
            }
            cg1.saveArticle(id,noms);
        }
        if (paactualitzat) {
            id.clear();
            id1.clear();
            for (int i = 0; i < pa.size(); ++i) {
                id.add(pa.get(i).getNode1());
                id1.add(pa.get(i).getNode2());
            }
            cg1.savepa(id,id1);
        }
        if (pcactualitzat) {
            id.clear();
            id1.clear();
            for (int i = 0; i < pc.size(); ++i) {
                id.add(pc.get(i).getNode1());
                id1.add(pc.get(i).getNode2());
            }
            cg1.savepc(id,id1);
        }
        if (ptactualitzat) {
            id.clear();
            id1.clear();
            for (int i = 0; i < pt.size(); ++i) {
                id.add(pt.get(i).getNode1());
                id1.add(pt.get(i).getNode2());
            }
            cg1.savept(id,id1);
        }
    }
}
