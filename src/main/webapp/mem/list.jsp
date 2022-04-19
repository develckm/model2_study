<%@page import="model2_shop.com.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>멤버 관리 페이지 입니다.</h1>
	<%
		List<MemberVo> mem_list=(List<MemberVo>)request.getAttribute("mem_list");
	%>
	<table>
		<thead>
		<tr>
		<th>id</th><th>pw</th><th>phone</th><th>email</th><th>name</th><th>address</th>
		<th>address_detail</th><th>signup_time</th><th>birth</th><th>grade</th><th>수정페이지</th>
		</tr>
		</thead>          
		<tbody>
			<%for(MemberVo mem : mem_list){%>
				<tr>
					<td><%=mem.getId() %></td>
					<td><%=mem.getPw() %></td>
					<td><%=mem.getPhone() %></td>
					<td><%=mem.getEmail() %></td>
					<td><%=mem.getName() %></td>
					<td><%=mem.getAddress() %></td>
					<td><%=mem.getAddress_detail() %></td>
					<td><%=mem.getSignup_time() %></td>
					<td><%=mem.getBirth() %></td>
					<td><%=mem.getGrade() %></td>
					<td>
						<a href="./modify.do?id=<%=mem.getId() %>">
							수정
						</a>
					</td>
				</tr>
			<%}; %>
			
		</tbody>	
	</table>
	
	
</body>
</html>