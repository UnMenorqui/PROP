/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Usuaris;


import java.util.Scanner;

/**
 *
 * @author toni_
 * 
 * Aquesta classe, està definida per a poder portar a terme les
 * operacions que un administrador faria, tals como modificar usuaris,
 * eliminar-los, i altres operacions de gestionar la base de dades principals
 * i també el GRAF
 */

public class Administrador extends UsuariNormal {
    // Elimina usuari de la base de dades d'usuari
    /* 
    Pre:    Quan cridem aquesta funcio sabrem quin usuari
            es voldrà eliminar de la base de dades
    
    Post:   L'usuari amb l'identificador d'usuari proporcionat
            que serà el seu "user_identifier", serà eliminat
    */
    private void elimina_user(Integer user_identifier) {
        
    }
    
    // Modifica un usuari de la bases de dades d'usuari
    /* 
    Pre:    Quan cridem aquesta funcio sabrem quin usuari
            es voldrà eliminar de la base de dades
    
    Post:   L'usuari amb l'identificador d'usuari proporcionat
            que serà el seu "user_name", serà modificat
    */
    private void modifica_user(Integer user_identifier, String user_name, String password) {
        
    }
    
    
    /*  Funció que utilizara altres funciones per a
        per a gestionar els usuaris de la BD, podrà
        eliminar i modificar usuaris
    */
    /* 
    Pre:    Quan cridem aquesta funcio sabrem quin usuari
            es voldrà eliminar de la base de dades
    
    Post:   L'usuari amb l'identificador d'usuari proporcionat
            que serà el seu "user_name", serà gestionat
    */
    public void gestiona_users_BD() {
        int cas;
        Integer user_identifier;
        user_identifier = 1;
        String user_name,password;
        user_name = "toni";
        password = "abc";
        Scanner scan = new Scanner(System.in);
        cas = scan.nextInt();
        while (cas != 0) {
            switch (cas) {         
                case 1: elimina_user(user_identifier);

                case 2: modifica_user(user_identifier,user_name,password);

                cas = scan.nextInt();
            }
        }
    }
    
    /*  Utilitzarà funciones de la classe "GRAF", per a poder modificar 
        els arcs i els nodes.
    */
    /* 
    Pre:    Quan cridem aquesta funcio sabrem quin usuari
            es voldrà eliminar de la base de dades
    
    Post:   L'usuari amb l'identificador d'usuari proporcionat
            que serà el seu "user_name", serà gestionat
    */
    
    
    public void gestionaGraf() {
        int cas;
        Scanner scan = new Scanner(System.in);
        cas = scan.nextInt();
        while (cas != 0) {
            switch (cas) {
                // Les seguents necessiten d'un import
                // de les funcions basiques del Graf
                case 1: elimina_node();

                case 2: modifica_node();

                case 3: crea_node();

                case 4: eliminar_aresta();

                case 5: cosa_random();

                cas = scan.nextInt();

            }
        }
    }
    
    
    /*  Funció que utilitzarà funcions de la classe "BASE DE DADES"
        que permetrà a l'administrador gestionar la informació
        continguda a la base de dades principals
    */
    /*
    Pre: Cap
    
    Post: s'hauran portat a terme les operacions desitjades.
    */
    public void gestionaBD () {
        
    }
    
    
}
