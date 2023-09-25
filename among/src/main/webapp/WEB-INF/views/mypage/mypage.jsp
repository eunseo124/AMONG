<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/mypage.css"/>" rel="stylesheet">
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
          <section id="main">
                <a href="<c:url value="/home" />" class="logo" style="text-decoration: none;">
             		<h1>AM<img src="resources/images/profile.png" id="timg" style="width: 80px;height: 70px; position: relative;top: 6px;">NG</h1>

                </a>
            </section>
            <section class = "mypage1">
            		<div class = "mypage2">
            			<img src="resources/images/profile.png" class = "pimg">
            		</div>
            		<div class = "mypage3">
	            		<h1>test님</h1>
		            	<p>test123@naver.com</p>
	            	</div>
            </section>
    </header>
    <main>
        <!-- 본문내용 -->
            <article id="widget">
            	<section class = "flex">
            		<div class = "pheader">
            		<div><h4><a href="<c:url value="/mypage" />">프로필 수정</a></h4></div>
            		<div><h4><a href="<c:url value="/mypost" />">게시글 관리</a></h4></div>
            		<div><h4><a href="<c:url value="/mypost2" />">댓글 관리</a></h4></div>
            		</div>
            		<div class = "pmypage1">
            			<h1>내 프로필</h1>
            				<div class = "pmypage2">
            						<c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                    <p>아이디</p>
                                    <div class = "pro2">
                                    <input type="text" value="${list.memId}" name="id" placeholder="아이디를 입력하시오" style="width: 441px;">
                                    <input type="button" value="아이디 중복검사" class="pro3">
                                    <a href="<c:url value="/checkid" />"></a>
                                    </input>
                                    </div>
                                    </div>
                                    </c:forEach>
                                    <c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                    <p>비밀번호</p>
                                    <div class = "pro2">
                                        <input type="password" value="${list.memPw}" name="password" placeholder="비밀번호 입력하시오">
                                    </div>
                                    </div>
                                    </c:forEach>
                                    <c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                    <p>비밀번호 확인</p>
                                    <div class = "pro2">
                                        <input type="password" value="${list.memPw}" name="password" placeholder="비밀번호 입력하시오">
                                    </div>
                                    </div>
                                    </c:forEach>
                                    <c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                    <p>닉네임</p>
                                    <div class = "pro2">
                                        <input type="text" value="${list.nName}" name="id" placeholder="닉네임을 입력하시오" style="width: 441px;">
                                        <input type="button" value="닉네임 중복검사" class="pro3"><a href="<c:url value="/checknik" />"></a></input>
                                    </div>
                                    </div>
                                    </c:forEach>
                                    <c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                    <p>이메일</p>
                                    	<div class = "pro2">
                                        <input type="text" value="${list.memEmail1}" name="email1" style="width: 142px;"> @ 
                                            <input id = "email2" type="text" value="${list.memEmail2}" name="email2" style="width: 142px;">
                                            <select id = "email3" name = "email2" style="width: 140px;margin-left: 1px; height: 50px;margin-top: 7px;border-radius: 7px;border: 1px solid gray;">
											  <option value="naver.com">naver.com</option>
											  <option value="google.com">google.com</option>
											  <option value="hanmail.net">hanmail.net</option>
											  <option value="nate.com">nate.com</option>
											  <option value="kakao.com">kakao.com</option>
											  <option value="">직접입력</option>
										 	</select>
                                            <input type="button" value="이메일 인증" class="pro3">
                                    	</div>
                                    </div>
                                    </c:forEach>
                                    <c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                   		<p style="margin-top:44px;"></p>
                                    	<div class = "pro2">
                                    		<input type="text" value="" name="emailcheck" placeholder="인증번호를 입력하시오">
                                    	</div>
                                    </div>
                                    </c:forEach>
                                    <c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                    <p>이름</p>
                                    	<div class = "pro2">
                                        <input type="text" value="${list.memName}" name="Name" placeholder="이름을 입력하시오">
                                     	</div>
                                     </div>
                                     </c:forEach>
                                     <c:forEach items="${memberlist}" var="list">
                                    <div class = "pro1">
                                    <p>주민번호</p>
                                    	<div class = "pro2">
                                        <input type="text" value="${list.memResident1}" name="id" style="width: 280px;">-<input
                                            type="password" value="${list.memResident2}" style="width: 280px;margin-left: 1px;">
                                    	</div>
                                    </div>
                                    </c:forEach>
                                    <div class="pro2">
                                    <input type="submit" value="수정완료" class="pro3" style = "margin-left:348px;margin-top:24px;">
                                    </div>
                                  </div>
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
		    $("#email2").val( $("#email3").val() );
		});
</script>
</html>