package model2_shop.com.dao;

import java.sql.SQLException;
import java.util.List;

import model2_shop.com.vo.MemberVo;

//상사 -> 부하에게 서비스 이렇게 저렇게 만들기로 했으니 구현하세요! 
public interface MemberDaoAble {
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException ; //관리자 멤버 리스트
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException ; //관리자 수정, 개인 정보 수정페이지, 개인 정보 상세페이지 
	public boolean insert(MemberVo mem) throws ClassNotFoundException, SQLException ; //회원등록, 회원가입 
	public boolean update(MemberVo mem) throws ClassNotFoundException, SQLException ; //회원수정, 개인 정보 수정 
	public boolean delete(String id) throws ClassNotFoundException, SQLException ; //회원삭제 => 위험 외래키로 참조하는 테이블이 많기 때문에 
}