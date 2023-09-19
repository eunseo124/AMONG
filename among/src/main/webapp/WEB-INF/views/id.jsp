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
                    <h1>AMONG</h1>
                </a>
    </header>
    <main>
        <!-- 본문내용 -->
            <article>
            	<section>
            		<div class = "login4">
            			<h1>아이디 찾기</h1>
            				<label>이름</label>
            				<input type = "text" name = "name" value = "" placeholder = "이름을 입력해주세요">
            				<legend>이메일</legend>
            				<label>
            				<input type="text" value="" name="email1" style="width: 202px;"> @ <input
                                            type="text" name="email2" value="" style="width: 202px; margin-left: 1px;">
                            <input type="button" value="인증번호 받기" class="idbtn">
                            <input type = "text" value = "" name="idnumber" placeholder = "인증번호를 입력해주세요"> 
                            </label>
            				<br>
            				<button>완료</button>
            				
            		</div>
            	</section>
            </article> 
    </main>
<!-- 푸터 -->
    <footer id = "footer">
    	<%@include file="base/footer.jsp"%>
  </footer>
    </div>
</body>

</html>