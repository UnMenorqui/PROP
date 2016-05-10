package capaDomini.Graf;


/**
 *
 * @author 
 */

public class Node {
    int id;
    double valor;
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
    
    public void PrintNode() {
        System.out.println("El node amb id: " + id + " te per nom: " + nom + " el seu tipus es: " + tipus + " i el seu valor es " + valor);
    }
}
