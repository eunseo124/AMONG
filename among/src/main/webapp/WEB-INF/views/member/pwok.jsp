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
            	<form method = "post" action = "member/memupdate_proc">
            		<div class = "login5">
            			<h1>비밀번호 변경</h1>
            			<input type = "hidden" name="memId" id = "memId" value = "${memberp.memId}">
            			<input type = "hidden" name="memEmail1" id = "memEmail1" value = "${memberp.memEmail1}">
            			<input type = "hidden" name="memEmail2" id = "memEmail2" value = "${memberp.memEmail2}">
            			<input type = "hidden" name="memName" id = "memName" value = "${memberp.memName}">
            			<input type = "hidden" name="memResident1" id = "memResident1" value = "${memberp.memResident1}">
            			<input type = "hidden" name="memResident2" id = "memResident2" value = "${memberp.memResident2}">
            			<input type = "hidden" name="memGrade" id = "memGrade" value = "${memberp.memGrade}">
            			<input type = "hidden" name = "nName" id = "nName" value = "${memberp.nName}">
            			<input type = "hidden" name = "memKey"  id = "memKey" value = "${memberp.memKey}">
            				<label>비밀번호</label>
            				<input type = "password" oninput="handleOnInput(this)" placeholder="영어,숫자,특수문자(~,!,.,/)를 조합해서 쓰시오" name = "memPw" id = "memPw">
            				<label>비밀번호 확인</label>
            				<input type = "password" onkeyup ="pwdch()" name = "memPw2" id = "memPw2">
            				<div><span id="msg" style="font-size:12px;"></span></div>
            				<button>수정완료</button>
            				
            		</div>
            		</form>
            	</section>
            </article> 
    </main>
<!-- 푸터 -->
    <footer id = "footer">
    	<%@include file="../base/footer.jsp"%>
  </footer>
    </div>
</body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
		//영어,숫자,특수문자(~!./)
		function handleOnInput(e)  {
	  		e.value = e.value.replace(/[^A-Za-z0-9~!./]/ig, '')
		}
		
		
		
  		function pwdch(){
  		var memPw = document.getElementById("memPw");
  		var memPw2 = document.getElementById("memPw2");
  		var msg = document.getElementById("msg");
  		if(memPw.value == memPw2.value && memPw.value != '' && memPw2.value != ''){
  			msg.style.color = "green";
  			msg.innerHTML = "비밀번호 일치";
  		}else {
  			msg.style.color = "red";
  			msg.innerHTML = "비밀번호 불일치";
  		}
  		}
</script>
</html>