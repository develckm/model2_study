package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model2_shop.com.vo.ItemVo;

public class ItemDao implements ItemDaoAble{
	private String list_sql="SELECT * FROM ITEM ORDER BY POST_TIME DESC";
	private String detail_sql="SELECT * FROM ITEM WHERE item_num=?";

	//private String sale_list_sql="SELECT * FROM ITEM WHERE STATE=0 && SALE_time>현재날짜";//실제 사용자가 보는 아이템 리스트
	@Override
	public List<ItemVo> list(int page)
			throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		List<ItemVo> item_list=new ArrayList<ItemVo>();
		while(rs.next()) {
			ItemVo item=new ItemVo();
			item.setItem_num(rs.getInt("item_num"));
			item.setCount(rs.getInt("count"));
			item.setPrice(rs.getInt("price"));
			item.setCate_num(rs.getInt("cate_num"));
			item.setState(rs.getByte("state"));
			item.setColor(rs.getString("color"));
			item.setTitle(rs.getString("title"));
			item.setMain_img(rs.getString("main_img"));
			item.setDetail_img(rs.getString("detail_img"));
			item.setName(rs.getString("name"));
			item.setMember_id(rs.getString("member_id"));
			item.setModel_num(rs.getString("model_num"));
			item.setPost_time(rs.getTimestamp("post_time"));
			item.setSale_time(rs.getTimestamp("sale_time"));
			item.setSale_end_time(rs.getTimestamp("sale_end_time"));
			item_list.add(item);
		}
		return item_list;
	}
	@Override
	public ItemVo detail(int num) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setInt(1, num);
		ResultSet rs=ps.executeQuery(); //유니크로 검색해서 1개만 넘어오지만 (mysql 은 몇개가 오는지 몰라서)무조건 배열 타입니다. 
		ItemVo item=new ItemVo();
		if(rs.next()) {
			item.setItem_num(rs.getInt("item_num"));
			item.setCount(rs.getInt("count"));
			item.setPrice(rs.getInt("price"));
			item.setCate_num(rs.getInt("cate_num"));
			item.setState(rs.getByte("state"));
			item.setColor(rs.getString("color"));
			item.setTitle(rs.getString("title"));
			item.setMain_img(rs.getString("main_img"));
			item.setDetail_img(rs.getString("detail_img"));
			item.setName(rs.getString("name"));
			item.setMember_id(rs.getString("member_id"));
			item.setModel_num(rs.getString("model_num"));
			item.setPost_time(rs.getTimestamp("post_time"));
			item.setSale_time(rs.getTimestamp("sale_time"));
			item.setSale_end_time(rs.getTimestamp("sale_end_time"));
		}
		return item;
	}

	@Override
	public boolean insert(ItemVo item)
			throws ClassNotFoundException, SQLException {
		String sql="INSERT INTO ITEM "
				+ "(cate_num,color,count,detail_img,main_img,member_id,model_num,name,price,state,title) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, item.getCate_num());
		ps.setString(2, item.getColor());
		ps.setInt(3, item.getCount());
		ps.setString(4, item.getDetail_img());
		ps.setString(5, item.getMain_img());
		ps.setString(6, item.getMember_id());
		ps.setString(7, item.getModel_num());
		ps.setString(8, item.getName());
		ps.setInt(9, item.getPrice());
		ps.setByte(10, item.getState());
		ps.setString(11, item.getTitle());
		int insert =ps.executeUpdate();
		if(insert>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(ItemVo item)
			throws ClassNotFoundException, SQLException {
		String update_sql="UPDATE ITEM SET  price=?, cate_num=?  WHERE item_num=?";
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setInt(1, item.getPrice());
		ps.setInt(2, item.getCate_num());
		ps.setInt(3, item.getItem_num());
		int update=ps.executeUpdate();
		if(update>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int[] num)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemVo> list(int page, String writer)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemVo detail(int num, String writer)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int num, String writer)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int[] num, String writer)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemVo> sale_list(int page)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	//톰캣의 메인이 아니고 직접 제작한 자바 어플 
	public static void main(String[] args) {
		try {
			//System.out.println(new ItemDao().list(0));
			System.out.println(new ItemDao().detail(1011));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}





