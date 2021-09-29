package com.example.servlet_excise.controller;


import com.example.servlet_excise.entity.EmpManager;
import com.example.servlet_excise.service.EmpManagerService;
import com.example.servlet_excise.service.Impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmpManagerLoginController",value = "/manager/empManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String codes = req.getParameter("codes");
        //验证
            //验证码是否正确
        if(codes.equalsIgnoreCase((String) req.getSession().getAttribute("codes"))){
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager=empManagerService.login(username,password);
            if(empManagerService!=null){
                //将账号密码存储在session作用域
                HttpSession session = req.getSession();
                session.setAttribute("empManager",empManager);
                resp.sendRedirect(req.getContextPath()+"/manager/safe/showAllEmpController");
            }else {
                //账号不存在，重定向到登录页面
                resp.sendRedirect(req.getContextPath()+"/login.html");
            }
        }else {
            //验证码不对，重定向到登录页面
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
