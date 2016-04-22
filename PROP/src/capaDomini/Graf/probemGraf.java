/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;


/**
 *
 * @author aleixabrieprat
 */
public class probemGraf {
    
    public static void main(String[] Args) {
        Graf_PageRank pk = new Graf_PageRank();
        int[][] mat = pk.getMadj();
        for (int i=0; i<pk.size(); ++i) 
        {
            for (int j=0; j<pk.size(); ++j) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
