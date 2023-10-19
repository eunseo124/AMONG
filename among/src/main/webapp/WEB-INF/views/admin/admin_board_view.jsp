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
		    width: 1000px;
		    height: 800px;
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
		
		.board_view {
		border-top: 2px solid #000;
		}
		
		.board_view .board_title {
		padding: 20px 15px;
		border-bottom: 1px dashed #ddd;
		font-size: 2rem;
		}
		
		.board_view .board_info {
		padding: 15px;
		border-bottom: 1px solid #999;
		}
		
		.board_view .board_info dl{
		display: inline-block;
		padding: 5px 20px;
		position: relative;
		}
		
		.board_view .board_info dl:first-child{
		padding-left: 0;
		}		

		.board_view .board_info dl::before{
		content: "";
		position: absolute;
		top: 1px;
		left: 0;
		display: block;
		width: 1px;
		height: 13px;
		background: #ddd;
		}
			
		.board_view .board_info dl:first-child::before{	
		display: none;
		}	
		
		.board_view .board_info dl dt,
		.board_view .board_info dl dd {
		display: inline-block;		
		}
		
		.board_view .board_info dl dt {
			
		}
		
		.board_view .board_info dl dd {
		margin-left: 10px;
		color: #777;	
		}
		
		.board_view .board_cont{
		padding: 15px;
		border-bottom: 1px solid #ddd;
		line-height: 160%;
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
        		<div id = "title"><h1>게시판 관리</h1></div>
        		 <div class ="wrap">
        		  <h1>게시판 상세 정보</h1>
        		  <form action="./update_board" method="post">		   
        		  <div class = "board_view">
        		   <div class = "board_title">
					<input name="boardTitle" type="text" value="${board.boardTitle}">
        		   </div>
        		   <div class="board_info">
        		   <c:set var = "boardCategory" value = "${board.boardCategory}"/>
        		   <dl>
	        		   <dt>카테고리</dt>
	        		   <dd>
	        		   <c:choose>
		              	<c:when test = "${boardCategory eq '1'}"><%out.print("자유게시판"); %></c:when>
						<c:when test = "${boardCategory eq '2'}"><%out.print("게임게시판"); %></c:when>
						<c:when test = "${boardCategory eq '3'}"><%out.print("맛집게시판"); %></c:when>
						<c:when test = "${boardCategory eq '4'}"><%out.print("여행게시판"); %></c:when>
                       </c:choose>
	        		   </dd>
        		   </dl>
        		   <dl>
	        		   <dt>작성자</dt>
	        		   <dd>${board.nName}</dd>
        		   </dl>
        		   <dl>
	        		   <dt>추천수</dt>
	        		   <dd>${board.boardRecommend}</dd>
        		   </dl>
        		   
			       <dl>
			           <dt>삭제여부</dt>
			           <dd><input id="delYn" name="delYn" type="radio" value="Y" <c:if test="${board.delYn eq 'Y'}">checked</c:if>></input> Y &nbsp;&nbsp;  
			          	   <input id="delYn" name="delYn" type="radio" value="N" <c:if test="${board.delYn eq 'N'}">checked</c:if>></input> N</dd>                   
			          	   <input name="boardKey" type="hidden" value="${board.boardKey}">
			       </dl>
        		   </div>
        		   <div class="board_cont">
					<input name="boardContent" type="text" value="${board.boardContent}">
        		   </div>
        		  </div>	        		  
			      
			      <br>
			                
			      <div id="box">
			      <input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
			      <input type="button" value="뒤로" onclick="history.go(-1)">
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