package controllers;
import helper.UpdateEverythingService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="UpdateEverything",urlPatterns = "/updateEverything")
public class UpdateEverything extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        UpdateEverythingService.handleRequest(request,response);
    }
}
