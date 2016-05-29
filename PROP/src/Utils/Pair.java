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
    private String first;
    private double second;
    
   public Pair() {
       first = "";
       second = 0;
   }
   
   public Pair (String first, double second) {
       this.first = first;
       this.second = second;
   }
   public void SetF(String first) {
       this.first = first;
   }
   
   public void SetS(double second) {
       this.second = second;
   }
   
   public void SetP(String first, double second) {
       this.first = first;
       this.second = second;
   }
   
   public String GetF() {
       return first;
   }
   
   public double GetS() {
       return second;
   }

    @Override
    public int compareTo(Object o) {
        Pair p2 = (Pair)o;
        if (this.first == p2.first) return 0;
        else return this.second < p2.second ? 1 : -1;
    }


}