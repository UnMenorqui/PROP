/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini;


import java.util.Scanner;

/**
 *
 * @author Oriolcapo
 */
public class Administrador extends UsuariNormal {
    private void elimina_user() {
        
    }
    private void modifica_user() {
        
    }
    private void crea_user() {
        
    }
    public void gestiona_users_BD() {
        int cas;
        Scanner scan = new Scanner(System.in);
        cas = scan.nextInt();
        while (cas != 0) {
            switch (cas) {         
                case 1: elimina_user();

                case 2: modifica_user();

                cas = scan.nextInt();
            }
        }
    }
    

public void gestionaGraf() {
        int cas;
        Scanner scan = new Scanner(System.in);
        cas = scan.nextInt();
        while (cas != 0) {
            switch (cas) {         
                case 1: elimina_node();

                case 2: modifica_node();

                case 3: crea_node();
                
                case 4: eliminar_aresta();

                cas = scan.nextInt();
            }
        }
    }
