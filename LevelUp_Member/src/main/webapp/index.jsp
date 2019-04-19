<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Syncopate" rel="stylesheet">
<script type="text/javascript">
	function longin(){
		location.href="./loginForm.do";
	}
</script>
<style type="text/css">
	.btn{
		width: 287px;
		height: 40px;
		background-color: #E6E0F8;
		border-radius: 10px;
		font-family: 'Syncopate', sans-serif;
		font-weight: bold;
		font-size: 15px;
		cursor: pointer;
		margin-bottom: 8px;
		margin-top: 0px;
	}
	a{
		color: black;
		text-decoration: none;
		font-size: 14px;
	}
	#main{
		width: 380px;
		height: 170px;
		
		margin-top: 100px;
		margin-left: 100px;
		
		border: 4px solid #E6E0F8;
		text-align: center;
	}
	h2{
		margin-bottom: 20px;
		margin-top: 20px;
	}
</style>
</head>
<body>
<div>
	<div id="main">
		<h2 style="color: #E6E0F8; font-weight: bold; font-size: 40px">Level Up</h2>
		<input type="button" class="btn" value="LEVEL UP 로그인" onclick="longin()"><br>
		<a href="./findId.do">아이디</a>
		<a>·</a>
		<a href="./findPw.do">비밀번호 찾기</a>
		<a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
		<a href="./terms.do">회원가입</a>
	</div>
</div>
</body>
</html>