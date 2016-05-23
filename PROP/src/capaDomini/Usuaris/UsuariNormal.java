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
        return user_name;
    }
    
    /*  Retorna la contrasenya.
    Pre:    Cap.
    Post:   Retorna la contrasenya.
    */
    public String consultar_password() {
        return password;
    }   
    
    /*  Modifca el nom de l'usuari.
    Pre:    Cap.
    Post:   El nom de l'usuari ha quedat modificat.
    */
    
    public void modifica_user(String new_user) {
        user_name = new_user;
    }
    
    /*  Modifica l'atribut password.
    Pre:    Cap.
    Post:   password ha quedat modificada per unaltra.
    */
    public void modifica_pass(String new_password) {
        password = new_password;
    }

    
}
