package application;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSource {

    protected Connection connection;
    
  
    private static String url = "jdbc:mysql://localhost:3306/cms";
    private static String username = "root";
    private static String password = "";
    
    public DataSource() {
    	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	public void close() {
    	try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
	}
}
