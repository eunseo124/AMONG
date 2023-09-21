<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/admin.css"/>" rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <style>
    	@import url('https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css');


/* 사이드바  css*/

        aside {
            width: 340px;
            display: flex;
            height: 800px;
            flex-direction: column;
            box-sizing: border-box;
            background: #5D5D5D;
            padding: 0;
        	margin: 0;
        	box-sizing: border-box;
        	float: left;
        	font-color: #FFFFFF;
        	border-radius: 10px;      
        }
               
        aside h1 span {
        	font-size: 30px;
        	margin-left: 6px;
        	color: white;
        }
        
        aside ul {
        	padding: 5px 0 5px 30px;
        } 
		
		aside ul li {
			list-style: none;
			font-weight: bold;
			margin: 20px auto;
			position: relative;
			overflow: hidden;
			max-height: 35px;
			line-height: 35px;
			transition: 1s;
			text-transform: capitalize;
		}
		
		aside ul: first-child li{
			max-height: 50px;
		}

		aside ul li: hover {
			background: #d1d1d173;
		}
		
		aside ul: first-child li: hover {
			background: none;
		}		
		
		aside ul li a{
			text-decoration: none;
			color: whitesmoke;
		}
		
		aside ul li a i{
			width: 30px;
			padding: 5px;
			margin-right: 10px;
		}
		
		aside ul li a i.fa-angle-right{
			position: absoulute;
			right: 0;
			top: 5px;
			transition: 0.5s;
		}		
		
		aside ul li>ul {
			padding: 1px;
			margin: 0 0 0 20px;
		}
		
		aside ul li>ul li a {
			height: 25px;
			line-height: 20px;
			font-size: 15px;
			padding: 1px 1px 1px 20px;
			font-weight: normal;
			border-left: 1px solid #fff0f0;
			margin: 5px;
			color: #fff0f0;
			cursor: pointer;
		}
		
		aside ul li>ul li a,
		aside ul li:target>ul li a {
			background: transparent;
			color: white;
		}
		
		aside ul li:target {
			max-height: 300px;
			border-radius: 5px 0px 0px 5px;
		}		
		
		aside ul li:target a {
			color: #444;
			display: inherit;
			background: white;
		}
		
		aside ul li:target:hover {
			background: initial;
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
			<ul>
				<li><h1><span>관리자 페이지</span></h1>
			</ul>
			<ul>
				<li id="adminMember">
					<a href ="#adminMember">
					<span>계정관리</span>
					<i class="fa fa-angle-right"></i>
					</a>
					
					<ul>
						<li><a href="<c:url value="/admin_member" />">회원</a></li>
					</ul>
				</li>
			</ul>
			<ul>
				<li id="adminBoard">
					<a href="#adminBoard">
					<span>게시판관리</span>
					<i class="fa fa-angle-right"></i>
					</a>
					
					<ul>
						<li><a href="<c:url value="/adminfreeboard" />">자유게시판</a></li>
						<li><a href="<c:url value="/admingameboard" />">게임게시판</a></li>
						<li><a href="<c:url value="/adminfoodboard" />">맛집게시판</a></li>
						<li><a href="<c:url value="/admintravleboard" />">여행게시판</a></li>					
					</ul>
				</li>			
			</ul>
        </aside>
        <!-- 본문내용 -->
        <article id = "postList">
        	<section id = "postList">
        		<div id = "title"><h1>계정관리</h1></div>
        		 <div id ="info">
        		   <section>
        		    <div>
        		     <h1>회원정보</h1>
        		     <table>
        		      <thead>
        		       <tr>
        		        <th>No.</th>
        		        <th>Name</th>		       
        		        <th>ID</th>
        		        <th>E-mail</th>
        		        <th>Grade</th>
        		        <th>Detail</th>  		                		        
        		       </tr>
        		      </thead>
        		      <tbody>
        		       <tr>
        		        <td>01</td>
        		        <td>최대한</td>
        		        <td>monkey</td>
        		        <td>dehan80942@naver.com</td>
        		        <td>관리자</td>
        		        <td><button><a href="<c:url value="/admin_member_info" />">View</a></button></td>
        		       </tr>
        		       <tr>
        		        <td>02</td>
        		        <td>김대한</td>
        		        <td>monkey2</td>
        		        <td>dehan80943@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>03</td>
        		        <td>이대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>04</td>
        		        <td>박대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>05</td>
        		        <td>곽대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>06</td>
        		        <td>장대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>07</td>
        		        <td>고대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>08</td>
        		        <td>임대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>09</td>
        		        <td>정대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>
        		       <tr>
        		        <td>10</td>
        		        <td>송대한</td>
        		        <td>monkey3</td>
        		        <td>dehan80944@naver.com</td>
        		        <td>회원</td>
        		        <td><button>View</button></td>
        		       </tr>        		               		               		               		               		               		               		               		               		       
        		      </tbody>  
        		     </table>
        		<section class="search">
        			<input type="text" placeholder="검색어" name="search">
        			<button>
        				<span class="material-symbols-outlined">search</span>
        			</button>
        		</section>
       		     
        		    </div>
        		   </section>
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
</html>