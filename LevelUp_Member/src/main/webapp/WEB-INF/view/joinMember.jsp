<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
	#id.int{
		width: 334px;
		height: 29px;
		
	}
	.join_row{
		width: 460px;
		height: 75px;
	}
	#pswd1{
		width: 404px;
		height: 29px;
	}
	.err{
		color: red;
	}
</style>
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	var key;
	window.onload=function(){
// 		alert("온로드");
		var input = document.getElementsByClassName("int");
// 		alert(input.length);
// 		for (var i = 0; i < input.length; i++) {
// 			input[i].onclick = function(){
// 				alert((i+1)+"번 눌림");
// 				for (var j = 0; j < i-1; j++) {
// // 					alert(input[j].value);
// 					if(input[j].value==null && input[j].value==""){
// 						alert(j+"번째 NULl");
// 					}
// 				}
// 			}
// 		}
		input[3].onclick = function(){
// 			alert(input[1].value);
			if(input[1].value!="" && input[2].value!=""){
				if(input[1].value!=input[2].value){
					document.getElementById("err_pwchk").innerHTML = "비밀번호가 일치하지 않습니다.";
					input[2].value="";
				}
			}
		}
		input[1].onclick = function(){
			var num = Number(input[0].value);
			if(input[0].value==""){
				document.getElementById("err_id").innerHTML="필수 정보입니다.";
// 			}else if(typeof(input[0].value)!="string"){
// 			}else if(input[0].value.){
// 				alert("문자열이 아니다.");
// 				document.getElementById("err_id").innerHTML="5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
			}else if(!isNaN(input[0].value) || !check()){
				document.getElementById("err_id").innerHTML="5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
			}else if(idduplicate(input[0].value)){
				document.getElementById("err_id").innerHTML="이미 사용중이거나 탈퇴한 아이디입니다.";
			}else{
				$("#err_id").css("color","blue");
				document.getElementById("err_id").innerHTML="사용가능한 아이디입니다.";
			}
		}
	}
	function idduplicate(id){
		$.ajax({
			url : "./idcheck.do",
			type : "post",
			async : true,
			data : {"id": id},
//			dataType : "json",
			success : function(msg){
				return msg;
			}
		});
	}
	function check(){
		var re = /^[a-zA-Z0-9]{4,12}$/;
		var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		var id = document.getElementsByName("id")[0];
		
		 if((id.value).match(re)) {
	           return true; // 유효성에 맞는아이디
	       }
// 	       alert(message);
	       id.value = "";
	       id.focus();
	       return false; // 유효성에 맞지않다
	}
	function certi(){
		var num = document.getElementsByName("phone")[0].value;
		if(num.length<11){
			alert("형식에 맞지 않는 번호입니다.");
		}else{
			$.ajax({
				url : "./msgsend.do",
				type : "post",
				async : true,
				data : {"phone": num},
// 				dataType : "json",
				success : function(msg){
					alert(msg);
					key = msg;					
				}, error : function(msg){
					
				}
				
			});
		}
	}
	function certi_check(){
		var obj = document.getElementsByName("certi")[0].value;
		if(key==obj){
			alert("인증되었습니다.");
			
		}else{
			alert("인증에 실패하였습니다.");
		}
		
	}
</script>
</head>
<body>
<div>
	<form action="./joinMember.do" method="post">
		<div class="row">
			<label>아이디</label><br>
			<input type="text" class="int" name="id" maxlength="20"><br>
			<span class="err" id="err_id"></span>
		</div>
		<div class="row">
			<label>비밀번호</label><br>
			<input type="password" class="int" name="pw" maxlength="20"><br>
			<span class="err" id="err_pw"></span>
		</div>
		<div class="row">
			<label>비밀번호 확인</label><br>
			<input type="password" class="int" name="pw_chk" maxlength="20"><br>
			<span class="err" id="err_pwchk"></span>
		</div>
		<div class="row">
			<label>이름</label><br>
			<input type="text" class="int" name="name"><br>
			<span class="err" id="err_name"></span>
		</div>
		<div class="row">
			<label>생년월일</label><br>
			<input type="text" name="birth_year" placeholder="년(4자)" maxlength="4"  class="int">
			<select name="birth_month" class="int">
				<option>월</option>
				<option value="01">1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<input type="text" name="birth_day" placeholder="일" maxlength="2" class="int"><br>
			<span class="err" id="err_birth"></span>
		</div>
		<div class="row">
			<label>성별</label>
			<select  class="int" name="gender">
				<option>성별</option>
				<option value="남">남자</option>
				<option value="여">여자</option>
			</select><br>
			<span class="err" id="err_gender"></span>
		</div>
		<div class="row">
			<label>본인확인 이메일(선택)</label>
			<input type="text" name="email" placeholder="선택입력" maxlength="100" class="int"><br>
			<span class="err" id="err_email"></span>
		</div>
		<div class="row">
			<label>휴대전화</label>
			<input type="text" name="phone" placeholder="전화번호 입력"  class="int">
			<input type="button" value="인증번호 받기" onclick="certi()"><br>
			<label>인증번호</label><input type="text" placeholder="인증번호 입력하세요" name="certi">
			<span name="err" id="err_phone"></span>
		</div>
			<input type="button" value="인증" onclick="certi_check()">
	</form>
</div>
</body>
</html>