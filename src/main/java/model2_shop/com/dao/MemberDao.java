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
			+ " birth=?,"
			+ " grade=? "
			+ " WHERE id=?";
	private String delete_sql="DELETE FROM MEMBER WHERE ID=?";
	private String insert_sql="INSERT INTO MEMBER(id,email,phone,pw,name,address,address_detail,grade,birth) VALUES (?,?,?,?,?,?,?,?,?)";
	private String detail_sql="SELECT * FROM MEMBER WHERE id=?";
	private String email_check_sql="SELECT * FROM MEMBER WHERE email=?";
	private String phone_check_sql="SELECT * FROM MEMBER WHERE phone=?";

	private String login_sql="SELECT * FROM MEMBER WHERE id=? and pw=?";

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
		PreparedStatement ps=conn.prepareStatement(detail_sql);
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
		ps.setByte(8, mem.getGrade());
		ps.setString(9, mem.getId());

		int update=ps.executeUpdate();
		//delete,update,insert ??? ?????? :  ????????? ????????? ?????????????????? 
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
		int delete=ps.executeUpdate(); //delete,update, insert  => ????????? ???
		//session ?????? ?????? ?????? (????????? ???????????? ??????)
		if(delete>0) {
			return true;			
		}else {
			return false;
		}
	}
	@Override
	public MemberVo login(String id, String pw) throws ClassNotFoundException, SQLException {
		MemberVo mem=null;
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(login_sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs=ps.executeQuery();
		//id??? ???????????? ????????? ????????? 1?????? ???????????? ????????? while ?????? ??? ?????? x
		if(rs.next()) {
			mem=new MemberVo(); //id??? pw??? ?????? ?????? null??? ?????????.
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
	public MemberVo emailCheck(String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberVo phoneCheck(String phone) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}


















