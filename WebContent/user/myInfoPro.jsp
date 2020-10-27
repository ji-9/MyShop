<%@page import="myShop.mvc.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>정보수정Pro</h1>

<%
	request.setCharacterEncoding("UTF-8");

	String sessionId = (String) session.getAttribute("user_id");
	if (sessionId == null) {
		response.sendRedirect("/myShop/user/loginForm.jsp");
	}
%>
<jsp:useBean id="dto" class="myShop.mvc.user.UserDTO" />
<jsp:setProperty name="dto" property="*" />

<%
	UserDAO dao = new UserDAO();
	dao.update(dto);
%>
<script>
	alert("수정되었습니다.");
	window.location = "/myShop/user/main.jsp";
</script>