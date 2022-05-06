package model2_shop.com.contoroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout.do")
public class MemberLogout extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그아웃 성공시 login 페이지로 이동
		req.getSession().invalidate(); 
		//해당 클라이언트와 관련된 세션을 만료하여 모두 삭제한다.
		resp.sendRedirect(req.getContextPath()+"/login.do");
	}
}
