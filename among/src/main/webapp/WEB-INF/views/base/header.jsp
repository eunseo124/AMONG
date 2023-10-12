<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<input type = "hidden" value = "<c:out value = '${sessionc.memKey}'/>" id = "memKey">
<input type = "hidden" value = "<c:out value = '${sessionc.memGrade}'/>" id = "memGrade">
   <c:choose>
      <c:when test = "${sessionc.memKey ne '0' && sessionc.memGrade eq '2'}">
         <section id="sub">
                <ul>
                   <li>
                        <a href="<c:url value="/home" />">홈페이지</a>
                    </li>
                   <li class="slash">|</li>
                    <li>
                        <a href="mypage?memKey=${sessionc.memKey}">마이페이지</a>
                    </li>
                    <li class="slash">|</li>
                    <li>
                        <a href="<c:url value="/admin_member" />">관리자페이지</a>
                    </li>
                </ul>
            </section>
      </c:when>
      <c:when test = "${sessionc.memKey ne null}">
         <section id="sub">
                <ul>
                   <li>
                        <a href="<c:url value="/home" />">홈페이지</a>
                    </li>
                   <li class="slash">|</li>
                    <li>
                        <a href="mypage?memKey=${sessionc.memKey}">마이페이지</a>
                    </li>
                   
                </ul>
            </section>
      </c:when>
      <c:otherwise>
      <section id="sub">
                <ul>
                    <li>
                        <a href="<c:url value="/memjoin" />">회원가입</a>
                    </li>
                    <li class="slash">|</li>
                    <li>
                        <a href="<c:url value="/login" />">로그인</a>
                    </li>
                </ul>
            </section>
      </c:otherwise>
   </c:choose>

            <section id="main">
                <a href="<c:url value="/home" />" class="logo" style="text-decoration: none;">
                    <h1>AM<img src="resources/images/profile.png" id="timg">NG</h1>
                </a>

            </section>
            <section id="nav">
                <nav>
                    <ul>
                        <li>
                            <div class="menu">
                                <a href="<c:url value="/freeboard" />">커뮤니티</a>
                            </div>
                            <ul>
                                <li>
                                    <a href="<c:url value="/freeboard" />"style="text-decoration: none; color:black;">자유게시판</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/hotboard" />"style="text-decoration: none; color:black;">인기게시판</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <div class="menu">
                                <a href="<c:url value="/gameboard" />">게임</a>
                            </div>
                        </li>
                        <li>
                            <div class="menu">
                                <a href="<c:url value="/foodboard" />">맛집</a>
                            </div>
                        </li>
                        <li>
                            <div class="menu">
                                <a href="<c:url value="/travleboard" />">여행</a>
                            </div>
                        </li>
                        <div class="navBackground"></div>
                    </ul>
                </nav>
    
    </section>
    