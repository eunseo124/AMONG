<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link
   href="<c:url value="${PageContext.requestcontextpath}/resources/css/base.css"/>"
   rel="stylesheet">
<link
   href="<c:url value="${PageContext.requestcontextpath}/resources/css/boardlist.css"/>"
   rel="stylesheet">
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
   font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24
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
         <article id="index ">
	 <input type="hidden" name="boardKey" id="boardKey" value="${param.boardKey}">



 <c:forEach items="${list}" var="list2">
            <article id="post">
    
      
               <section class="backToList">
                  <br> <br> <a href="home"> &lt; 홈으로 </a>
               </section>
         
         
               <section class="article">
                  <div class="info">
                     <div class="title">
                        <span>일반</span>
                     </div>
                     <div class="etc">
                        <div class="left">
                           <div id="nickName">
                              
                              <div>${list2.nName}</div>
                           </div>
                           <div>${list2.boardRegDate}</div>
                           <div>추천 ${list2.boardRecommend}</div>
                           <div>조회수 ${list2.boardView}</div>
                           <div>댓글 ${list2.repleCount}</div>
                        </div>

                     </div>
                  </div>
                  <div class="content ">
                     <figure class="image">
                        <img
                           src="https://dzvpypcfjkr44.cloudfront.net/5df8dc651983470793cde08bf668302f.webp">
                     </figure>  
                     <p>내용${list2.boardContent}</p>
                    
                     
                  </div>

  </c:forEach> 
                  <br>   <br>   <br>   <br>    <br>   <br>   <br>   <br>   <br>

                  <div class="buttons">
                     <div class="left">
                        <a href="home">
                           <button >홈으로</button>
                        </a>
                     </div>
                     <div class="right">
                        <button onclick="share()">공유</button>
                        <button form="like">추천</button>
                     </div>
                  </div>


                     <!-- 댓 글 작 성 -->
                  <div id="comments">
                     <h2>댓글</h2>
                     <div class="new">
                        <textarea name="repleContent" id="repleContent" placeholder="댓글을 입력하세요."
                           style="resize: none"></textarea>
                        <button type="button" name="save" id="save"
                           onclick="saveReple()">작성</button>
                     </div>
                  </div>

               

   <!-- 댓 글 리스트 -->   
               
               <c:forEach items="${repleList}" var="reple">      
                  
                  <div class="items">



                     
                     <br>
                     
                     
                     <div id ="infos">
                           <div id="nickName">
                              <div id="gradeBadge" class="color admin"
                                 style="background-color: black">
                              <c:choose>
                                           <c:when  test = "${reple.memGrade eq '1'}">
                                           <%out.print("일반"); %>
                                           </c:when>
                                           <c:when test = "${reple.memGrade eq '2'}">
                                           <%out.print("관리자"); %>
                                           </c:when>
                                      </c:choose>
                                      </div>
                                 <div>${reple.nName}</div>
                           </div>
                           <div class="content">${reple.repleContent}</div>
                           <div id="date">   ${reple.repleRegDate}</div>
                     </div>      
                        
                     

                  </div>
        </c:forEach> 
         


                  <br>
                  <div id="table">
                     <a href="#">1</a> <a href="#">2</a> <a href="#">3</a>
                  </div>






                  <br> <br> <br> <br> <br> <br>


        <article id = "postList">
        	<div id = "postList">
        		<section id = "title"><h1>자유게시판</h1></section>
        		<input type="hidden" id="category" value="1">
        		<section id = "sort">
        			<a style="display: flex; align-items: center;" href="home" class="subject"><span class="material-symbols-outlined">house</span><strong>메인페이지로</strong></a>
        		</section>
        		<section id = "generalList">
        			<div class = "items">
        			
        			<!-- 공지&관리자용 게시판 -->
        			<c:forEach items="${boardList}" var="board">
        			<c:set var = "memGrade" value="${board.memGrade}"/>
        			<c:choose>
        			<c:when test="${memGrade == 2 && board.boardCategory==1}">
        			<a href="boardlist?boardKey=${board.boardKey}&category=${1}" class="notice">
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
        				<c:when test="${memGrade == 1 && board.boardCategory==1}">
        				<a href="boardlist?boardKey=${board.boardKey}&category=${1}" class="item" id="item">
        					<c:choose>
        					<c:when test="${!board.boardImg.isEmpty()}">
        						<div class="image">
        							<img src="resources/images/${board.boardImg}">
        						</div>
        					</c:when>
        					<c:otherwise>
        						<div class="image">
        							<img src="resources/images/profile.png">
        						</div>
        					</c:otherwise>
        					</c:choose>	
        					<div class="info">
        						<div class="title">
        							<span class="text">${board.boardTitle}</span>
        						</div>
        						<div class="etc">
        							<div id="nickName">
        								<img src="resources/images/banner.jpg">
        								<div>${board.nName}</div>
        							</div>
        							<input type="hidden" name="boardKey" value="${board.boardKey}">
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
        		<c:choose>
        		<c:when test = "${memKey!=null}">
        			<section class="write">
        				<a id="boardWrite">글작성</a>
        			</section>
        		</c:when>
        		<c:otherwise>
        		</c:otherwise>
        		</c:choose>
        	
        		
        		<div id="table">
        			<a href="#">1</a>
        			<a href="#">2</a>
        			<a href="#">3</a>
        			<a href="#">4</a>
        		</div>

</section>
         </article>
</article>
      </main>
      <!-- 푸터 -->
      <footer id="footer">
         <%@include file="../base/footer.jsp"%>
      </footer>
   </div>
</body>

<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>







<script>
var boardKey = $("#boardKey").val();
console.log(boardKey);
function saveReple() {

   // repl
   
   const repl = document.getElementById("repleContent").value;
    let joinForm = document.getElementById("memKey").value;
    

   $.post("http://localhost:8080/get/repl/save", {
      repleContent : repl,
      repleRegDate : new Date(),
      memKey : joinForm, // 수정해야됨
      boardKey : boardKey // 수정해야됨
       
   }, function(responseData) {
      // 성공적으로 응답을 받았을 때 처리할 코드
      console.log("success");
      // console.log(responseData);
   }).fail(function(xhr, status, error) {
      // 에러 발생 시 처리할 코드
      console.error('AJAX 요청 에러:', error);
   });
}
   
   
</script>
</html>