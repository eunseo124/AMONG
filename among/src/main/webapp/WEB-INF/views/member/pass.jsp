<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/login.css"/>" rel="stylesheet">
<link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <style>
        aside {
            width: 340px;
            display: flex;
            flex-direction: column;
            box-sizing: border-box;
            
        }

        .userContainer {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .inputsAndButtons {
            display: flex;
            flex-direction: column;
            gap: 10px;
            border-radius: 10%;
        }

        input {
            width: 100%;
            height: 50px;
            padding-left: 15px;
            padding-right: 15px;
            background-color: #fff;
            border: unset;
            border-radius: 8px;
        }

        /*login*/
        aside .joinAndFindPassword {
            display: flex;
            justify-content: space-between;
            
        }
        aside .joinAndFindPassword a {
            color: black;
        }

	.material-symbols-outlined {
            font-variation-settings:
                'FILL' 0,
                'wght' 400,
                'GRAD' 0,
                'opsz' 24
        }
    </style>
    <title>AMONG</title>
</head>

<body>
    <div class="container">
<!-- 헤더  -->     
<header>
            	<a href="<c:url value="/home" />" class="logo">
                    <h1>AM<img src="resources/images/profile.png" id="timg" style="width: 80px;height: 70px; position: relative;top: 6px;">NG</h1>
                </a>
    </header>
    <main>
        <!-- 본문내용 -->
            <article>
            	<section>
            		<div class = "login5">
            			<h1>비밀번호 찾기</h1>
            				<label>아이디</label>
            				<input type = "text" name = "memId" id = "memId" value = "" placeholder = "아이디를 입력해주세요">
            				<label>이름</label>
            				<input type = "text" name = "memName" id = "memName" value = "" placeholder = "이름을 입력해주세요">
            				<legend>이메일</legend>
            				<label>
            				<input type="text" value="" name="memEmail1" id = "memEmail1" style="width: 134px;"> @ 
                                            <input id = "memEmail2" type="text" value="" name="memEmail2" style="width: 134px;">
                                            <select id = "email3" name = "email3" style="width: 133px;margin-left: 1px; height: 50px;margin-top: 7px;border-radius: 7px;border: 1px solid gray;">
											  <option value="naver.com">naver.com</option>
											  <option value="google.com">google.com</option>
											  <option value="hanmail.net">hanmail.net</option>
											  <option value="nate.com">nate.com</option>
											  <option value="kakao.com">kakao.com</option>
											  <option value="">직접입력</option>
										 	</select>
										 	<input type="button" value="인증번호 받기" class="idbtn">	
                            <input type = "text" value = "" name="idnumber" placeholder = "인증번호를 입력해주세요"> 
                            </label>
            				<br>
            				<button type = "submit" id = "su">완료</button>
            				
            		</div>
            	</section>
            </article> 
    </main>
<!-- 푸터 -->
    <footer id = "footer">
    	<%@include file="../base/footer.jsp"%>
  </footer>
    </div>
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

  	
$( "#email3" ).change(function(){
    $("#memEmail2").val( $("#email3").val() );
});

//id 중복체크
$(function(){
    $("#su").click(function(){
    
    	let memId = $("#memId").val();
        let memName = $("#memName").val();
        let memEmail1 = $("#memEmail1").val();
        let memEmail2 = $("#memEmail2").val();
        //id 빈값입력 방지
        if(memName != '' && memEmail != '' && memEmail2 != ''){
        $.ajax({
            type:'post', //post 형식으로 controller 에 보내기위함!!
            url:"<c:url value='/member/pwfind'/>" , // 컨트롤러로 가는 mapping 입력
            data: {"memId":memId,"memName":memName, "memEmail1":memEmail1, "memEmail2":memEmail2}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
            success: function(data){ 
                if(data == 0){ // 만약 성공할시
                	alert("비밀번호는 " + memPw + "입니다.")
                 
             }else if(data == 1){ // 만약 실패할시
            	 alert("비밀번호가 존재하지 않습니다!")
             }
                 console.log(result);
         },
            error : function(error){alert("false");}
        });
        
    }else if(memName == ''){
	alert("이름을 입력해주세요!");
}else if(memId == ''){
	alert("아이디를 입력해주세요!");
}else if(memEmail1 == '' && memEmail2 == ''){
	alert("이메일을 입력해주세요!");
}; 
});
});
</script>
</html>