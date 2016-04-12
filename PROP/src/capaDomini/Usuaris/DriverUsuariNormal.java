package capaDomini.Usuaris;


import java.util.Scanner;

/**
 * @author toni
 */

public class DriverUsuariNormal {
 
    public static void main (String[] args) {
        DriverUsuariNormal us = new DriverUsuariNormal();
        try (Scanner sc = new Scanner(System.in)) {
            Boolean bool = false;
            Boolean primer = true;
            CtrlUsuaris ctrlusuaris = new CtrlUsuaris();
            System.out.println("Tria una opció:");
            System.out.println("Si vols consultar tots els usuaris de la BD marca 1.");
            //ja esta a Administrador
            
            System.out.println("Si vols modificar el nom de l'usuari marca 2.");
            //ja esta a UsuariNormal
            
            System.out.println("Si vols consultar la contrasenya marca 3.");
            //ja esta a Usuari Normal
            
            System.out.println("Si vols modificar la contrasenya marca 4.");
            //ja esta a UsuariNormal
            
            System.out.println("Si vols guardar un nou usari marca 5.");
            
            
            System.out.println("Si vols borrar un usuari marca 6.");
            //ja esta a Administrador
            
            System.out.println("Si vols acabar la prova de driver marca 7.");
            
            String user;
            String pass = null;
            while(!bool) {
                if(!primer) {
                    System.out.println("Operació realitzada.");
                    System.out.println("---------------------");
                    System.out.println("Torna a entrar la operació a fer:");
                } else primer = false;
                int prova = sc.nextInt();
                switch(prova) {
                    case 1:
                        CtrlUsuaris.consultaUsuarisBD();
                        break;
                    case 2:
                        System.out.println("Entra el teu username: ");
                        user = sc.next();
                        System.out.println("Entra el teu password: ");
                        pass = sc.next();
                        System.out.println("Escriu el nou username:");
                        String nou_user = sc.next();
                        if (CtrlUsuaris.modificar_usuari(user, pass, nou_user)) {
                           System.out.println("Usuari modificat correctament"); 
                        } else {
                            System.out.println("Usuari i/o contrasenya incorrecte");
                        }
                        break;
                    case 3:
                        System.out.println("Entra el teu username:");
                        user = sc.next();
                        String contr = CtrlUsuaris.consultar_password(user);
                        if (contr.equals("")) {
                            System.out.println("Usuari incorrecte");
                        } else {
                            System.out.println("La teva contrasenya és: "+contr);
                        }
                        break;
                    case 4:
                        System.out.println("Entra el teu username: ");
                        user = sc.next();
                        System.out.println("Escriu la contrasenya de l'usuari");
                        pass = sc.next();
                        System.out.println("Escriu la nova contrasenya:");
                        String new_pass = sc.next();
                        if (CtrlUsuaris.modificar_password(user,pass,new_pass)) {
                            System.out.println("Contrasenya modificada correctament");
                        }
                        else {
                            System.out.println("Usuari i/o contrasenya incorrecte");
                        }
                        break;
                    case 5:
                        System.out.println("Entra el nom de l'usuari:");
                        user = sc.next();
                        System.out.println("Entra la contrasenya: ");
                        pass = sc.next();
                        if (CtrlUsuaris.GuardarUsuari(user,pass)) {
                            System.out.println("Usuari afegit correctament");
                        } else {
                            System.out.println("Usuari ja existent");
                        }
                        break;
                    case 6:
                        System.out.println("Entra el nom de l'usuari: ");
                        user = sc.next();
                        System.out.println("Escriu la contrasenya de l'usuari");
                        pass = sc.next();
                        if (CtrlUsuaris.borrarlinea(user,pass)) {
                            System.out.println("Usuari borrat correctament");
                        } else {
                            System.out.println("Usuari i/o contrasenya incorrecte");
                        }
                        break;
                    case 7:
                        bool = true;
                        break;
                }
            }
        }
        System.out.println(); 
    }   
}
