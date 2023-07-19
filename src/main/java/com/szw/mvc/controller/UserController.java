package com.szw.mvc.controller;

import com.szw.mvc.pojo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: szw
 * @Date: 2023/7/17 - 07 - 17 - 17:54
 * @Description: com.szw.mvc.controller
 * @version: 1.0
 */
@Controller
public class UserController {
    @GetMapping(value = "/user")
    public String getUser() {

        return "success";
    }

    @GetMapping(value = "/user/{id}")
    public String getUserByID() {

        return "success";
    }

    @PostMapping(value = "/user")
    public String addUser(RequestEntity<String> req) {
        System.out.println("RequestEntity 测试");
        System.out.println(req.getMethod());
        System.out.println(req.getHeaders());
        return "success";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user")
    public String deleteUserByID(Integer id) {
        System.out.println("DELETE进来了");
//        System.out.println(id);
        return "success";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public String updateUserByID() {
        System.out.println("put进来了");
        System.out.println("put");
        return "success";
    }

    @RequestMapping(value = "/showsuccess")
    @ResponseBody
    public User showSuccess() {

        return new User("szw", "1234567");
    }

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testdown(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/static/img/1.jpg");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=1.jpg");
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, httpHeaders, status);
        fileInputStream.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        String fileName = photo.getOriginalFilename();
        String substring = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + substring;
        ServletContext servletContext = session.getServletContext();
        String photo1 = servletContext.getRealPath("photo");
        File file = new File(photo1);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photo1 + File.separator + fileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }

}
