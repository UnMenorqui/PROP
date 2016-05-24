/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Usuaris;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Perfils.DriverPerfil;
import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class DriverNormal {
    public void main(String user, String pass, CtrlGraf G) {
        Boolean bool = false;
        CtrlUsuaris ctrlusuaris = new CtrlUsuaris();
        DriverPerfil ctrl = new DriverPerfil();
        String user1, pass1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Login correcte.");
        UsuariNormal usr = new UsuariNormal(user,pass);
        System.out.println("Si vols consultar l'usuari marca 1.");
        System.out.println("Si vols consultar la contrasenya marca 2.");
        System.out.println("Si vols modificar el nom de l'usuari marca 3.");
        System.out.println("Si vols modificar la contrasenya marca 4.");
        System.out.println("Si vols fer una consulta marca 5.");
        System.out.println("Si vols consultar l'historial de consultes marca 6.");
        System.out.println("Si vols acabar marca un altre número.");
        int id;
        while(!bool) {
            int prova = sc.nextInt();
            switch(prova) {
                case 1:
                    System.out.println("El teu nom d'usuari és: "+usr.consultar_username()+".");
                    break;
                case 2:
                    System.out.println("El teu usuari és: "+usr.consultar_password()+".");
                    break;
                case 3:
                    System.out.println("Entra el nou nom d'usuari:");
                    user1 = sc.next();
                    id = ctrlusuaris.modificar_usuari(user, pass, user1);
                    if (id == 3) System.out.println("El nou nom d'usuari ja EXISTEIX");
                    else if (id == 2) {
                        usr.modifica_user(user1);
                        System.out.println("El nou nom d'usuari s'ha modificat correctament");
                    }
                    break;
                case 4:
                    System.out.println("Entra la nova contrasenya:");
                    pass1 = sc.next();
                    id = ctrlusuaris.modificar_password(user, pass, pass1);
                    usr.modifica_pass(pass1);
                    System.out.println("Contrasenya modificada correctament");
                    break;
                case 5:
                    ctrl.main(G,true);
                    break;
                case 6:
                    ctrlusuaris.consultar(G);
                    break;
                default:
                    bool = true;
                    break;
            }
        }
    }
}
