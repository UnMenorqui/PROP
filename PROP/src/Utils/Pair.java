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
    private short first;
    private short second;
    
   public Pair() {
       first = 0;
       second = 0;
   }
   
   public Pair (short first, short second) {
       this.first = first;
       this.second = second;
   }
   public void SetF(short first) {
       this.first = first;
   }
   
   public void SetS(short second) {
       this.second = second;
   }
   
   public void SetP(short first, short second) {
       this.first = first;
       this.second = second;
   }
   
   public short GetF() {
       return first;
   }
   
   public short GetS() {
       return second;
   }

    @Override
    public int compareTo(Object o) {
        Pair p2 = (Pair)o;
        if (this.first == p2.first) return 0;
        else return this.first < p2.first ? 1 : -1;
    }


}