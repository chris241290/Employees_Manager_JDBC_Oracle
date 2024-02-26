package EmployeeController;

import java.util.List;

import payloads.Employee;
import service.in.EmployeeService;
import service.impl.EmployeeServiceImpl;

public class EmployeeController {
	
    private EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeServiceImpl();
    }

    // Metodo per aggiungere un nuovo impiegato
    public boolean addEmployee(int id, String name, String surname) {
        Employee employee = new Employee(id, name, surname);
        return employeeService.addEmployee(employee);
    }

    // Metodo per ottenere tutti gli impiegati
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Metodo per ottenere un impiegato tramite ID
    public Employee getEmployeeById(int id) {
        return employeeService.getEmployeeById(id);
    }

    // Metodo per eliminare un impiegato tramite ID
    public boolean deleteEmployeeById(int id) {
        return employeeService.deleteEmployeeById(id);
    }
}
