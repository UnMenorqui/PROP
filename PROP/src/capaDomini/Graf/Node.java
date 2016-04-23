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
public class Node{

      int id;
      float valor;
      String nom;
      String tipus;
      
      public Node (){
          id = 0;
          valor = 0;
          nom = null;
          tipus = null;
      }
      
      public Node(int id, String nom, String tipus) {
        this.id = id;
        this.valor = 0;
        this.nom = nom;
        this.tipus = tipus;
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
      
      public int getId(){
      //Pre:True
      //Post: Retorna el id del node que crida la funcio.
        return id; 
      }
      
      public String getNom() {
          return nom;
      }
      
      public String getTipus() {
          return tipus;
      }
      
      public void PrintNode() {
          System.out.println("El node amb id: " + id + " te per nom: " + nom + " el seu tipus es: " + tipus + " i el seu valor es " + valor);
      }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

      
}
