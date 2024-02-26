package service.in;

import java.util.List;

import payloads.Employee;

public interface EmployeeService {
	
	public Boolean addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Integer IdOfEmployeeToFind);
	public Boolean deleteEmployeeById(Integer IdOfEmployeeToDelete);
}