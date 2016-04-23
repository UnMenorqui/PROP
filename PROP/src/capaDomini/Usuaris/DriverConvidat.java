/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Usuaris;

import capaDomini.Perfils.DriverPerfil;
import capaDomini.Graf.Graf_PageRank;
import java.io.IOException;

/**
 *
 * @author Toni
 */

public class DriverConvidat {
    public void main(Graf_PageRank G) throws IOException {
        DriverPerfil ctrl = new DriverPerfil();
        ctrl.main(G,false);
    }
}
