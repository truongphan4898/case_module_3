package org.example.case_module3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.case_module3.model.Employee;
import org.example.case_module3.model.dto.EmployeeDTO;
import org.example.case_module3.service.department.DepartmentDAO;
import org.example.case_module3.service.employee.EmployeeDAO;
import org.example.case_module3.service.employeeDto.EmployeeDTODAO;
import org.example.case_module3.service.position.PositionDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name ="EmployeeServlet", value = "/employee")

public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO=new EmployeeDAO() ;
    private DepartmentDAO departmentDAO= new DepartmentDAO();
    private PositionDAO positionDAO = new PositionDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if(action==null){
           action = "";
       }
       try {
           switch (action){
               case "create":
                   insertEmployee(req,resp);
                   break;
               case "edit":
                   updateEmployee(req,resp);
                   break;
           }
       }
       catch (SQLException e){
           throw new ServletException(e);
       }
    }
    public void insertEmployee(HttpServletRequest request,HttpServletResponse response) throws ServletException,SQLException,IOException{
        String name = request.getParameter("name");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        int departmentId = Integer.parseInt(request.getParameter("idDepartment"));
        int positionId = Integer.parseInt(request.getParameter("idPosition"));
        Employee employee = new Employee(name,dob,gender,address,departmentId,positionId);
        employeeDAO.insert(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request,response);
    }
    public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("employeeId"));
        String name = request.getParameter("name");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String department1 = request.getParameter("departmentId");
        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        Employee employee = new Employee(name,dob,gender,address,departmentId,positionId);
        employeeDAO.updateById(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action="";
        }
        try{
            switch (action){
                case "create":
                    showCreateForm(req,resp);
                    break;
                case "edit":
                    showUpdateForm(req,resp);
                    break;
                case "delete":
                    deleteEmployee(req,resp);
                    break;
                case "view":
                    showEmployee(req,resp);
                    break;
                default:
                    showList(req,resp);
                    break;
        }
            }catch (SQLException e){
                throw new ServletException(e);
            }
            }
    public void showList(HttpServletRequest request,HttpServletResponse response) throws ServletException,SQLException,IOException{
        List<EmployeeDTO> employeeList = employeeDAO.getAll();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }
    public void showEmployee (HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDTO employee = employeeDAO.findById(id);
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/view.jsp");
        dispatcher.forward(request,response);

    }
    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteById(id);
        List<EmployeeDTO>employeeList= employeeDAO.getAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }

    public void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDTO employee = employeeDAO.findById(id);
        RequestDispatcher dispatcher= request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("positionList",positionDAO.findAll());
        request.setAttribute("departmentList",departmentDAO.findAll());
        request.setAttribute("employee",employee);
        dispatcher.forward(request,response);
    }
    public void showCreateForm(HttpServletRequest request, HttpServletResponse response ) throws ServletException,SQLException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        request.setAttribute("positionList",positionDAO.findAll());
        request.setAttribute("departmentList",departmentDAO.findAll());
        dispatcher.forward(request,response);
    }
}
