/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Entrar
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String url = "jdbc:sqlite:C:\\Users\\Entrar\\Downloads\\SQLiteDatabaseBrowserPortable\\Data\\Kata5.db";
        Connection conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement();
        String sql = "Select * from PEOPLE;";
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            System.out.println("ID:" + result.getInt("id"));
            System.out.println("Name:" + result.getString("Name"));
            System.out.println("Apellidos:" + result.getString("Apellidos"));
            System.out.println("Departamento:" + result.getString("Departamento")+ "\n");
        }
        
    }
    
}
