/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;

import java.util.Scanner;

/**
 *
 * @author marc_
 */
public class DriverPerfil {
    
    public static void main (String[] args) {
        Perfil perfil = new Perfil();
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
            int num;
            String entitat;
            PerfilAutor p_autor = new PerfilAutor();
            PerfilConf p_conf = new PerfilConf();
            PerfilTerme p_terme = new PerfilTerme();
            PerfilArticle p_article = new PerfilArticle();
            switch(marca) {
                case 1:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    entitat = sc.next();
                    System.out.println("Introdueix la quantitat de conferencies:");
                    num = sc.nextInt();
                    p_autor.quantitat_conf = num;
                    System.out.println("Introdueix la quantitat de termes:");
                    num = sc.nextInt();
                    p_autor.quantitat_termes = num;
                    System.out.println("Introdueix la quantitat d'articles:");
                    num = sc.nextInt();
                    p_autor.quantitat_articles = num;
                    p_autor.creacio_perfil(marca,entitat);
                    break;
                case 2: 
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    entitat = sc.next();
                    System.out.println("Introdueix la quantitat d'autors:");
                    num = sc.nextInt();
                    p_conf.quantitat_autors = num;
                    System.out.println("Introdueix la quantitat de termes:");
                    num = sc.nextInt();
                    p_conf.quantitat_termes = num;
                    System.out.println("Introdueix la quantitat d'articles:");
                    num = sc.nextInt();
                    p_conf.quantitat_articles = num;
                    p_conf.creacio_perfil(marca,entitat);
                    break;
                case 3:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    entitat = sc.next();
                    System.out.println("Introdueix la quantitat de conferencies:");
                    num = sc.nextInt();
                    p_article.quantitat_conf = num;
                    System.out.println("Introdueix la quantitat d'autors:");
                    num = sc.nextInt();
                    p_article.quantitat_autors = num;
                    System.out.println("Introdueix la quantitat de termes:");
                    num = sc.nextInt();
                    p_article.quantitat_termes = num;
                    p_article.creacio_perfil(marca,entitat);
                    break;
                case 4:
                    System.out.println("Introdueix l'entitat que desitjes cercar:");
                    entitat = sc.next();
                    System.out.println("Introdueix la quantitat de conferencies:");
                    num = sc.nextInt();
                    p_terme.quantitat_conf = num;
                    System.out.println("Introdueix la quantitat de articles:");
                    num = sc.nextInt();
                    p_terme.quantitat_articles = num;
                    System.out.println("Introdueix la quantitat d'autors:");
                    num = sc.nextInt();
                    p_terme.quantitat_autors = num;
                    p_terme.creacio_perfil(marca,entitat);
                    break;
                case 5:
                    bool = true;
                    break;
            } 
        }
        sc.close();
    }
}
