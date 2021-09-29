package com.example.servlet_excise.controller;

import com.example.servlet_excise.entity.Emp;
import com.example.servlet_excise.service.EmpService;
import com.example.servlet_excise.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "UpdateEmpController",value = "/manager/safe/updateEmpController")
public class UpdateEmpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Double salary = Double.valueOf(req.getParameter("salary"));
        Integer age = Integer.valueOf(req.getParameter("age"));

        Emp emp =new Emp(id,name,salary,age);
        EmpService empService = new EmpServiceImpl();

        empService.modify(emp);

        resp.sendRedirect(req.getContextPath()+"/manager/safe/showAllEmpController");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
