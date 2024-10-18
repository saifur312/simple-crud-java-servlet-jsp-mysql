// src/main/java/service/EmployeeService.java
package service;

import model.Employee;
import java.util.List;

public interface EmployeeService {
	
    void saveEmployee(Employee employee);
    
    List<Employee> getAllEmployees();
    
    Employee getEmployeeById(int id);
    
    void updateEmployee(Employee employee);
    
    void deleteEmployee(int id);
}
