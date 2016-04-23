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
    
    protected String nom; // nom de l'entitat (article,autor,conferencia,terme)
    
    public Perfil() {
        
    }
    
    public void set_name(String nom1) {
        nom = nom1;
    }
    
    public String get_name() {
        return nom;
    } 
}
