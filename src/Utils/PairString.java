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
public class PairString {
    private Integer first;
    private String second;
    
   public PairString() {
       first = 0;
       second = "";
   }
   
   public PairString(int first, String second) {
       this.first = first;
       this.second = second;
   }
   public void SetF(int first) {
       this.first = first;
   }
   
   public void SetS(String second) {
       this.second = second;
   }
   
   public void SetP(int first, String second) {
       this.first = first;
       this.second = second;
   }
   
   public int GetF() {
       return first;
   }
   
   public String GetS() {
       return second;
   }
}
