package capaDomini.Usuaris;


import capaDomini.Graf.CtrlGraf;
import capaDomini.Perfils.DriverPerfil;
import java.util.Scanner;

/**
 * @author toni
 */

public class DriverAdministrador {
 
    public void main (CtrlGraf CG, CtrlUsuaris U) {
            Boolean bool = false;
            Boolean primer = true;
            System.out.println("Tria una opció:");
            Scanner sc = new Scanner(System.in);
            
            String user;
            String pass = null;
            String nom,tipus,node1,node2;
            while(!bool) {
                System.out.println("Si vols consultar tots els usuaris de la BD marca 1.");
                        
                System.out.println("Si vols modificar el nom d'un usuari marca 2.");

                System.out.println("Si vols borrar un usuari marca 3.");

                System.out.println("Si vols fer una consulta marca 4.");

                System.out.println("Si vols afegir un Node marca 5.");

                System.out.println("Si vols afegir una Aresta marca 6.");

                System.out.println("Si vols eliminar un Node marca 7.");

                System.out.println("Si vols eliminar una Aresta marca 8.");

                System.out.println("Si vols consultar l'historial de consultes marca 9.");

                System.out.println("Si vols acabar marca un altre número.");
                
                if(!primer) {
                    System.out.println("Operació realitzada.");
                    System.out.println("---------------------");
                    System.out.println("Torna a entrar la operació a fer:");
                } else primer = false;
                int prova = sc.nextInt();
                switch(prova) {
                    case 1:
                        U.consultaUsuarisBD();
                        break;
                    case 2:
                        System.out.println("Entra el teu username: ");
                        user = sc.next();
                        System.out.println("Entra el teu password: ");
                        pass = sc.next();
                        System.out.println("Escriu el nou username:");
                        String nou_user = sc.next();
                        if (U.modificar_usuari(user, pass, nou_user)) {
                           System.out.println("Usuari modificat correctament"); 
                        } else {
                            System.out.println("Usuari i/o contrasenya incorrecte");
                        }
                        break;
                    case 3:
                        System.out.println("Entra el nom de l'usuari: ");
                        user = sc.next();
                        System.out.println("Escriu la contrasenya de l'usuari");
                        pass = sc.next();
                        if (U.borrarlinea(user,pass)) {
                            System.out.println("Usuari borrat correctament");
                        } else {
                            System.out.println("Usuari i/o contrasenya incorrecte");
                        }
                        break;
                        
                    case 4:
                        DriverPerfil ctrls = new DriverPerfil();
                        ctrls.main(CG,true);
                        break;
                    case 5:
                        System.out.println("Entra el Tipus del Node: ");
                        sc.nextLine();
                        tipus = sc.nextLine();
                        System.out.println("Entra el nom del Node: ");
                        nom = sc.nextLine();
                        if (CG.afegirNode(tipus, nom)) System.out.println("Node ja existent");
                        else System.out.println("Node Afegit");
                        break;
                    case 6:
                        System.out.println("Entra el nom del Node1: ");
                        sc.nextLine();
                        node1 = sc.nextLine();
                        System.out.println("Entra el nom del Node2: ");
                        node2 = sc.nextLine();
                        System.out.println("Entra el tipus del Node2: ");
                        tipus = sc.nextLine();
                        if (CG.afegirAresta(node1, node2,tipus)) System.out.println("Aresta NO Afegida");
                        else System.out.println("Aresta Afegida");
                        break;
                    case 7:
                        System.out.println("Entra el nom del Node1: ");
                        sc.nextLine();
                        node1 = sc.nextLine();
                        System.out.println("Entra el tipus del Node1: ");
                        tipus = sc.nextLine();
                        if (CG.eliminarNode(node1,tipus)) System.out.println("Node no existent");
                        else System.out.println("Node eliminat");
                        break;
                    case 8:
                        System.out.println("Entra el nom del Node1: ");
                        node1 = sc.nextLine();
                        System.out.println("Entra el nom del Node2: ");
                        node2 = sc.nextLine();
                        System.out.println("Entra el tipus del Node2: ");
                        tipus = sc.nextLine();
                        if (CG.eliminarAresta(node1,node2,tipus)) System.out.println("Aresta NO Eliminada");
                        else System.out.println("Aresta Eliminada");
                        break; 
                    case 9:
                        U.consultar(CG);
                        break;
                        
                    default:
                        bool = true;
                        break;
                }
            }
        } 
    }   
