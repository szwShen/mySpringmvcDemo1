package com.szw.mvc.controller;

import com.szw.mvc.pojo.User;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: szw
 * @Date: 2023/7/15 - 07 - 15 - 0:16
 * @Description: com.szw.mvc.controller
 * @version: 1.0
 */
@Controller
public class HelloCotroller {
    //    @GetMapping(value = "/")
//    public String index() {
//        return "index";
//    }
    @GetMapping(value = "/success")
    public String index() {
        return "success";
    }
    @GetMapping(value = "/target")
    public String toTarget() {

        int x = 1 / 0;
        return "target";
    }

    @RequestMapping(value = {"/success/{id}/{username}", "/mytarget"},
            method = {RequestMethod.GET, RequestMethod.POST}
//            params = {"username", "password=123456"}
    )
    public String getMyTarget(@PathVariable("id") String id, @PathVariable("username") String username) {
        System.out.printf("idwei%s,usermaewei%s", id, username);
        return "success";
    }

    @PostMapping("/geturl")
    public String geturl(HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        System.out.printf("idwei %s , usermaewei %s", password, username);
        return "success";
    }

    @GetMapping("/success2")
    public String getur2(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("name", "szw");

        return "success";
    }

    @PostMapping("/geturl3")
    public ModelAndView getur2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testScope", "hello");
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
