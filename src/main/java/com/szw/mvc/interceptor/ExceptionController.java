package com.szw.mvc.interceptor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Auther: szw
 * @Date: 2023/7/18 - 07 - 18 - 18:40
 * @Description: com.szw.mvc.interceptor
 * @version: 1.0
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public String handle(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";

    }
}
