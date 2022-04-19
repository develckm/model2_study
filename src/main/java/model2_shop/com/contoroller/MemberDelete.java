package model2_shop.com.contoroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model2_shop.com.dao.MemberDao;

@WebServlet("/mem/delete.do")
public class MemberDelete extends HttpServlet{
	MemberDao memDao=new MemberDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		boolean delete=false;
		try {
			delete=memDao.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//성공하면 session에 저장.  접속하고있는 브라우저에 대응되는 객체를 생성(로그인)
		HttpSession session=req.getSession();
		session.setAttribute("delete", delete);
		//성공(redirect)->list 
		//실패(redirect)->modify?id=
		if(delete) {
			resp.sendRedirect("./list.do?page=1");
		}else {
			resp.sendRedirect("./modify.do?id="+id);
		}
	}
}
