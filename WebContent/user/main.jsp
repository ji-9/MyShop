<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>메인</h1>
    <%! String id,pw,auto; %>
    <%

    	if(session.getAttribute("user_id") == null){
    		Cookie [] cookies = request.getCookies();
    		if(cookies != null){
    			for(Cookie c : cookies){
    				if(c.getName().equals("cid")) id = c.getValue();
    				if(c.getName().equals("cpw")) pw = c.getValue();
    				if(c.getName().equals("cauto")) auto = c.getValue();				
    			}
    		}
    		if(auto != null && id != null && pw != null){
    			response.sendRedirect("/myShop/user/cookiePro.jsp");
    		}else{
    			response.sendRedirect("/myShop/user/loginForm.jsp");
    		}
    	}else{
    		out.println("로그인 되었습니다.");
    	}
    
    %>
	<br /><br />
    <button onclick="window.location='/myShop/user/myInfo.jsp'">내 정보 확인</button><br /><br />
	<button onclick="window.location='/myShop/user/deleteForm.jsp'">탈퇴</button><br /><br />
	<button onclick="window.location='/myShop/user/logout.jsp'">로그아웃</button><br /><br />
    <button onclick="window.location='/myShop/user/cash.jsp'">충전</button><br /><br />
    	
    	
    	
    	
    