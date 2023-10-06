<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="kor">

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
        <header>
            <a href="<c:url value="/home" />" class="logo">
                    <h1>AM<img src="resources/images/profile.png" id="timg" style="width: 80px;height: 70px; position: relative;top: 6px;">NG</h1>
                </a>
    </header>
    <main class= "memjoin">

        <!-- 본문내용 -->
            <article>
                <section>   
                                <div class="login3">
                                    <h1>회원가입</h1>
                                    <form name = "loginfrm" method = "post" action = "memjoin/memjoin_proc">
                                    <legend>아이디</legend>
                                    <label>
                                        <input type="text" value="" name="memId" id="memId" placeholder="아이디를 입력하시오" class="Mid">
                                        <input type="button" value="아이디 중복검사" class="idbtn"><a href="<c:url value="/checkid" />"></a></input>
                                    </label>
                                    <legend>비밀번호</legend>
                                    <label>
                                        <input type="password" name="memPw" id="memPw" value="" name="password" placeholder="비밀번호 입력하시오">
                                    </label>
                                    <legend>비밀번호 확인</legend>
                                    <label>
                                        <input type="password" value="" name="password" placeholder="비밀번호 입력하시오">
                                    </label>
                                    <legend>닉네임</legend>
                                    <label>
                                        <input type="text" value="" name="nName" id="nName" placeholder="닉네임을 입력하시오" class="Mid">
                                        
                                        <input type="button" value="닉네임 중복검사" class="idbtn"><a href="<c:url value="/checknik" />"></a></input>
                                    </label>
                                    <legend>이메일</legend>
                                    <label style="display: flex;align-items: center;">
                                        <input type="text" value="" name="memEmail1" id="memEmail1" style="width: 100%;"> @ 
                                            <input type="text" value="" name="memEmail2" id="memEmail2" style="width: 100%;">
                                            <select id = "email3" name = "email2" style="width: 100%;margin-left: 1px; height: 50px;margin-top: 7px;border-radius: 7px;border: 1px solid gray;">
											  <option value="naver.com">naver.com</option>
											  <option value="google.com">google.com</option>
											  <option value="hanmail.net">hanmail.net</option>
											  <option value="nate.com">nate.com</option>
											  <option value="kakao.com">kakao.com</option>
											  <option value="">직접입력</option>
										 	</select>
                            			<input type="button" value="인증번호 받기" class="idbtn">	
                                    </label>
                                    <legend>이름</legend>
                                    <label>
                                        <input type="text" value="" id = "memName" name = "memName" placeholder="이름을 입력하시오">
                                    </label>
                                    <legend>주민번호</legend>
                                    <label style="display: flex;align-items: center;">
                                        <input type="text" value="" name="memResident1" id="memResident1" style="width: 280px;">-<input
                                            type="password" value="" name="memResident2" id="memResident2" style="width: 280px;margin-left: 1px;">
                                    </label>
                                    <div class="cidbtn">
                                    <input type="submit" value="회원가입" class="cid">
                                    </div>
                                </form>
                                </div>
						
                </section>

            </article>
    </main>
    <footer id = "footer">
    	<%@include file="../base/footer.jsp" %>
  </footer>
    </div>
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

  	
		$( "#email3" ).change(function(){
		    $("#memEmail2").val( $("#email3").val() );
		});
</script>

</html>
