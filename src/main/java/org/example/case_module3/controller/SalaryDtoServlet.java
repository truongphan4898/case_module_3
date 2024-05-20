package org.example.case_module3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.case_module3.model.dto.SalaryDto;
import org.example.case_module3.service.salaryDto.SalaryDTODAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet (name = "salaryDtoServlet", value = "/salaryDto")

public class SalaryDtoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SalaryDTODAO salaryDTODAO;
    public void init(){
        salaryDTODAO = new SalaryDTODAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action= "";
        }
        try {
            switch (action){
                case "view":
                    showList(req,resp);
                    break;
            }
        }catch (SQLException e){
            throw new ServletException();
        }
    }
    public void showList(HttpServletRequest request,HttpServletResponse response) throws ServletException,SQLException,IOException{
        List<SalaryDto> salaryDtoList = salaryDTODAO.findAll();
        request.setAttribute("salaryDtoList",salaryDtoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("salaryDto/list.jsp");
        dispatcher.forward(request,response);
    }
}
