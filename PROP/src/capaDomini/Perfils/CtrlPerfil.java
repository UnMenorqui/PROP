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
public class CtrlPerfil {
    
    public void main (Graf_PageRank G) throws IOException {
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
            PerfilAutor p_autor = new PerfilAutor();
            PerfilConf p_conf = new PerfilConf();
            PerfilTerme p_terme = new PerfilTerme();
            PerfilArticle p_article = new PerfilArticle();
            switch(marca) {
                case 1:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    p_autor.set_name(sc.nextLine());
                    System.out.println("Introdueix la quantitat de conferencies:");
                    p_autor.set_quantitat_conf(sc.nextInt());
                    System.out.println("Introdueix la quantitat de termes:");
                    p_autor.set_quantitat_termes(sc.nextInt());
                    System.out.println("Introdueix la quantitat d'articles:");
                    p_autor.set_quantitat_articles(sc.nextInt());
                    System.out.println("Introdueix la quantitat de co-autors:");
                    p_autor.set_quantitat_autors(sc.nextInt());
                    p_autor.crear_perfil_autor(G);
                    break;
                case 2: 
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    p_conf.set_name(sc.nextLine());
                    System.out.println("Introdueix la quantitat d'autors:");
                    p_conf.set_quantitat_autors(sc.nextInt());
                    System.out.println("Introdueix la quantitat de termes:");
                    p_conf.set_quantitat_termes(sc.nextInt());
                    System.out.println("Introdueix la quantitat d'articles:");
                    p_conf.set_quantitat_articles(sc.nextInt());
                    p_conf.crear_perfil_conf(G);
                    break;
                case 3:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    p_article.set_name(sc.nextLine());
                    System.out.println("Introdueix la quantitat de conferencies:");
                    p_article.set_quantitat_conf(sc.nextInt());
                    System.out.println("Introdueix la quantitat d'autors:");
                    p_article.set_quantitat_autors(sc.nextInt());
                    System.out.println("Introdueix la quantitat de termes:");
                    p_article.set_quantitat_termes(sc.nextInt());
                    p_article.crear_perfil_article(G);
                    break;
                case 4:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    sc.nextLine();
                    p_terme.set_name(sc.nextLine());
                    System.out.println("Introdueix la quantitat de conferencies:");
                    p_terme.set_quantitat_conf(sc.nextInt());
                    System.out.println("Introdueix la quantitat de articles:");
                    p_terme.set_quantitat_articles(sc.nextInt());
                    System.out.println("Introdueix la quantitat d'autors:");
                    p_terme.set_quantitat_autors(sc.nextInt());
                    p_terme.crear_perfil_terme(G);
                    break;
                case 5:
                    bool = true;
                    break;
            } 
        }
        sc.close();
    }
}
