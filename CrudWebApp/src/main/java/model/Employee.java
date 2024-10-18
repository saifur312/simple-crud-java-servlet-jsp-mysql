package model;

public class Employee {
	private int id;
	private String name;
  private String email;
  private String department;
  private double salary;
  
  // No arguments constructor
  public Employee () {}
  
  // All argument constructor
	public Employee(int id, String name, String email, String department,
			double salary) {
		super();
		this.id         = id;
		this.name       = name;
		this.email      = email;
		this.department = department;
		this.salary     = salary;
	}

  //All argument constructor
	public Employee(String name, String email, String department,
			double salary) {
		super();
		this.name       = name;
		this.email      = email;
		this.department = department;
		this.salary     = salary;
	}


	// getter setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// to string method 
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email
				+ ", department=" + department + ", salary=" + salary + "]";
	}
 
}

