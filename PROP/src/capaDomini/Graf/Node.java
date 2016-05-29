package capaDomini.Graf;

import Utils.PairString;
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
    ArrayList<PairString> nodesadjacents;
      
    public Node (){
          id = 0;
          valor = 0;
          nom = null;
          tipus = null;
          nodesadjacents = new ArrayList<>();
    }
      
    public Node(int id, String nom, String tipus) {
        this.id = id;
        this.nom = nom;
        this.tipus = tipus;
        this.valor = 0;
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
    
    public void afegirnodeadjacent(int nom, String tipus) {
        PairString pa = new PairString(nom,tipus);
        nodesadjacents.add(pa);
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
    
    public ArrayList<PairString> getnodesadjacents() {
        return nodesadjacents;
    }
    
    public int nodeiessimFirst(int i) {
        return nodesadjacents.get(i).GetF();
    }
    
    public String nodeiessimSecond(int i) {
        return nodesadjacents.get(i).GetS();
    }
}
