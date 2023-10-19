<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/base.css"/>" rel="stylesheet">
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


    </style>
    <title>AMONG</title>
</head>

<body>
    <div class="container">
        <header>
            <%@include file = "base/header.jsp" %>
    </header>
    <main>
        <aside>
            <%@include file = "base/aside.jsp" %>
        </aside>
        <!-- 본문내용 -->
            <article id="index ">
                <section id = "Mbanner">
        		<img src = "resources/images/travle2.png">
        		<img src = "resources/images/Mbanner2.png">
        	</section>
                <section id="widget">
                    <div class="container">
                        <div class="flex">
                            <div class="Itable">
                                <div class="Iboard">
                                    <h2>자유게시판</h2>
                                    <p><a href = "<c:url value="/freeboard"/>">더보기</a></p>
                                </div>
                                <div class = "btable">
                                
                               <c:forEach items="${boardList}" var="board">
                                <c:set var = "boardCategory" value="${board.boardCategory}"/>
                                <c:if test = "${boardCategory eq 1}">
                                    <div class = "btr">
                                        <div class = "btd1"><img src="resources/images/profile.png" id="Mark">${board.nName}</div>
                                        <div id="Ttext">${board.boardTitle}</div>
                                        <div id="Tday">${board.boardRegDate}</div>
                                    </div>
                                    
                                </c:if>
                       </c:forEach>    
                                </div>
                            </div>
                            <div class="Itable">
                                <div class="Iboard">
                                    <h2>게임</h2>
                                    <p><a href = "<c:url value="/gameboard"/>">더보기</a></p>
                                </div>
                                <div class = "btable">
                                <c:forEach items="${boardList}" var="board">
                                <c:set var = "boardCategory" value="${board.boardCategory}"/>
                                <c:if test = "${boardCategory eq 2}">
                                
                                    <div class = "btr">
                                        <div class = "btd1"><img src="resources/images/gameAdminIcon.png" id="Mark">${board.nName}</div>
                                        <div id="Ttext">${board.boardTitle}</div>
                                        <div id="Tday">${board.boardRegDate}</div>
                                    </div>
                                    
                                   </c:if>
                       </c:forEach>  
                                   
                                    
                                </div>
                            </div>
                            <div class="Itable">
                                <div class="Iboard">
                                    <h2>맛집</h2>
                                    <p><a href = "<c:url value="/foodboard"/>">더보기</a></p>
                                </div>
                                <div class = "btable">
                                <c:forEach items="${boardList}" var="board">
                                <c:set var = "boardCategory" value="${board.boardCategory}"/>
                                <c:if test = "${boardCategory eq 3}">
                                
                                    <div class = "btr">
                                        <div class = "btd1"><img src="resources/images/foodAdminIcon.png" id="Mark">${board.nName}</div>
                                        <div id="Ttext">${board.boardTitle}</div>
                                        <div id="Tday">${board.boardRegDate}</div>
                                    </div>
                                    
                                   </c:if>
                       </c:forEach>  
                                   
                                    
                                </div>
                            </div>
                            <div class="Itable">
                                <div class="Iboard">
                                    <h2>여행</h2>
                                    <p><a href = "<c:url value="/travleboard"/>">더보기</a></p>
                                </div>
                                <div class = "btable">
                                <c:forEach items="${boardList}" var="board">
                                <c:set var = "boardCategory" value="${board.boardCategory}"/>
                                <c:if test = "${boardCategory eq 4}">
                                
                                    <div class = "btr">
                                        <div class = "btd1"><img src="resources/images/travelAdminIcon.png" id="Mark">${board.nName}</div>
                                        <div id="Ttext">${board.boardTitle}</div>
                                        <div id="Tday">${board.boardRegDate}</div>
                                    </div>
                                    
                                   </c:if>
                       </c:forEach>  
                                   
                                    
                                </div>
                            </div>
                            <!-- 광고 -->
                            <section id="Mbanner3">
		              			<div >
		            				<img src="resources/images/travle.png">
		            			</div>
              				</section>
                        </div>
                    </div>
                </section>
              
            </article> 
    </main>
    <footer id = "footer">
    	<%@include file="base/footer.jsp" %>
  </footer>
    </div>
</body>

</html>