/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Usuaris;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Perfils.DriverPerfil;
import java.io.IOException;

/**
 *
 * @author Toni
 */

public class DriverConvidat {
    public void main(CtrlGraf G) throws IOException {
        DriverPerfil ctrl = new DriverPerfil();
        ctrl.main(G,false);
    }
}
