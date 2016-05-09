/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.main;

import capaDomini.Usuaris.DriverConvidat;
import capaDomini.Usuaris.DriverNormal;
import capaDomini.Usuaris.CtrlUsuaris;
import capaDomini.Usuaris.DriverAdministrador;
import capaDomini.Graf.Graf_PageRank;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Toni
 */

public class PROP {
    
    
    public static void main(String args[]) throws IOException {
        
        Graf_PageRank gf = new Graf_PageRank();
        
        String usr_admin = "Administrador";
        String admin_pass = "1234";
        CtrlUsuaris ctrl = new CtrlUsuaris();
        
        System.out.println("BENVINGUT A L'APLICACIÓ DE PROP");
        System.out.println();
        System.out.println();
        System.out.println();        
        System.out.println("Created by Aleix Abrie, Roger Oriol, Marc Anglada i Toni Riera");
        System.out.println();
        System.out.println();
        
        
        
        Scanner sc = new Scanner(System.in);
        
        boolean bool = false;
        boolean primer = false;
        while(!bool) {
            System.out.println("Si vol entrar com a convidat, marqui 1.");
        
            System.out.println("Si ja disposa d'un compte, marqui 2.");
        
            System.out.println("Si és un administrador, marqui 3.");
        
            System.out.println("Si vol registrar-se, marqui 4.");
        
            System.out.println("Si vol sortir de l'aplicació, marqui 5.");
                if(primer) {
                    System.out.println("Operació realitzada.");
                    System.out.println("---------------------");
                    System.out.println("Torna a entrar la operació a fer:");
                } else primer = true;
                int id = sc.nextInt();
                switch(id) {
                case 1:
                    DriverConvidat uc = new DriverConvidat();
                    uc.main(gf);
                    break;
                case 2:
                    String user = null, pass = null;     
                    System.out.print("Entra el nom d'usuari: ");
                    user = sc.next();
                    System.out.println();
                    System.out.print("Entra la contrasenya: ");
                    pass = sc.next();
                    System.out.println();
                    if(ctrl.ExisteixUsuari_contrasenya(user,pass)) {
                        DriverNormal norm = new DriverNormal();
                        norm.main(user,pass,gf);
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
                            DriverAdministrador admin = new DriverAdministrador();
                            admin.main(gf);
                        }
                        else System.out.print("Clau mestre incorrecta.");
                    }
                    else System.out.print("Usuari Administrador incorrecte.");
                    break;

                case 4:
                    System.out.print("Entra el nou usuari: ");
                    user = sc.next();
                    if(!ctrl.ExisteixUsuari(user)) {
                        System.out.print("Entra la contrasenya: ");
                        pass = sc.next();
                        ctrl.GuardarUsuari(user, pass);
                    }
                    else System.out.print("Usuari existent.");
                    break;

                case 5:
                    System.out.println("Gràcies per utilitzar l'aplicaió, fins aviat!");
                    bool = true;
                    break;

            }
        }
    }
    
}
