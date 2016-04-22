/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;

/**
 *
 * @author Toni
 */
public class DriverGraf {
    
    public void main (String args[]) {
        double matriu [][] = new double[4][11];
        matriu[0][0] = -1.0;
        matriu[0][1] = 100.;
        matriu[0][2] = 101.;
        matriu[0][3] = 102.;
        matriu[0][4] = 103.;
        matriu[0][5] = 104.;
        matriu[0][6] = 51.;
        matriu[0][7] = 52.;
        matriu[0][8] = 70.;
        matriu[0][9] = 71.;
        matriu[0][10] = 72.0;
        
        
        matriu[1][0] = 1.;
        matriu[1][1] = 0.5;
        matriu[1][2] = 0.5;
        matriu[1][3] = 0.;
        matriu[1][4] = 0.;
        matriu[1][5] = 0.;
        matriu[1][6] = 1.;
        matriu[1][7] = 0.;
        matriu[1][8] = 1.;
        matriu[1][9] = 0.;
        matriu[1][10] = 0.;
        
        
        matriu[2][0] = 2.;
        matriu[2][1] = 0.;
        matriu[2][2] = 0.;
        matriu[2][3] = 1.;
        matriu[2][4] = 0.;
        matriu[2][5] = 0.;
        matriu[2][6] = 1.;
        matriu[2][7] = 0.;
        matriu[2][8] = 0.;
        matriu[2][9] = 1.;
        matriu[2][10] = 0.;
        
        
        matriu[3][0] = 3.0;
        matriu[3][1] = 0.33;
        matriu[3][2] = 0.;
        matriu[3][3] = 0.;
        matriu[3][4] = 0.33;
        matriu[3][5] = 0.33;
        matriu[3][6] = 0.;
        matriu[3][7] = 1.;
        matriu[3][8] = 0.;
        matriu[3][9] = 0.;
        matriu[3][10] = 1.0;
        
        
        String[] Info = new String[13];
        
        
        
    }
    /*  Donat un node retornarà la probabilitat d'aquest node en relació 
        a un article. IDEA: si es desitjen buscar autors mes importants en funció d'un terme
        només d'han de mirar els articles més importants relacionats amb un terme, i un cop
        allí, per cada article important, els autors més importants de cada article.
    */
    public static double return_prob(Double node) {
        double prob = 0.;
        return prob;
    }
    
}