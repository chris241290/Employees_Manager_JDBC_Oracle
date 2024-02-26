package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public static Connection getJdbcConnection() {
		Connection connection = null;
		try {
			Class.forName(Constants.getDbDriver());
			connection = DriverManager.getConnection(Constants.getUrl(), Constants.getUser(), Constants.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}