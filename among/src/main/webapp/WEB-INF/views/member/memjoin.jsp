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
                                    <form name = "loginfrm" method = "post" action = "memjoin/memjoin_proc" onsubmit = "return as()" >
                                    <legend>아이디</legend>
                                    <label>
                                        <input type="text" value="" name="memId" id="memId" placeholder="영어,숫자로 조합해서 아이디를 생성하시오" class="Mid" oninput="handleOnInput(this)" >
                                        <input type="button" value="아이디 중복검사" id ="checkId"  class="idbtn"></input>
                                        <div><span id="result_checkId" style="font-size:12px;"></span></div>
                                    </label>
                                    <legend>비밀번호</legend>
                                    <label>
                                        <input type="password"  name="memPw" id="memPw" value="" name="password" placeholder="영어,숫자,특수문자(~,!,.,/)를 조합해서 쓰시오" oninput="handleOnInput(this)" >
                                    </label>
                                    <legend>비밀번호 확인</legend>
                                    <label>
                                        <input type="password" onkeyup ="pwdch()" value="" id="memPw2" name="password" placeholder="비밀번호 입력하시오" >
                                        <div><span id="msg" style="font-size:12px;"></span></div>
                                    </label>
                                    <legend>닉네임</legend>
                                    <label>
                                        <input type="text" value="" name="nName" id="nName" placeholder="닉네임을 입력하시오" class="Mid">
                                        <input type="button" value="닉네임 중복검사" class="idbtn" id ="checknName" >
                                        <div><span id="result_checknName" style="font-size:12px;"></span></div>
                                    </label>
                                    <legend>이메일</legend>
                                    <label style="display: flex;align-items: center;">
                                        <input type="text" value="" name="memEmail1" id="memEmail1" style="width: 100%;" oninput="handleOnInput(this)"> @ 
                                            <input type="text" value="" name="memEmail2" id="memEmail2" style="width: 100%;" oninput="handleOnInput(this)">
                                            <select id = "email3" name = "email2" style="width: 100%;margin-left: 1px; height: 50px;margin-top: 7px;border-radius: 7px;border: 1px solid gray;">
											  <option value="naver.com">naver.com</option>
											  <option value="google.com">google.com</option>
											  <option value="hanmail.net">hanmail.net</option>
											  <option value="nate.com">nate.com</option>
											  <option value="kakao.com">kakao.com</option>
											  <option value="">직접입력</option>
										 	</select>
                                    </label>
                                   
                                    <legend>이름</legend>
                                    <label>
                                        <input type="text" value="" id = "memName" name = "memName" placeholder="이름을 입력하시오">
                                    </label>
                                    <legend>주민번호</legend>
                                    <label style="display: flex;align-items: center;">
                                        <input type="text" value="" name="memResident1" id="memResident1"  style="width: 280px;" maxlength='6'oninput="handleInput(this)">-
                                        <input type="password" value="" name="memResident2" id="memResident2" style="width: 280px;margin-left: 1px;" maxlength='7'oninput="handleInput(this)">
                                    </label>
                                    <div class="cidbtn">
                                    <input type="submit" value="회원가입" class="cid" id = "joinCheck" onclick="sub()">
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
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
		
</script>

</html>
