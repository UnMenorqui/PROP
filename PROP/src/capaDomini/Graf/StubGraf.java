/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class StubGraf {
    
    
    private int numTotalNode;
    
    private int numTotalAresta;
    //ultim id donat a un node
    private int numFinalNode;
    
    //ultim id donat a una aresta
    private int numFinalAresta;
    
    private ArrayList<Aresta> arestes;
    
    private ArrayList<Node> nodes;
    //estructuraQueConteElGraf;
    private int[][] adj;
    //S'utilitzarà una matriu d'adjacencia per implementar el graf 
    private void initMadj() {
        for(int i = 0; i < numTotalNode; ++i) {
            for (int j = 0; j < numTotalNode; ++j) {
                adj[i][j] = -1;
            }
        }
    }
    
    private void aA(int idNode1, int idNode2) {
        Aresta a = new Aresta(numFinalAresta,idNode1,idNode2);
        arestes.add(a);
        adj[idNode1][idNode2] = numFinalAresta;
        adj[idNode2][idNode1] = numFinalAresta;
        ++numFinalAresta;
    }
    
    public int matriu[][] = new int[13][13]; 
    
    public StubGraf() {
        for (int i = 0; i < 13; ++i) {
            for (int j = 0; j < 13; ++j) {
                matriu[i][j] = -1;
            }
        }
        
        matriu[0][5] = 20;
        matriu[1][5] = 21;
        matriu[2][5] = 22;
        matriu[3][6] = 23;
        matriu[0][7] = 24;
        matriu[4][7] = 25;
        matriu[5][8] = 26;
        matriu[6][8] = 27;
        matriu[5][10] = 28;
        matriu[7][9] = 29;
        matriu[6][11] = 30;
        matriu[7][12] = 31;
        
        
        matriu[5][0] = 20;
        matriu[5][1] = 21;
        matriu[5][2] = 22;
        matriu[6][3] = 23;
        matriu[7][0] = 24;
        matriu[7][4] = 25;
        matriu[8][5] = 26;
        matriu[8][6] = 27;
        matriu[10][5] = 28;
        matriu[9][7] = 29;
        matriu[11][6] = 28;
        matriu[12][7] = 31; 
    }
    
    public int simula_id (String nom) {
        int id;
        System.out.print("Entra l'identificador de simulació: ");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        return id;
    }
    
    public int getID(String nom) {
        int id;
        switch(nom) {
            case "Souad Hadjres": 
                id = 0;
                break;
            case "Yan Zhang":
                id = 1;
                break;
            case "David Hogg":
                id = 2;
                break;
            case "Martial Hebert":
                id = 3;
                break;
            case "Gady Agam":
                id = 4;
                break;
            case "Some Philosophical Problems with Formal Learning Theory.":
                id = 5;
                break;
            case "Terminological Cycles in KL-ONE-based Knowledge Representation Languages.":
                id = 6;
                break;
            case "Integrating Description Logics and Action Formalisms: First Results.":
                id = 7;
                break;
            case "AAAI":
                id = 8;
                break;
            case "CIKM":
                id = 9;
                break;
            case "some":
                id = 10;
                break;
            case "terminological":
                id = 11;
                break;
            case "integrating":
                id = 12;
                break;
            default:
                id = -1;
        }
        return id;
    }
    
    public String getNom(int id) {
        String nom;
        switch(id) {
            case 0:
                nom = "Souad Hadjres";
                break;
            case 1:
                nom = "Yan Zhang";
                break;
            case 2:
                nom = "David Hogg";
                break;
            case 3:
                nom = "Martial Hebert";
                break;
            case 4:
                nom = "Gady Agam";
                break;
            case 5:
                nom = "Some Philosophical Problems with Formal Learning Theory.";
                break;
            case 6:
                nom = "Terminological Cycles in KL-ONE-based Knowledge Representation Languages.";
                break;
            case 7:
                nom = "Integrating Description Logics and Action Formalisms: First Results.";
                break;
            case 8:
                nom = "AAAI";
                break;
            case 9:
                nom = "CIKM";
                break;
            case 10:
                nom = "some";
                break;
            case 11:
                nom = "terminological";
                break;
            case 12:
                nom = "integrating";
                break;
            default:
                nom = "";
        }
        return nom;
    }
    
    public int[][] getMadj() {
        return matriu;
    }
    
    public int size() {
        return 13;
    }
    
    public String getTipusNode(int id) {
        if (id <= 4) return "Autor";
        else if (id <= 7) return "Article";
        else if (id <= 9) return "Conferencia"; 
        return "Terme";
    }
    
    public String simula_nom_entitat (int id) {
        String nom;
        System.out.print("Entra el nom de simulació: ");
        Scanner sc = new Scanner(System.in);
        nom = sc.next();
        return nom;
    }
    
    public void afegirNode(String tipus,String nom) {
        Node n = new Node(numFinalNode,nom,tipus);
        ++numFinalNode;
        nodes.add(n);
    }
    
    
    public void eliminarNode(String nomNode) {
        int id = getID(nomNode);
        nodes.remove(id);
        for(int i = 0; i < adj.length; ++i) {
            adj[id][i] = -1;
            adj[i][id] = -1;
        }
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        int node1, node2;
        node1 = getID(nom1);
        node2 = getID(nom2);
        arestes.remove(adj[node1][node2]);
        adj[node1][node2] = -1;
        adj[node2][node1] = -1;
    }
    
    public void afegirAresta(String nom1, String nom2) {
        int a = this.getID(nom1);
        int b = this.getID(nom2);
        this.aA(a,b);
    }
    
}