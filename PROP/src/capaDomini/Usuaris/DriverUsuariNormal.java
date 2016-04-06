package capaDomini.Usuaris;

import java.util.Scanner;

/**
 * @author aleixabrieprat
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
        usn = new UsuariNormal(usuari,nom,password);
        
        Boolean bool = false;
        
        System.out.println("Tria una opció:");
        System.out.println("Si vols consultar el nom de l'usuari marca 1.");
        System.out.println("Si vols modificar el nom de l'usuari marca 2.");
        System.out.println("Si vols consultar la contrasenya marca 3.");
        System.out.println("Si vols modificar la contrasenya marca 4.");
        System.out.println("Si vols consultar el nom marca 5.");
        System.out.println("Si vols modificar el nom marca 6.");
        System.out.println("Si vols acabar la prova de driver marca 7.");

        while(!bool) {
            int prova = sc.nextInt();
            switch(prova) {
                case 1:
                    System.out.println(usn.consultar_username());
                    break;
                case 2:
                    String username_nou;
                    System.out.println("Entra el nou nom: ");
                    username_nou = sc.next();
                    usn.modificar_user(username_nou);
                    break;
                case 3:
                    System.out.println(usn.consultar_password());
                    break;
                case 4:
                    System.out.println("Entra la nova contrasenya: ");
                    String new_password = sc.next();
                    usn.modificar_pass(new_password);
                    break;  
                case 5:
                    System.out.println(usn.consultar_Nom());
                    break;
                case 6:
                    String nom_nou;
                    System.out.println("Entra el nou nom: ");
                    nom_nou = sc.next();
                    usn.modificar_Nom(nom_nou);
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
