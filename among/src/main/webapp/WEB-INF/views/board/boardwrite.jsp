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
    <link  href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.js"></script>

    <!-- include summernote css/js -->
    <link  href="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/lang/summernote-ko-KR.js"></script>
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
		#timg {
		width: 80px; 
		height: 70px; 
		position: relative;
		top:-6px;
		}
    </style>
    <title>AMONG</title>
</head>

<body>
    <div class="container" style= "width: 100%; margin: 0; padding: 0;">
<!-- 헤더  -->     
<header style="text-decoration:none;">
            <%@include file="../base/header.jsp"%>
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
                                <section class="writeButton">
				                        <input type = "submit" class="confirm" value="등록">
				                        <input type = "reset" class="cancel" value="취소">
                   			 	</section>
                            </form>
        <script>
			$(document).ready(function () {
		        	var fontList = ['Pretendard-Regular','HakgyoansimWoojuR', 'GangwonState','SBAggroB','iceSotong-Rg'];
		            $('#summernote').summernote({
		                placeholder: '내용을 작성하세요',
		                height: 400,
		                maxHeight: 400,
		                focus: true, 
		                lang: 'ko-KR',
		                toolbar: [
		                	 ['Font Style', ['fontname']],
		                	 ['fontsize', ['fontsize']],
		                     ['style', ['bold', 'italic', 'underline']],
		                     ['font', ['strikethrough']],                  
		                     ['color', ['color']],
		                     ['para', ['paragraph']],
		                     ['height', ['height']],
		                     ['Insert', ['picture']],
		                     ['Insert', ['link']],
		                     ['Misc', ['fullscreen']]
		        		  ],
		            	fontNames: fontList,
		            	fontNamesIgnoreCheck: fontList,
		            });
		            $('#summernote').summernote('fontName', 'Pretendard-Regular');
		      });
</script>
                        </div>
                    </section>

                    
                </div>


              
            </article> 
    </main>
<!-- 푸터 -->
    <footer id = "footer">
    	<%@include file="../base/footer.jsp"%>
  </footer>
    </div>
</body>

</html>