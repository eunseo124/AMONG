<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="fixedBanner" class="left"></section>
            <%
            	Integer memKey = (Integer)session.getAttribute("memKey"); //로그인성공하면 memKey 가져오기
            	//int memKey = 0;
            	if(memKey != null) {
            %>
            <section id="fixedBanner" class="right"></section>
            <section class="userContainer">
                <div class="inputsAndButtons">
                    <input type="text" name="id" placeholder="아이디">
                    <input type="password" name="password" placeholder="비밀번호">
                    <button class="button">로그인</button>
                </div>
                <div class="joinAndFindPassword">
                    <a href="<c:url value="/pass" />">비밀번호 찾기</a>
                    <a href="<c:url value="/memjoin" />">회원가입</a>
                </div>
            </section>
             <!-- 광고 -->
            <section id = "banner">
                <img src="resources/images/banner.jpg" class = "img">
            </section>
            <section id = "banner2">
                <img src="resources/images/banner.jpg" class = "img">
            </section>
              <%} else { %>  
                <section id="fixedBanner" class="left"></section>
                <section id="fixedBanner" class="right"></section>
                <section class="userContainer">
                    <div class="loginAfter">
                        <div id="Aid">
                            <p> 홍길동님 </p>
                            <p id="grade">|</p>
                            <p id="grade">일반 회원</p>
                        </div>
                        <div id="Aboard">
                            <p>게시글 : 1개 <br>
                                <br> 댓글 : 1개
                            </p>
                            <button id="Alogout">로그아웃<span class="material-symbols-outlined">
                                logout
                                </span></button>
                        </div>
                        <div>

                        </div>
                        <div id="Aboard2">
                            <p></p>

                        </div>
                        <button class="button">마이페이지</button>
                        <button id="button2">정보수정</button>

                    </div>

                    <div class="joinAndFindPassword">
                        <a href="#">비밀번호 찾기</a>
                        <a href="#">회원가입</a>
                    </div>
                </section>
                <section id = "banner">
                <img src="resources/images/banner.jpg" class = "img">
            </section>
            <section id = "banner2">
                <img src="resources/images/banner.jpg" class = "img">
            </section>
          <%} %>
