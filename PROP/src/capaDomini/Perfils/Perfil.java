/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;

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
    
    public static void creacio_perfil(int marca, String entitat) {
        nom = entitat;
        switch(marca) {
            case 1: 
                PerfilAutor.crear_perfil_autor();
                break;
            case 2: 
                PerfilConf.crear_perfil_conf();
                break;
            case 3: 
                PerfilArticle.crear_perfil_article();
                break;
            case 4: 
                PerfilTerme.crear_perfil_terme();
                break;
        }
    }
    
}
