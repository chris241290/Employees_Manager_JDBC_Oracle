package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcConnection.Constants;
import jdbcConnection.GetConnection;
import payloads.Employee;
import service.in.EmployeeService;
import query.DatabaseQuery;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public Boolean addEmployee(Employee employee) {
		Connection connection = GetConnection.getJdbcConnection();
		if(employee != null && connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(DatabaseQuery.addEmployeeQuery());
				preparedStatement.setInt(Constants.getFirstQueryParameter(), employee.getId());
				preparedStatement.setString(Constants.getSecondQueryParameter(), employee.getName());
				preparedStatement.setString(Constants.getThirdQueryParameter(), employee.getSurname());
				preparedStatement.executeUpdate();
				return true;
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
				return false;
			}finally {
				try {
					connection.close();
				}catch(Exception exception) {
					exception.printStackTrace();
				}	
			}
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Connection connection = GetConnection.getJdbcConnection();
		List<Employee> listOfAllEmployees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DatabaseQuery.getAllEmployees());
			ResultSet resultSet = preparedStatement.executeQuery();;
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSurname(resultSet.getString("surname"));
				listOfAllEmployees.add(employee);
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return listOfAllEmployees;
	}

	@Override
	public Employee getEmployeeById(Integer IdOfEmployeeToFind ) {
		Connection connection = GetConnection.getJdbcConnection();
		Employee employee = new Employee();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DatabaseQuery.getEmployeeById());
			preparedStatement.setInt(Constants.getFirstQueryParameter(), IdOfEmployeeToFind);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSurname(resultSet.getString("surname"));
			}
		}catch(Exception exception) {
			exception.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(Exception exception) {
				exception.printStackTrace();
			}

		}
		return employee;
	}

	@Override
	public Boolean deleteEmployeeById(Integer IdOfEmployeeToDelete ) {
		Connection connection = GetConnection.getJdbcConnection();
		if(IdOfEmployeeToDelete != null && connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(DatabaseQuery.deleteEmployeeQuery());
				preparedStatement.setInt(Constants.getFirstQueryParameter(), IdOfEmployeeToDelete);
				preparedStatement.executeUpdate();
				return true;
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
				return false;
			}finally {
				try {
					connection.close();
				}catch(Exception exception) {
					exception.printStackTrace();
				}	
			}
		}
		return false;
	}
}