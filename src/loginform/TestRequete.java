/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class TestRequete {
    public static void main(String[] args){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/formulaire", "root", "");
            
            // Création du statement
            Statement state = conn.createStatement();
            // Création du resultset
            String user = "adocal";
            ResultSet result = state.executeQuery("SELECT * FROM users="+user);
            // Récupération des métadata
            ResultSetMetaData meta = result.getMetaData();
            
            // Affichage du nombre de colonnes
            int count = meta.getColumnCount();
            System.out.println("Il y a " + count + " colonnes dans la table " + meta.getTableName(count));
            
            // Affichage des colonnes 
            for(int i = 1; i <= count; i++){
                System.out.println("*" + meta.getColumnName(i));
            }
            
            System.out.println("Voici les users et leurs mot de passe :"+"`\n");
            
            while(result.next()){
                System.out.print(result.getString("username") + "\t" + "|");
                System.out.println("\t" + result.getString("password"));
                
                System.out.println("\n");
            }
            
            result.close();
            state.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
