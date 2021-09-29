package com.example.servlet_excise.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateCodeController",value = "/createcode")
public class CreateCodeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //new一个验证码对象
        ValidateCode validateCode=new ValidateCode(200,30,4,20);
        String codes = validateCode.getCode();
        //将验证码设置到session里边
        HttpSession session = req.getSession();
        session.setAttribute("codes",codes);
        //利用resp返回生成的验证码图片（输出流）
        validateCode.write(resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
