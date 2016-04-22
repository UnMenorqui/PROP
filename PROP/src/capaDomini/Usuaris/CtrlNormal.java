/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Usuaris;

import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class CtrlNormal {
    public void main(String user, String pass) {
        boolean bool= false;
        boolean primer = false;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Si vols consultar l'usuari marca 1.");
        System.out.println("Si vols consultar la contrasenya marca 2.");
        System.out.println("Si vols modificar el nom de l'usuari marca 3.");
        System.out.println("Si vols modificar la contrasenya marca 4.");
        
        UsuariNormal usr = new UsuariNormal(user,pass);
        
        while(!bool) {
                if(!primer) {
                    System.out.println("Operació realitzada.");
                    System.out.println("---------------------");
                    System.out.println("Torna a entrar la operació a fer:");
                } else primer = false;
                int prova = sc.nextInt();
                switch(prova) {
                    case 1:
                        user = usr.consultar_username();
                        break;
                        
                    case 2:
                        usr.consultar_password();
                        break;
                    case 3:
                        usr.modifica_user();
                        break;
                    case 4:
                        usr.modifica_pass();
                        break;
                }
            }
    }
}
