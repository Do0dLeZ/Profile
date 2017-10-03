package servlets;

import session.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public static String access = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String logout = req.getParameter("log");

        if (login != null && !login.isEmpty()) {
            if (validation(login, null)) {
                resp.sendRedirect("profile.jsp");
            } else {
                access = "denied";
                resp.sendRedirect("authorization.jsp");
            }
        } else if (logout != null && logout.equals("exit")) {
            HttpSession session = req.getSession();
            session.removeAttribute("user_login");
            resp.sendRedirect("authorization.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login != null && !login.isEmpty()) {
            if (validation(login, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("user_login", login);
                access = "";
                resp.sendRedirect("profile.jsp");
            } else {
                access = "denied";
                resp.sendRedirect("authorization.jsp");
            }
        }
    }

    private boolean validation(String login, String password) {
        UserSession session = UserSession.getInstance();
        return session.getUser(login, password) != null;
    }
}
