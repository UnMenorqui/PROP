/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prop;

import capaDomini.Usuaris.CtrlUsuaris;
import capaDomini.Usuaris.DriverUsuariNormal;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;



/**
 *
 * @author toni_
 */
public class PROP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TransformerException, SAXException, IOException, ParserConfigurationException {
        // TODO code application logic here
        DriverUsuariNormal driver = new DriverUsuariNormal();
        driver.main();
        
    }
    
}
