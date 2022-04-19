<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
if(session.getAttribute("insert")!=null){
	boolean delete=(boolean)session.getAttribute("insert");
	String msg="";
	if(delete){ 
		msg="<script>alert(\"등록 성공\");</script>";
	}else{ 
		msg="<script>alert(\"등록 실패\");</script>";
	} 
	out.append(msg);
	session.removeAttribute("insert");
}
%>


<body>
	<h1>/mem/insert.jsp</h1>
	<h2>멤버 등록 폼</h2>
	<form action="./insert.do" method="post">
		<p>
			<label>
				아이디:<input type="text" name="id" value="hong">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		<p>
			<label>
				이메일:<input type="text" name="email" value="hong@gmail.com">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		<p>
			<label>
				폰:<input type="text" name="phone" value="111-1111-1234">
			</label>
			<span id="checkId">중복체크중입니다.</span>
		</p>
		<p>
			<label>
				pw:<input type="text" name="pw" value="1234">
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
				이름:<input type="text" name="name" value="길동">
			</label>
		</p>
		<p>
			<label>
				주소:<input type="text" name="address" value="서울">
			</label>
		</p>
		<p>
			<label>
				주소상세:<input type="text" name="address_detail" value="종로">
			</label>
		</p>
	
		<p>
			<label>
				등급:<select size="1" name="grade">
					<option value="0">총관리자(0)</option>
					<option value="1">관리자(1)</option>
					<option value="2">판매자(2)</option>
					<option value="3" selected>소비자(3)</option>
					<option value="4">탈퇴(4)</option>
				</select>
			</label>
		</p>
		<p>
			<label>
				생일:<input type="date" name="birth" value="1900-01-01" pattern="yyyy-mm-dd">
			</label>
		</p>
		
		<p>
			<button type="reset">리셋</button>
			<button type="submit">제출</button>
		</p>
	
	</form>
	
</body>
</html>