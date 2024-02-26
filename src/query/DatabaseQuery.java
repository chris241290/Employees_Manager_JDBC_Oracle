package query;

public class DatabaseQuery {
	
	public static String addEmployeeQuery(){
		String query = "INSERT INTO employees (id,name,surname) values (?,?,?);";
		return query;
	}
	
	public static String deleteEmployeeQuery() {
		String query = "DELETE FROM employees WHERE id = ?;";
		return query;
	}
	
	public static String getAllEmployees() {
		String query = "SELECT * FROM employees;";
		return query;
	}
	
	public static String getEmployeeById() {
		String query = "SELECT id,name,surname FROM employees WHERE id=?;";
		return query;
	}
}