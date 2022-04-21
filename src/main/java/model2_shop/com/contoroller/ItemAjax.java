package model2_shop.com.contoroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.ItemDao;

/**
 * Servlet implementation class ItemAjax
 */
@WebServlet("/item/ajax.do")
public class ItemAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //list or ?id= detail    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao itemDao=new ItemDao();
		response.setContentType("application/json;charset=UTF-8;");
		
		try {
			response.getWriter().append(itemDao.list(0).toString());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("{\"insert\":false}");
		
	
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
