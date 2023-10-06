<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%//System.out.println("aside memKey = "+ memKey); %>
    
            <section id="fixedBanner" class="left"></section>
            <section id="fixedBanner" class="right"></section>
            <section class="userContainer">
        <!--     -->
      <input type = "hidden" value = "<c:out value = '${sessionc.memKey}'/>" id = "memKey">
	  <input type = "hidden" value = "<c:out value = '${sessionc.memGrade}'/>" id = "memGrade">
	  <input type = "hidden" value = "<c:out value = '${sessionc.nName}'/>" id = "nName">
	  
            <c:choose>
         <c:when test = "${memberList.MemKey eq null}">
         <form name = "loginfrm" method = "post" action = "login/login_proc">
                <div class="inputsAndButtons">
                    <input type="text" name="memId"  id = "memId" placeholder="아이디">
                    <input type="password" name="memPw" id = "memPw" placeholder="비밀번호">
                    <button class="button" type = "submit">로그인</button>
                    <%System.out.println("aside sumit완료"); %>
                </div>
                </form>
                <div class="joinAndFindPassword">
                    <a href="<c:url value="/pass" />">비밀번호 찾기</a>
                    <a href="<c:url value="/memjoin" />">회원가입</a>
                </div>
            </c:when>
              <c:when test = "${memberList.MemKey ne null}">
                    <div class="loginAfter">
                        
                        <div id="Aid">
                            <p>${memberList.MemName}님 </p>
                            <p id="grade">|</p>
                            <p id="grade">
                            <c:set var = "memGrade" value = "${sessionc.memGrade}"/>
                            <c:choose>
                               <c:when test = "${sessionc.memGrade eq '1'}">
                                  <%out.print("일반회원"); %>
                               </c:when>
                               <c:when test = "${sessionc.memGrade eq '2'}">
                                  <%out.print("관리자"); %>
                               </c:when>
                            </c:choose>
                            </p>
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
                </c:when>
                </c:choose>
                
                </section>
                <!-- 광고 -->
               <section id = "banner">
                   <img src="resources/images/banner.jpg" class = "img">
               </section>
               <section id = "banner2">
                   <img src="resources/images/banner.jpg" class = "img">
               </section>


