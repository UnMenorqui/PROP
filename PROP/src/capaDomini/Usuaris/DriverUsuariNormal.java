package capaDomini.Usuaris;


import java.util.Scanner;

/**
 * @author cacadevaca
 */
public class DriverUsuariNormal {
 
    public static void main (String[] args) {
        DriverUsuariNormal us = new DriverUsuariNormal();
        Scanner sc = new Scanner(System.in);
        CtrlUsuaris cn = new CtrlUsuaris();
        String usuari, password, nom;
        System.out.println("Escriu nom del usuari: ");
        nom = sc.nextLine();
        System.out.println("Escriu user_name:");
        usuari = sc.nextLine();
        System.out.println("Escriu contrasenya:");
        password = sc.nextLine();
        UsuariNormal usn;
        usn = new UsuariNormal(usuari,password);
        
        Boolean bool = false;
        
        System.out.println("Tria una opció:");
        System.out.println("Si vols consultar el nom de l'usuari marca 1.");
        System.out.println("Si vols modificar el nom de l'usuari marca 2.");
        System.out.println("Si vols consultar la contrasenya marca 3.");
        System.out.println("Si vols modificar la contrasenya marca 4.");
        System.out.println("Si vols guardar un nou usari marca 5.");
        System.out.println("Si vols borrar un usuari marca 6.");
        System.out.println("Si vols acabar la prova de driver marca 7.");

        String user;
        String pass;
        int i = 0;
        while(!bool) {
            if(i != 0) {
                System.out.println("Operació realitzada.");
                System.out.println("---------------------");
                System.out.println("Torna a entrar la operació a fer: ");
            }
            int prova = sc.nextInt();
            ++i;
            
            UsuariNormal usr= new UsuariNormal();
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
                    CtrlUsuaris.GuardarUsuari(user,pass);
                    break;
                case 6:
                    System.out.println("Entra el nom de l'usuari: ");
                    user = sc.next();
                    if (!CtrlUsuaris.ExisteixUsuari(user)) { 
                        System.out.println("L'usuari no existeix");
                        boolean acabat = false;
                        while(!acabat) {
                            System.out.println("Escriu de nou el nom de l'usuari: ");
                            user = sc.next();
                            if (!CtrlUsuaris.ExisteixUsuari(user)) System.out.println("L'usuari no existeix");
                            else acabat = true;
                        }
                    }
                    System.out.println("Entra la contrasenya: ");
                    pass = sc.next();
                    usr = new UsuariNormal(user,pass);
                    if (!CtrlUsuaris.ExisteixUsuari_contrasenya(usr)) {
                        System.out.println("Constrasenya incorrecta");
                        boolean acabat = false;
                        while(!acabat) {
                            System.out.println("Escriu de nou la contrasenya de l'usuari: ");
                            pass = sc.next();
                            if (!CtrlUsuaris.ExisteixUsuari_contrasenya(usr)) System.out.println("Constraseya incorrecta");
                            else acabat = true;
                        }
                    }
                    if(CtrlUsuaris.borrarlinea(user,pass)) //System.out.println("No borra");
                    //else System.out.println("Si borra");
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
