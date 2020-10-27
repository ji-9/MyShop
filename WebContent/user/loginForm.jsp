<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<h1>로그인</h1>
	<%
		String user_id = null, user_pw = null, auto = null;
		Cookie [] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("cid")) user_id = c.getValue();
				if(c.getName().equals("cpw")) user_pw = c.getValue();
				if(c.getName().equals("cauto")) auto = c.getValue();
			}
		}
		
		if(auto != null && user_id != null && user_pw != null){
 			response.sendRedirect("/myShop/user/cookiePro.jsp");
		}
	%>
	
	
	<form action="cookiePro.jsp" method="post">
    	id : <input type="text" name="user_id" /> 	<br />
    	pw : <input type="text" name="user_pw" /> 	<br />
    		 <input type="checkbox" name="auto" value="1" /> 자동로그인 <br />	
    		 <input type="submit" value="로그인" /> 	<br />
    </form>
    
   <button onclick="window.location='/myShop/user/insertForm.jsp'">회원가입</button>