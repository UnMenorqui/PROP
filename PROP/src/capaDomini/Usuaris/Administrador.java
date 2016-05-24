package capaDomini.Usuaris;

/**
 *
 * @author toni_
 * 
 * Aquesta classe, està definida per a poder portar a terme les
 * operacions que un administrador faria, tals como modificar usuaris,
 * eliminar-los, i altres operacions de gestionar la base de dades principals
 * i també el GRAF.
 */


public class Administrador extends UsuariNormal {
    
    public static void consultaBD() {
        CtrlUsuaris ctrl = new CtrlUsuaris();
        ctrl.consultaUsuarisBD();
    }
    
    public static void borra_user(String usuari) {
        
    }
}