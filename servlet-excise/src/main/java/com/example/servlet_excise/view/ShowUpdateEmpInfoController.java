package com.example.servlet_excise.view;

import com.example.servlet_excise.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "ShowUpdateEmpInfoController",value = "/manager/safe/showUpdateEmpInfoController")
public class ShowUpdateEmpInfoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp emp = (Emp)req.getAttribute("emp");

        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>修改员工信息页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <form action='/servlet_excise_war_exploded/manager/safe/updateEmpController' method='post'>");
        printWriter.println("       编号：<input type='text' name='id' value='"+emp.getId()+"' readonly/><br/>");
        printWriter.println("       姓名：<input type='text' name='name' value='"+emp.getName()+"'/><br/>");
        printWriter.println("       工资：<input type='text' name='salary' value='"+emp.getSalary()+"'/><br/>");
        printWriter.println("       年龄：<input type='text' name='age' value='"+emp.getAge()+"'/><br/>");
        printWriter.println("       <input type='submit'  value='修改'/><br/>");
        printWriter.println("       </form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
