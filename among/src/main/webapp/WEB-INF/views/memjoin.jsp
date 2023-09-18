<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/base.css"/>" rel="stylesheet">
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
            <%@include file = "base/header.jsp" %>
    </header>
    <main>
        <aside>
            <%@include file = "base/aside.jsp" %>
        </aside>
        <!-- 본문내용 -->
            <article id="index ">
                <section id="widget">
                    <div class="container">
                        <div class="flex">
                            <div class="Mmerge">
                                <div class="mjoin">
                                    <h1>회원가입</h1>
                                    <legend>아이디</legend>
                                    <label>
                                        <input type="text" value="" name="id" placeholder="아이디를 입력하시오" class="Mid">
                                        <input type="button" value="아이디 중복검사" class="idbtn">
                                    </label>
                                    <legend>비밀번호</legend>
                                    <label>
                                        <input type="password" value="" name="password" placeholder="비밀번호 입력하시오">
                                    </label>
                                    <legend>비밀번호 확인</legend>
                                    <label>
                                        <input type="password" value="" name="password" placeholder="비밀번호 입력하시오">
                                    </label>
                                    <legend>닉네임</legend>
                                    <label>
                                        <input type="text" value="" name="id" placeholder="닉네임을 입력하시오">
                                    </label>
                                    <legend>이메일</legend>
                                    <label style="display: flex;">
                                        <input type="text" value="" name="email1" style="width: 267px;"> @ <input
                                            type="text" name="email2" value="" style="width: 267px; margin-left: 1px;">
                                    </label>
                                    <legend>이름</legend>
                                    <label>
                                        <input type="text" value="" name="Name" placeholder="이름을 입력하시오">
                                    </label>
                                    <legend>주민번호</legend>
                                    <label style="display: flex;">
                                        <input type="text" value="" name="id" style="width: 271px;">-<input
                                            type="password" value="" style="width: 271px;margin-left: 1px;">
                                    </label>
                                    <input type="submit" value="회원가입" class="cid">
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </article>
    </main>
    <footer id = "footer">
    	<%@include file="base/footer.jsp" %>
  </footer>
    </div>
</body>

</html>