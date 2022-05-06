package model2_shop.com.contoroller;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.ItemCommentDao;
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
		boolean insert=false;

		String sale_time_str=json.getString("sale_time"); //"2022-05-03T10:45"
		String sale_end_time_str=json.getString("sale_end_time");
		//Timestamp.valueOf("yyyy-mm-dd hh:mm:ss");=>Timestamp type으로 형변환 
		ItemDao itemDao=new ItemDao();
		try {
			Timestamp sale_time=(sale_time_str!="")?
					Timestamp.valueOf(sale_time_str.replace("T", " ")+":00"):
					new Timestamp(new Date().getTime());
			Timestamp sale_end_time=(sale_end_time_str!="")?Timestamp.valueOf(sale_end_time_str.replace("T", " ")+":00"):null;
			item.setSale_time(sale_time);
			item.setSale_end_time(sale_end_time);
			
			insert=itemDao.insert(item);
		} catch (ClassNotFoundException | SQLException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		response.getWriter().append("{\"insert\": "+insert+" }");
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
		
		Timestamp sale_time=(json.get("sale_time")!="")?Timestamp.valueOf(json.getString("sale_time")):null;		
		Timestamp sale_end_time=(json.get("sale_end_time")!="")?Timestamp.valueOf(json.getString("sale_end_time")):null;		
		item.setSale_time(sale_time);
		item.setSale_end_time(sale_end_time);
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
		String item_num_str=request.getParameter("item_num");
		System.out.println("delete 방식으로 통신 item_num:"+item_num_str);
		boolean delete=false;
		int commnet_delete=0;
		ItemDao itemDao=new ItemDao();
		ItemCommentDao itemCommentDao=new ItemCommentDao();
		try {
			int item_num=Integer.parseInt(item_num_str);
			commnet_delete=itemCommentDao.deleteItemNum(item_num);
			delete=itemDao.delete(item_num);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//아이템에 달린 상품평도 동시에 삭제됨
		//삭제를 성공했는지를 응답 {delete:true, comment_delete:4} 
		//delete =new ItemDao().delete();
		HashMap<String, Object> delMap=new HashMap<>();
		delMap.put("delete", delete);
		delMap.put("comment_delete",  commnet_delete);
		System.out.println(new JSONObject(delMap).toString());
		response.getWriter().append(new JSONObject(delMap).toString());
	}
}




