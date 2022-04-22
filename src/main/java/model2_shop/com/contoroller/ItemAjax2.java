package model2_shop.com.contoroller;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model2_shop.com.dao.ItemDao;
import model2_shop.com.vo.ItemVo;

import org.json.JSONObject;
/**
 * Servlet implementation class ItemAjax
 */
public class ItemAjax2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //list or ?id= detail    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해더 본문의 문자열에서 json으로 보낸 파라미터 불러오기 
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {/* report an error */ }

		JSONObject json= new JSONObject(jb.toString());
		System.out.println(json.get("cate_num"));
		System.out.println(request.getParameter("cate_num"));
		int cate_num=Integer.parseInt(request.getParameter("cate_num"));
		int count=Integer.parseInt(request.getParameter("count"));
		int price=Integer.parseInt(request.getParameter("price"));
		byte state=Byte.parseByte(request.getParameter("state"));
		String color=request.getParameter("color");
		String detail_img=request.getParameter("detail_img");
		String main_img=request.getParameter("main_img");
		String mamber_id=request.getParameter("mamber_id");
		String model_num=request.getParameter("model_num");
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		//null이면 형변환 시 오류를 막기 위해 
		Timestamp sale_end_time=
		(request.getParameter("sale_end_time")!=null)?Timestamp.valueOf(request.getParameter("sale_end_time")):null; 
		Timestamp sale_time=
		(request.getParameter("sale_time")!=null)?Timestamp.valueOf(request.getParameter("sale_time")):null; 

		ItemVo item=new ItemVo();
		item.setCate_num(cate_num);
		item.setCount(count);
		item.setPrice(price);
		item.setState(state);
		item.setColor(color);
		item.setDetail_img(detail_img);
		item.setMain_img(main_img);
		item.setMember_id(mamber_id);
		item.setModel_num(model_num);
		item.setName(name);
		item.setTitle(title);
		item.setSale_end_time(sale_end_time);
		item.setSale_time(sale_time);
		
		System.out.println(item);
		
		boolean insert=false;
		ItemDao itemDao=new ItemDao();
		try {
			insert=itemDao.insert(item);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("{\"insert\":"+insert+"}");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao itemDao=new ItemDao();
		response.setContentType("application/json;charset=UTF-8;");
		
		try {
			response.getWriter().append(itemDao.list(0).toString());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
