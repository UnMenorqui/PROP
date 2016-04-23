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
    
<<<<<<< Updated upstream
    public void main (Graf_PageRank G) throws IOException {
        System.out.println("Per a la creació d'un perfil, determina el tipus:");
        System.out.println("Marca 1 si vols un perfil d'autor");
        System.out.println("Marca 2 si vols un perfil d'una conferencia");
        System.out.println("Marca 3 si vols un perfil d'un article");
        System.out.println("Marca 4 si vols un perfil d'un terme"); 
        System.out.println("Marca 5 si vols un perfil general"); 
        System.out.println("Marca 6 si vols surtir de la consulta");
=======
    public void main (Graf_PageRank G) {
        
>>>>>>> Stashed changes
        Scanner sc = new Scanner(System.in);
        CtrlPerfils ctrl = new CtrlPerfils();
        int marca;
        boolean bool = false;
        boolean primer = false;
        while (!bool) {
            System.out.println("Per a la creació d'un perfil, determina el tipus:");
            System.out.println("Marca 1 si vols un perfil d'autor");
            System.out.println("Marca 2 si vols un perfil d'una conferencia");
            System.out.println("Marca 3 si vols un perfil d'un article");
            System.out.println("Marca 4 si vols un perfil d'un terme"); 
            System.out.println("Marca 5 si vols surtir de la consulta");
            if (!primer) {
                primer = true;
            }
            else {
                System.out.println();
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
                    ctrl.crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies, G);
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
                    ctrl.crear_perfil_conferencia(nom, q_articles, q_autors, q_termes, G);
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
                    ctrl.crear_perfil_article(nom, q_autors, q_termes, q_conferencies, G);
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
                    ctrl.crear_perfil_terme(nom, q_articles, q_autors, q_conferencies, G);
                    break;
                case 5:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    nom = sc.nextLine();
                    String tipus = G.getTipusNode(G.getID(nom));
                    switch(tipus) {
                        case "Autor":
                            System.out.println("Introdueix la quantitat de conferencies:");
                            q_conferencies = sc.nextInt();
                            System.out.println("Introdueix la quantitat de termes:");
                            q_termes = sc.nextInt();
                            System.out.println("Introdueix la quantitat d'articles:");
                            q_articles = sc.nextInt();
                            System.out.println("Introdueix la quantitat de co-autors:");
                            q_autors = sc.nextInt();
                            ctrl.crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies, G);
                            break;
                        
                        case "Conferencia":
                            System.out.println("Introdueix la quantitat d'autors:");
                            q_autors = sc.nextInt();
                            System.out.println("Introdueix la quantitat de termes:");
                            q_termes = sc.nextInt();
                            System.out.println("Introdueix la quantitat d'articles:");
                            q_articles = sc.nextInt();
                            ctrl.crear_perfil_conferencia(nom, q_articles, q_autors, q_termes, G);
                            break;
                            
                        case "Article":
                            System.out.println("Introdueix la quantitat de conferencies:");
                            q_conferencies = sc.nextInt();
                            System.out.println("Introdueix la quantitat d'autors:");
                            q_autors = sc.nextInt();
                            System.out.println("Introdueix la quantitat de termes:");
                            q_termes = sc.nextInt();
                            ctrl.crear_perfil_article(nom, q_autors, q_termes, q_conferencies, G);
                            break;
                            
                        default:
                            System.out.println("Introdueix la quantitat de conferencies:");
                            q_conferencies = sc.nextInt();
                            System.out.println("Introdueix la quantitat de articles:");
                            q_articles = sc.nextInt();
                            System.out.println("Introdueix la quantitat d'autors:");
                            q_autors = sc.nextInt();
                            ctrl.crear_perfil_terme(nom, q_articles, q_autors, q_conferencies, G);
                            break;
                    }
                    break;
                case 6:
                    bool = true;
                    break;
            }
        }
        //sc.close();
        
    }
}
