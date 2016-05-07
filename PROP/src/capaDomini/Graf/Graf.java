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
    protected int numFinalNode;
    
    //ultim id donat a una aresta
    protected int numFinalAresta;
    
    protected ArrayList<Aresta> arestes;
    
    protected ArrayList<Node> nodes;
    
    //estructuraQueConteElGraf;
    protected int[][] adj;
    
    //funcions
    public Graf() {
        numFinalNode = 0;
        numFinalAresta = 0;
        numTotalNode = 100; //Testing
        numTotalAresta = 100; //Testing
        arestes = new ArrayList<Aresta>();
        nodes = new ArrayList<Node>();
        adj = new int[numTotalNode][numTotalNode]; 
        initMadj();
        
    };
    
    public Graf(ArrayList<Aresta> arestes, ArrayList<Node> nodes) {

        numFinalNode = nodes.size();
        numFinalAresta = arestes.size(); 
        numTotalNode = nodes.size() + 500;
        numTotalAresta = arestes.size()+ 500;
        this.arestes = arestes; 
        this.nodes = nodes;
        adj = new int[numTotalNode][numTotalNode]; 
        initMadj();
        iniAdj();
        iniAdjAC();
        iniAdjAT();
        iniAdjCT();
    };
    
    //S'utilitzarà una matriu d'adjacencia per implementar el graf 
    protected void initMadj() {
        for(int i = 0; i < numTotalNode; ++i) {
            for (int j = 0; j < numTotalNode; ++j) {
                adj[i][j] = -1;
            }
        }
    }
    
    protected void aA(int idNode1, int idNode2) {
        Aresta a = new Aresta(numFinalAresta,idNode1,idNode2);
        arestes.add(a);
        adj[idNode1][idNode2] = numFinalAresta;
        adj[idNode2][idNode1] = numFinalAresta;
        ++numFinalAresta;
    }
    
    protected void iniAdj() {
        int i;
        for (i=0; i<numFinalAresta; ++i) {
            int tmp1=arestes.get(i).getNode1();
            int tmp2=arestes.get(i).getNode2();
            int tmp3=arestes.get(i).getId();
            adj[tmp1][tmp2]=tmp3;
            adj[tmp2][tmp1]=tmp3;
        }
    } 
    
    protected void iniAdjAC(){
        int i;
        for (i=0; i<numFinalNode; ++i) {
            if(nodes.get(i).getTipus().equals("Autor")) {
                int j;
                for (j=0; j<numFinalNode; ++j) {
                    if(adj[i][j]>-1) {
                        if(nodes.get(j).getTipus().equals("Paper")) {
                            int k;
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
        int i;
        for (i=0; i<numFinalNode; ++i) {
            if(nodes.get(i).getTipus().equals("Autor")) {
                int j;
                for (j=0; j<numFinalNode; ++j) {
                    if(adj[i][j]>-1) {
                        if(nodes.get(j).getTipus().equals("Paper")) {
                            int k;
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
        int i;
        for (i=0; i<numFinalNode; ++i) {
            if(nodes.get(i).getTipus().equals("Conferencia")) {
                int j;
                for (j=0; j<numFinalNode; ++j) {
                    if(adj[i][j]>-1) {
                        if(nodes.get(j).getTipus().equals("Paper")) {
                            int k;
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
    
    protected boolean existeixNode(int id) {
        if (id > numFinalNode || id < 0) return false;
        else {
            if (nodes.get(id) != null) return true;
        }
        return false;
    }

    protected boolean existeixAresta(int id) {
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
        int id = GetID(nomNode);
        if(id == -1) System.out.println("Aquest node no existeix");
        else { 
            nodes.remove(id);
            for(int i = 0; i < adj.length; ++i) {
                adj[id][i] = -1;
                adj[i][id] = -1;
            }
        }
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        int node1, node2;
        node1 = GetID(nom1);
        node2 = GetID(nom2);
        if(node1 == -1) System.out.println("El primer node no existeix");
        else if (node2 == -1) System.out.println("El segon node no existeix");
        else {
            //mirarse com eliminar aresta
            arestes.remove(adj[node1][node2]);
            adj[node1][node2] = -1;
            adj[node2][node1] = -1;
        }
    }
    
    public int GetVNsize() {
        return numFinalNode;
    }
    
    public int GetVAsize() {
        return numFinalAresta;
    }
    
    public ArrayList<Node> GetVN() {
        return nodes;
    }
    
    public ArrayList<Aresta> GetVA() {
        return arestes;
    }
    
    public int[][] GetMadj() {
        return adj;
    }
    
    public int size() {
        return numFinalNode;
    }
    
    public String getTipus(int id) {
        return nodes.get(id).getTipus();
    }
    
    //mirarse aquesta funcio
    public int getIdAresta(int node1, int node2) {
        return adj[node1][node2];
    }
    
    public float getValorNode(int id) {
        return nodes.get(id).getValor();
    }
    
    public String getTipusNode(int id) {
        return nodes.get(id).getTipus();
    }
    
    public String getNomNode(int id) {
        return nodes.get(id).getNom();
    }
    
    public float getValorAresta(int id) {
        return arestes.get(id).getValor();
    }
    
    public int GetID(String nom) {
        for (int i = 0; i < nodes.size(); ++i) {
            if (nodes.get(i).getNom().equals(nom)) return nodes.get(i).getId();
        }
        return -1;
    }
    
    public void ModNode(int id, float valor) {
        nodes.get(id).setValor(valor);
    }
    
    public void modAresta(int id, float valor) {
        arestes.get(id).setValor(valor);
    }
    
    //mirar funcio
    public void afegirAresta(String nom1, String nom2) {
        int a = this.GetID(nom1);
        int b = this.GetID(nom2);
        this.aA(a,b);
    }
    
    public void PrintNodes() {
        for(int i = 0; i < nodes.size(); ++i) {
            if(nodes.get(i) != null) {
                nodes.get(i).PrintNode();
            }
        } 
    }
    
    public void PrintArestes() {
        for(int i = 0; i < arestes.size(); ++i) {
            if(arestes.get(i) != null) {
                arestes.get(i).PrintarAresta();
            }
        }
    }
}
