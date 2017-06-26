/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozapateria;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class Conexion {
   
    Connection connect =  null; 
    public Connection conectar()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/ventas","root",""); 
            
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, "Fallo conexión Inténtalo de nuevo más tarde.  ");
        }
       return connect;
        
    }
    
}
