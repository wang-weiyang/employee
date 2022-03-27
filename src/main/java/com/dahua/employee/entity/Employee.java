package com.dahua.employee.entity;

public class Employee {

    private String id;
    private String name;
    private String password;
    private Double salary;
    private Integer age;


    public Employee() {
    }

    public Employee(String id, String name, Double salary, Integer age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    public Employee(String id, String name, String password, Double salary, Integer age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salary = salary;
        this.age = age;
    }
//
//    public Employee(String name, String password, Double salary, Integer age) {
//        this.name = name;
//        this.password = password;
//        this.salary = salary;
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "{id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", salary=" + salary + ", age=" + age + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
