package main;

import javax.swing.SwingUtilities;

import employeesGUI.EmployeeGUI;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EmployeeGUI().setVisible(true);
			}
		});
	}
}