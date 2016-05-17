/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverTest {

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // Create webDriver reference
        WebDriver driver;
        
        // Launch FirefoxDriver
        driver = new FirefoxDriver();
        String route = new java.io.File(".").getCanonicalPath();
        System.out.println("file:/"+route+"/index.html");
        driver.get("file://"+route+"/index.html");
    }
    
    FirefoxDriverTest () {
    }

}