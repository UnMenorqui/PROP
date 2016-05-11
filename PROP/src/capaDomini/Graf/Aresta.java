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
    
    private int node1;
    private int node2;
    
    public Aresta(int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
    
    public int getNode1(){
        return node1;
    }
    
    public int getNode2(){
        return node2;
    } 
    
}
