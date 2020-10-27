<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="/myShop/css/bootstrap.css"> <!-- 참조  -->

    <nav class ="navbar navbar-default">
        <div class="navbar-header"> <!-- 홈페이지의 로고 -->
            <button type="button" class="navbar-toggle collapsed"  data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expand="false">
                <span class ="icon-bar"></span> <!-- 줄였을때 옆에 짝대기 -->
                <span class ="icon-bar"></span> <span class ="icon-bar"></span>
            </button>
            <a class ="navbar-brand" href="/myShop/index.jsp">myShop</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/">스토어</a></li>
                <li><a href="/">시공</a></li>
                <li><a href="/">커뮤니티</a></li>
                <li><form action="#" method ="post"> <input type="text" name="?" />
            <input type="submit" value="검색" />           </form></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                <a href="#	" class = "dropdown-toggle" data-toggle="dropdown" role ="button" aria-haspopup="true" aria-expanded="false">
                접속하기
                <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="active"><a href="/myShop/user/loginForm.jsp">로그인</a></li>
                        <li><a href="/myShop/user/insertForm.jsp">회원가입</a></li>                    
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>