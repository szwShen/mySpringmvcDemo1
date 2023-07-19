package com.szw.mvc.controller;

import com.szw.mvc.dao.EmployeeDao;
import com.szw.mvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(value = "/employee")
    public ModelAndView getUser(ModelAndView modelAndView) {
        Collection<Employee> employeeList = employeeDao.getAll();

        modelAndView.addObject("employeeList", employeeList);
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @PostMapping(value = "/employee")
    public String addUser(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
//@RequestMapping(method = RequestMethod.DELETE, value = "/employee")
//@RequestMapping(method = RequestMethod.DELETE, value = "/user")
    public String deleteUserByID(@PathVariable("id") Integer id) {
        employeeDao.delete(id);

        return "redirect:/employee";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
    public String getUserByID(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee")
    public String UpdateUserByID(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
