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
public class PerfilAutor extends Perfil {
    
    List<String> termes = new Vector<String>();
    List<String> conferencies = new Vector<String>();
    List<String> articles = new Vector<String>();
    int quantitat_termes;
    int quantitat_conf;
    int quantitat_articles;
    
    
    public int get_quantitat_termes() {
        return quantitat_termes;
    }
    
    public int get_quantitat_conf() {
        return quantitat_conf;
    }
    
    public int get_quantitat_articles() {
        return quantitat_articles;
    }
    
    public List<String> articles_importants() {
        // obtenir_autors(autors,nom,quantitat_autors);
        return articles;
    }
    
    public List<String> conferencies_importants() {
        // obtenir_conferencies(conferencies,nom,quantitat_conf);
        return conferencies;
    }
    
    public List<String> termes_importants() {
        // obtenir_termes(termes,nom,quantitat_termes);
        return termes;
    }
    
    public void crear_perfil() {
        articles_importants();
        conferencies_importants();
        termes_importants();
        System.out.println(nom);
        System.out.println("");
        System.out.println("Conferencies més rellevants d'aquest autor:");
        for (int i = 0; i < conferencies.size(); ++i) {
            String aux = conferencies.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Articles més rellevants d'aquest autor:");
        for (int i = 0; i < articles.size(); ++i) {
            String aux = articles.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Termes més rellevants d'aquest autor:");
        for (int i = 0; i < termes.size(); ++i) {
            String aux = termes.get(i);
            System.out.println(aux);
        }
    }
    
}
