<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>회원가입</h1>
    
    <form action="insertPro.jsp" method="post" >
    	<input type = "hidden" name = "join" value = "1" />
    	<input type = "hidden" name = "rating" value = "1" />
    	<input type = "hidden" name = "user_cash" value = "0" />
    	id :   <input type = "text" name= "user_id" />    			<br />
    	pw :   <input type = "text" name= "user_pw" /> 				<br />
    	name : <input type = "text" name= "user_name" />   			<br />
    	phone :  <input type = "text" name= "user_phone" />    		<br />
    	address :   <input type = "text" name= "user_address" />    	<br />
    	       <input type = "submit" value= "가입" /> 				<br />
    </form>