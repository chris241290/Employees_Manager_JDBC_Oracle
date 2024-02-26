package jdbcConnection;

public class Constants {
	
	private static final String URL ="";
	private static final String USER="";
	private static final String PASSWORD="";
	private static final String DB_DRIVER="";
	private static final Integer FIRST_QUERY_PARAMETER = 1;
	private static final Integer SECOND_QUERY_PARAMETER = 2;
	private static final Integer THIRD_QUERY_PARAMETER = 3;
	
	public static String getUrl() {
		return URL;
	}
	public static String getUser() {
		return USER;
	}
	public static String getPassword() {
		return PASSWORD;
	}
	public static String getDbDriver() {
		return DB_DRIVER;
	}
	
	public static Integer getFirstQueryParameter() {
		return FIRST_QUERY_PARAMETER;
	}
	public static Integer getSecondQueryParameter() {
		return SECOND_QUERY_PARAMETER;
	}
	public static Integer getThirdQueryParameter() {
		return THIRD_QUERY_PARAMETER;
	}
	

}
