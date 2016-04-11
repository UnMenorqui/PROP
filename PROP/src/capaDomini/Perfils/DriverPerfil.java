/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;

import java.util.Scanner;

/**
 *
 * @author marc_
 */
public class DriverPerfil {
    
    public static void main (String[] args) {
        Perfil perfil = new Perfil();
        System.out.println("Per a la creació d'un perfil, determina el tipus:");
        System.out.println("Marca 1 si vols un perfil d'autor");
        System.out.println("Marca 2 si vols un perfil d'una conferencia");
        System.out.println("Marca 3 si vols un perfil d'un article");
        System.out.println("Marca 4 si vols un perfil d'un terme");
        Scanner sc = new Scanner(System.in);
        int marca;
        boolean bool = false;
        while (!bool) {
            marca = sc.nextInt();
            System.out.println("Introdueix l'entitat que destjes cercar:");
            String entitat = sc.next();
            switch(marca) {
                case 1:
                    System.out.println("Introdueix la quantitat de conferencies:");
                    System.out.println("Introdueix la quantitat de termes:");
                    System.out.println("Introdueix la quantitat d'articles:");
                    Perfil.creacio_perfil(marca,entitat);
                    break;
                case 2: 
                    System.out.println("Introdueix la quantitat d'autors:");
                    System.out.println("Introdueix la quantitat de termes:");
                    System.out.println("Introdueix la quantitat d'articles:");
                    Perfil.creacio_perfil(marca,entitat);
                    break;
                case 3:
                    System.out.println("Introdueix la quantitat de conferencies:");
                    System.out.println("Introdueix la quantitat d'autors:");
                    System.out.println("Introdueix la quantitat de termes:");
                    Perfil.creacio_perfil(marca,entitat);
                    break;
                case 4:
                    System.out.println("Introdueix la quantitat de conferencies:");
                    System.out.println("Introdueix la quantitat de termes:");
                    System.out.println("Introdueix la quantitat d'autors:");
                    Perfil.creacio_perfil(marca,entitat);
                    break;
                case 5:
                    bool = true;
                    break;
            } 
        }
    }
}
