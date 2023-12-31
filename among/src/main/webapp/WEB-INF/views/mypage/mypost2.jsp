<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
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
          <section id="main" >
                <a href="<c:url value="/home" />" class="logo" style="text-decoration: none;">
             		<h1>AM<img src="resources/images/profile.png" id="timg" style="width: 80px;height: 70px; position: relative;top: 6px;">NG</h1>

                </a>
            </section>
            <section class = "mypage1">
            		<div class = "mypage2">
            			<img src="resources/images/profile.png" class = "pimg">
            		</div>
            		<div class = "mypage3">
	            		<h1>${sessionc.nName}님</h1>
		            	<p>${sessionc.memEmail1}@${sessionc.memEmail2}</p>
	            	</div>
            </section>
    </header>
    <main style="height:900px;">
        <!-- 본문내용 -->
            <article id="widget">
            	<section class = "flex">
            		<div class = "pheader">
            		<div><h4><a href="mypage?memKey=${sessionc.memKey}">내 프로필</a></h4></div>
            		<div><h4><a href="mypost?memKey=${sessionc.memKey}">게시글 관리</a></h4></div>
            		<div><h4><a href="myreply?memKey=${sessionc.memKey}">댓글 관리</a></h4></div>
            		</div>
            		<div class = "pmypage1" style="height:900px;">
            				<div class = "pmypage2" style="width:1000px;">
                                    <div class="merge">
	                                <div class = "pheader2" role="tablist">
					            		<div role="presentation"><h4><a href="mypost?memKey=${sessionc.memKey}" id="loinid" class="menu_id" role="tab" aria-selected="false">자유 게시판</a></h4></div>
					            		<div role="presentation"><h4><a href="mypost2?memKey=${sessionc.memKey}" class="menu_ones on" role="tab" aria-selected="true">인기 게시판</a></h4></div>
					            		<div role="presentation"><h4><a href="mypost3?memKey=${sessionc.memKey}" class="menu_id2" role="tab" aria-selected="false"> 게임 </a></h4></div>
					            		<div role="presentation"><h4><a href="mypost4?memKey=${sessionc.memKey}" class="menu_id3" role="tab" aria-selected="false"> 맛집 </a></h4></div>
					            		<div role="presentation"><h4><a href="mypost5?memKey=${sessionc.memKey}" class="menu_id4" role="tab" aria-selected="false"> 여행 </a></h4></div>
			            			</div>
                                	<div class="Htable" aria-controls="loinid">
	                                    <c:forEach items="${hboard}" var="hboard">
	                                    <input type="hidden" id="modifyDate" value="${hboard.boardModifyDate}">
	                                    <c:choose>
	                                    <c:when test = "${hboard.delYn eq 'N' }">
	                                    <div class="Htext">
	                                    <c:choose>
	                                    	<c:when test = "${hboard.boardImg.isEmpty()}">
	                                        <img src="resources/images/profile.png" id="Himg">
	                                        </c:when>
	                                        <c:when test = "${!hboard.boardImg.isEmpty()}">
	                                        <img src="resources/images/${hboard.boardImg}" id = "Himg">
	                                        </c:when>
	                                        </c:choose>
	                                        <div id = "Btext">${hboard.nName}</div>
	                                        <div id = "Btext2"><a href = "boardlist?boardKey=${hboard.boardKey}&category=${hboard.boardCategory}">${hboard.boardTitle}</a></div>
	                                        <c:choose>
	                                        <c:when test = "${hboard.boardRegDate eq hboard.boardModifyDate}">
	                                        <div id = "Hday">${hboard.boardRegDate}</div>
	                                        </c:when>
	                                        <c:when test = "${hboard.boardRegDate ne hboard.boardModifyDate}">
	                                        <div id = "Hday">${hboard.boardModifyDate}</div>
	                                        </c:when>
	                                        </c:choose>
	                                        <c:choose>
	                                        	<c:when test = "${hboardl.boardRegDate != hboardl.boardModifyDate}">
	                                        		<div><a href = "boardmodify?boardKey=${boardl.boardKey}"><input type="button" value="수정"></a></div>
	                                        	</c:when>
	                                        	<c:otherwise>
	                                        		<div><a href = "boardmodify?boardKey=${hboardl.boardKey}" onClick="disable()"><input type="button" value="수정"></a></div>
	                                        	</c:otherwise>
	                                        </c:choose>
	                                        <form method = "post" action = "delboard">
	                                        <input type = "hidden" value = "Y" id = "delYn" name = "delYn">
	                                        <input type = "hidden" value = "${hboard.boardKey}" id = "boardKey" name = "boardKey">
	                                        <input type = "hidden" value = "${hboard.memKey}" id = "memKey" name = "memKey">
	                                        <div><input type="submit" value="삭제"></div>
	                                        </form>
	                                    </div>
	                                    </c:when>
	                                    <c:otherwise>
	                                    	
	                                    </c:otherwise>
	                                    </c:choose>
	                                    </c:forEach>
	                                 
                                </div>
                               <div class = "paging">
                                <c:if test="${pageMaker.prev }">
							                <li>
							                    <a href='<c:url value="/mypost2?memKey=${param.memKey}&page=${pageMaker.startPage-1 }"/>'><i style = "list-decoration:none;">처음으로</i></a>
							                </li>
							                </c:if>
							                <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
							                <li>
							                    <a href='<c:url value="/mypost2?memKey=${param.memKey}&page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
							                </li>
							                </c:forEach>
							                <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
							                <li>
							                    <a href='<c:url value="/mypost2?memKey=${param.memKey}&page=${pageMaker.endPage+1 }"/>'><i class="fa fa-chevron-right"></i></a>
							                </li>
							           </c:if>
							           </div>
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
<script>
function disable(e) {
	alert("당일 작성한 게시물은 수정하실 수 없습니다.");
	var e = window.event;
	e.preventDefault();
}
</script>

</html>