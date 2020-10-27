<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>회원탈퇴</h1>
    
    <%  
    String sessionId = (String)session.getAttribute("user_id");
		if(sessionId == null){
			response.sendRedirect("/myShop/user/loginForm.jsp");
		}
	%>
    
    <form action="deletePro.jsp" method="post">
    		 <input type="hidden" name="user_id" value="<%=sessionId %>" />
    	pw : <input type="text" name="user_pw" /> <br />
    		 <input type="submit" value="탈퇴" />
    
    </form>
   
	