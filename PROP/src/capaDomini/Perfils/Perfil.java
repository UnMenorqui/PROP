/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;

import capaDomini.Graf.Graf_PageRank;
import java.util.Scanner;

/**
 *
 * @author marc_
 */
public class Perfil {
    
    public static String nom; // nom de l'entitat (article,autor,conferencia,terme)
    
    
    public Perfil() {
        
    }
    
    public static void set_name(String nom1) {
        nom = nom1;
    }
    
    public static String get_name() {
        return nom;
    }
    
    public void creacio_perfil(int marca, String entitat, Graf_PageRank G) {
        nom = entitat;
        PerfilAutor perfilautor = new PerfilAutor();
        Scanner sc = new Scanner(System.in);
        switch(marca) {
            case 1: 
                perfilautor.crear_perfil_autor(G);
                break;
            case 2: 
                PerfilConf.crear_perfil_conf(G);
                break;
            case 3: 
                PerfilArticle.crear_perfil_article(G);
                break;
            case 4: 
                PerfilTerme.crear_perfil_terme(G);
                break;
        }
    }
    
}
