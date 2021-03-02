package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    //模拟数据库
    private static Map<Integer, Employee> employees=null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees=new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","A864536396@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B864536396@qq.com",0,new Department(102,"体育部")));
        employees.put(1003,new Employee(1003,"CC","C864536396@qq.com",1,new Department(103,"文艺部")));
        employees.put(1004,new Employee(1004,"DD","D864536396@qq.com",0,new Department(104,"办公室")));
        employees.put(1005,new Employee(1005,"EE","E864536396@qq.com",1,new Department(105,"活动部")));

    }

    //增加员工
    private static Integer initID=1006;

    public void save(Employee employee){
        employee.setId(initID++);
        
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //获得全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过ID查询员工
    public Employee getEmployeeById(int id){
        return employees.get(id);
    }

    //删除员工
    public void deletge(Integer id){
        employees.remove(id);
    }

    public void save2(Employee employee){


        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
}
