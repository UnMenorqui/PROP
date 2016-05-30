package capaDomini.Usuaris;


/**
 *
 * @author toni_
 */

public class UsuariConvidat {
    
    private String user_name = "";
    
    
    public UsuariConvidat() {
        user_name = "Convidat";
    }
    
    public String consultar_username() {
        return user_name;
    }   
}
