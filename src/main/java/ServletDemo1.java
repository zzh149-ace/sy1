import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print("get 提交方式<br/>");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                resp.getWriter().print(j + "*" + i + "=" + j * i + " ");
            }
            resp.getWriter().print("<br/>");
        }
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print("post 提交方式<br/>");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                resp.getWriter().print(j + "*" + i + "=" + j * i + " ");
            }
            resp.getWriter().print("<br/>");
        }
    }
}
