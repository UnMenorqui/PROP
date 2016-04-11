/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marc_
 */
public class PerfilArticle extends Perfil {
    
    static List<String> termes = new Vector<String>();
    static List<String> conferencies = new Vector<String>();
    static List<String> autors = new Vector<String>();
    static int quantitat_termes;
    static int quantitat_conf;
    static int quantitat_autors;
    
    
    public static int get_quantitat_termes() {
        return quantitat_termes;
    }
    
    public static int get_quantitat_conf() {
        return quantitat_conf;
    }
    
    public static int get_quantitat_autors() {
        return quantitat_autors;
    }
    
    public static List<String> autors_importants() {
        // obtenir_autors(autors,nom,quantitat_autors);
        return autors;
    }
    
    public static List<String> conferencies_importants() {
        // obtenir_conferencies(conferencies,nom,quantitat_conf);
        return conferencies;
    }
    
    public static List<String> termes_importants() {
        // obtenir_termes(termes,nom,quantitat_termes);
        return termes;
    }
    
    public static void crear_perfil_article() {
        autors_importants();
        conferencies_importants();
        termes_importants();
        System.out.println(nom);
        System.out.println();
        System.out.println("Conferencies més rellevants d'aquest article:");
        for (int i = 0; i < conferencies.size(); ++i) {
            String aux = conferencies.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Autors més rellevants d'aquest article:");
        for (int i = 0; i < autors.size(); ++i) {
            String aux = autors.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Termes més rellevants d'aquest article:");
        for (int i = 0; i < termes.size(); ++i) {
            String aux = termes.get(i);
            System.out.println(aux);
        }
    }
    
}