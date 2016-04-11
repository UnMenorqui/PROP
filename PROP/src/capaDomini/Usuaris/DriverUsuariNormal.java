package capaDomini.Usuaris;


import java.util.Scanner;

/**
 * @author cacadevaca
 */
public class DriverUsuariNormal {
 
    public static void main (String[] args) {
        DriverUsuariNormal us = new DriverUsuariNormal();
        try (Scanner sc = new Scanner(System.in)) {
            Boolean bool = false;
            Boolean primer = true;
            System.out.println("Tria una opció:");
            System.out.println("Si vols consultar tots els usuaris de la BD marca 1.");
            System.out.println("Si vols modificar el nom de l'usuari marca 2.");
            System.out.println("Si vols consultar la contrasenya marca 3.");
            System.out.println("Si vols modificar la contrasenya marca 4.");
            System.out.println("Si vols guardar un nou usari marca 5.");
            System.out.println("Si vols borrar un usuari marca 6.");
            System.out.println("Si vols acabar la prova de driver marca 7.");
            String user;
            String pass = null;
            CtrlUsuaris ctrlusuaris = new CtrlUsuaris();
            int i;
            while(!bool) {
                if(!primer) {
                    System.out.println("Operació realitzada.");
                    System.out.println("---------------------");
                    System.out.println("Torna a entrar la operació a fer: ");
                } else primer = false;
                int prova = sc.nextInt();
                switch(prova) {
                    case 1:
                        CtrlUsuaris.consultaBD();
                        break;
                    case 2:
                        System.out.println("Entra el teu username: ");
                        user = sc.next();
                        if (!CtrlUsuaris.ExisteixUsuari(user)) {
                            System.out.println("Usuari no-existent");
                        }
                        else {
                            i = 1;
                            boolean contrasenya = false;
                            while (i <= 3 && !contrasenya) {
                                System.out.println("Escriu la contrasenya de l'usuari");
                                pass = sc.next();
                                if (!CtrlUsuaris.ExisteixUsuari_contrasenya(new UsuariNormal(user,pass))) {
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
                                System.out.println("Escriu el nou username:");
                                String nou_user = sc.next();
                                if (!CtrlUsuaris.ExisteixUsuari(nou_user)) {
                                    CtrlUsuaris.modificar_usuari(user,nou_user,pass);
                                    System.out.println("Username modificat correctament.");
                                }
                                else {
                                    System.out.println("Aquest usuari ja existeix. Torna-ho a provar");                          
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Entra el teu username:");
                        user = sc.next();
                        if (!CtrlUsuaris.ExisteixUsuari(user)) System.out.println("No existeix l'usuari");
                        else {
                            System.out.println("La teva contrasenya és: "+CtrlUsuaris.consultar_password(user));
                        }
                        break;
                    case 4:
                        System.out.println("Entra el teu username: ");
                        user = sc.next();
                        if (!CtrlUsuaris.ExisteixUsuari(user)) System.out.println("No existeix l'usuari");
                        else {
                            boolean contrasenya = false;
                            i = 1;
                            while (i <= 3 && !contrasenya) {
                                System.out.println("Escriu la contrasenya de l'usuari");
                                pass = sc.next();
                                if (!CtrlUsuaris.ExisteixUsuari_contrasenya(new UsuariNormal(user,pass))) {
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
                                CtrlUsuaris.modificar_password(user,pass,new_pass);
                                System.out.println("Contrasenya de l'usuari modificada correctament.");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Entra el nom de l'usuari:");
                        user = sc.next();
                        if (CtrlUsuaris.ExisteixUsuari(user)) System.out.println("Aquest Usuari ja existeix");
                        else {
                            System.out.println("Entra la contrasenya: ");
                            pass = sc.next();
                            CtrlUsuaris.GuardarUsuari(user,pass);
                        }
                        break;
                    case 6:
                        System.out.println("Entra el nom de l'usuari: ");
                        user = sc.next();
                        if (!CtrlUsuaris.ExisteixUsuari(user)) {
                            System.out.println("L'usuari no existeix");
                        }
                        else {
                            boolean contrasenya = false;
                            i = 1;
                            while (i <= 3 && !contrasenya) {
                                System.out.println("Escriu la contrasenya de l'usuari");
                                pass = sc.next();
                                if (!CtrlUsuaris.ExisteixUsuari_contrasenya(new UsuariNormal(user,pass))) {
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
                            if (contrasenya) CtrlUsuaris.borrarlinea(user,pass);
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
