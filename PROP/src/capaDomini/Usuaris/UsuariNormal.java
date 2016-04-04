/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Usuaris;

/**
 *
 * @author toni_
 * 
 * Classe d'un usuari normal, aquesta conte els atributs
 * principals de l'usuari, com nom de l'usuari, contrasenya, identificador
 * assignat, etc..
 * A mes, conté també les funcions bàsiques per a gestionar aquests atributs,
 * també anomenades "getters" i "setters", entre d'altres com guardar perfil.
 */

public class UsuariNormal extends UsuariConvidat {
    private String user_name;
    private String Nom;
    private String password;
    
    /*  Utilitza la funció de la Classe Apunts, que guarda
        el perfil resultant d'una cerca a una base de dades d'apunts.
    */
    /* 
    Pre:    S'ha de saber l'identificador de l'usuari que guardarà
            l'informació.
    
    Post:   El perfil ha quedat guardat a la base de dades d'apunts.
    */
    public void guarda_perfil(){
        
    }
    /*  Consultarà l'historial de cercques que s'han portat a terme
    */
    /* 
    Pre:    S'ha de saber l'identificador de l'usuari que guardarà
            l'informació.
    
    Post:   Retornarà totes les consultes guardades, amb el nom que se
            se li haurà donat a la consulta.
    */
    public String[] consulta_historial(Integer user_identifier) {
        String hola[] = null;
        hola[1] = "hola";
        hola[2] = " tu";
        return hola;
    }
    
    /*  Retorna el nom de l'usuari.
    */
    /* 
    Pre:    Cap.
    
    Post:   Retorna el nom d'usuari.
    */
    public String consulta_username() {
        return user_name;
    }
    
    /*  Retorna la contrasenya.
    */
    /* 
    Pre:    Cap.
    
    Post:   Retorna la contrasenya.
    */
    public String consulta_password() {
        return password; 
    }
    
    /*  Retorna l'identificador de l'usuari.
    */
    /* 
    Pre:    Cap.
    
    Post:   Retorna l'identificador de l'usuari.
    */
    public String consulta_Nom() {
        return Nom;
    }
    
    /*  Modifica l'atribut user_identifier.
    */
    /* 
    Pre:    Cap.
    
    Post:   user_identifier ha quedat modificat.
    */
    public void modifica_Nom(String nom) {
        Nom = nom;
    }
    
    /*  Modifca el nom de l'usuari.
    */
    /* 
    Pre:    Cap.
    
    Post:   El nom de l'usuari ha quedat modificat.
    */
    public void modifica_user(String user) {
        user_name = user;
    }
    
    /*  Modifica l'atribut password.
    */
    /* 
    Pre:    Cap.
    
    Post:   password ha quedat modificada per unaltra.
    */
    public void modifica_pass(String pass) {
        password = pass;
    }
    
    /*  Comprova que el password sigui el correcte.
    */
    /* 
    Pre:    Cap.
    
    Post:   Retorna true si es correcte, else false.
    */
    public boolean correct_pass(String pass) {
        return true;
    }
    
    /*  Comprova que l'usuari existeix a la base de dades.
    */
    /* 
    Pre:    Cap.
    
    Post:   Retorna true si existex, else false.
    */
    public boolean user_exists(String pass) {
        return true;
    }
}
