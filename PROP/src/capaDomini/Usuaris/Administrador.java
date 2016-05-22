/*
package capaDomini.Usuaris;


import java.util.Scanner;

/**
 *
 * @author toni_
 * 
 * Aquesta classe, està definida per a poder portar a terme les
 * operacions que un administrador faria, tals como modificar usuaris,
 * eliminar-los, i altres operacions de gestionar la base de dades principals
 * i també el GRAF.
 */

/*
public class Administrador extends UsuariNormal {
    
    public static void consultaBD() {
        CtrlUsuaris ctrl = new CtrlUsuaris();
        ctrl.consultaUsuarisBD();
    }
    
    public static void borra_user() {
        CtrlUsuaris ctrl = new CtrlUsuaris();
        System.out.println("Entra el nom de l'usuari: ");
        Integer i;
        String user,pass = null;
        Scanner sc = new Scanner(System.in);
        user = sc.next();
        if (!ctrl.ExisteixUsuari(user)) {
            System.out.println("L'usuari no existeix");
        }
        else {
            boolean contrasenya = false;
            i = 1;
            while (i <= 3 && !contrasenya) {
                System.out.println("Escriu la contrasenya de l'usuari");
                pass = sc.next();
                if (!ctrl.ExisteixUsuari_contrasenya(user,pass)) {
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
            if (contrasenya) ctrl.borrarlinea(user,pass);
        }
        sc.close();
    }
}
*/