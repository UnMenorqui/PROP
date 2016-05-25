package capaDomini.Usuaris;


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
    CtrlUsuaris ctrl;
    
    public UsuariNormal() {
        ctrl = new CtrlUsuaris();
    }
    
    public UsuariNormal(String usuari, String password) {
        this.user_name = usuari;
        this.password = password;
        ctrl = new CtrlUsuaris();
    }
    
    public String consultar_username() {
        return user_name;
    }
    
    public String consultar_password() {
        return password;
    }   
    
    public void modifica_user(String new_user) {
        ctrl.modificar_usuari(user_name, password, new_user);
        user_name = new_user;
    }
    
    public void modifica_pass(String new_password) {
        ctrl.modificar_password(user_name, password, new_password);
        password = new_password;
    }

    
}
