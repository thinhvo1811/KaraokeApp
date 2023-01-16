package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection con = null;
	public static Connect instance = new Connect();
	
	public static Connection getCon() {
		return con;
	}
	public static Connect getInstance() {
		return instance;
	}
	
	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLKaraoke";
		con = DriverManager.getConnection(url, "sa","sapassword");
	}
	public void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
