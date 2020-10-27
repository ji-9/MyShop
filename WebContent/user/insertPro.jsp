<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "myShop.mvc.user.UserDAO" %>
<%@ page import= "myShop.mvc.user.UserDTO" %>

    <h1>회원가입Pro</h1>

    <jsp:useBean id="dto" class= "myShop.mvc.user.UserDTO" />
    <jsp:setProperty property="*" name="dto" />

    	<%
    		request.setCharacterEncoding("UTF-8");
	    	UserDAO dao = new UserDAO();
	        boolean result = dao.userselId(dto.getUser_id());
	        if(result){
	    %>
	    <script>
			alert("이 아이디는 있는 아이디거나 삭제된 아이디 입니다.");
		</script>  
	    <%	
	        }else{
	        	dao.insert(dto); 
	    %>
	   <script>
	        alert("등록되었습니다.");
	    </script> 
	    <%
	        }
    	%>
    	
    <button onclick="window.location='/myShop/user/loginForm.jsp'">로그인</button>
    
    
    
    
    
    
    
    
    
    