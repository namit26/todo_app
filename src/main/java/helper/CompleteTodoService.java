package helper;

import models.Todo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import store.Store;
import util.Utilities;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CompleteTodoService extends HttpServlet {

    public static void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        if(Utilities.getInstance().validateSession(request.getCookies()) == false){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

        Integer todoId = Integer.parseInt(request.getParameter("todoId"));   //TODO

        List<Todo> todoList = Store.getInstance().getTodoList();
        Todo todoToSend = null;
        for (Todo todo : todoList) {
            if (todo.getTodoId() == todoId) {
                todoToSend = todo;
                break;
            }
        }


        if(todoToSend == null){
            response.setContentType("application/text");
            response.getWriter().write("Sorry Todo is deleted");
        } else if ("Completed".equals(todoToSend.getStatus())) {
            response.setContentType("application/text");
            response.getWriter().write("Todo is already completed ");
        } else {
            response.setContentType("application/json");
            JSONObject obj = new JSONObject();
            JSONArray array = new JSONArray();
            array.add(todoToSend.getTodoId());
            array.add(todoToSend.getTitle());
            array.add(todoToSend.getDesc());
            array.add(todoToSend.getAssignedTo());
            obj.put("1", array);

            response.getWriter().write(obj.toJSONString());
        }
    }
}
