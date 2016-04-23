/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author aleixabrieprat
 */

public class Pair implements Comparable {
    private int first;
    private int second;
    
   public Pair() {
       first = 0;
       second = 0;
   }
   
   public Pair (int first, int second) {
       this.first = first;
       this.second = second;
   }
   public void SetF(int first) {
       this.first = first;
   }
   
   public void SetS(int second) {
       this.second = second;
   }
   
   public void SetP(int first, int second) {
       this.first = first;
       this.second = second;
   }
   
   public int GetF() {
       return first;
   }
   
   public int GetS() {
       return second;
   }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}