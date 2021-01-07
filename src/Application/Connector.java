package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

Connection connect;
	
@SuppressWarnings("finally")
public Connection getConnection() {
	try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms" , "root" , "");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return connect;
}

		
	}
}