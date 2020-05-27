package launch;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oz500
 */
public class Main {
    
    
    public static void main(String[] args) throws Exception{
        
        String webAppDirLocation = "src/main/webapp";
        
        String webPort = System.getenv("PORT");
        
        if(webPort == null || webPort.isEmpty()){
            webPort = "8080";
        }
 
        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setDescriptor(webAppDirLocation+"/WEB-INF/web.xml");
        root.setResourceBase(webAppDirLocation);
        root.setParentLoaderPriority(true);
 
        server.setHandler(root);
        server.start();
        server.join();
    }
    
}
