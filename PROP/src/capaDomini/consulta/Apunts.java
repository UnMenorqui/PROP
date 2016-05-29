/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

/**
 *
 * @author rogia
 */
public class Apunts {
    
    String nom;
    int id;
    String tipus;
    
    public Apunts(int i, String n, String t) {
        nom = n;
	id = i;
	tipus = t;
    }

    public String getNom() {
	String r = nom;
	return r;
    }
    public int getID() {
	return id;
    }
    public String getTipus() {
	String r = nom;
	return r;
    }
}
