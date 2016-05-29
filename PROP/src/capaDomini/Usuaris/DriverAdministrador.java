package capaDomini.Usuaris;


import capaDomini.Graf.CtrlGraf;
import java.util.Scanner;

/**
 * @author toni
 */

public class DriverAdministrador {
    public void main (CtrlGraf CG) {
        Administrador admin = new Administrador();
        Boolean bool = false;
        Boolean primer = true;
        System.out.println("Tria una opció:");
        Scanner sc = new Scanner(System.in);
        String user;
        String pass = null;
        String nom,tipus,node1,node2;
        int id;
        String opcio;
        while(!bool) {
            System.out.println("Si vols consultar tots els usuaris de la BD marca 1.");     
            System.out.println("Si vols borrar algun usuari marca 2.");
            System.out.println("Si vols fer una consulta marca 3.");
            System.out.println("Si vols consultar l'historial de consultes marca 4.");
            System.out.println("Si vols afegir un Node marca 5.");
            System.out.println("Si vols eliminar un Node marca 6.");
            System.out.println("Si vols afegir una Aresta marca 7.");
            System.out.println("Si vols eliminar una Aresta marca 8.");
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
                    admin.consultaBD();
                    break;
                case 2:
                    System.out.println("Entra el nom d'usuari: ");
                    sc.nextLine();
                    user = sc.nextLine();
                    System.out.println("Estas segur que vols eliminar aquest usuari?(S/N)");
                    opcio = sc.nextLine();
                    if (opcio.equals("S")) {
                        id = admin.borra_user(user);
                        if (id == 0) System.out.println("Nom d'usuari INCORRECTE");
                        else System.out.println("Usuari borrat correctament");
                    }
                    else System.out.println("Operació no realitzada");
                    break;
                case 3:
                    admin.consulta(CG);
                    break;
                case 4:
                    admin.consultar_historial(CG);
                    break;

                case 5:
                    System.out.println("Entra el Tipus del Node: ");
                    sc.nextLine();
                    tipus = sc.nextLine();
                    System.out.println("Entra el nom del Node: ");
                    nom = sc.nextLine();
                    System.out.println("Estas segur que el vols afegir el node?(S/N)");
                    opcio = sc.next();
                    if (opcio.equals("S")) {
                        id = admin.afegir_node(nom, tipus, CG);
                        if (id == 0) System.out.println("Node ja existent");
                        else System.out.println("Node afegit correctament");
                    }
                    else System.out.println("Operació no realitzada");
                    break;
                case 6:
                    System.out.println("Entra el nom del Node1: ");
                    sc.nextLine();
                    node1 = sc.next();
                    System.out.println("Entra el tipus del Node1: ");
                    sc.nextLine();
                    tipus = sc.nextLine();
                    System.out.println("Estas segur que el vols eliminar el node?(S/N)");
                    opcio = sc.nextLine();
                    if (opcio.equals("S")) {
                        id = admin.eliminar_node(node1, tipus, CG);
                        if (id == 0) System.out.println("Node NO existeix");
                        else System.out.println("Node eliminat correctament");
                    }
                    else System.out.println("Operació no realitzada");
                    break;
                case 7:
                    System.out.println("Entra el nom del Node1:");
                    sc.nextLine();
                    node1 = sc.nextLine();
                    System.out.println("Entra el nom del Node2:");
                    node2 = sc.nextLine();
                    System.out.println("Entra el tipus del Node2:");
                    tipus = sc.nextLine();
                    System.out.println("Estas segur que el vols afegir l'aresta?(S/N)");
                    opcio = sc.nextLine();
                    if (opcio.equals("S")) {
                        id = admin.afegir_aresta(node1, node2, tipus, CG);
                        if (id == 0) System.out.println("Node1 NO existent");
                        else if (id == 1) System.out.println("Node2 NO existent");
                        else if (id == 2) System.out.println("Aresta ja existent");
                        else System.out.println("Aresta afegida correctament");
                    }
                    else System.out.println("Operació no realitzada");
                    break;
                case 8:
                    System.out.println("Entra el nom del Node1:");
                    sc.next();
                    node1 = sc.nextLine();
                    System.out.println("Entra el nom del Node2:");
                    sc.next();
                    node2 = sc.nextLine();
                    System.out.println("Entra el tipus del Node2:");
                    tipus = sc.nextLine();
                    System.out.println("Estas segur que el vols afegir l'aresta?(S/N)");
                    opcio = sc.next();
                    if (opcio.equals("S")) {
                        id = admin.eliminar_aresta(node1,node2,tipus,CG);
                        if (id == 0) System.out.println("Node1 NO existent");
                        else if (id == 1) System.out.println("Node2 NO existent");
                        else if (id == 2) System.out.println("Aresta NO existent");
                        else if (id == 3) System.out.println("Aresta eliminada correctament");
                    }
                    else System.out.println("Operació no realitzada");
                    break;    
                default:
                    bool = true;
                    break;
                }
            }
        } 
    }   
