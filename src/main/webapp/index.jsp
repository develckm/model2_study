<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>샵 관리자 페이지</h1>
	<nav>
		<ul>
			<li><a href="<%=request.getContextPath()%>/mem/list.do">멤버리스트(관리)</a></li>
			<li><a href="<%=request.getContextPath()%>/cate/list.do">카테고리스트(관리)</a></li>
		
		</ul>
	</nav>
</body>
</html>