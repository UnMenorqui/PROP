/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;

/**
 *
 * @author marc.capdevila.canadell
 */
public class Aresta {
    
    private int id;
    private float valor;
    private int node1;
    private int node2;
    
    public Aresta(int id, int node1, int node2) {
        this.id=id;
        this.valor = 0;
        this.node1 = node1;
        this.node2 = node2;
  }
    //Pre: Donat un id,valor i dos nodes
    //Post: Crea una aresta
    
    public int getNode1(){
    //Pre: True
    //Post: retorna un id del node1 que relaciona l'aresta
    
        return node1;
    }

    public int getId() {
        return id;
    }
    
    public int getNode2(){
    //Pre: True
    //Post: retorna un id del node2 que relaciona l'aresta
    
        return node2;
    }    
    public float getValor(){
    //Pre: True
    //Post: retorna els valor que se li ha assignat a l'aresta
        return valor;
    }
    public void setValor(float val){
    //Pre: True
    //Post: Canvia el valor de l'aresta per val
    
        this.valor = val;
    }
    public boolean compararAresta(int idNode1, int idNode2){
    //Pre: True
    //Post: compara el id1 i el id2 i retorna true si son iguals, sino, retorna false
        return idNode1 == node1 && idNode2 == node2;
    }
    
    public void PrintarAresta() {
        System.out.println("Aresta que conecta el node " + node1 + " amb el node " + node2 + " i el seu valor es: " + valor);
    }
}
