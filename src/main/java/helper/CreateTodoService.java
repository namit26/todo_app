package helper;

import models.Todo;
import models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import store.Store;
import util.Utilities;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateTodoService extends HttpServlet{

    public static void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        if(Utilities.getInstance().validateSession(request.getCookies()) == false){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

        response.setContentType("application/json");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Cookie[] cookies = request.getCookies();

        String userId = null;
        for(Cookie cookie : cookies){
            if("userToken".equals(cookie.getName())){
                userId = cookie.getValue();
            }
        }

        String userName = Store.getInstance().getUserTokenMap().get(userId);
        User user = Store.getInstance().findUser(userName);
        Todo todo = Store.getInstance().createTodo(user,title,description);
        Store.getInstance().getTodoList().add(todo);
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        array.add(todo.getTodoId());
        array.add(todo.getTitle());
        array.add(Utilities.getInstance().trimString(todo.getDesc()));
        array.add(todo.getCreated().toString());
        obj.put(1, array);
        response.getWriter().write(obj.toJSONString());
    }
}
