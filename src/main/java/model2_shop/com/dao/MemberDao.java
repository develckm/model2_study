package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model2_shop.com.vo.MemberVo;


public class MemberDao implements MemberDaoAble{

	private String list_sql="SELECT * FROM MEMBER";
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MemberVo mem)
			throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn
				.prepareStatement("UPDATE MEMBER SET name=?, phone=? WHERE id=?");
		ps.setString(1, mem.getName());
		ps.setString(2, mem.getPhone());
		ps.setString(3, mem.getId());
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
		// TODO Auto-generated method stub
		return false;
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


















