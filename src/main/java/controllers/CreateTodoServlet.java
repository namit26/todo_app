package controllers;

import helper.CreateTodoService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CreateTodoServlet", urlPatterns = "/createTodo")
public class CreateTodoServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        CreateTodoService.handleRequest(request,response);
    }
}
