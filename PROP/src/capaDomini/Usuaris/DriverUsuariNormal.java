package capaDomini.Usuaris;

import static capaDomini.Usuaris.CtrlUsuaris.ExisteixUsuari;
import static capaDomini.Usuaris.CtrlUsuaris.ExisteixUsuari_contrasenya;
import static capaDomini.Usuaris.CtrlUsuaris.borrarlinea;
import capaPersistencia.DadesUsuari; // ??????
import static capaPersistencia.DadesUsuari.GuardarUsuari;
import java.util.Scanner;

/**
 * @author cacadevaca
 */
public class DriverUsuariNormal {
 
    public static void main (String[] args) {
        DriverUsuariNormal us = new DriverUsuariNormal();
        Scanner sc = new Scanner(System.in);
        String usuari, password, nom;
        System.out.println("Escriu nom del usuari: ");
        nom = sc.nextLine();
        System.out.println("Escriu user_name:");
        usuari = sc.nextLine();
        System.out.println("Escriu contrasenya:");
        password = sc.nextLine();
        UsuariNormal usn;
        usn = new UsuariNormal(usuari,password);
        
        DadesUsuari dades = new DadesUsuari();
        
        Boolean bool = false;
        
        System.out.println("Tria una opció:");
        System.out.println("Si vols consultar el nom de l'usuari marca 1.");
        System.out.println("Si vols modificar el nom de l'usuari marca 2.");
        System.out.println("Si vols consultar la contrasenya marca 3.");
        System.out.println("Si vols modificar la contrasenya marca 4.");
        System.out.println("Si vols guardar un nou usari marca 5.");
        System.out.println("Si vols borrar un usuari marca 6.");
        System.out.println("Si vols acabar la prova de driver marca 7.");

        while(!bool) {
            int prova = sc.nextInt();
            String user;
            String pass;
            switch(prova) {
                case 1:
                    System.out.println(usn.consultar_username());
                    break;
                case 2:
                    System.out.println("Entra el nou nom: ");
                    user = sc.next();
                    usn.modificar_user(user);
                    break;
                case 3:
                    System.out.println(usn.consultar_password());
                    break;
                case 4:
                    System.out.println("Entra la nova contrasenya: ");
                    pass = sc.next();
                    usn.modificar_pass(pass);
                    break;  
                case 5:
                    System.out.println("Entra el nom de l'usuari: ");
                    user = sc.next();
                    System.out.println("Entra la contrasenya: ");
                    pass = sc.next();
                    GuardarUsuari(user, pass);
                    break;
                case 6:
                    System.out.println("Entra el nom de l'usuari: ");
                    user = sc.next();
                    if (ExisteixUsuari(user).equals(false)) { 
                        System.out.println("L'usuari no existeix");
                        boolean acabat = false;
                        while(!acabat) {
                            System.out.println("Escriu de nou el nom de l'usuari: ");
                            user = sc.next();
                            if (! ExisteixUsuari(user)) System.out.println("L'usuari no existeix");
                            else acabat = true;
                        }
                    }
                    System.out.println("Entra la contrasenya: ");
                    pass = sc.next();
                    UsuariNormal usr_prova;
                    usr_prova = new UsuariNormal();
                    usr_prova.modificar_user(user);
                    usr_prova.modificar_pass(pass);
                    if (ExisteixUsuari_contrasenya(usr_prova).equals(false)) {
                        System.out.println("Constrasenya incorrecta");
                        boolean acabat = false;
                        while(!acabat) {
                            System.out.println("Escriu de nou la contrasenya de l'usuari: ");
                            user = sc.next();
                            if (! ExisteixUsuari(user)) System.out.println("Constraseya incorrecta");
                            else acabat = true;
                        }
                    }
                    borrarlinea(user,pass);
                    break;
                case 7:
                    bool = true;
                    break;
            }
        }
        sc.close();
        System.out.println(); 
    }   
}
