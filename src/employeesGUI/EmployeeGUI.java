package employeesGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import EmployeeController.EmployeeController;
import payloads.Employee;

public class EmployeeGUI extends JFrame{

	private EmployeeController employeeController;

	public EmployeeGUI() {
		this.employeeController = new EmployeeController();

		// Impostazioni della finestra principale
		setTitle("Employee Management");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Pannello principale
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		add(mainPanel);

		// Bottone per ottenere tutti gli impiegati
		JButton getAllEmployeesButton = new JButton("Get All Employees");
		mainPanel.add(getAllEmployeesButton);

		// Bottone per ottenere un impiegato per ID
		JButton getEmployeeByIdButton = new JButton("Get Employee By ID");
		mainPanel.add(getEmployeeByIdButton);

		// Bottone per aggiungere un nuovo impiegato
		JButton addEmployeeButton = new JButton("Add Employee");
		mainPanel.add(addEmployeeButton);

		// Bottone per eliminare un impiegato per ID
		JButton deleteEmployeeByIdButton = new JButton("Delete Employee By ID");
		mainPanel.add(deleteEmployeeByIdButton);

		// Area di testo per visualizzare gli impiegati
		JTextArea employeeTextArea = new JTextArea(10, 30);
		mainPanel.add(new JScrollPane(employeeTextArea));

		// Aggiungi azione al bottone "Get All Employees"
		getAllEmployeesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Employee> employees = employeeController.getAllEmployees();
				displayEmployees(employeeTextArea, employees);
			}
		});

		// Aggiungi azione al bottone "Get Employee By ID"
		getEmployeeByIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idString = JOptionPane.showInputDialog("Enter Employee ID:");
				if (idString != null && !idString.isEmpty()) {
					int id = Integer.parseInt(idString);
					Employee employee = employeeController.getEmployeeById(id);
					if (employee != null) {
						displayEmployees(employeeTextArea, List.of(employee));
					} else {
						displayMessage("Employee not found.");
					}
				}
			}
		});

		// Aggiungi azione al bottone "Add Employee"
		addEmployeeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idString = JOptionPane.showInputDialog("Enter Employee ID:");
				String name = JOptionPane.showInputDialog("Enter Employee Name:");
				String surname = JOptionPane.showInputDialog("Enter Employee Surname:");
				if (idString != null && !idString.isEmpty() && name != null && !name.isEmpty() && surname != null && !surname.isEmpty()) {
					int id = Integer.parseInt(idString);
					boolean success = employeeController.addEmployee(id, name, surname);
					if (success) {
						displayMessage("Employee added successfully.");
					} else {
						displayMessage("Failed to add employee.");
					}
				}
			}
		});

		// Aggiungi azione al bottone "Delete Employee By ID"
		deleteEmployeeByIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idString = JOptionPane.showInputDialog("Enter Employee ID:");
				if (idString != null && !idString.isEmpty()) {
					int id = Integer.parseInt(idString);
					boolean success = employeeController.deleteEmployeeById(id);
					if (success) {
						displayMessage("Employee deleted successfully.");
					} else {
						displayMessage("Failed to delete employee.");
					}
				}
			}
		});

	}

	// Metodo per visualizzare gli impiegati nell'area di testo
	private void displayEmployees(JTextArea employeeTextArea, List<Employee> employees) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Employee employee : employees) {
			stringBuilder.append(employee.toString()).append("\n");
		}
		employeeTextArea.setText(stringBuilder.toString());
	}

	// Metodo per visualizzare un messaggio di avviso
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public static void main(String[] args) {
		new EmployeeGUI().setVisible(true);
	}
}
