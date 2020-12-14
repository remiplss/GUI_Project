package Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author romanphilip
 */
public class DataSource {
 
    Connection conn = null;

    public Connection createConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Db parameters
            String url = "jdbc:mysql://localhost:3307/gui_sql";
            String user = "root";
            String password = "";

                ///Create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

        } catch( Exception e )
    {
      System.out.println("Error Occured " + e.toString());
    }
        return conn;
    }
}
