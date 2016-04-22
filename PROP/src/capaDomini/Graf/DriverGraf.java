/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;

import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class DriverGraf {
    
    public void main (String args[]) {
        double matriu [][] = new double[13][13];
        for (int i = 0; i < 13; ++i) {
            for (int j = 0; j < 13; ++j) {
                matriu[i][j] = -1;
            }
        }
        
        matriu[0][5] = 20;
        matriu[1][5] = 21;
        matriu[2][5] = 22;
        matriu[3][6] = 23;
        matriu[0][7] = 24;
        matriu[4][7] = 25;
        matriu[5][8] = 26;
        matriu[6][8] = 27;
        matriu[5][9] = 28;
        matriu[7][9] = 29;
        matriu[6][11] = 30;
        matriu[7][12] = 31;
        
        
        matriu[5][0] = 20;
        matriu[5][1] = 21;
        matriu[5][2] = 22;
        matriu[6][3] = 23;
        matriu[7][0] = 24;
        matriu[7][4] = 25;
        matriu[8][5] = 26;
        matriu[8][6] = 27;
        matriu[9][5] = 28;
        matriu[9][7] = 29;
        matriu[11][6] = 30;
        matriu[12][7] = 31;
        

        
        
        
    }
    
    
    public int simula_id (String nom) {
        int id;
        System.out.print("Entra l'identificador de simulació: ");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        return id;
    }
    
    public String simula_nom_entitat (int id) {
        String nom;
        System.out.print("Entra el nom de simulació: ");
        Scanner sc = new Scanner(System.in);
        nom = sc.next();
        return nom;
    }
    
}