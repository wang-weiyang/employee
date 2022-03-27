package com.dahua.employee.controller;

import com.dahua.employee.entity.Employee;
import com.dahua.employee.service.EmployeeService;
import com.dahua.employee.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class EmployeeAdd extends HttpServlet {
    EmployeeServiceImpl service = new EmployeeService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String salary = request.getParameter("salary");
        String age = request.getParameter("age");


        Employee e = new Employee(id, name, pwd, Double.parseDouble(salary), Integer.parseInt(age));
        String s = service.addEmp(e);
        System.out.println("添加结果: " + s);
        response.sendRedirect("Employee/emplist.html");
    }
}
