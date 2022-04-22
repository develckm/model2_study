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
@WebServlet("/item/ajax.do")
public class ItemAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //list or ?id= detail    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해더 본문의 문자열에서 json으로 보낸 파라미터 불러오기 
		StringBuffer jb = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null){
			jb.append(line);			
		}

		JSONObject json= new JSONObject(jb.toString());
		//System.out.println(json.get("cate_num"));
		//System.out.println(request.getParameter("cate_num"));

		ItemVo item=new ItemVo();
		item.setCate_num(Integer.parseInt( json.getString("cate_num") ));
		item.setCount(Integer.parseInt( json.getString("count") ));
		item.setPrice(Integer.parseInt( json.getString("price")));
		item.setState(Byte.parseByte(json.getString("state")));
		item.setColor(json.getString("color"));
		item.setDetail_img(json.getString("detail_img"));
		item.setMain_img(json.getString("main_img"));
		item.setMember_id(json.getString("mamber_id"));
		item.setModel_num(json.getString("model_num"));
		item.setName(json.getString("name"));
		item.setTitle(json.getString("title"));
		//item.setSale_end_time(  (json.getString("sale_end_time")=="")? null : Timestamp.valueOf(json.getString("sale_end_time").split("T")[0]  )  );
		//item.setSale_time(  (json.getString("sale_time")=="")? null : Timestamp.valueOf(json.getString("sale_time").split("T")[0])  );
		
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
		///////id 파라미터가 오면 detail을 반환 
		String item_num=request.getParameter("item_num");
		
		ItemDao itemDao=new ItemDao();
		response.setContentType("application/json;charset=UTF-8;");
		
		try {
			if(item_num==null) {
				response.getWriter().append(itemDao.list(0).toString());				
			}else{
				response.getWriter().append( itemDao.detail(Integer.parseInt(item_num)).toString() );
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer json_str=new StringBuffer();
		BufferedReader br=request.getReader();//본문 해더의 문자열을 읽는 객체 
		String line="";
		while((line=br.readLine())!=null) {
			json_str.append(line);
		}
		JSONObject json=new JSONObject(json_str.toString());
		System.out.println(json);
		ItemVo item=new ItemVo();
		item.setItem_num(Integer.parseInt( json.get("item_num").toString() ));
		item.setCate_num(Integer.parseInt( json.getString("cate_num") ));
		item.setCount(Integer.parseInt( json.getString("count") ));
		item.setPrice(Integer.parseInt( json.getString("price")));
		item.setState(Byte.parseByte(json.getString("state")));
		item.setColor(json.getString("color"));
		item.setDetail_img(json.getString("detail_img"));
		item.setMain_img(json.getString("main_img"));
		item.setMember_id(json.getString("member_id"));
		item.setModel_num(json.getString("model_num"));
		item.setName(json.getString("name"));
		item.setTitle(json.getString("title"));
		System.out.println("item="+item);
		
		boolean update= false;
		ItemDao itemDao=new ItemDao();
		try {
			update=itemDao.update(item);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("{\"update\":"+update+"}");
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
