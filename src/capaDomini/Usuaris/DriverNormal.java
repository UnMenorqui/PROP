/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Usuaris;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Perfils.DriverPerfil;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class DriverNormal {
    public void main(String user, String pass, CtrlGraf G) throws IOException {
        boolean bool= false;
        boolean primer = true;
        CtrlUsuaris ctrlusuaris = new CtrlUsuaris();
        DriverPerfil ctrl = new DriverPerfil();
        Scanner sc = new Scanner(System.in);
        System.out.println("Login correcte.");
        UsuariNormal usr = new UsuariNormal(user,pass);
        while(!bool) {
            System.out.println("Si vols consultar l'usuari marca 1.");
            System.out.println("Si vols consultar la contrasenya marca 2.");
            System.out.println("Si vols modificar el nom de l'usuari marca 3.");
            System.out.println("Si vols modificar la contrasenya marca 4.");
            System.out.println("Si vols fer una consulta marca 5.");
            System.out.println("Si vols consultar l'historial de consultes marca 6.");
            System.out.println("Si vols acabar marca un altre número.");
            if(!primer) {
                System.out.println("Operació realitzada.");
                System.out.println("---------------------");
                System.out.println("Torna a entrar la operació a fer:");
            } 
            else primer = false;
            int prova = sc.nextInt();
            switch(prova) {
                case 1:
                    usr.consultar_username();
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
