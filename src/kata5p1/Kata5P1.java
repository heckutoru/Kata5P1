/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author Entrar
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        // TODO code application logic here
        String url = "jdbc:sqlite:C:\\Users\\Entrar\\Downloads\\SQLiteDatabaseBrowserPortable\\Data\\Kata5.db";
        Connection conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement();
        String sqlSelectPeople = "Select * from PEOPLE;";
        ResultSet result = statement.executeQuery(sqlSelectPeople);
        while(result.next()){
            System.out.println("ID:" + result.getInt("id"));
            System.out.println("Name:" + result.getString("Name"));
            System.out.println("Apellidos:" + result.getString("Apellidos"));
            System.out.println("Departamento:" + result.getString("Departamento")+ "\n");
        }
        String sqlCreateTable = "CREATE TABLE `Mails` (\n" +
"	`ID`	INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"	`Mail`	TEXT NOT NULL\n" + ");";
        
        //statement.execute(sqlCreateTable);
        String mail = "test@ulpgc.es";
        String sqlInsert = "Insert INTO Mails (Mail) VALUES ('" + mail + "');";
        statement.executeUpdate(sqlInsert);
        String sqlCount = "Select count (*) from Mails";
    
        String nameFile = "C:\\Users\\Entrar\\Downloads\\Ficheros para la práctica en laboratorio 5 -20171110\\emails.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
        while((mail = reader.readLine()) != null){
            if(!mail.contains("@")){
                continue;
            }
            sqlInsert = "Insert INTO Mails (Mail) VALUES ('" + mail + "');";
            //statement.execute(sqlInsert);
        }
        ResultSet amount = statement.executeQuery(sqlCount);
        System.out.println("Existen " + amount.getInt(1) + " Mails registrados");
    }
    
}
