<%@page import="model2_shop.com.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%String login=request.getParameter("login");
MemberVo mem=(MemberVo)request.getAttribute("mem"); %>

<script>
let login=<%=login%>;
if(login!=null){
	alert("js 로그인 :"+login);
}
</script>

<body>
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
				등급:<input type="number" size="1" name="grade" value="<%=mem.getGrade()%>">
			</label>
		</p>
		<p>
			<label>
				가입일:<input type="text" name="signup_time" value="<%=mem.getSignup_time()%>" readonly>
			</label>
		</p>
				<p>
			<label>
				생일:<input type="text" name="birth" value="<%=mem.getBirth()%>">
			</label>
		</p>
		
		<p>
			<button type="reset">리셋</button>
			<button type="submit">제출</button>
			
		</p>
	
	</form>
	
</body>
</html>