import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        
        // 首次遍历用户登录信息，查看是否存储有自动登录相关信息
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    cookie.setMaxAge(5);
                    resp.addCookie(cookie);
                    out.print(cookie.getValue() + "您已登录，欢迎你！");
                    out.print("<a href='/sy1/Login.html'>退出</a>");
                    return;
                }
            }
        }
        
        // 用户收集用户登录信息
        String username = req.getParameter("username");
        String autoLogin = req.getParameter("autoLogin");
        
        if (username == null || username.trim().equals("")) {
            out.print("请输入用户名登录");
            resp.setHeader("Refresh", "2;URL=http://localhost:8080/sy1/Login.html");
            return;
        }
        
        // 表示用户使用自动登录功能
        if (autoLogin != null && autoLogin.equals("autoLogin")) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(10);
            cookie.setPath("/");
            resp.addCookie(cookie);
        }
        
        out.print(username + "您已登录，欢迎你！");
        out.print("<a href='/sy1/Login.html'>退出</a>");
        return;
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
