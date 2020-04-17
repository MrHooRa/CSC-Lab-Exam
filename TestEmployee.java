/*
 * 
 * Salman Alessa
 * UID: 439100011
 * 
 */
import java.util.Scanner;
public class TestEmployee { 

	//Static
	static Scanner input = new Scanner(System.in);

	// To use it anywhere
	public static Employee e1 = new Employee();
	public static Employee e2 = new Employee();

	// This method, print menu and check what user entered
	public static void Options(int option) {

		// Temp variables
		String name, department;
		int id, years, salary;

		// If int option == -1, then this is first time
		// So, we need create 2 objects e1-> Employee 1 | e2-> Employee 2
		if(option == -1) {
			System.out.print("Enter Employee 1 details (id, name, department, years, salary): ");
			id = input.nextInt();
			name = input.next();
			department = input.next();
			years = input.nextInt();
			salary = input.nextInt();
			checker(id, department, years, salary);
	
//			Employee e1 = new Employee();
			e1.Employee(id, name, department, years, salary);
			
			// Employee 1 should be the manager first time
			e1.changeManager(true);
			e1.setDepartment(department);
	
			System.out.print("Enter Employee 2 details (id, name, department, years, salary): ");
			id = input.nextInt();
			name = input.next();
			department = input.next();
			years = input.nextInt();
			salary = input.nextInt();
			checker(id, department, years, salary);
	
//			Employee e2 = new Employee();
			e2.Employee(id, name, department, years, salary);
			e2.setDepartment(department);
		}

		// Ask user enter option number
		// Call method options
		System.out.print(
			"\n1-Show Employees\n" +
			"2-Change manager\n" +
			"3-Change salaries\n" + 
			"4-Change departments\n" +
			"5-Change years\n" +
			"6-Exit\n-> "
		);
		
		option = input.nextInt();

		// if user enter 1 -> Show Employees
		if(option == 1) {
			System.out.println(e1.toString());
			System.out.println(e2.toString());
			
			// Call method Options
			Options(1);
			
		// if user enter 2 -> Change manager
		}else if(option == 2) {
			
			// This method change manager, if e1 is the manager, e2 will be the manager
			// If e2 is the manager, e1 will be the manager
			
			if(e1.getManager()) {
				e2.changeManager(true); 
				e1.changeManager(false);
			}
			else if(e2.getManager()) {
				e1.changeManager(true); 
				e2.changeManager(false);
			}
			
			// Call method Options
			Options(1);
			
		// if user enter 3 -> Change salaries
		}else if(option == 3) {
			
			System.out.print(e1.getName() + "'s basic salary is " + e1.getSalary() + ". Change it to: ");
			int newSalary = input.nextInt();
			e1.setSalary(newSalary);
			
			System.out.print(e2.getName() + "'s basic salary is " + e2.getSalary() + ". Change it to: ");
			newSalary = input.nextInt();
			e2.setSalary(newSalary);
			
			
			// Call method Options
			Options(1);
			
		// if user enter 4 -> Change department
		}else if(option == 4) {
			
			System.out.print(e1.getName() + " is in " + e1.getDepartment() + ". Change to: ");
			String newDepartment = input.next();
			e1.setDepartment(newDepartment);
			
			System.out.print(e2.getName() + " is in " + e2.getDepartment() + ". Change to: ");
			newDepartment = input.next();
			e2.setDepartment(newDepartment);
			
			// Call method Options
			Options(1);
		
		// if user enter 5 -> Change years
		}else if(option == 5) {
			
			System.out.print(e1.getName() + " work for " + e1.getYear() + " year(s). Change the year to: ");
			int newYear = input.nextInt();
			e1.setYear(newYear);
			
			System.out.print(e2.getName() + " work for " + e2.getYear() + " year(s). Change the year to: ");
			newYear = input.nextInt();
			e2.setYear(newYear);
			
			// Call method Options
			Options(1);
			
		// if user enter 6 -> Exit
		}else if(option == 6) {
			System.out.println("GoodBey");
			System.exit(0);
			
		// if user entered incorrect option
		}else {
			System.out.println("There are no option (" + option + ")");
			// Call method Options
			Options(1);
		}
		
	}

	// This method print error message
	public static void checker(int id, String department, int years, int salary) {
		if (id < 0) System.out.println("Value was not set"); id = -1;
		if (years < 0) System.out.println("Value was not set"); years = -1;
		if (salary < 0) System.out.println("Value was not set"); salary = -1;
		if (department == null || department.isEmpty()) System.out.println("Department was not set");
	}

	public static void main(String[] args) {

		// By default, -1 that's mean this is first time
		// 1 means this is not the first time
		Options(-1);

	}
}