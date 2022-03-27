package com.dahua.employee.service;

import com.dahua.employee.entity.Employee;
import com.dahua.employee.util.RedisUtil;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Set;

public class EmployeeService implements EmployeeServiceImpl {

    final Jedis jedis = RedisUtil.getJedis();
    final Gson gson = new Gson();

    public Integer effectiveness(String name, String password) {
        for (String key : jedis.keys("*")) {
            String s = jedis.get(key);
            Employee emp = gson.fromJson(s, Employee.class);
            if (name.equals(emp.getName()) && password.equals(emp.getPassword())) {
                return 1;
            }
        }
        return 0;
    }


    public String addEmp(Employee e) {
        String s = gson.toJson(e);
        return jedis.set(e.getId(), s);
    }


    public Boolean delEmp(String key) {
        if (jedis.exists(key)) {
            return jedis.del(key) == 1;
        } else {
            System.out.println(key + "不存在");
            return false;
        }
    }

    @Override
    public Employee selectByName(String key) {
        String s = jedis.get(key);
        return gson.fromJson(s, Employee.class);
    }

    public String update(Employee e) {
        Employee emp = selectByName(e.getId());
        e.setPassword(emp.getPassword());
        delEmp(emp.getId());
        return addEmp(e);
    }

    public ArrayList<String> select() {

        ArrayList<String> list = new ArrayList<>();
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            list.add(jedis.get(key));
        }

        return list;
    }

}
