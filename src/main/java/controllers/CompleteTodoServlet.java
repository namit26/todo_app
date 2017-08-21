package controllers;
import helper.CompleteTodoService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name="CompleteTodoServlet",urlPatterns = "/completeTodo")
public class CompleteTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        CompleteTodoService.handleRequest(request,response);
    }
}

