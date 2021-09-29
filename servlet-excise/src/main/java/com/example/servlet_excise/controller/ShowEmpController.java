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
@WebServlet(name = "ShowEmpController",value = "/manager/safe/showEmpController")
public class ShowEmpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));

        EmpService empService = new EmpServiceImpl();
        Emp emp = empService.showEmp(id);

        req.setAttribute("emp",emp);

        req.getRequestDispatcher("/manager/safe/showUpdateEmpInfoController").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
