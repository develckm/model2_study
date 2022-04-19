package model2_shop.com.contoroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.MemberDao;
import model2_shop.com.vo.MemberVo;

@WebServlet("/mem/modify.do")
public class MemberModify extends HttpServlet{
	MemberDao memDao=new MemberDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		MemberVo mem=new MemberVo();
		try {
			mem=memDao.detail(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("mem", mem);
		req.getRequestDispatcher("./modify.jsp").forward(req, resp);
	}
}
