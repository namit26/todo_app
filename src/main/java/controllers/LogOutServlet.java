package controllers;
import helper.LogOutService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name="LogOutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        LogOutService.handleRequest(request,response);
    }
}
