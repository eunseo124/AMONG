<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
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





				<article id="post">

					<section class="backToList">
						<br> <br> <a href="#"> &lt; 목록으로 </a>
					</section>

					<section class="article">
						<div class="info">
							<div class="title">
								<span>일반</span>
								<h1>애플 키보드 트랙패드 기타 구입</h1>
							</div>
							<div class="etc">
								<div class="left">
									<div id="nickName">
										<div id="gradeBadge" class="color admin"
											style="background-color: red">M</div>
										<div>관리자</div>
									</div>
									<div>2023.03.09</div>
									<div>추천 1</div>
									<div>조회수 1423</div>
									<div>댓글 10</div>
								</div>

							</div>
						</div>
						<div class="content ">
							<figure class="image">
								<img
									src="https://dzvpypcfjkr44.cloudfront.net/5df8dc651983470793cde08bf668302f.webp">
							</figure>  
							<p>안녕하세요 애플 트랙 패드 필요해서 구입 해서 사용 해봤는데</p>
							<p>애플 마우스랑 같이 해보니 신세계 였습니다 너무 좋습니다</p>
							<p>애플 악세사리도 조금 구입 하고 스탠드 커브 구입도 하고</p>
							<p>너무 좋습니다</p>
						</div>


						<br>

						<div class="buttons">
							<div class="left">
								<a href="/posts/자유게시판?search=&amp;page=">
									<button>목록으로</button>
								</a>
							</div>
							<div class="right">
								<button onclick="share()">공유</button>
								<button form="like">추천</button>
							</div>
						</div>

						<div id="comments">
							<h2>댓글</h2>
							<div class="new">
								<textarea name="repleContent" id="repleContent"
									style="resize: none"></textarea>
								<button type="button" name="save" id="save"
									onclick="saveReple()">작성</button>
							</div>
						</div>

					


               <c:forEach items="${repleList}" var="reple">
						
						
						<div class="items">



							
							<br>
							<div id ="infos">
									<div id="nickName">
										<div id="gradeBadge" class="color admin"
											style="background-color: black">일반</div>
										<div>${reple.memKey}</div>
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


						<article id="postList">
							<div id="postList">
								<section id="title">
									<h1>자유게시판</h1>
								</section>
								<section id="sort">
									<a class="subject">정렬 |</a> <a href="#" class="subject">최신순</a>
									<a href="#" class="subject">추천순</a> <a href="#" class="subject">조회순</a>
									<a href="#" class="subject">댓글순</a>
								</section>
								<section id="generalList">
									<div class="items">
										<a href="#" class="notice"> <span class="subject">공지</span>
											<div class="info">
												<div class="title">
													<span class="text">공지 테스트 중입니다.</span>
													<div class="etc">
														<div id="nickName">
															<img src="resources/images/banner.jpg">
															<div>관리자</div>
														</div>
														<div>2023.09.14</div>
													</div>
												</div>
											</div>
										</a>
										<div class="line"></div>
										<a href="#" class="notice"> <span class="subject">공지</span>
											<div class="info">
												<div class="title">
													<span class="text">안내말씀드립니다....</span>
													<div class="etc">
														<div id="nickName">
															<div>관리자</div>
														</div>
														<div>2023.09.14</div>
													</div>
												</div>
											</div>
										</a>
										<div class="line"></div>
										<a href="#" class="notice"> <span class="subject">공지</span>
											<div class="info">
												<div class="title">
													<span class="text">서버점검예정 12:00 ~ 23:00</span>
													<div class="etc">
														<div id="nickName">
															<div>관리자</div>
														</div>
														<div>2023.09.14</div>
													</div>
												</div>
											</div>
										</a>
										<div class="line"></div>
										<a href="#" class="item">
											<div class="image">
												<img src="resources/images/banner.jpg">
											</div>
											<div class="info">
												<div class="title">
													<span class="text">테스트용 작성글 입니다.</span>
												</div>
												<div class="etc">
													<div id="nickName">
														<div>관리자</div>
													</div>
													<div>조회수 1,000</div>
													<div>댓글 10</div>
													<div>추천 10</div>
													<div>2023.09.14</div>
												</div>
											</div>
										</a>
										<div class="line"></div>
										<a href="#" class="item">
											<div class="image">
												<img src="resources/images/banner.jpg">
											</div>
											<div class="info">
												<div class="title">
													<span class="text">테스트용 작성글 입니다.</span>
												</div>
												<div class="etc">
													<div id="nickName">
														<div>관리자</div>
													</div>
													<div>조회수 1,0z00</div>
													<div>댓글 10</div>
													<div>추천 10</div>
													<div>2023.09.14</div>
												</div>
											</div>
										</a>
										<div class="line"></div>
										<a href="#" class="item">
											<div class="image">
												<img src="resources/images/banner.jpg">
											</div>
											<div class="info">
												<div class="title">
													<span class="text">테스트용 작성글 입니다.</span>
												</div>
												<div class="etc">
													<div id="nickName">
														<div>관리자</div>
													</div>
													<div>조회수 1,000</div>
													<div>댓글 10</div>
													<div>추천 10</div>
													<div>2023.09.14</div>
												</div>
											</div>
										</a>
										<div class="line"></div>
									</div>
								</section>

								<section class="write">
									<a href="#">글작성</a>
								</section>

								<section class="search">
									<input type="text" placeholder="검색어" name="search">
									<button>
										<span class="material-symbols-outlined">search</span>
									</button>
								</section>

								<div id="table">
									<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a
										href="#">4</a>
								</div>

							</div>
						</article>
				</article>





				<div style="display: none;"></div>



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

	function saveReple() {

		// repl
		const repl = document.getElementById("repleContent").value;

		$.post("http://localhost:8080/get/repl/save", {
			repleContent : repl,
			repleRegDate : new Date(),
			memKey : 1, // 수정해야됨
			boardKey : 1 // 수정해야됨
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