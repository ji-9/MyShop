<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "myshop.cart.CartDAO" %>
<%@ page import = "myshop.cart.CartDTO" %>
<%@ page import = "java.util.Vector" %>
<%@ page import = "java.text.NumberFormat" %>


<%
	String sessionId = (String)session.getAttribute("id");
%>

<html>
<head>
<title>구매페이지</title>
</head>

<%
	Vector cartLists = null;
	Vector accountLists = null;
	CartDAO cartList = null;
	MemberDAO member = null;
	int number = 0;
	int total;
	
	if(session.getAttribute("id")==null){
		response.sendRedirect("//메인경로");
	}else{
		CartDAO cartdao = new CartDAO();
		cartLists = dao.//getCart(//buyer);
		
		MemberDAO memberdao = new MemberDAO();
		member = memberdao.//getMember(//buyer);
		
		BuyDAO buydao = new BuyDAO();
		accountLists = buydao.//getAccount();
%>
	<center><h3><b>구매목록</b></h3></center>
	<center>
	<form action = "updateCart.jsp" method="post">
	<table border ="1" width="700" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td align ="center" width="50">번호</td>
			<td align ="center" width="300">상품</td>
			<td align ="center" width="100">가격</td>
			<td align ="center" width="100">수량</td>
			<td align ="center" width="150">금액</td>
		</tr>

<%
	for(int i=0; i<cartLists.size();i++){
		cartList = (CartDTO)cartLists.//elementAt(i);
%>		
	<tr>
		<td align = "center" width="50"><%=++number %></td>
		<td width ="300">
			<img ~>
		</td>
		<td align ="center" width="100">\<%=NumberFormat.getInstance().format(cartList.//getBuy_price() %></td>
		<td width="150" align="center"><%=cartList.//getBuy_price(); %>
		<td align = "center" width="150" align="center">
			<%total += cartList.getBuy_count()*cartList.getBuy_price(); %>
			\<%=NumberFormat.getInstance().format(cartList.getBuy_count()*cartList.getBuy_price()) %>
			</td>
		</tr>
<%
	}
%>
	<tr>
		<td colspan = "5" align="right"><b>총 구매금액: \<%=NumberFormat.getInstance().format(total) %></b></td>
	</tr>
	</table>
	</form>
	</center>
<%}
%>
	<br>
	<form method="post" action="//buyPro.jsp" >
	<table width="600" border ="1" cellpadding="3" cellspacing="0" align="center">
	<tr>
		<td colspan="2" align="center"><font size="+1"><b>주문자 정보</b></font></td>
	</tr>
	<tr>
		<td width = "200">성명</td>
		<td width = "400"><%=member.getName() %></td>
	</tr>	
	<tr>
		<td width = "200">전화번호</td>
		<td width = "400"><%=member.getTel() %></td>
	</tr>	
	<tr>
		<td width = "200">주소</td>
		<td width = "400"><%=member.getAddress() %></td>
	</tr>	
	</table>
	<br>
	
	<table width="600" border="1" cellspacing="0" cellpadding="3"  align="center"> 
    <tr >  
    	<td  colspan="2" align="center"><font size="+1" ><b>배송지 정보</b></font></td> 
    </tr> 
	<tr>  
		<td  width="200">성명</td> 
		<td  width="400"> 
			<input type="text" name="userName" value="<%=member.getName()%>"> 
		</td> 
	</tr> 
	<tr>  
		<td  width="200">전화번호</td> 
		<td  width="400"> 
			<input type="text" name="deliveryTel" value="<%=member.getTel()%>"> 
		</td> 
	</tr> 
	<tr>  
		<td  width="200">주소</td> 
		<td  width="400"> 
			<input type="text" name="deliveryAddess" value="<%=member.getAddress()%>"> 
		</td> 
	</tr> 
	<tr>  
		<td colspan="2" align="center" > 
			<input type="submit" value="확인" > 
			<input type="button" value="취소" onclick="javascript:window.location='../shopMain.jsp'">       
		</td> 
	</tr> 
	</table> 
	</form> 
	</body> 
	</html> 

