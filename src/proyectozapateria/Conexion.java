/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectozapateria;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC08_Lab06_Inv
 */
public class Conexion {
     Connection connect = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost/ventas", "root", "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fallo conexión Inténtalo de nuevo más tarde.  ");
        }
        return connect;
    }
    public void escribir(String tabla, String[] codigos, String[] campos) {
        String codigos_sal = "";
        String campos_sal = "";
        String num_val = "";
        String inser = "";
        for (int i = 0; i < codigos.length; i++) {

            if (i != codigos.length - 1) {
                codigos_sal += codigos[i] + ", ";
                num_val += "?, ";
            } else {
                num_val += "?";
                codigos_sal += codigos[i];
            }
        }

        inser = "INSERT INTO " + tabla + "(" + codigos_sal + ")" + " VALUES(" + num_val + ")";
        try {
            PreparedStatement INGRESO = connect.prepareStatement(inser);
            for (int i = 0; i < campos.length; i++) {
                INGRESO.setString(i + 1, campos[i]);
            }
            int a = INGRESO.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "Se Inserto el dato correctamente");
            }
            INGRESO.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error sql "+e);
            JOptionPane.showMessageDialog(null,"ingreso fallido");
        }

    }
    
    public void eliminar(String tabla,String campo, String valor) {
        ResultSet rs = null;
        String sql = "DELETE FROM " + tabla+" WHERE "+campo+"="+valor;
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizar(String tabla,String campo1,String campo2, String valor1,String valor2,String comparacion,String comp_valor) {
        ResultSet rs = null;
        String sql = "UPDATE " + tabla+" SET "+campo1+"= "+valor1+", "+campo2+"= "+valor2+" WHERE "+comparacion+" = "+comp_valor;
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet consultar(String tabla) {
        ResultSet rs = null;
        String sql = "SELECT * FROM " + tabla;
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rs;
    }
    
    public ResultSet consultar(String tabla, String cam_consultar,String consulta) {
        ResultSet rs = null;
        String sql = "SELECT * FROM " + tabla+" WHERE "+cam_consultar+" = "+consulta;
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rs;
    }
    
    public ResultSet consultar(String tabla,String campo) {
        ResultSet rs = null;
        String sql = "SELECT "+campo+" FROM " + tabla+" ;";
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
        return rs;
    }
    
    public ResultSet consulta_compleja(String tabla,String[] campos,String condicion) {
        //condicion es la condicion compleja ejemplo where a='1' and b='2'
        //esa condicion debe ser tratada antes de enviarse a este metodo
        String campos_cont="";
        for (int i = 0; i < campos.length; i++) {
            if (i==campos.length-1) {
                campos_cont+=" "+campos[i];
            }else{
                campos_cont+=" "+campos[i]+",";
            }
        }
        ResultSet rs = null;
        String sql = "SELECT "+campos_cont+" FROM " + tabla+" "+condicion+" ;";
        try {
            PreparedStatement stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
        return rs;
    }
}
