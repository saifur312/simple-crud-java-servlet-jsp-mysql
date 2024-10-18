// src/servlet/EmployeeServlet.java
package servlet;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        
//    	 String action = request.getParameter("action");
//    	 // Collect employee data from the form
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String department = request.getParameter("department");
//        double salary = Double.parseDouble(request.getParameter("salary"));
//
//        // Create and save the employee object
//        Employee employee = new Employee(name, email, department, salary);
//        employeeService.saveEmployee(employee);
//
//        // Redirect to the employee list after insertion
//        response.sendRedirect("EmployeeServlet?action=list");
//    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("save")) {
            // Collect employee data from the form
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            // Create and save the employee object
            Employee employee = new Employee(name, email, department, salary);
            employeeService.saveEmployee(employee);

            // Redirect to the employee list after insertion
            response.sendRedirect("EmployeeServlet?action=list");

        } else if (action != null && action.equals("update")) {
            // Collect updated employee data
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            // Update the employee details
            Employee employee = new Employee(id, name, email, department, salary);
            employeeService.updateEmployee(employee);

            // Redirect to employee list
            response.sendRedirect("EmployeeServlet?action=list");
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if (action != null && action.equals("list")) {
//            // Fetch the list of employees and display it
//            List<Employee> employees = employeeService.getAllEmployees();
//            System.out.println(employees);
//            request.setAttribute("employees", employees);
//            request.getRequestDispatcher("employeeList.jsp").forward(request, response);
//        }
//    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action: " + action);  // Log the action parameter

        if (action != null && action.equals("list")) {
            // Fetch the list of employees and forward to JSP
            List<Employee> employees = employeeService.getAllEmployees();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("employeeList.jsp").forward(request, response);

        } else if (action != null && action.equals("edit")) {
            // Fetch employee by ID and forward to edit form
          System.out.println("Editing employee...");
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeService.getEmployeeById(id);
            request.setAttribute("employee", employee);
            System.out.println("Fetch Emp: " + employee);
            request.getRequestDispatcher("employeeEdit.jsp").forward(request, response);

        } else if (action != null && action.equals("delete")) {
          System.out.println("Deleting employee...");
            // Delete the employee by ID
            int id = Integer.parseInt(request.getParameter("id"));
            employeeService.deleteEmployee(id);

            // Redirect to employee list
            response.sendRedirect("EmployeeServlet?action=list");
        }
    }
}
