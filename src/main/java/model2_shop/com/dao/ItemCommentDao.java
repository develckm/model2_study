package model2_shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.ItemCommentVo;

public class ItemCommentDao implements ItemCommentDaoAble{

	@Override
	public List<ItemCommentVo> list(int item_num, int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemCommentVo detail(int comment_num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(ItemCommentVo vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ItemCommentVo vo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int comment_num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteItemNum(int item_num) throws SQLException, ClassNotFoundException {
		String deleteItemNumSql="DELETE FROM ITEM_COMMENT WHERE item_num=?"; //외래키 아이템넘버로 복수 삭제
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(deleteItemNumSql);
		ps.setInt(1, item_num);
		int del=ps.executeUpdate();
		return del;
	}
//	public static void main(String[]args) {
//		try {
//			int del=new ItemCommentDao().deleteItemNum(999);
//			System.out.println(del+"개 삭제");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
}







