/*
 * 
 * Salman Alessa
 * UID: 439100011
 * 
 */
import java.util.Scanner;
public class Employee {

	// Variables
	private int id;
	private String name;
	private String department;
	private int year;
	private double salary;
	private boolean MANAGER;

	// This array helped me to make search method in setDepartment()
	private String[] depList = {"IT", "Sales", "Warehouse"};

	// Getter [One for each]
	public String getName() {
		return this.name;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public boolean getManager() {
		return this.MANAGER;
	}
	
	// Check if employee is manager or not
	public boolean isManager() {
		if(this.MANAGER == true) return true;
		else return false;
	}

	// - - - - - - - - - - - - - - //
	// Setter [One for each except for Manager].
	
	
	public Employee() {
		this.id = -1;
		this.year = -1;
		this.salary = -1;
		this.name = "NA";
		this.department = "NA";
		this.MANAGER = false;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// This method search in array depList, If there is match then set new department, else tell user "Department was ...."
	// No matter "Sales" = "sAlEs"
	public void setDepartment(String department) {
		int count = 0, depIndex = 0;
		
		// Search in array, and to avoid the upper and the lower case, I used .toUpperCase() , and to compare two strings, I used .equals()
		for(int i = 0; i < depList.length; i++) {
			if(depList[i].toUpperCase().equals(department.toUpperCase())) {
				count++;
				depIndex = i;
			}
		}
		
		// If there is result, replace the new one.
		if(count > 0 ) this.department = depList[depIndex];
		else System.out.println("Department was not set");
	}
	
	// ID should be more than 0
	public void setID(int id) {
		if (id > 0) this.id = id;
		else System.out.println("Value was not set!");
	}
	
	// Year should be more than the old one.
	public void setYear(int year) {
		// I think year should be more than 1300?
		// but i'll leave it 0!
		if (year > this.year && year >= 0) this.year = year;
		else System.out.println("Year was not set!");
	}
	
	// Should be positive
	public void setSalary(double salary) {
		if (salary >= 0) this.salary = salary;
		else System.out.println("Value was not set!");
	}
	
	
	
	// - - - - - - - - - - - - - - //
	// Methods
	
	// Calculate total salary
	public double calculateTotalSalary() {
		// Formula is: basic salary + bonus
		
		// Bonus
		if(this.year < 5 && this.MANAGER) return this.salary + (this.year * 100.0) + 5000.0;								// Manager [< 5]
		else if(this.year < 5 && !this.MANAGER) return this.salary + (this.year * 100.0);								// NOT manager [< 5]
		else if(this.year >= 5 && this.year <= 10 && this.MANAGER) return this.salary + (this.year * 250.0) + 7000.0;		// Manager [5 <= years <= 10]
		else if(this.year >= 5 && this.year <= 10 && !this.MANAGER) return this.salary + (this.year * 250.0);			// NOT Manager [5 <= years <= 10]
		else if(this.year > 10 && this.MANAGER) return this.salary + (this.year * 500.0) + 10000.0;							// Manager [> 10]
		else if(this.year > 10 && !this.MANAGER) return this.salary + (this.year * 500.0);								// NOT Manager [> 10]
		else return 0;
	}
	
	// Compare two employees total salary, >>  1 for salary 1 greater than 2, -1 if it is less, 0 if equals
	public int compare(double salaryOtherEmp) {
		
		if(this.salary > salaryOtherEmp) return 1;
		else if(this.salary < salaryOtherEmp) return -1;
		else return 0;
		
	}
	
	// Change manager
	public void changeManager(boolean to) {
		this.MANAGER = to;
	}
	
	// toString (return details)
	public String toString() {
		
		// Short if
		String isManager = ((this.isManager()) ? "Manager " : "");
		return "ID " + this.id + ", " + isManager + this.name + " in " + this.department + " (" + this.year + " year(s)). Total Salary: " + calculateTotalSalary() + " SR.";
	}
	
	
	// Set new values &
	// Check if user enter incorrect values
	public void Employee(int id, String name, String department, int year, double salary) {
		
		// if ID correct, else set default value
		if (id >= 0) this.id = id;
		// if year correct, else set default value
		if (year >= 0) this.year = year;

		// if salary correct, else set default value
		if (salary  >= 0) this.salary = salary;

		// if name NOT empty, else set default value
		if (name != null && !name.isEmpty()) this.name = name;
		
//		 // We do not need this know!!
//		 // We have setDepartment in TestEmplyee
//		 // if name NOT empty, else set default value
//		 if (department != null || !department.isEmpty()) this.department = department;
		
	}

}
