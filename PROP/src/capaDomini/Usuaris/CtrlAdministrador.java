package capaDomini.Usuaris;


import capaDomini.Graf.Graf_PageRank;
import capaDomini.Perfils.CtrlPerfil;
import capaDomini.consulta.Historial;
<<<<<<< HEAD
import java.io.IOException;
=======
>>>>>>> Merge-Consultes-i-Main
import java.util.Scanner;

/**
 * @author toni
 */

public class CtrlAdministrador {
 
    public void main (Graf_PageRank G) throws IOException {
        CtrlAdministrador us = new CtrlAdministrador();
        try (Scanner sc = new Scanner(System.in)) {
            Boolean bool = false;
            Boolean primer = true;
            CtrlUsuaris ctrlusuaris = new CtrlUsuaris();
            System.out.println("Tria una opció:");
            System.out.println("Si vols consultar tots els usuaris de la BD marca 1.");
            //ja esta a Administrador
            
            System.out.println("Si vols modificar el nom d'un usuari marca 2.");
            //ja esta a UsuariNormal
            
            System.out.println("Si vols borrar un usuari marca 3.");
            //ja esta a Administrador
            
            System.out.println("Si vols fer una consulta marca 4.");
            
            System.out.println("Si vols consultar l'historial de consultes marca 5.");
            
            System.out.println("Si vols consultar l'historial de consultes marca 6.");
            
            System.out.println("Si vols acabar marca 7.");
            
            String user;
            String pass = null;
            CtrlUsuaris ctrl = new CtrlUsuaris();
            Graf_PageRank G = new Graf_PageRank();
            while(!bool) {
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
                        CtrlPerfil ctrls = new CtrlPerfil();
                        ctrls.main(G);
                        break;
                    case 5:
<<<<<<< HEAD
                        Historial hist = new Historial();
                        //Crida a escriure historial
=======
                        CtrlPerfil ctrls = new CtrlPerfil();
                        ctrls.main(G);
>>>>>>> Merge-Consultes-i-Main
                        break;
                        
                    case 6:
<<<<<<< HEAD
                        bool = true;
=======
                        Historial hist = new Historial();
                        //Crida a escriure historial
                        break;
                        
                    case 7:
>>>>>>> Merge-Consultes-i-Main
                        break;
                }
            }
        }
        System.out.println(); 
    }   
}
