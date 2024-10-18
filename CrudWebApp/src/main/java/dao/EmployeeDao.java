// src/main/java/dao
package dao;

import java.util.List;
import model.Employee;

public interface EmployeeDao {
	
	void save(Employee employee);
	
  List<Employee> getAll();
  
  Employee getById(int id);
  
  void update(Employee employee);
  
  void delete(int id);

}
