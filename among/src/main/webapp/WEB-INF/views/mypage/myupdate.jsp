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
	            		<h1>${memu.nName}님</h1>
		            	<p>${memu.memEmail1}@${memu.memEmail2}</p>
	            	</div>
            </section>
    </header>
    <main>
        <!-- 본문내용 -->
            <article id="widget">
            	<section class = "flex">
            		<div class = "pheader">
            		<div><h4><a href="mypage?memKey=${memu.memKey}">내 프로필</a></h4></div>
            		<div><h4><a href="mypost?memKey=${memu.memKey}">게시글 관리</a></h4></div>
            		<div><h4><a href="myreply?memKey=${memu.memKey}">댓글 관리</a></h4></div>
            		</div>
            		<div class = "pmypage1">
            			<h1>프로필 수정</h1>
            				<div class = "pmypage2">
            						<form method = "post" action="mypage/memupdate_proc" name = "memupdate_proc">
            						<input type = "hidden" value = "${memu.memKey}" name = "memKey" id = "memKey">
            						<input type = "hidden" value = "${memu.memGrade}" name = "memGrade" id = "memGrade">
            						<input type = "hidden" value = "${memu.memJoinDate}" name = "memJoinDate" id = "memJoinDate">
            						<input type = "hidden" value = "${memu.delYn}" name = "delYn" id = "delYn">
            						<input type = "hidden" value = "${memu.memId}" name = "memId" id = "memId">
            						<input type = "hidden" value = "${memu.memName}" name = "memName" id = "memName">
                                    <div class = "pro1">
                                    <p>아이디</p>
                                    <div class = "pro2">
                                    <p>${memu.memId}</p>
                                    </div>
                                    </div>
                                    <div class = "pro1">
                                    <p>비밀번호</p>
                                    <div class = "pro2">
                                        <input type="password" value="${memu.memPw}" name="memPw" id = "memPw" placeholder="비밀번호 입력하시오" oninput="handleOnInput(this)">
                                    </div>
                                    </div>
                                    <div class = "pro1">
                                    <p>비밀번호 확인</p>
                                    <div class = "pro2">
                                        <input type="password" value="${memu.memPw}" name="memPw2" onkeyup ="pwdch()" placeholder="비밀번호 입력하시오"id = "memPw2" oninput="handleOnInput(this)">
                                        
                                    </div>
                                    </div>
                                    <div class = "pro1">
                                    <span id="msg" style="font-size:12px;"></span>
                                    </div>
                                    <div class = "pro1">
                                    <p>닉네임</p>
                                    <div class = "pro2">
                                        <input type="text" value="${memu.nName}" name="nName" id = "nName" placeholder="닉네임을 입력하시오" style="width: 441px;">
                                        <input type="button" value="닉네임 중복검사" class="pro3"id ="checknName">
                                        
                                    </div>
                                    </div>
                                    <div class = "pro1">
                                    <p></p>
                                    	<div class = "pro2">
                                    		<span id="result_checknName" style="font-size:12px;"></span>
                                    		</div>
                                    	</div>
                                    <div class = "pro1">
                                    <p>이메일</p>
                                    	<div class = "pro2">
                                        <input type="text" value="${memu.memEmail1}" name="memEmail1" style="width: 142px;" id = "memEmail1"oninput="handleOnInput(this)"> @ 
                                            <input id = "memEmail2" type="text" value="${memu.memEmail2}" name="memEmail2" style="width: 142px;"oninput="handleOnInput(this)">
                                            <select id = "email3" name = "email3" style="width: 140px;margin-left: 1px; height: 50px;margin-top: 7px;border-radius: 7px;border: 1px solid gray;">
											  <option value="">직접입력</option>
											  <option value="naver.com">naver.com</option>
											  <option value="google.com">google.com</option>
											  <option value="hanmail.net">hanmail.net</option>
											  <option value="nate.com">nate.com</option>
											  <option value="kakao.com">kakao.com</option>
										 	</select>
                                    	</div>
                                    </div>
                                    <div class = "pro1">
                                    <p>이름</p>
                                    	<div class = "pro2">
                                        <p>${memu.memName}</p>
                                     	</div>
                                     </div>
                                    <div class = "pro1">
                                    <p>주민번호</p>
                                    	<div class = "pro2">
                                        <p>${memu.memResident1} - ${memu.memResident2}</p>
                                    	</div>
                                    </div>
                                    <div class="pro2">
                                    <input type="submit" onclick="sub()" value="수정완료" class="pro3" style = "margin-left:348px;margin-top:24px;">
                                    </div>
                                    </form>
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
		    $("#memEmail2").val( $("#email3").val() );
		});
		//영어,숫자,특수문자(~!./)
		function handleOnInput(e)  {
	  		e.value = e.value.replace(/[^A-Za-z0-9~!./]/ig, '')
		}
		
		//숫자
		function handleInput(e)  {
	  		e.value = e.value.replace(/[^0-9]/ig, '')
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
  		
		$( "#email3" ).change(function(){
		    $("#memEmail2").val( $("#email3").val() );
		});
		
		//id 중복체크
		$(function(){
		    $("#checkId").click(function(){
		    
		        let memId = $("#memId").val();
		        //id 빈값입력 방지
		        if(memId != ''){
		        $.ajax({
		            type:'post', //post 형식으로 controller 에 보내기위함!!
		            url:"<c:url value='/member/checkId'/>" , // 컨트롤러로 가는 mapping 입력
		            data: {"memId":memId}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
		            success: function(data){ 
		                if(data == 0){ // 만약 성공할시
		                	console.log(data);
		                    result = "사용 가능한 아이디입니다.";
		                    $("#result_checkId").html(result).css("color", "green");
		                    $("#memPw").trigger("focus");
		                 
		             }else if(data == 1){ // 만약 실패할시
		                 result="이미 사용중인 아이디입니다.";
		                     $("#result_checkId").html(result).css("color","red");
		                     $("#memId").val("").trigger("focus");
		             }
		                 console.log(result);
		         },
		            error : function(error){alert("false");}
		        });
		        
		    }else if(memId == ''){
			alert("아이디를 입력해주세요!");
		}; 
		});
		});
		
		//nName 중복체크
		$(function(){
		    $("#checknName").click(function(){
		    
		        let nName = $("#nName").val();
		        //nName 빈값입력 방지
		        if(nName != ''){
		        $.ajax({
		            type:'post', //post 형식으로 controller 에 보내기위함!!
		            url:"<c:url value='/member/checknName'/>" , // 컨트롤러로 가는 mapping 입력
		            data: {"nName":nName}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
		            success: function(data){ 
		                if(data == 0){ // 만약 성공할시
		                	console.log(data);
		                    result = "사용 가능한 닉네임입니다.";
		                    $("#result_checknName").html(result).css("color", "green");
		                    $("#memEmail1").trigger("focus");
		                 
		             }else if(data == 1){ // 만약 실패할시
		                 result="이미 사용중인 닉네임입니다.";
		                	 $("#result_checknName").html(result).css("color","red");
		                     $("#nName").val("").trigger("focus");
		             }
		                 console.log(result);
		         },
		            error : function(error){alert("false");}
		        });
		        
		    }else if(nName == ''){
			alert("닉네임을 입력해주세요!");
		}; 
		});
		});
		function as() {
			window.location.href="<c:url value='/member/memjoin_false'/>" 
			alert("공백없이 입력해주세요");
		}
</script>
</html>