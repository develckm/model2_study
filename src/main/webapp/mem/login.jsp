<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>샵 스프링 로그인 페이지</title>
</head>
<body>
<%
	//HttpSesion session=request.getSession();
	//null=>boolean형변환 시 오류
	//boolean login=(boolean)session.getAttribute("login");
	Object login=session.getAttribute("login");

%>
<script>
	alert(<%=login%>);
</script>

	<%@include file="/header_nav.jsp"%>
	<h1>샵 스프링 로그인 페이지 </h1>
	<div class="d-flex justify-content-center align-items-center" style="height: calc(100vh - 200px)">
		<form action="<%=request.getContextPath()%>/login.do" method="post" style="width: 400px;">
		  <div class="mb-3 row">
		    <label for="staticEmail" class="col-sm-2 col-form-label">아이디</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="staticEmail" value="">
		    </div>
		  </div>
		  <div class="mb-3 row">
		    <label for="inputPassword" class="col-sm-2 col-form-label">패스워드</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword">
		    </div>
		  </div>
	  	  <div class="col-12">
		  	<button type="button" class="btn btn-danger">회원가입</button>
		  	<button type="submit" class="btn btn-success">로그인</button>
		  </div>
		</form>
	</div>
</body>
</html>