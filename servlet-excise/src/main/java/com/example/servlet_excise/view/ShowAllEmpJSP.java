package com.example.servlet_excise.view;

import com.example.servlet_excise.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllEmpJSP",value = "/manager/showAllEmpJSP")
public class ShowAllEmpJSP extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> emps = (List<Emp>) req.getAttribute("emps");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查询所有员工页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <table border='1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>编号</td>");
        printWriter.println("               <td>姓名</td>");
        printWriter.println("               <td>工资</td>");
        printWriter.println("               <td>年龄</td>");
        printWriter.println("               <td colspan='2'>操作</td>");
        printWriter.println("           </tr>");
        for(Emp emp: emps){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+emp.getId()+"</td>");
            printWriter.println("               <td>"+emp.getName()+"</td>");
            printWriter.println("               <td>"+emp.getSalary()+"</td>");
            printWriter.println("               <td>"+emp.getAge()+"</td>");
            printWriter.println("               <td><a href='"+req.getContextPath()+"/manager/safe/removeEmpController?id="+emp.getId()+"'>删除<a></td>");
            printWriter.println("               <td><a href='"+req.getContextPath()+"/manager/safe/showEmpController?id="+emp.getId()+"'>修改</a></td>");
            printWriter.println("           </tr>");
        }
        printWriter.println("       </table>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
