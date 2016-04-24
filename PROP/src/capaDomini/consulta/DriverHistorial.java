/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import capaDomini.Graf.Graf_PageRank;
import capaDomini.Perfils.CtrlPerfils;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rogia
 */
public class DriverHistorial {
    public void main () {
        Graf_PageRank G = new Graf_PageRank();
        Historial historial = new Historial();
        int opcio;
        escriure_opcions();
        Scanner sc = new Scanner(System.in);
        opcio = sc.nextInt();
        while(opcio != 4) {
            switch(opcio) {
                case 1: 
                    consultar(G);
                    break;
                case 2: 
                    System.out.println("Entra les dades de la consulta a guardar:");
                    Apunts consulta = llegirConsulta(sc);
                    historial.afegirCerca(consulta);
                    break;
                case 3: 
                    System.out.println("Escriu l'índex de la consulta que vols esborrar:");
                    int i = sc.nextInt();
                    historial.esborrar(historial.size()-i);
            }
            escriure_opcions();
            opcio = sc.nextInt();
        }
    }
    
    private static void escriure_opcions() {
        System.out.println("Tria una opció:");
        System.out.println("1. Consultar historial");
        System.out.println("2. Afegir cerca");
        System.out.println("3. Esborrar cerca");
        System.out.println("4. Exit");
    }
    
    private static Apunts llegirConsulta(Scanner sc) {
        System.out.println("Nom de l'entitat:");
        sc.nextLine();
        String nom = sc.nextLine();
        System.out.println("ID del node:");
        int id = sc.nextInt();
        System.out.println("Tipus del node (Autor, Conferencia, Article, Terme)");
        sc.nextLine();
        String tipus = sc.nextLine();
        return new Apunts(nom, id, tipus);
    }
    
    public void consultar(Graf_PageRank G) {
        CtrlHistorial ctrl = new CtrlHistorial();
        ArrayList<Apunts> LlistaConsultes = ctrl.getList();
	Scanner sc = new Scanner(System.in);
        System.out.println("HISTORIAL");
	for(int i = LlistaConsultes.size()-1; i >= 0; i--) {
		System.out.print(LlistaConsultes.size()-i);
		System.out.print(". ");
                Apunts aux = LlistaConsultes.get(i);
                System.out.println(aux.getNom());
	}
	System.out.print("\n");
	System.out.println("Selecciona un número de cerca o -1 per sortir");
        int n = sc.nextInt();
	while(n != -1) {
            CtrlPerfils ctrlper = new CtrlPerfils();
            Apunts a = LlistaConsultes.get(n-1);
            int q_conferencies,q_termes,q_articles,q_autors;
            switch(a.getTipus()) {
                    case "Autor":
                        System.out.println("Introdueix la quantitat de conferencies:");
                        q_conferencies = sc.nextInt();
                        System.out.println("Introdueix la quantitat de termes:");
                        q_termes = sc.nextInt();
                        System.out.println("Introdueix la quantitat d'articles:");
                        q_articles = sc.nextInt();
                        System.out.println("Introdueix la quantitat de co-autors:");
                        q_autors = sc.nextInt();
                        ctrlper.crear_perfil_autor(a.getNom(), q_articles, q_autors, q_termes, q_conferencies, G, false);
                        break;
                    case "Conferencia":  
                        System.out.println("Introdueix la quantitat d'autors:");
                        q_autors = sc.nextInt();
                        System.out.println("Introdueix la quantitat de termes:");
                        q_termes = sc.nextInt();
                        System.out.println("Introdueix la quantitat d'articles:");
                        q_articles = sc.nextInt();
                        ctrlper.crear_perfil_conferencia(a.getNom(), q_articles, q_autors, q_termes, G, false);
                        break;
                    case "Article":
                        System.out.println("Introdueix la quantitat de conferencies:");
                        q_conferencies = sc.nextInt();
                        System.out.println("Introdueix la quantitat d'autors:");
                        q_autors = sc.nextInt();
                        System.out.println("Introdueix la quantitat de termes:");
                        q_termes = sc.nextInt();
                        ctrlper.crear_perfil_article(a.getNom(), q_autors, q_termes, q_conferencies, G, false);
                        break;
                    case "Terme" : 
                        System.out.println("Introdueix la quantitat de conferencies:");
                        q_conferencies = sc.nextInt();
                        System.out.println("Introdueix la quantitat de articles:");
                        q_articles = sc.nextInt();
                        System.out.println("Introdueix la quantitat d'autors:");
                        q_autors = sc.nextInt();
                        ctrlper.crear_perfil_terme(a.getNom(), q_articles, q_autors, q_conferencies, G, false);
                        break;
            }
            System.out.print("\n");
            System.out.println("Selecciona un número de cerca o -1 per sortir");
            n = sc.nextInt();
	}
    }
}
