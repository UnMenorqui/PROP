/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.Graf.Graf_PageRank;
import java.util.ArrayList;
import capaDomini.consulta.Consulta;
import capaDomini.consulta.CtrlHistorial;
import java.util.Scanner;

/**
 *
 * @author marc_
 */
public class PerfilArticle extends Perfil {
    
    public ArrayList<String> termes = new ArrayList<>();
    public ArrayList<String> conferencies = new ArrayList<>();
    public ArrayList<String> autors = new ArrayList<>();
    public short quantitat_termes;
    public short quantitat_conf;
    public short quantitat_autors;
    
    
    public short get_quantitat_termes() {
        return quantitat_termes;
    }
    
    public void set_quantitat_termes(short q_terme) {
        quantitat_termes = q_terme;
    }
    
    public short get_quantitat_conf() {
        return quantitat_conf;
    }
    public void set_quantitat_conf(short q_conferencia) {
        quantitat_conf = q_conferencia;
    }
    
    public short get_quantitat_autors() {
        return quantitat_autors;
    }
    public void set_quantitat_autors(short q_autor) {
        quantitat_autors = q_autor;
    }
    
    public void crear_perfil_article(Graf_PageRank G, boolean usuari) {
        Consulta cs = new Consulta();
        cs.obtenir_autors(autors,nom,quantitat_autors,G);
        cs.obtenir_termes(termes,nom,quantitat_termes,G);
        cs.obtenir_conferencies(conferencies,nom,quantitat_conf,G);
        if(termes.size()+conferencies.size()+autors.size() == 0) {
            System.out.println("No s'ha trobat cap article amb aquest nom.");
        } else {
            System.out.println(nom);
            System.out.println();
            System.out.println("Conferencies més rellevants d'aquest article:");
            for (short i = 0; i < conferencies.size(); ++i) {
                String aux = conferencies.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_conf > conferencies.size()) {
                System.out.println();
                System.out.println("No hi ha tantes conferencies per la quantitat desitjada");
                System.out.println();
            }
            System.out.println("");
            System.out.println("Autors més rellevants d'aquest article:");
            for (short i = 0; i < autors.size(); ++i) {
                String aux = autors.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_autors > autors.size()) {
                System.out.println("No hi ha tants autors per la quantitat desitjada");
            }
            System.out.println("");
            System.out.println("Termes més rellevants d'aquest article:");
            for (short i = 0; i < termes.size(); ++i) {
                String aux = termes.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_termes > termes.size()) {
                System.out.println("No hi ha tants termes per la quantitat desitjada");
            }
            if (usuari) {
                System.out.println("Vols Guardar la Consulta?(S/N)");
                Scanner sc = new Scanner(System.in); 
                String sino = sc.next();
                switch(sino) {
                    case "S":
                        CtrlHistorial hist = new CtrlHistorial();
                        hist.afegirCerca(nom,G.GetID(nom),G.getTipusNode(G.GetID(nom)));


                }

            }
            autors.clear();
            conferencies.clear();
            termes.clear();
        }
    }
    
}
