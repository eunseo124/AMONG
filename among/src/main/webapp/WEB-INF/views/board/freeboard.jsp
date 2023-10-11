<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
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
        		<section id = "title"><h1>자유게시판</h1></section>
        		<input type="hidden" id="category" value="2">
        		<section id = "sort">
        			<a class="subject">정렬 |</a>
        			<a href="#" class="subject">최신순</a>
        			<a href="#" class="subject">추천순</a>
        			<a href="#" class="subject">조회순</a>
        			<a href="#" class="subject">댓글순</a>
        		</section>
        		<section id = "generalList">
        			<div class = "items">
        			
        			<!-- 공지&관리자용 게시판 -->
        			<c:forEach items="${boardList}" var="board">
        			<c:set var = "memGrade" value="${board.memGrade}"/>
        			<c:choose>
        			<c:when test="${memGrade == 2}">
        			<a href="boardlist" class="notice">
        					<span class="subject">공지</span>
        					<div class="info">
        						<div class="title">
        							<span class="text">${board.boardTitle}</span>
        							<div class="etc">
        							<div id="nickName">
        								<img src="resources/images/banner.jpg">
        								<div>${board.nName}</div>
        							</div>
        							<c:set var = "boardModifyDate" value = "${board.boardModifyDate}"/>
        							<c:set var = "boardRegDate" value = "${board.boardRegDate}"/>
        							<c:choose>
        							<c:when test = "${boardModifyDate != boardRegDate}">
        								<div>${boardModifyDate}(수정됨)</div>
        							</c:when>
        							<c:otherwise>
        								<div>${boardRegDate}</div>
        							</c:otherwise>
        							</c:choose>
        						</div>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        				</c:when>
        				</c:choose>
        				</c:forEach>
        				
        				<!-- 유저용 게시판 -->
        				<c:forEach items="${boardList}" var="board">
        				<c:set var = "memGrade" value="${board.memGrade}"/>
        				<c:choose>
        				<c:when test="${memGrade == 1}">
        				<a href="boardlist" class="item" id="item">
        					<div class="image">
        						<img src="resources/images/profile.png">
        					</div>	
        					<div class="info">
        						<div class="title">
        							<span class="text">${board.boardTitle}</span>
        							<input type="hidden" id="boardKey" value="${board.boardKey}">
        						</div>
        						<div class="etc">
        							<div id="nickName">
        								<img src="resources/images/banner.jpg">
        								<div>${board.nName}</div>
        							</div>
        							<div>조회수 ${board.boardView}</div>
        							<div>댓글 ${board.repleCount}</div>
        							<div>추천 ${board.boardRecommend}</div>
        							<!-- if문  -->
        							<c:set var = "boardModifyDate" value = "${board.boardModifyDate}"/>
        							<c:set var = "boardRegDate" value = "${board.boardRegDate}"/>
        							<c:choose>
        							<c:when test = "${boardModifyDate != boardRegDate}">
        								<div>${boardModifyDate}(수정됨)</div>
        							</c:when>
        							<c:otherwise>
        								<div>${boardRegDate}</div>
        							</c:otherwise>
        							</c:choose>
        						</div>
        					</div>
        				</a>
        				<div class="line"></div>
        				</c:when>
        				</c:choose>
        				</c:forEach>
        			</div>
        		</section>
        		
        		<!-- 글작성 기능 -->
        		<section class="write">
        			<a id="boardWrite">글작성</a>
        		</section>
        	
        		<!-- 검색어 기능 -->
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
        		
        		<script>
        			var category = $("#category").val();
        			var id = $("#boardKey").val();
        			console.log(category);
        			$(document).ready(function() {
        				
        				$("#boardWrite").on("click", function() {
        					location.href = "boardwrite?category="+category;
        				});
        			});
        			
        			//조회수 증가 스크립트
        			$("#item").on("click", function() {
        				location.href = "./upView?id="+id;
        			});
        		</script>
        		
        		<script>
   
   
      $("#boardKey").click(function(){
    
    

      let boardKey = $("#boardKey").val();
      
      $.ajax({
    		url : "<c:url value='/repl/repleList'/>",
    		type : 'post',
    		data : {"boardKey":boardKey},
    		dataType: "json",
    		
    		error : function() {
    			alert("error");
    		}
    	});
      
</script>
        		
        		
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