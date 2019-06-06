package P2;
import java.sql.*;

public class OracleBaseDao {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//Kevin.fritz.box:1521/xepdb1";
	private static final String DB_USER = "KEVINOVCHIP";
	private static final String DB_PASS = "12345";
	private static Connection conn;

	protected static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public void closeConnection(){
		// NVT
	}
} 