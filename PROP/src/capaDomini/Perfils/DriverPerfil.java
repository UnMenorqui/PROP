/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;

import capaDomini.Graf.Graf_PageRank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author marc_
 */
public class DriverPerfil {
    
    public void main () throws IOException {
        System.out.println("Per a la creació d'un perfil, determina el tipus:");
        System.out.println("Marca 1 si vols un perfil d'autor");
        System.out.println("Marca 2 si vols un perfil d'una conferencia");
        System.out.println("Marca 3 si vols un perfil d'un article");
        System.out.println("Marca 4 si vols un perfil d'un terme"); 
        Scanner sc = new Scanner(System.in);
        int marca;
        boolean bool = false;
        boolean primer = false;
        while (!bool) {
            if (!primer) {
                primer = true;
            }
            else {
                System.out.println("Torna a introduir el tipus:");
            }
            marca = sc.nextInt();
            String nom = "";
            int q_articles = 0;
            int q_termes = 0;
            int q_conferencies = 0;
            int q_autors = 0;
            switch(marca) {
                case 1:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    nom = sc.nextLine();
                    System.out.println("Introdueix la quantitat de conferencies:");
                    q_conferencies = sc.nextInt();
                    System.out.println("Introdueix la quantitat de termes:");
                    q_termes = sc.nextInt();
                    System.out.println("Introdueix la quantitat d'articles:");
                    q_articles = sc.nextInt();
                    System.out.println("Introdueix la quantitat de co-autors:");
                    q_autors = sc.nextInt();
                    //Passar a controlador
                    break;
                case 2: 
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    nom = sc.nextLine();
                    System.out.println("Introdueix la quantitat d'autors:");
                    q_autors = sc.nextInt();
                    System.out.println("Introdueix la quantitat de termes:");
                    q_termes = sc.nextInt();
                    System.out.println("Introdueix la quantitat d'articles:");
                    q_articles = sc.nextInt();
                    //Passar a controlador
                    break;
                case 3:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    nom = sc.nextLine();
                    System.out.println("Introdueix la quantitat de conferencies:");
                    q_conferencies = sc.nextInt();
                    System.out.println("Introdueix la quantitat d'autors:");
                    q_autors = sc.nextInt();
                    System.out.println("Introdueix la quantitat de termes:");
                    q_termes = sc.nextInt();
                    //Passar a controlador
                    break;
                case 4:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    nom = sc.nextLine();
                    System.out.println("Introdueix la quantitat de conferencies:");
                    q_conferencies = sc.nextInt();
                    System.out.println("Introdueix la quantitat de articles:");
                    q_articles = sc.nextInt();
                    System.out.println("Introdueix la quantitat d'autors:");
                    q_autors = sc.nextInt();
                    //Passar a controlador
                    break;
                case 5:
                    bool = true;
                    break;
            } 
        }
        sc.close();
    }
}
