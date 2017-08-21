package helper;
import store.Store;
import util.Utilities;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LogOutServlet", urlPatterns = "/logout")
public class LogOutService extends HttpServlet{

    public static void handleRequest(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        if(Utilities.getInstance().validateSession(request.getCookies()) == false){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        Cookie[] cookies = request.getCookies();
        String userId = null;
        for(Cookie cookie : cookies){
            if("userToken".equals(cookie.getName())){
                userId = cookie.getValue();
            }
        }
        Cookie timeCookie = null;
        for(Cookie cookie : cookies){
            if("lastupdate".equals(cookie.getName())){
                timeCookie = cookie;
            }
        }
        timeCookie.setMaxAge(0);
        response.addCookie(timeCookie);
        Store.getInstance().getUserTokenMap().remove(userId);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
