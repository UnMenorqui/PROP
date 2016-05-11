package capaDomini.Graf;

import java.util.*;

/**
 *
 * @author 
 */

public class Node {
    int id;
    String nom;
    String tipus;
    double valor;
    ArrayList<String> nodesadjacents;
      
    public Node (){
          id = 0;
          valor = 0;
          nom = null;
          tipus = null;
          nodesadjacents = new ArrayList<>();
    }
      
    public Node(int id, String nom, String tipus) {
        this.id = id;
        this.valor = 0;
        this.nom = nom;
        this.tipus = tipus;
        nodesadjacents = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
      
    public int getId(){
      return id; 
    }
      
    public String getNom() {
        return nom;
    }
      
    public String getTipus() {
        return tipus;
    }

    public double getValor() {
        return valor;
    }  
    
    public void afegirnodeadjacent(String nom) {
        nodesadjacents.add(nom);
    }
    
    public void esborrarnodeadjacent(String nom) {
        for (int i=0; i<nodesadjacents.size(); ++i) {
            if (nodesadjacents.get(i).equals(nom)) {
                nodesadjacents.remove(i);
            }
        }
    }
    
    public int getsize() {
        return nodesadjacents.size();
    }
    
    public ArrayList<String> getnodesadjacents() {
        return nodesadjacents;
    }
}
