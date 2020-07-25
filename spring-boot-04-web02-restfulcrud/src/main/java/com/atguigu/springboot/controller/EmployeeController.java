package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Collection;

/**
 * @author 熟尔
 * @createdate 2019/10/17 0017-15:24
 */
//控制层   springMVC和sturts所做的事情
@Controller
public class EmployeeController {

@Autowired
    EmployeeDao employeeDao;

@Autowired
    DepartmentDao departmentDao;

@GetMapping("/emps")
//上面的这个与dashboard页面上的员工管理按钮是映射的responces
    public String list(Model model ){//这里的list（）里面需要机上参数   model或者map或者modelmap都是可以的


    //这个是调用的employeeDao 连接上的数据库，然后调用的getALL方法， 获取数据，放到employees
      Collection<Employee> employees = employeeDao.getAll();
    //  把获得的数据，放到emps里面
      model.addAttribute("emps", employees);

//         System.out.println("测试");
//        因为是使用的thymeleaf所以所有的
//        return都是找得类路径下的templates下面的文件
        return "emp/list";
    }


   @GetMapping("/emp")   //这个是映射的list页面上的 th:href只要是
    public  String toAddpage(Model model){

        //从数据库里面获取 数据
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts",departments);
       return "emp/add"; // 返回到添加的页面， 是模板引擎， 可以进行前后缀的添加

    }


    // 添加员工的按钮
    @PostMapping("/emp")
    public  String addEmp(Employee employee){
        System.out.println("保存的员工信息： "+employee);
        employeeDao.save(employee);
    // 跳转到 list页面，参见@GetMapping("/emps") 就是上面的那个
        // redirect: 表示重定向到一个地址， /代表当前项目路径
        // forward： 表示转发到一个地址
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}") // 为什么要加上大括号，是固定的？
    public  String  toEditPage(@PathVariable("id") Integer id,Model model){


        //上面是路径变量参数的获取
        Employee employee = employeeDao.get(id); // 根据id获取员工的信息，需要将employee回显在
                                    //  页面上，所以我们需要保存一下
        model.addAttribute("emp",employee); //用于回显数据的
        //获取查询部门信息，页面显示部门列表
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts",departments);

//        return 可以复制一份add.html页面，然后return直接定位到，或者是直接重用这个页面add.html
            return "emp/add";
}

    @PutMapping("/emp")
//    相当于传进来一个employee，然后我们队employee进行操作
    public  String update(Employee employee){

        System.out.println(employee);

        employeeDao.save(employee);
        return  "redirect:/emps";

    }


    //删除员工
    @DeleteMapping("/emp/{id}")
    public  String deleteEmployee(@PathVariable("id") Integer id){

        //存储地址变量
        employeeDao.delete(id);
    return  "redirect:/emps";

    }


}
