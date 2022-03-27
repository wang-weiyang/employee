package com.dahua.employee.controller;

import com.dahua.employee.entity.Employee;
import com.dahua.employee.service.EmployeeService;
import com.dahua.employee.service.EmployeeServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class EmployeeUpdate extends HttpServlet {

    EmployeeServiceImpl service = new EmployeeService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        String key = request.getParameter("n");
        if (key != null){
            Employee result = service.selectByName(key);
            response.getWriter().println(gson.toJson(result));
            return ;
        }

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String age = request.getParameter("age");

        Employee employee = new Employee(id, name, Double.parseDouble(salary), Integer.parseInt(age));

        String s = service.update(employee);

        response.sendRedirect("Employee/emplist.html");
    }
}
