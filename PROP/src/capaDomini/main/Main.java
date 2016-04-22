/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.main;

import capaDomini.Usuaris.CtrlConvidat;
import capaDomini.Usuaris.CtrlNormal;
import capaDomini.Usuaris.CtrlUsuaris;
import capaDomini.Usuaris.CtrlAdministrador;
import java.util.Scanner;

/**
 *
 * @author Toni
 */

public class Main {
    
    
    public static void main(String args[]) {
        
        String usr_admin = "Administrador";
        String admin_pass = "1234";
        System.out.println("BENVINGUT A L'APLICACIÓ DE PROP");
        System.out.println();
        System.out.println();
        System.out.println();        
        System.out.println("Created by Aleix Abrie, Roger Oriol, Marc Anglada i Toni Riera");
        System.out.println();
        System.out.println();
        
        System.out.println("Si vol entrar com a convidat, marqui 1.");
        
        System.out.println("Si ja disposa d'un compte, marqui 2.");
        
        System.out.println("Si és un administrador, marqui 3.");
        
        System.out.println("Si vol registrar-se, marqui 4.");
        
        System.out.println("Si vol sortir de l'aplicació, marqui 5.");
        
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        switch(id) {
            case 1:
                CtrlConvidat uc = null;
                uc.main();
                break;
            case 2:
                String user = null, pass = null;     
                System.out.print("Entra el nom d'usuari: ");
                user = sc.next();
                System.out.println();
                System.out.print("Entra la contrasenya: ");
                pass = sc.next();
                System.out.println();
                if(CtrlUsuaris.ExisteixUsuari_contrasenya(user,pass)) {
                    CtrlNormal norm = null;
                    norm.main(user,pass);
                }
                else System.out.println("Usuari o contrasenya incorrecta");
                break;
                
            case 3:
                System.out.print("Entra l'usuari Administrador: ");
                user = sc.next();
                if (user.equals(usr_admin)) { 
                    System.out.print("Entra la clau mestre: ");
                    pass = sc.next();
                    if (pass.equals(admin_pass)) {
                        CtrlAdministrador admin = null;
                        admin.main();
                    }
                    else System.out.print("Clau mestre incorrecta.");
                }
                else System.out.print("Usuari Administrador incorrecte.");
                break;
                
            case 4:
                System.out.print("Entra el nou usuari: ");
                user = sc.next();
                if(!CtrlUsuaris.ExisteixUsuari(user)) {
                    System.out.print("Entra la contrasenya: ");
                    pass = sc.next();
                    CtrlUsuaris.GuardarUsuari(user, pass);
                }
                else System.out.print("Usuari existent.");
                break;
                
            case 5:
                System.out.print("Gràcies per utilitzar l'aplicaió, fins aviat!");
                break;
                
        }
    }
    
}
