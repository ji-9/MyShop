<%@page import="myShop.mvc.user.UserDTO"%>
<%@page import="myShop.mvc.user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="myShop.mvc.user.UserDTO" />
<jsp:setProperty name="dto" property="*" />
<%
	request.setCharacterEncoding("UTF-8");

	String sessionId = (String) session.getAttribute("user_id");
	if (sessionId == null) {
		response.sendRedirect("/myShop/user/loginForm.jsp");
	}else{
	UserDAO dao = new UserDAO();
	UserDTO infodto = dao.myInfo(sessionId);

	String parcash = request.getParameter("user_cash1");
	String dtocash = dto.getUser_cash();
	int a = Integer.parseInt(parcash);
	int b = Integer.parseInt(dtocash);
	int c = a + b;
	String cash = Integer.toString(c);
	dto.setUser_cash(cash);
	dao.cashUpdate(dto);
%>
<script>
	alert("충전되었습니다.");
	window.location = "main.jsp";
</script>
<%}%>