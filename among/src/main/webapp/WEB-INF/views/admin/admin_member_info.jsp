<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/admin.css"/>" rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <style>
    	@import url('https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css');


/* 사이드바  css*/

        aside {
            width: 340px;
            display: flex;
            height: 800px;
            flex-direction: column;
            box-sizing: border-box;
            background: #5D5D5D;
            padding: 0;
        	margin: 0;
        	box-sizing: border-box;
        	float: left;
        	font-color: #FFFFFF;
        	border-radius: 10px;      
        }
               
        aside h1 span {
        	font-size: 30px;
        	margin-left: 6px;
        	color: white;
        }
        
        aside ul {
        	padding: 5px 0 5px 30px;
        } 
		
		aside ul li {
			list-style: none;
			font-weight: bold;
			margin: 20px auto;
			position: relative;
			overflow: hidden;
			max-height: 35px;
			line-height: 35px;
			transition: 1s;
			text-transform: capitalize;
		}
		
		aside ul: first-child li{
			max-height: 50px;
		}

		aside ul li: hover {
			background: #d1d1d173;
		}
		
		aside ul: first-child li: hover {
			background: none;
		}		
		
		aside ul li a{
			text-decoration: none;
			color: whitesmoke;
		}
		
		aside ul li a i{
			width: 30px;
			padding: 5px;
			margin-right: 10px;
		}
		
		aside ul li a i.fa-angle-right{
			position: absoulute;
			right: 0;
			top: 5px;
			transition: 0.5s;
		}		
		
		aside ul li>ul {
			padding: 1px;
			margin: 0 0 0 20px;
		}
		
		aside ul li>ul li a {
			height: 25px;
			line-height: 20px;
			font-size: 15px;
			padding: 1px 1px 1px 20px;
			font-weight: normal;
			border-left: 1px solid #fff0f0;
			margin: 5px;
			color: #fff0f0;
			cursor: pointer;
		}
		
		aside ul li>ul li a,
		aside ul li:target>ul li a {
			background: transparent;
			color: white;
		}
		
		aside ul li:target {
			max-height: 300px;
			border-radius: 5px 0px 0px 5px;
		}		
		
		aside ul li:target a {
			color: #444;
			display: inherit;
			background: white;
		}
		
		aside ul li:target:hover {
			background: initial;
		}
		
		
		.wrap {
		    width: 700px;
		    height: 600px;
		    margin: 0 auto;
		    padding: 50px;
		    box-sizing: border-box;
		    background: #fff;
		}
		
		.wrap h1 {
		    padding-bottom: 12px;
		    border-bottom: 3px solid #000;
		    font-size: 32px;
		    letter-spacing: -2px;
		}
		
		.wrap form {
		    margin-top: 30px;
		}
		
		.wrap dl {
		    margin-top: 10px;
		    font-size: 0;
		}
		
		.wrap dl:first-child {
		    margin-top: 0;
		}
		
		.wrap dt,
		.wrap dd {
		    display: inline-block;
		    vertical-align: middle;
		    font-size: 14px;
		    margin: 10px auto 0 auto;
		}
		
		.wrap dt {
		    width: 30%;
		}
		
		.wrap dd {
		    width: 70%;
		}
		
		.wrap input[type="text"],
		.wrap input[type="password"],
		.wrap input[type="tel"],
		.wrap input[type="email"],
		.wrap select {
		    padding: 10px;
		    border: 1px solid #ccc;
		    border-radius: 2px;
		}
			
		.wrap input[type="submit"], input[type="button"] {
		    display: inline-block;
		    margin: 30px auto 0 auto;
		    padding: 16px 50px;
		    border: 0;
		    border-radius: 100px;
		    background: #325cb2;
		    font-weight: 600;
		    color: #fff;
		    cursor: pointer;

		}
		
		.wrap #box {
			text-align: center;
		}


    </style>
    <title>AMONG</title>
</head>

<body>
    <div class="container">
<!-- 헤더  -->     
<header>
            <%@include file="../base/header.jsp"%>
    </header>
    <main>
