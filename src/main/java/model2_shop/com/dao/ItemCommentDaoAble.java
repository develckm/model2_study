package model2_shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.ItemCommentVo;
import model2_shop.com.vo.MemberVo;

public interface ItemCommentDaoAble {
	public List<ItemCommentVo> list(int item_num,int page) throws ClassNotFoundException, SQLException ; 
	public ItemCommentVo detail(int comment_num) throws ClassNotFoundException, SQLException ; 
	public boolean insert(ItemCommentVo vo) throws ClassNotFoundException, SQLException ; 
	public boolean update(ItemCommentVo vo) throws ClassNotFoundException, SQLException ; 
	public boolean delete(int comment_num) throws ClassNotFoundException, SQLException ; 
	public int deleteItemNum(int item_num) throws ClassNotFoundException, SQLException;//외래키인 아이템넘버로 복수 삭제 
}