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
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/board.css"/>" rel="stylesheet">
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
            <%@include file="../base/header.jsp"%>
    </header>
    <main>
<!-- 사이드 -->
        <aside>
            <%@include file="../base/aside.jsp"%>
        </aside>
        <!-- 본문내용 -->
        <article id = "postList">
        	<div id = "postList">
        		<section id = "title"><h1>여행</h1></section>
        		<section id = "sort">
        			<a class="subject">정렬 |</a>
        			<a href="#" class="subject">최신순</a>
        			<a href="#" class="subject">추천순</a>
        			<a href="#" class="subject">조회순</a>
        			<a href="#" class="subject">댓글순</a>
        		</section>
        		<section id = "generalList">
        			<div class = "items">
        			<a href="#" class="notice">
        					<span class="subject">공지</span>
        					<div class="info">
        						<div class="title">
        							<span class="text">공지 테스트 중입니다.</span>
        							<div class="etc">
        							<div id="nickName">
        								<img src="resources/images/banner.jpg">
        								<div>관리자</div>
        							</div>
        							<div>2023.09.14</div>
        						</div>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        			<a href="#" class="notice">
        					<span class="subject">공지</span>
        					<div class="info">
        						<div class="title">
        							<span class="text">안내말씀드립니다....</span>
        							<div class="etc">
        							<div id="nickName"><div>관리자</div></div>
        							<div>2023.09.14</div>
        						</div>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        				<a href="#" class="notice">
        					<span class="subject">공지</span>
        					<div class="info">
        						<div class="title">
        							<span class="text">서버점검예정 12:00 ~ 23:00</span>
        							<div class="etc">
        							<div id="nickName"><div>관리자</div></div>
        							<div>2023.09.14</div>
        						</div>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        				<a href="#" class="item">
        					<div class="image">
        						<img src="resources/images/banner.jpg">
        					</div>	
        					<div class="info">
        						<div class="title">
        							<span class="text">테스트용 작성글 입니다.</span>
        						</div>
        						<div class="etc">
        							<div id="nickName"><div>관리자</div></div>
        							<div>조회수 1,000</div>
        							<div>댓글 10</div>
        							<div>추천 10</div>
        							<div>2023.09.14</div>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        				<a href="#" class="item">
        					<div class="image">
        						<img src="resources/images/banner.jpg">
        					</div>	
        					<div class="info">
        						<div class="title">
        							<span class="text">테스트용 작성글 입니다.</span>
        						</div>
        						<div class="etc">
        							<div id="nickName"><div>관리자</div></div>
        							<div>조회수 1,000</div>
        							<div>댓글 10</div>
        							<div>추천 10</div>
        							<div>2023.09.14</div>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        				<a href="#" class="item">
        					<div class="image">
        						<img src="resources/images/banner.jpg">
        					</div>	
        					<div class="info">
        						<div class="title">
        							<span class="text">테스트용 작성글 입니다.</span>
        						</div>
        						<div class="etc">
        							<div id="nickName"><div>관리자</div></div>
        							<div>조회수 1,000</div>
        							<div>댓글 10</div>
        							<div>추천 10</div>
        							<div>2023.09.14</div>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        			</div>
        		</section>
        		
        		<section class="write">
        			<a href="#">글작성</a>
        		</section>
        	
        		<section class="search">
        			<input type="text" placeholder="검색어" name="search">
        			<button>
        				<span class="material-symbols-outlined">search</span>
        			</button>
        		</section>
        		
        		<div id="table">
        			<a href="#">1</a>
        			<a href="#">2</a>
        			<a href="#">3</a>
        			<a href="#">4</a>
        		</div>
        		
        	</div>
        </article>
    </main>
<!-- 푸터 -->
    <footer id = "footer">
    	<%@include file="../base/footer.jsp"%>
  </footer>
    </div>
</body>

</html>