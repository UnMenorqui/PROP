package capaDomini.Usuaris;


import capaDomini.Graf.CtrlGraf;
import capaDomini.Graf.Graf_PageRank;
import capaDomini.Perfils.DriverPerfil;
import java.util.Scanner;

/**
 * @author toni
 */

public class DriverAdministrador {
 
    public void main (Graf_PageRank G) {
            Boolean bool = false;
            Boolean primer = true;
            CtrlUsuaris ctrlusuaris = new CtrlUsuaris();
            CtrlGraf CG = new CtrlGraf();
            System.out.println("Tria una opció:");
            Scanner sc = new Scanner(System.in);
            
            String user;
            String pass = null;
            String nom,tipus,node1,node2;
            CtrlUsuaris ctrl = new CtrlUsuaris();
            while(!bool) {
                System.out.println("Si vols consultar tots els usuaris de la BD marca 1.");
            //ja esta a Administrador
            
            System.out.println("Si vols modificar el nom d'un usuari marca 2.");
            //ja esta a UsuariNormal
            
            System.out.println("Si vols borrar un usuari marca 3.");
            //ja esta a Administrador
            
            System.out.println("Si vols fer una consulta marca 4.");
            /*
            System.out.println("Si vols afegir un Node marca 5.");
            
            System.out.println("Si vols afegir una Aresta marca 6.");
            
            System.out.println("Si vols eliminar un Node marca 7.");
            
            System.out.println("Si vols eliminar una Aresta marca 8.");
            */
            System.out.println("Si vols consultar l'historial de consultes marca 5.");
            
            System.out.println("Si vols acabar marca 6.");
                if(!primer) {
                    System.out.println("Operació realitzada.");
                    System.out.println("---------------------");
                    System.out.println("Torna a entrar la operació a fer:");
                } else primer = false;
                int prova = sc.nextInt();
                switch(prova) {
                    case 1:
                        ctrl.consultaUsuarisBD();
                        break;
                    case 2:
                        System.out.println("Entra el teu username: ");
                        user = sc.next();
                        System.out.println("Entra el teu password: ");
                        pass = sc.next();
                        System.out.println("Escriu el nou username:");
                        String nou_user = sc.next();
                        if (ctrl.modificar_usuari(user, pass, nou_user)) {
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
                        if (ctrl.borrarlinea(user,pass)) {
                            System.out.println("Usuari borrat correctament");
                        } else {
                            System.out.println("Usuari i/o contrasenya incorrecte");
                        }
                        break;
                        
                    case 4:
                        DriverPerfil ctrls = new DriverPerfil();
                        ctrls.main(G,true);
                        break;
                    /*
                    case 5:
                        System.out.println("Entra el Tipus del Node: ");
                        tipus = sc.nextLine();
                        System.out.println("Entra el nom del Node: ");
                        nom = sc.nextLine();
                        CG.afegirNode(tipus, nom);
                    case 6:
                        System.out.println("Entra el nom del Node1: ");
                        node1 = sc.nextLine();
                        System.out.println("Entra el nom del Node2: ");
                        node2 = sc.nextLine();
                        CG.afegirAresta(node1, node2);
                        
                    case 7:
                        System.out.println("Entra el nom del Node1: ");
                        node1 = sc.nextLine();
                        CG.eliminarNode(node1);
                    case 8:
                        System.out.println("Entra el nom del Node1: ");
                        node1 = sc.nextLine();
                        System.out.println("Entra el nom del Node2: ");
                        node2 = sc.nextLine();
                        CG.eliminarAresta(node1,node2);
                            */
                    case 5:
                        ctrlusuaris.consultar(G);
                        break;
                        
                    case 6:
                        bool = true;
                        break;
                }
            }
        }
        //System.out.println(); 
    }   
