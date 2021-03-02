package com.kuang.dao;

import com.kuang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments=null;

    static {
        departments=new HashMap<>();
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"体育部"));
        departments.put(103,new Department(103,"文艺部"));
        departments.put(104,new Department(104,"办公室"));
        departments.put(105,new Department(105,"活动部"));
    }

    //获得所有部门信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(int id){
        return departments.get(id);
    }


}
