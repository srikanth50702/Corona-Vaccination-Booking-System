
package corona;

import flight.*;
import java.sql.*;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/corona"; 
            c =DriverManager.getConnection("jdbc:mysql:///corona","root","srikanth5297");             
            s =c.createStatement();  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