<!-- 사이드 -->
        <aside>
			<ul>
				<li><h1><span>관리자 페이지</span></h1>
			</ul>
			<ul>
				<li id="adminMember">
					<a href ="#adminMember">
					<span>계정관리</span>
					<i class="fa fa-angle-right"></i>
					</a>
					
					<ul>
						<li><a href="<c:url value="/admin_member" />">회원</a></li>
					</ul>
				</li>
			</ul>
			<ul>
				<li id="adminBoard">
					<a href="#adminBoard">
					<span>게시판관리</span>
					<i class="fa fa-angle-right"></i>
					</a>
					
					<ul>
						<li><a href="<c:url value="/adminfreeboard" />">자유게시판</a></li>
						<li><a href="<c:url value="/admingameboard" />">게임게시판</a></li>
						<li><a href="<c:url value="/adminfoodboard" />">맛집게시판</a></li>
						<li><a href="<c:url value="/admintravelboard" />">여행게시판</a></li>					
					</ul>
				</li>			
			</ul>
			<ul>
				<li id="adminComment">
					<a href ="#adminComment">
					<span>댓글관리</span>
					<i class="fa fa-angle-right"></i>
					</a>
					
					<ul>
						<li><a href="<c:url value="/admin_comment" />">댓글</a></li>
					</ul>
				</li>
			</ul>				
        </aside>
        <!-- 본문내용 -->
        <article id = "postList">
        	<section id = "postList">
        		<div id = "title"><h1>계정관리</h1></div>
        		 <div id ="info">
			        <div class="wrap">
			            <h1>회원정보</h1>		             
			            <form action="./update" method="post">
			                <dl>
			                    <dt>아이디</dt>
			                    <dd><input type="text" id="memId" name="memId" placeholder="아이디 입력" readonly="readonly" value="${member.memId}"></dd>
			                </dl>
			                <dl>
			                    <dt>비밀번호</dt>
			                    <dd><input type="password" id="memPw" name="memPw" placeholder="비밀번호 입력" value="${member.memPw}"></dd>
			                </dl>
			                <dl>
			                    <dt>비밀번호 확인</dt>
			                    <dd><input type="password" placeholder="비밀번호 재입력" value="${member.memPw}"></dd>
			                </dl>
			                <dl>
			                    <dt>닉네임</dt>
			                    <dd><input type="text" id="nName" name="nName" placeholder="이름 입력" value="${member.nName}"></dd>
			                </dl>                  
			                <dl>
			                    <dt>이메일</dt>
			                    <dd>
			                        <input type="text" id="email1" name="memEmail1" placeholder="이메일 입력" value="${member.memEmail1}" style="width: 120px;"> @
                                    <input type="text" id="email2" name="memEmail2"  value="${member.memEmail2}" style="width: 120px;">			                        
                                    <select id="email3" name="email2" style="width: 120px;">
									  <option value="naver.com">naver.com</option>
			  		   				  <option value="google.com">google.com</option>
									  <option value="hanmail.net">hanmail.net</option>
									  <option value="nate.com">nate.com</option>
									  <option value="kakao.com">kakao.com</option>
									  <option value="">직접입력</option>									  
			                        </select>
			                    </dd>
			                </dl>                
			                <dl>
			                    <dt>이름</dt>
			                    <dd><input type="text" id="memName" name="memName" placeholder="이름 입력" readonly="readonly" value="${member.memName}"></dd>
			                </dl>
			                <dl>
			                    <dt>주민번호</dt>
			                    <dd><input type="text" id="memResident1" name="memResident1" placeholder="이름 입력" readonly="readonly" value="${member.memResident1}">-
			             	        <input type="text" id="memResident2" name="memResident2" placeholder="이름 입력" readonly="readonly" value="${member.memResident2}">
			                    </dd>
			                </dl>
			                <dl>
			                    <dt>가입일시</dt>
			                    <dd><input type="text" id="memJoinDate" name="memJoinDate" placeholder="이름 입력" readonly="readonly" value="${member.memJoinDate}"></dd>
			                </dl>
			                <dl>
			                    <dt>삭제여부</dt>
			                    <dd><input name="delYn" type="radio" value="Y"></input>Y</dd>
			                    <dd><input name="delYn" type="radio" value="N"></input>N</dd>		                    		                    
			                </dl>				                		
			                <br>
			                <div id="box">
			                <input type="hidden" id="memGrade" name="memGrade" value="${member.memGrade}">
			                <input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
			                <input type="button" value="뒤로" onclick="history.go(-1)">
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
		    $("#email2").val( $("#email3").val() );
		});
</script>
</html>