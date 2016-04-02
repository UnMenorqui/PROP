/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package capaDomini.Usuaris;

import java.io.BufferedWriter;
import java.io.File;

/**
 *
 * @author toni_
 * 
 * Aquesta classe està dedicada exlcusivament per a crear la
 * Base de Dades d'usuaris, les operacions seran tals com
 * carregar la BD, codificar la BD en un arxiu, modificar-la, etc..
 * 
 * 
 * 
 */

public class CtrlUsuaris {
    public String ruta_BD;
    
    // Carregarà la Base de Dades
    /* 
    Pre:    Cap.
    
    Post:   Base de Dades carregada.
    */
    protected static void carrega() {
        
    }
    
    /*  Codificarà la base de dades com un arxiu, per a poder utilittzar-la
        i així guardar tota la informació.
    */
    /* 
    Pre:    Cap.
    
    Post:   Base de Dades carregada.
    */
    protected boolean codifica() {
        File f = null;
        String v;
        boolean bool = false;
         // create new file
        f = new File("Usuaris.txt");

        // pathname string from abstract pathname
        v = f.getPath();
        ruta_BD = v;

        // true if the file path exists
        bool = f.exists();

        // if file exists
        if (bool) return true;
        return false;
    }
    
    /*  Utilitzarà l'arixiu creat anteriorment com a Base de Dades
        per a escriure sobre aquest, i/o modificarl-o, poguent així
        afegir dades noves.
    */
    /* 
    Pre:    Cap.
    
    Post:   Modificació de la Base de Dades.
    */
    protected void modifica_arxiu() {
        BufferedWriter bw;
        String ruta = ruta_BD;
        //if(ruta.exists()) {
        //} 
        //else {
         //}
    }
}
