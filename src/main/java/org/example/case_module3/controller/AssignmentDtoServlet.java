package org.example.case_module3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.case_module3.model.dto.AssignmentDto;
import org.example.case_module3.service.asignmentDto.AssignmentDTODAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="assignmentDtoServlet", value = "/assignmentDto")

public class AssignmentDtoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AssignmentDTODAO assignmentDTODAO;
    public void init(){assignmentDTODAO=new AssignmentDTODAO();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action== null){
            action= "";
        }
        try{
            switch (action){
                case "view":
                    showList(req,resp);
                    break;
            }
        }catch (SQLException e){
            throw new ServletException(e);
        }
    }
    public void showList(HttpServletRequest request,HttpServletResponse response) throws ServletException,SQLException,IOException{
        List<AssignmentDto> assignmentDtoList = assignmentDTODAO.findAll();
        request.setAttribute("assignmentDtoList",assignmentDtoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("assignmentDto/list.jsp");
        dispatcher.forward(request,response);
    }
}
