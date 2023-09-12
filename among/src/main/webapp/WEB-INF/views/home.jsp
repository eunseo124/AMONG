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
    <style>
        aside {
            width: 340px;
            display: flex;
            flex-direction: column;
            box-sizing: border-box;
            margin-top: 20px;
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
        /*광고*/
   #banner .img {
    display: grid;
    margin-top: 30px;
    width: 100%;
    height: auto;
   }
   /*푸터*/
   .container #footer {
        background-color: #eeee;
        padding: 10px;
        text-align: center;
        bottom: 0%;
        width: 100%;
        height: 150px;
        font-size: small;
    }
    </style>
    <title>AMONG</title>
</head>

<body>
    <div class="container">
        <header>
            <section id="sub">
                <ul>
                    <li>
                        <a href="/join">회원가입</a>
                    </li>
                    <li class="slash">|</li>
                    <li>
                        <a href="/login">로그인</a>
                    </li>
                </ul>
            </section>
            <section id="main">
                <a href="/" class="logo">
                    <h1>AMONG</h1>
                </a>

            </section>
            <section id="nav">
                <nav>
                    <ul>
                        <li>
                            <div class="menu">
                                <a href="/posts/자유게시판">커뮤니티</a>
                            </div>
                            <ul>
                                <li>
                                    <a href="/posts/자유게시판">자유게시판</a>
                                </li>
                                <li>
                                    <a href="/posts/뉴스">인기게시판</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <div class="menu">
                                <a href="/posts/갤러리">게임</a>
                            </div>
                        </li>
                        <li>
                            <div class="menu">
                                <a href="/posts/유튜브">맛집</a>
                            </div>
                        </li>
                        <li>
                            <div class="menu">
                                <a href="/posts/북마크">여행</a>
                            </div>
                        </li>
                        <div class="navBackground"></div>
                    </ul>
                </nav>
    
    </section>
    </header>
    <main>
        <aside>
            <section id="fixedBanner" class="left"></section>
            <section id="fixedBanner" class="right"></section>
            <section class="userContainer">
                <div class="inputsAndButtons">
                    <input type="text" name="email" placeholder="아이디 또는 이메일">
                    <input type="password" name="password" placeholder="비밀번호">
                    <button class="button">로그인</button>
                </div>
                <div class="joinAndFindPassword">
                    <a href="#">비밀번호 찾기</a>
                    <a href="#">회원가입</a>
                </div>
            </section>
            <section id = "banner">
                <img src="img/f.PNG" class = "img">

            </section>
        </aside>
        <!-- 본문내용 -->
        <article id = "index ">
            
        </article>
    </main>
    <nav id = "footer">
        <p>AMONG</p>
        <p>tel : 1234-5678 / Email : among@naver.com</p>
        <p>Business License No : 123-123-123[사업자정보확인]</p>
        <p>전주시 완산구 팔달로 184 2층</p>
        <br>
        <p>CEO : AMONG </p>
  </nav>
    </div>
</div>
</body>

</html>