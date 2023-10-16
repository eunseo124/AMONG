<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
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
          <section id="main">
                <a href="<c:url value="/home" />" class="logo" style="text-decoration: none;">
             		<h1>AM<img src="resources/images/profile.png" id="timg" style="width: 80px;height: 70px; position: relative;top: 6px;">NG</h1>

                </a>
            </section>
            <section class = "mypage1">
            		<div class = "mypage2">
            			<img src="resources/images/profile.png" class = "pimg">
            		</div>
            		
            		<div class = "mypage3">
	            		<h1>${memlist.nName}님</h1>
		            	<p>${memlist.memEmail1}@${memlist.memEmail2}</p>
	            	</div>
            </section>
    </header>
    <main style = "height:400px;">
        <!-- 본문내용 -->
            <article id="widget">
            	<section class = "flex">
            		<div class = "pheader">
            		<div><h4><a href="mypage?memKey=${sessionc.memKey}">내 프로필</a></h4></div>
            		<div><h4><a href="mypost?memKey=${sessionc.memKey}">게시글 관리</a></h4></div>
            		<div><h4><a href="myreply?memKey=${sessionc.memKey}">댓글 관리</a></h4></div>
            		</div>
            		
            		<div class = "pmypageinfo">
            			<h1>내 프로필</h1>
            				<div class = "pmypage2">
            						
                                    <div class = "pro1">
                                    <p>아이디</p>
                                    <div class = "pro2">
                                    <p>${memlist.memId}</p>
                                    </div>
                                    </div>
                                    <div class = "pro1">
                                    <p>닉네임</p>
                                    <div class = "pro2">
                                        <p>${memlist.nName}</p>
                                    </div>
                                    </div>
                                    <div class = "pro1">
                                    <p>이메일</p>
                                    	<div class = "pro2">
                                        <p>${memlist.memEmail1}@${memlist.memEmail2}</p>
                                    	</div>
                                    </div>
                                    <div class = "pro1">
                                    <p>이름</p>
                                    	<div class = "pro2">
                                         	<p>${memlist.memName}</p>
                                     	</div>
                                     </div>
                                    <div class="pro2">
                                    <a href="myupdate?memKey=${memlist.memKey}" style = "color:white;"><button type="submit" class="pro3" style = "margin-left:348px;margin-top:24px;">정보 수정</button></a>
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
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

  	
		$( "#email3" ).change(function(){
		    $("#email2").val( $("#email3").val() );
		});
</script>
</html>