package login;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Không cần cấu hình thêm
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String username = req.getParameter("username");

        if (username == null || username.trim().isEmpty()) {
            // Nếu không nhập username, chuyển hướng về form login
            req.setAttribute("message", "Tên người dùng không được để trống");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, res);
        } else {
            // Cho phép đi tiếp nếu hợp lệ
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Không cần dọn dẹp gì thêm
    }
}
