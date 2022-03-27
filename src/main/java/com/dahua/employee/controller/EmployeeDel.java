package com.dahua.employee.controller;

import com.dahua.employee.service.EmployeeService;
import com.dahua.employee.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del")
public class EmployeeDel extends HttpServlet {

    EmployeeServiceImpl service = new EmployeeService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("n");

        Boolean emp = service.delEmp(s);
        System.out.println("删除结果" + emp);
        response.sendRedirect("Employee/emplist.html");
    }
}
