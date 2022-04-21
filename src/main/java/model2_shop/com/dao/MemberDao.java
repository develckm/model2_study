package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.JsonParser;

import model2_shop.com.vo.MemberVo;


public class MemberDao implements MemberDaoAble{

	private String list_sql="SELECT * FROM MEMBER";
	private String update_sql="UPDATE MEMBER SET "
			+ " pw=?,"
			+ " phone=?,"
			+ " email=?,"
			+ " name=?,"
			+ " address=?,"
			+ " address_detail=?,"
			+ " birth=?"
			+ " WHERE id=?";
	private String delete_sql="DELETE FROM MEMBER WHERE ID=?";
	private String insert_sql="INSERT INTO MEMBER(id,email,phone,pw,name,address,address_detail,grade,birth) VALUES (?,?,?,?,?,?,?,?,?)";
	@Override
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException {
		List<MemberVo> mem_list=new ArrayList<MemberVo>();
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps =conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			MemberVo mem=new MemberVo();
			mem.setId(rs.getString("id"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setEmail(rs.getString("email"));
			mem.setPhone(rs.getString("Phone"));
			mem.setPw(rs.getString("pw"));
			mem.setBirth(rs.getDate("birth"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setGrade(rs.getByte("grade"));
			mem_list.add(mem);
		}
		return mem_list;
	}
	@Override
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM MEMBER WHERE id=?");
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		MemberVo mem=new MemberVo();
		
		while(rs.next()) {
			mem.setId(rs.getString("id"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setEmail(rs.getString("email"));
			mem.setPhone(rs.getString("Phone"));
			mem.setPw(rs.getString("pw"));
			mem.setBirth(rs.getDate("birth"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setGrade(rs.getByte("grade"));
		}
		return mem;
	}

	@Override
	public boolean insert(MemberVo mem)
			throws ClassNotFoundException, SQLException {
		//INSERT INTO MEMBER(id,email,phone,pw,name,address,address_detail,grade,birth) VALUES (?,?,?,?,?,?,?,?,?);
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setString(1, mem.getId());
		ps.setString(2, mem.getEmail());
		ps.setString(3, mem.getPhone());
		ps.setString(4, mem.getPw());
		ps.setString(5, mem.getName());
		ps.setString(6, mem.getAddress());
		ps.setString(7, mem.getAddress_detail());
		ps.setByte(8, mem.getGrade());
		ps.setString(9,new SimpleDateFormat("yyyy-mm-DD").format(mem.getBirth()));
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public boolean update(MemberVo mem)
			throws ClassNotFoundException, SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn
				.prepareStatement(update_sql);
		ps.setString(1, mem.getPw());
		ps.setString(2, mem.getPhone());
		ps.setString(3, mem.getEmail());
		ps.setString(4, mem.getName());
		ps.setString(5, mem.getAddress());
		ps.setString(6, mem.getAddress_detail());
		ps.setString(7, sdf.format(mem.getBirth()));
		ps.setString(8, mem.getId());
		int update=ps.executeUpdate();
		//delete,update,insert 시 사용 :  결과는 몇개가 수정되었는지 
		if(update>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String id)
			throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setString(1, id);
		int delete=ps.executeUpdate(); //delete,update, insert  => 성공한 수
		//session 으로 성공 실패 (서버에 저장되는 객체)
		if(delete>0) {
			return true;			
		}else {
			return false;
		}
	}

	public static void main(String[]args) {
		try {
			MemberDao dao=new MemberDao();
//			dao.list(1).forEach((MemberVo mem)->{
//				System.out.println(mem);
//			});
			System.out.println(dao.detail("admin"));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


















