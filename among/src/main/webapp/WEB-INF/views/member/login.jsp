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
            		<div class = "login1">
            		<form name = "loginfrm" method = "post" action = "login/login_proc">
            			<h1>로그인</h1>
            				<label>아이디</label>
            				<input type = "text" id = "memId" name = "memId" value = "" placeholder = "아이디를 입력해주세요">
            				<%System.out.println("memId dfd"); %>
            				<label>비밀번호</label>
            				<input type = "password" id = "memPw" name = "memPw" value = "" placeholder = "비밀번호를 입력해주세요">
            				<br>
            				<button type = "submit" >로그인</button>
            				<div class = "login2">
            				<p><a href="<c:url value="/id" />">아이디 찾기</a></p>
            				<p>|</p>
            				<p><a href="<c:url value="/pass" />">비밀번호 찾기</a></p>
            				<p>|</p>
            				<p><a href="<c:url value="/memjoin" />">회원가입</a></p>
            				</div>
            				</form>
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

</html>