package capaDomini.Usuaris;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Perfils.DriverPerfil;


/**
 *
 * @author toni_
 */

public class UsuariConvidat {
    
    DriverPerfil ctrl;
    
    public UsuariConvidat() {
        ctrl = new DriverPerfil();
    }
    
    public void consulta(CtrlGraf G) {    
        ctrl.main(G,false);
    }
}
