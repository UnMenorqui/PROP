/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.events.ScriptContextAdapter;
import com.teamdev.jxbrowser.chromium.events.ScriptContextEvent;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
 
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class prop {
    public static void main(String args[]) throws IOException {
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame();
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(1368, 768);
        frame.setVisible(true);
        String route = new java.io.File(".").getCanonicalPath();
        browser.loadURL("file://"+route+"/index.html");
        
        browser.addScriptContextListener(new ScriptContextAdapter() {
            @Override
            public void onScriptContextCreated(ScriptContextEvent event) {
                Browser browser = event.getBrowser();
                JSValue window = browser.executeJavaScriptAndReturnValue("window");
                window.asObject().setProperty("java", new JavaObject());
            }
        });
    }
}