package model2_shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.ItemVo;
import model2_shop.com.vo.MemberVo;

//상사 -> 부하에게 서비스 이렇게 저렇게 만들기로 했으니 구현하세요! 
public interface ItemDaoAble {

////////////////////////////////////////관리자//////////////////////////////////////////	
	public List<ItemVo> list(int page) throws ClassNotFoundException, SQLException ; //관리자 아이템 리스트, 상품 구매 리스트(서비스),장바구니(서비스)
	public ItemVo detail(int num) throws ClassNotFoundException, SQLException ; //관리자 아이템 수정, 상품 상세(서비스) 
	public boolean insert(ItemVo item) throws ClassNotFoundException, SQLException ; //관리자,판매자 아이템 등록
	public boolean update(ItemVo item) throws ClassNotFoundException, SQLException ; //관리자,판매자 아이템 수정 
	public boolean delete(int num) throws ClassNotFoundException, SQLException ; //관리자, 판매자 아이템 삭제 => 위험 외래키로 참조하는 테이블이 많기 때문에 
	public boolean delete(int [] num) throws ClassNotFoundException, SQLException ; //관리자, 판매자 아이템 복수 삭제 => 위험 외래키로 참조하는 테이블이 많기 때문에 
////////////////////////////////////////판매자//////////////////////////////////////////
	public List<ItemVo> list(int page,String writer) throws ClassNotFoundException, SQLException ; //판매자 아이템 리스트
	public ItemVo detail(int num,String writer) throws ClassNotFoundException, SQLException ; // 판매자 아이템 수정페이지, 상품 상세(서비스) 
	public boolean delete(int num,String writer) throws ClassNotFoundException, SQLException ; //판매자 아이템 삭제 => 위험 외래키로 참조하는 테이블이 많기 때문에 
	public boolean delete(int [] num,String writer) throws ClassNotFoundException, SQLException ; //판매자 아이템 복수 삭제 => 위험 외래키로 참조하는 테이블이 많기 때문에 
////////////////////////////////////////판매자//////////////////////////////////////////
	public List<ItemVo> sale_list(int page) throws ClassNotFoundException, SQLException ; // 상품 리스트(서비스)  (현재 판매 중인 것만 출력) 

}