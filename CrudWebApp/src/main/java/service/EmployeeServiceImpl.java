// src/main/java/service/EmployeeServiceImpl.java
package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }
}
