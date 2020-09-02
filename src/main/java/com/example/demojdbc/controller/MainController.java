package com.example.demojdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：fuhua zhang
 * @date ：Created in 2020/8/24 9:56
 * @description：
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/xiaokeai2")
public class MainController {
    @RequestMapping("/index")
    public String get1(){
        return "my520/index";
    }

    @RequestMapping("/show")
    public String show(){
        return "my520/show";
    }

    @RequestMapping("/result")
    public void result(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了result");
         request.getRequestDispatcher("/static/qinqin.html").forward(request,response);
    }

    @RequestMapping("/biubiu")
    public String biubiu(){
        return "biubiu";
    }

    @RequestMapping("/qinqin")
    public String qinqin(){
        return "qinqin";
    }
    //跳转jsp和html
    @RequestMapping("test04")
    public void test04(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("设置看能不能跳转到jsp");
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
    }
    //跳转jsp和html
    @RequestMapping("test05")
    public void test05(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("设置看能不能跳转到static jsp");
        request.getRequestDispatcher("/resources/static/index.jsp").forward(request,response);
    }
    //跳转jsp
    @RequestMapping("test03")
    public String test03(){
        return "index";
    }
}
