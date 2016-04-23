/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rogia
 */
public class DriverHistorial {
    public static void main (String[] args) {
        Historial historial = new Historial();
        int opcio;
        try (Scanner sc = new Scanner(System.in)) {
            escriure_opcions();
            opcio = sc.nextInt();
            while(opcio != 4) {
                switch(opcio) {
                    case 1: 
                        ArrayList<Apunts> LlistaConsultes = historial.consultar();
                        escriureLlistaConsultes(LlistaConsultes);
                        break;
                    case 2: 
                        System.out.println("Escriu la teva consulta:");
                        Apunts consulta = llegirConsulta();
                        historial.afegirCerca(consulta);
                        break;
                    case 3: 
                        System.out.println("Escriu l'índex de la consulta que vols esborrar:");
                        int i = sc.nextInt();
                        historial.esborrar(i);
                }
                escriure_opcions();
                opcio = sc.nextInt();
            }
        }
    }
    
    private static final void escriure_opcions() {
        System.out.println("Tria una opció:");
        System.out.println("1. Consultar historial");
        System.out.println("2. Afegir cerca");
        System.out.println("3. Esborrar cerca");
        System.out.println("4. Exit");
    }
    
    private static void escriureLlistaConsultes(ArrayList<Apunts> LlistaConsultes) {
        
    }
    
    private static Apunts llegirConsulta() {
        Consulta c = new Consulta();
        Apunts r = new Apunts(c);
        return r;
    }
}
