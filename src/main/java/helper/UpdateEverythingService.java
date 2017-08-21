package helper;


import models.Todo;
import org.json.simple.JSONObject;
import store.Store;
import util.Utilities;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateEverythingService extends HttpServlet {

    public static void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        if(Utilities.getInstance().validateSession(request.getCookies()) == false){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        response.setContentType("application/json");
        Cookie[] cookies = request.getCookies();
        Cookie cookieForTimeStamp = null;
        for(Cookie cookie:cookies){
            if("lastupdate".equals(cookie.getName())){
                cookieForTimeStamp = cookie;
                break;
            }
        }
        List<Todo> todoList = Store.getInstance().getTodoList();
        if(cookieForTimeStamp == null){
            JSONObject obj = Utilities.getInstance().makeJSONObject(todoList);
            response.getWriter().write(obj.toJSONString());
        } else{
            List<Todo> todosToBeUpdated = new ArrayList<Todo>();
            try {
                Date dateOfClient = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(cookieForTimeStamp.getValue());
                for(Todo todo:todoList){
                    if(dateOfClient.compareTo(todo.getCreated())<0){
                        todosToBeUpdated.add(todo);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject obj = Utilities.getInstance().makeJSONObject(todosToBeUpdated);
            response.getWriter().write(obj.toJSONString());
        }
        Cookie cookie = new Cookie("lastupdate",(new Date().toString()));
        response.addCookie(cookie);
    }

}
