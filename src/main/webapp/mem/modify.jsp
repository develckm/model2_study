<%@page import="model2_shop.com.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
MemberVo mem=(MemberVo)request.getAttribute("mem");
%>
<%
if(session.getAttribute("delete")!=null){
	boolean delete=(boolean)session.getAttribute("delete");
	String msg="";
	if(delete){ 
		msg="<script>alert(\"삭제 성공\");</script>";
	}else{ 
		msg="<script>alert(\"삭제 실패\");</script>";
	} 
	out.append(msg);
	session.removeAttribute("delete");
}
%>
<body>
	<%@ include file="/header_nav.jsp" %>
	<h1>/mem/modify.jsp</h1>
	<h2><%=mem.toString() %></h2>
	<h2>멤버 수정 폼</h2>
	<form action="./update.do" method="post">
		<p>
			<label>
				아이디:<input type="text" name="id" value="<%=mem.getId()%>">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		<p>
			<label>
				이메일:<input type="text" name="email" value="<%=mem.getEmail()%>">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		<p>
			<label>
				폰:<input type="text" name="phone" value="<%=mem.getPhone()%>">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		<p>
			<label>
				pw:<input type="text" name="pw" value="<%=mem.getPw()%>">
			</label>
			<span id="checkId">길이가 4이상</span>
		</p>
			<p>
			<label>
				pw:<input type="text" name="pw_check" value="">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		
		<p>
			<label>
				이름:<input type="text" name="name" value="<%=mem.getName()%>">
			</label>
		</p>
		<p>
			<label>
				주소:<input type="text" name="address" value="<%=mem.getAddress()%>">
			</label>
		</p>
		<p>
			<label>
				주소상세:<input type="text" name="address_detail" value="<%=mem.getAddress_detail()%>">
			</label>
		</p>
	
		<p>
			<label>
				등급:<select size="1" name="grade" value="<%=mem.getGrade()%>">
					<option value="0" <%if(mem.getGrade()==0){out.append("selected");}%> >총관리자(0)</option>
					<option value="1" <%if(mem.getGrade()==1){out.append("selected");}%> >관리자(1)</option>
					<option value="2" <%if(mem.getGrade()==2){out.append("selected");}%> >판매자(2)</option>
					<option value="3" <%if(mem.getGrade()==3){out.append("selected");}%> >소비자(3)</option>
					<option value="4" <%if(mem.getGrade()==4){out.append("selected");}%> >탈퇴(4)</option>
				
				</select>
			</label>
		</p>
		<p>
			<label>
				가입일:<input type="text" name="signup_time" value="<%=mem.getSignup_time()%>" readonly>
			</label>
		</p>
				<p>
			<label>
				생일:<input type="date" name="birth" value="<%=mem.getBirth()%>" pattern="yyyy-mm-dd">
			</label>
		</p>
		
		<p>
			<button type="reset">리셋</button>
			<button type="submit">제출</button>
			<a href="./delete.do?id=<%out.append(mem.getId());%>">삭제</a>
		</p>
	
	</form>
	
</body>
</html>