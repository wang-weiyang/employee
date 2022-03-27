package com.dahua.employee.service;

import com.dahua.employee.entity.Employee;

import java.util.ArrayList;

public interface EmployeeServiceImpl {

    // 登陆验证
    Integer effectiveness(String name, String password);

    // 增
    String addEmp(Employee e);

    // 删
    Boolean delEmp(String key);

    // 查询单条
    Employee selectByName(String name);

    // 改
    String update(Employee e);

    // 查
    ArrayList<String> select();
}
