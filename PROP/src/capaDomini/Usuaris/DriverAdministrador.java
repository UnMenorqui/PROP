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
            int id;
            while(!bool) {
                System.out.println("Si vols consultar tots els usuaris de la BD marca 1.");     
                System.out.println("Si vols modificar el nom d'un usuari marca 2.");
                System.out.println("Si vols borrar algun usuari marca 3.");
                System.out.println("Si vols fer una consulta marca 4.");
                System.out.println("Si vols afegir un Node marca 5.");
                System.out.println("Si vols eliminar un Node marca 6.");
                System.out.println("Si vols afegir una Aresta marca 7.");
                System.out.println("Si vols eliminar una Aresta marca 8.");
                System.out.println("Si vols consultar l'historial de consultes marca 9.");
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
                        U.consultaUsuarisBD();
                        break;
                    case 2:
                        System.out.println("Entra el teu nom d'usuari:");
                        user = sc.next();
                        System.out.println("Entra la teva contrasenya:");
                        pass = sc.next();
                        System.out.println("Escriu el nou nom d'usuari:");
                        String nou_user = sc.next();
                        id = U.modificar_usuari(user, pass, nou_user);
                        if (id == 0) System.out.println("Nom d'usuari INCORRECTE"); 
                        else if (id == 1) System.out.println("Contrasenya INCORRECTA");
                        else if (id == 2) System.out.println("Nom d'usuari modificat correctament");
                        else if (id == 3) System.out.println("El nou nom d'usuari ja existeix");  
                        break;
                    case 3:
                        System.out.println("Entra el nom d'usuari: ");
                        user = sc.next();
                        id = U.borrarUsuariAdmin(user);
                        if (id == 0) System.out.println("Nom d'usuari INCORRECTE");
                        else if (id == 1) System.out.println("Usuari borrat correctament");
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
                        id = CG.afegirNode(tipus, nom);
                        if (id == 0) System.out.println("Node ja existent");
                        else if (id == 1) System.out.println("Node afegit correctament");
                        break;
                    case 6:
                        System.out.println("Entra el nom del Node1: ");
                        sc.nextLine();
                        node1 = sc.nextLine();
                        System.out.println("Entra el tipus del Node1: ");
                        tipus = sc.nextLine();
                        id = CG.eliminarNode(node1, tipus);
                        if (id == 0) System.out.println("Node NO existeix");
                        else if (id == 1) System.out.println("Node eliminat correctament");
                        break;
                    case 7:
                        System.out.println("Entra el nom del Node1: ");
                        sc.nextLine();
                        node1 = sc.nextLine();
                        System.out.println("Entra el nom del Node2: ");
                        node2 = sc.nextLine();
                        System.out.println("Entra el tipus del Node2: ");
                        tipus = sc.nextLine();
                        id = CG.afegirAresta(node1, node2, tipus);
                        if (id == 0) System.out.println("Node1 NO existent");
                        else if (id == 1) System.out.println("Node2 NO existent");
                        else if (id == 2) System.out.println("Aresta ja existent");
                        else if (id == 3) System.out.println("Aresta afegida correctament");
                        break;
                    case 8:
                        System.out.println("Entra el nom del Node1: ");
                        node1 = sc.nextLine();
                        System.out.println("Entra el nom del Node2: ");
                        node2 = sc.nextLine();
                        System.out.println("Entra el tipus del Node2: ");
                        tipus = sc.nextLine();
                        id = CG.eliminarAresta(node1,node2,tipus);
                        if (id == 0) System.out.println("Node1 NO existent");
                        else if (id == 1) System.out.println("Node2 NO existent");
                        else if (id == 2) System.out.println("Aresta NO existent");
                        else if (id == 3) System.out.println("Aresta eliminada correctament");
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
