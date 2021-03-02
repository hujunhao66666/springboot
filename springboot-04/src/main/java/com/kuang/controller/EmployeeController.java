package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Collections;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employee = employeeDao.getAll();

        model.addAttribute("emps",employee);
        return "list";
    }

    @GetMapping("/toAdd")
    public String toAddpage(Model model){
        Collection<Department> departments= departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "add";
    }

    @PostMapping("/toAdd")
    public String addEmp(Employee employee){
        //添加的操作
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    //去员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //查出原来的数据
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employeeById);
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments",department);

        return "update";
    }

    @PostMapping("/toUpdate")
    public String toUpdate(Employee employee){
        employeeDao.save2(employee);
        return "redirect:/emps";
    }

    @GetMapping("/empDelete/{id}")
    public String toDelete(@PathVariable("id") Integer id){
        employeeDao.deletge(id);
        return "redirect:/emps";
    }
}
