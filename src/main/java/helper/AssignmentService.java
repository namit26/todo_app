package helper;

import models.Todo;
import store.Store;
import util.Utilities;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AssignmentService extends HttpServlet {

    public static void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        if(Utilities.getInstance().validateSession(request.getCookies()) == false){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        String assignTo = request.getParameter("assignTo");
        Integer assignId = Integer.parseInt(request.getParameter("todoId"));
        List<Todo> todoList = Store.getInstance().getTodoList();
        Todo todoToUpdate = null;
        for(Todo todo:todoList){
            if(todo.getTodoId() == assignId){
                todoToUpdate = todo;
                break;
            }
        }
        if(todoToUpdate == null){
            response.setContentType("application/text");
            response.getWriter().write("Sorry Todo is deleted");
        }
        else if ("Assigned".equals(todoToUpdate.getStatus())) {
            response.setContentType("application/text");
            response.getWriter().write("Todo is already Assigned " );
        } else if ("Completed".equals(todoToUpdate.getStatus())) {
            response.setContentType("application/text");
            response.getWriter().write("Todo is already completed");
        } else {
            response.setContentType("application/json");
            todoToUpdate.setAssignedTo(assignTo);
        }
    }
}
