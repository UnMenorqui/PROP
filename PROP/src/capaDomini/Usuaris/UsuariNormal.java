package capaDomini.Usuaris;

import java.util.Scanner;

/**
 *
 * @author toni_
 * 
 * Classe d'un usuari normal, aquesta conte els atributs
 * principals de l'usuari, com nom de l'usuari, contrasenya, etc..
 * A mes, conté també les funcions bàsiques per a gestionar aquests atributs,
 * també anomenades "getters" i "setters", entre d'altres com guardar perfil.
 */

public class UsuariNormal extends UsuariConvidat {
    private String user_name;
    private String password;
    
    
    //CONSTRUCTORA SENSE PARÀMETRES
    public UsuariNormal() {
    }
    
    //CONSTRUCTORA AMB PARÀMETRES
    public UsuariNormal(String usuari, String password) {
        this.user_name = usuari;
        this.password = password;
    }
    
    /*  Retorna el nom de l'usuari.
    Pre:    Cap.
    Post:   Retorna el nom d'usuari.
    */
    public String consultar_username() {
        System.out.println("El teu usuari és: "+user_name+".");
        return user_name;
    }
    
    /*  Retorna la contrasenya.
    Pre:    Cap.
    Post:   Retorna la contrasenya.
    */
    public String consultar_password() {
        System.out.println("Entra el teu username:");
        Scanner sc = new Scanner(System.in);                
        String pass;
        String user = sc.next();
        CtrlUsuaris ctrl = new CtrlUsuaris();
        if (!ctrl.ExisteixUsuari(user)) System.out.println("No existeix l'usuari");
        else if (user.equals(user_name)) { 
            System.out.println("Usuari correcte");
            pass = ctrl.consultar_password(user);
            if (pass.equals(password)) System.out.println("La teva contrasenya és: "+pass);
            return password;
        }
        return "No has seguit el procediment correctament";
    }   
    
    /*  Modifca el nom de l'usuari.
    Pre:    Cap.
    Post:   El nom de l'usuari ha quedat modificat.
    */
    
    public void modifica_user() {
        Scanner sc = new Scanner(System.in);
        String user,pass;
        System.out.println("Entra el teu username: ");
                        user = sc.next();
                        System.out.println("Entra el teu password: ");
                        pass = sc.next();
                        System.out.println("Escriu el nou username:");
                        String nou_user = sc.next();
                        CtrlUsuaris ctrl = new CtrlUsuaris();
                        if (!ctrl.ExisteixUsuari(nou_user)) {
                            if (ctrl.modificar_usuari(user, pass, nou_user)) {
                               System.out.println("Usuari modificat correctament");
                               user_name = nou_user;
                            } else {
                                System.out.println("Usuari i/o contrasenya incorrecte");
                            }
                        }
                        else {
                            System.out.println("Usuari Existent.");
                        }
    }
    
    /*  Modifica l'atribut password.
    Pre:    Cap.
    Post:   password ha quedat modificada per unaltra.
    */
    public void modifica_pass() {
        Integer i;
        String pass = null;
        Scanner sc = new Scanner(System.in);
        CtrlUsuaris ctrl = new CtrlUsuaris();
        if (!ctrl.ExisteixUsuari(user_name)) {
            System.out.println("Usuari no-existent");
        }
        else {
            System.out.print("El teu usuari és: ");
            System.out.print(user_name);
            System.out.print(".");
            System.out.println();
            System.out.println("Si desitjeu modificar la contrasenya marqueu 1.");
            System.out.println("Altrament no es modificara la contrasenya.");
            Integer h = sc.nextInt();
            if (h == 1) {
                boolean contrasenya = false;
                i = 1;
                while (i <= 3 && !contrasenya) {
                    System.out.println("Escriu la contrasenya de l'usuari");
                    pass = sc.next();
                    if (!ctrl.ExisteixUsuari_contrasenya(user_name,pass)) {
                        System.out.println("Contrasenya incorrecta.");
                        System.out.println("Et queden "+(3-i)+" intents");
                    }
                    else {
                        System.out.println("Password correcta.");
                        contrasenya = true;
                    }
                    ++i;
                }
                if (i > 3) {
                    System.out.println("Se t'han acabat tots els intents.");
                }
                else if (contrasenya) {
                    System.out.println("Escriu la nova contrasenya:");
                    String new_pass = sc.next();
                    ctrl.modificar_password(user_name,pass,new_pass);
                    System.out.println("Contrasenya de l'usuari modificada correctament.");
                    password = new_pass;
                }
            }
        }
    }

    
}
