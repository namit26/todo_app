package helper;

import models.User;
import store.Store;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class SignupService extends HttpServlet {
    public static void handleRequest(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        response.setContentType("text/html");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String emailId = request.getParameter("emailId");
        String phone = request.getParameter("phone");
        User user = new User(userName, passWord, emailId, phone);

        if (Store.getInstance().createUser(user) == -1) {
            response.getWriter().write("User Already exist");
        } else {
            UUID uuid = UUID.randomUUID();
            Cookie cookie = new Cookie("userToken", uuid.toString());
            response.addCookie(cookie);
            Store.getInstance().setUserToken(uuid.toString(), user.getUserName());
            RequestDispatcher dispatcher = servletContext
                    .getRequestDispatcher("/WEB-INF/home.jsp");
            dispatcher.forward(request, response);
        }

    }
}
