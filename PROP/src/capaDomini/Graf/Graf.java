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
    
    protected int numTotalNode;
    protected int numTotalAresta;
  
    //ultim id donat a un node
    protected short numFinalNode;
    
    //ultim id donat a una aresta
    protected short numFinalAresta;
    
    protected ArrayList<Aresta> arestes;
    protected ArrayList<Node> nodes;
    
    protected short numarticles = 0;
    protected short numautors = 0;
    protected short numconf = 0;
    
    //estructuraQueConteElGraf;
    protected short[][] adj;
    
    //funcions
    public Graf() {
        numFinalNode = 0;
        numFinalAresta = 0;
        numTotalNode = 100; //Testing
        numTotalAresta = 100; //Testing
        arestes = new ArrayList<Aresta>();
        nodes = new ArrayList<Node>();
        adj = new short[numTotalNode][numTotalNode]; 
        initMadj();
    };
    
    public Graf(ArrayList<Aresta> arestes, ArrayList<Node> nodes) {

        numFinalNode = (short) nodes.size();
        numFinalAresta =(short) arestes.size(); 
        numTotalNode = nodes.size() + 500;
        numTotalAresta = arestes.size()+ 500;
        this.arestes = arestes; 
        this.nodes = nodes;
        adj = new short[numTotalNode][numTotalNode]; 
        initMadj();
        iniAdj();
        iniAdjAC();
        iniAdjAT();
        iniAdjCT();
    };
    
    //S'utilitzarà una matriu d'adjacencia per implementar el graf 
    protected void initMadj() {
        for(short i = 0; i < numarticles; ++i) {
            for (short j = 0; j < numTotalNode-numarticles; ++j) {
                adj[i][j] = -1;
            }
        }
    }
    
    protected void aA(short idNode1, short idNode2) {
        Aresta a = new Aresta(numFinalAresta,idNode1,idNode2);
        arestes.add(a);
        adj[idNode1][idNode2] = numFinalAresta;
        ++numFinalAresta;
    }
    
    protected void iniAdj() {
        short i;
        for (i=0; i<numFinalAresta; ++i) {
            short tmp1=arestes.get(i).getNode1();
            short tmp2=arestes.get(i).getNode2();
            short tmp3=arestes.get(i).getId();
            adj[tmp1][tmp2]=tmp3;
        }
    } 
    
    
    protected void iniAdjAC(){
        short i;
        for (i=0; i<numFinalNode; ++i) {
            if(nodes.get(i).getTipus().equals("Autor")) {
                short j;
                for (j=0; j<numFinalNode; ++j) {
                    if(adj[i][j]>-1) {
                        if(nodes.get(j).getTipus().equals("Paper")) {
                            short k;
                            for(k=0; k<numFinalNode; ++k) {
                                if(nodes.get(k).getTipus().equals("Conferencia")) {
                                    afegirAresta(nodes.get(i).getNom(), nodes.get(k).getNom());
                                }
                            }

                        }

                    }
                }
            }
        }
    }
    
    protected void iniAdjAT(){
        short i;
        for (i=0; i<numFinalNode; ++i) {
            if(nodes.get(i).getTipus().equals("Autor")) {
                short j;
                for (j=0; j<numFinalNode; ++j) {
                    if(adj[i][j]>-1) {
                        if(nodes.get(j).getTipus().equals("Paper")) {
                            short k;
                            for(k=0; k<numFinalNode; ++k) {
                                if(nodes.get(k).getTipus().equals("Term")) {
                                    afegirAresta(nodes.get(i).getNom(), nodes.get(k).getNom());
                                }
                            }

                        }

                    }
                }
            }

        }
    }
    
    protected void iniAdjCT(){
        short i;
        for (i=0; i<numFinalNode; ++i) {
            if(nodes.get(i).getTipus().equals("Conferencia")) {
                short j;
                for (j=0; j<numFinalNode; ++j) {
                    if(adj[i][j]>-1) {
                        if(nodes.get(j).getTipus().equals("Paper")) {
                            short k;
                            for(k=0; k<numFinalNode; ++k) {
                                if(nodes.get(k).getTipus().equals("Term")) {
                                    afegirAresta(nodes.get(i).getNom(), nodes.get(k).getNom());
                                }
                            }

                        }

                    }
                }
            }
        }
    }
    
    protected boolean existeixNode(short id) {
        if (id > numFinalNode || id < 0) return false;
        else {
            if (nodes.get(id) != null) return true;
        }
        return false;
    }

    protected boolean existeixAresta(short id) {
        if (id > numFinalAresta || id < 0) return false;
        else {
            if (arestes.get(id) != null) return true;
        }
        return false;
    }
    
    public void afegirNode(String tipus,String nom) {
        Node n = new Node(numFinalNode,nom,tipus);
        ++numFinalNode;
        nodes.add(n);
    }
    
    public void eliminarNode(String nomNode) {
        short id = GetID(nomNode);
        if(id == -1) System.out.println("Aquest node no existeix");
        else { 
            nodes.remove(id);
            for(short i = 0; i < adj.length; ++i) {
                adj[id][i] = -1;
            }
        }
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        short node1, node2;
        node1 = GetID(nom1);
        node2 = GetID(nom2);
        if(node1 == -1) System.out.println("El primer node no existeix");
        else if (node2 == -1) System.out.println("El segon node no existeix");
        else {
            //mirarse com eliminar aresta
            arestes.remove(adj[node1][node2]);
            adj[node1][node2] = -1;
        }
    }
    
    public short GetVNsize() {
        return numFinalNode;
    }
    
    public short GetVAsize() {
        return numFinalAresta;
    }
    
    public ArrayList<Node> GetVN() {
        return nodes;
    }
    
    public ArrayList<Aresta> GetVA() {
        return arestes;
    }
    
    public short[][] GetMadj() {
        return adj;
    }
    
    public short size() {
        return numFinalNode;
    }
    
    public String getTipus(short id) {
        return nodes.get(id).getTipus();
    }
    
    public short getIdAresta(short node1, short node2) {
        return adj[node1][node2];
    }
    
    public float getValorNode(short id) {
        return nodes.get(id).getValor();
    }
    
    public String getTipusNode(short id) {
        return nodes.get(id).getTipus();
    }
    
    public String getNomNode(short id) {
        return nodes.get(id).getNom();
    }
    
    public float getValorAresta(short id) {
        return arestes.get(id).getValor();
    }
    
    public short GetID(String nom) {
        for (short i = 0; i < nodes.size(); ++i) {
            if (nodes.get(i).getNom().equals(nom)) return nodes.get(i).getId();
        }
        return -1;
    }
    
    public void ModNode(short id, float valor) {
        nodes.get(id).setValor(valor);
    }
    
    public void modAresta(short id, float valor) {
        arestes.get(id).setValor(valor);
    }
    
    //mirar funcio
    public void afegirAresta(String nom1, String nom2) {
        short a = this.GetID(nom1);
        short b = this.GetID(nom2);
        this.aA(a,b);
    }
    
    public void PrintNodes() {
        for(short i = 0; i < nodes.size(); ++i) {
            if(nodes.get(i) != null) {
                nodes.get(i).PrintNode();
            }
        } 
    }
    
    public void PrintArestes() {
        for(short i = 0; i < arestes.size(); ++i) {
            if(arestes.get(i) != null) {
                arestes.get(i).PrintarAresta();
            }
        }
    }
}
