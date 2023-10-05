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
        		<img src = "resources/images/Mbanner1.png">
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
                                <table>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    
                                </table>
                            </div>
                            <div class="Itable">
                                <div class="Iboard">
                                    <h2>게임</h2>
                                    <p><a href = "<c:url value="/gameboard"/>">더보기</a></p>
                                </div>
                                <table>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    
                                </table>
                            </div>
                            <div class="Itable">
                                <div class="Iboard">
                                    <h2>맛집</h2>
                                    <p><a href = "<c:url value="/foodboard"/>">더보기</a></p>
                                </div>
                                <table>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    
                                </table>
                            </div>
                            <div class="Itable">
                                <div class="Iboard">
                                    <h2>여행</h2>
                                    <p><a href = "<c:url value="/travleboard"/>">더보기</a></p>
                                </div>
                                <table>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    <tr>
                                        <td><img src="resources/images/banner.jpg" id="Mark">홍길동</td>
                                        <td id="Ttext">오늘 날씨가 좋네요</td>
                                        <td id="Tday">2023.09.14</td>
                                    </tr>
                                    
                                </table>
                            </div>
                            <!-- 광고 -->
                            <section id="Mbanner2">
		              			<div>
		            				<img src="resources/images/banner.jpg">
		            			</div>
              				</section>
              				
                            <div class="merge">
                                <div class="Hboard">
                                    <h2>인기게시판</h2>
                                    <p><a href = "<c:url value="/hotboard"/>">더보기</a></p>
                                </div>
                                <div class="Htable">
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">제목의 길이가 잘 넘어가나 실험중입니다 가나다라마바사아자차카타파하</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                    <div class="Htext">
                                        <img src="resources/images/banner.jpg" id="Himg">
                                        <div id = "Btext">김철수</div>
                                        <div id = "Btext2">올해의 인기상은 내것!</div>
                                        <div id = "Hday">2023.09.14</div>
                                    </div>
                                </div>
                            </div>
                            <!-- 광고 -->
                            <section id="Mbanner3">
		              			<div >
		            				<img src="resources/images/banner.jpg">
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