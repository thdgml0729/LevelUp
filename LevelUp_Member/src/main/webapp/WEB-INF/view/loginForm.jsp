<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h1>로그인페이지</h1>
	<form action="./login.do" method="post">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="text" name="pw" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>