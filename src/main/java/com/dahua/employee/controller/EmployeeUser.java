package com.dahua.employee.controller;

import com.dahua.employee.service.EmployeeService;
import com.dahua.employee.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class EmployeeUser extends HttpServlet {

    EmployeeServiceImpl service = new EmployeeService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pwd");
        if (name == null || pass == null){
            response.getWriter().println(0);
            return ;
        }
        Integer aBoolean = service.effectiveness(name, pass);

        response.getWriter().println(aBoolean);

    }

}
