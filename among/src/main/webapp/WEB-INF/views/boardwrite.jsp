<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    
	<!-- include libraries(jQuery, bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

    <!-- include summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.js"></script>
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link href="<c:url value="${PageContext.requestcontextpath}/resources/css/boardwirte.css"/>" rel="stylesheet">
    
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
     @font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
	}
	@font-face {
	    font-family: 'HakgyoansimWoojuR';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-2@1.0/HakgyoansimWoojuR.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
	}
	@font-face {
	    font-family: 'GangwonState';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-2@1.0/GangwonState.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
	}
	@font-face {
	    font-family: 'SBAggroB';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
	}
	@font-face {
	    font-family: 'iceSotong-Rg';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-2@1.0/iceSotong-Rg.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
	}   
    </style>
    <title>AMONG</title>
</head>

<body>
    <div class="container" style= "width: 100%; margin: 0; padding: 0;">
<!-- 헤더  -->     
<header style="text-decoration:none;">
            <%@include file="base/header.jsp"%>
    </header>
    <main style="display: flex; align-items: flex-start; gap: 20px;">
        <!-- 본문내용 -->
<article id="postWrite">
                <div id="postWrite">
                    <section id ="title">
                        <h1>자유게시판</h1>
                    </section>

                    <section id = "boardWrite">
                        <div class = "writeTitle">
                            <input id="subject" name="subject" type="text" maxlength="40" placeholder="제목(40자이내)">
                        </div>

                        <div id= "note">
                            <form method="post" style="margin-top: 80px;">
                                <textarea id="summernote" name="editordata"></textarea>
                            </form>
        <script>
	$(document).ready(function () {
        	var fontList = ['Pretendard-Regular','HakgyoansimWoojuR', 'GangwonState','SBAggroB','iceSotong-Rg'];
            $('#summernote').summernote({
                placeholder: '내용을 작성하세요',
                height: 400,
                maxHeight: 400,
                lang: 'ko-KR',
                fontNames: fontList,
                fontNamesIgnoreCheck: fontList,
                toolbar: [
        		    // 글꼴 설정
        		    ['fontname', ['fontname']],
        		    // 글자 크기 설정
        		    ['fontsize', ['fontsize']],
        		    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
        		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
        		    // 글자색
        		    ['color', ['forecolor','color']],
        		    // 표만들기
        		    ['table', ['table']],
        		    // 글머리 기호, 번호매기기, 문단정렬
        		    ['para', ['ul', 'ol', 'paragraph']],
        		    // 줄간격
        		    ['height', ['height']],
        		    // 그림첨부, 링크만들기, 동영상첨부
        		    ['insert',['picture','link','video']],
        		    // 코드보기, 확대해서보기, 도움말
        		    ['view', ['codeview','fullscreen', 'help']],
        		  ]
            });
            $('#summernote').summernote('fontName', 'Pretendard-Regular');
        });
</script>
                        </div>
                    </section>

                    <section class="writeButton">
                        <a href="#" class="confirm">등록</a>
                        <a href="#" class="cancel">취소</a>
                    </section>
                </div>


              
            </article> 
    </main>
<!-- 푸터 -->
    <footer id = "footer">
    	<%@include file="base/footer.jsp"%>
  </footer>
    </div>
</body>

</html>