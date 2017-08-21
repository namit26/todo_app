package helper;

import store.Store;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class LoginService extends HttpServlet{
    public static void handleRequest(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException,ServletException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        User user = Store.getInstance().findUser(userName);
        if (user == null) {
            response.getWriter().write("Wrong UserName");
        }
        else{
            if(user.getPassword().equals(passWord)){
                UUID uuid = UUID.randomUUID();
                Cookie cookie = new Cookie("userToken",uuid.toString());
                Store.getInstance().setUserToken(uuid.toString(),user.getUserName());
                response.addCookie(cookie);
                RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/WEB-INF/home.jsp");
                dispatcher.forward(request, response);
            }
            else{
                response.getWriter().write("Wrong Password");
            }
        }
    }
}
