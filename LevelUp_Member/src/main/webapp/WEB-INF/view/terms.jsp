<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Level Up :  회원가입</title>
<style type="text/css">
input[id="chk_all"]{
	display: inline-block;
	width: 20px;
	height: 20px;
	border: 2px solid #bcbcbc;
	cursor: pointer;
}
	#wrap{
		width: 768px;
		height: 920px;
	}
	#container{
		width: 768px;
		height: 668px;
		text-align: center;
	}
	#join_form{
		width: 460px;
		height: 630px;
/* 		text-align: center; */
	}
</style>
<script type="text/javascript">
	function agree(){
		location.href="./join.do";
	}
</script>
</head>
<body>
	<div id="wrap">
		<h1 style="text-align: center"><a style="color:#E6E0F8">Level Up</a></h1>
		<div id="container">
			<form id="join_form" method="get" action="">
				<p class="chk_all">
					<span>
						<input type="checkbox" id="chk_all">
						<label for="chk_all">
							<span>이용약관, 개인정보 수집 및 이용
								위치정보 이용약관(선택)<br>
								프로모션 안내
								메일 수신(선택)에 모두 동의합니다. 
							</span>
						</label>
					</span>
				</p>
				<ul>
					<li>
						<span>
							<input type="checkbox" class="chk">
							<label>네이버 이용약관 동의
								<span class="terms_necessary">(필수)</span>
							</label>
						</span>
						<div class="terms_box">
							<h3>여러분을 환영합니다.</h3>
							<p>
        네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다.
        본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와
        이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며,
        아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
    </p>
						</div>
					</li>
				</ul>
				<span class="error" id="agreeMsg" style="display:none">네이버 이용약관과 개인정보 수집 및 이용에 대한 안내 모두 동의해주세요.</span>
				<input type="button" value="동의" onclick="agree()">
			</form>
		</div>
	</div>
</body>
</html>