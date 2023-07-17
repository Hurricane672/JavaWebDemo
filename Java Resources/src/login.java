package src;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
//import src.SQLutil;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        boolean c = src.SQLutil.login(username,password);
        System.out.println(c);
        request.setAttribute("result",c);
        request.getRequestDispatcher("/loginres.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginPost");
    }
}
