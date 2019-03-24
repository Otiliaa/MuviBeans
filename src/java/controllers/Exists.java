/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author OTI
 */
import java.sql.*;
public class Exists {
    
    public boolean userExists(String username){
         boolean usernameExists = false;

    try
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("muvi:mysql://localhost:3306/MuviBeans", "muvi", "password");

        PreparedStatement st = connection.prepareStatement("select * from users order by username desc");
        ResultSet r1=st.executeQuery();
        String usernameCounter;
         if(r1.next()) 
         {
           usernameCounter =  r1.getString("username");
           if(usernameCounter.equals(username)) //this part does not happen even if it should
           {
               System.out.println("It already exists");
              usernameExists = true;
           }
         }


     }

     catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
     catch (ClassNotFoundException cE) 
     {
        System.out.println("Class Not Found Exception: "+ cE.toString());
     }

 return usernameExists;
    }
    
}
