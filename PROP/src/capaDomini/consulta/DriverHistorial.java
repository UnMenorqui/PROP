/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import capaDomini.Graf.Graf_PageRank;
import java.util.Scanner;

/**
 *
 * @author rogia
 */
public class DriverHistorial {
    public static void main (String[] args) {
        Graf_PageRank G = new Graf_PageRank();
        Historial historial = new Historial();
        int opcio;
        try (Scanner sc = new Scanner(System.in)) {
            escriure_opcions();
            opcio = sc.nextInt();
            while(opcio != 4) {
                switch(opcio) {
                    case 1: 
                        historial.consultar(G);
                        break;
                    case 2: 
                        System.out.println("Escriu la teva consulta (nom\\n id\\n tipus):");
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
    }
    
    private static void escriure_opcions() {
        System.out.println("Tria una opció:");
        System.out.println("1. Consultar historial");
        System.out.println("2. Afegir cerca");
        System.out.println("3. Esborrar cerca");
        System.out.println("4. Exit");
    }
    
    private static Apunts llegirConsulta(Scanner sc) {
        sc.nextLine();
        String nom = sc.nextLine();
        int id = sc.nextInt();
        sc.nextLine();
        String tipus = sc.nextLine();
        return new Apunts(nom, id, tipus);
    }
}
