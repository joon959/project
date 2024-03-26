<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/style.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#left {
	width: 200px;
	height: 600px;
	float: left;
	border-right: 2px solid darkblue;
	margin-left: 50px;
}

#right {
	width: 900px;
	height: 600px;
	margin-left: 260px;
}

#bt {
	width: 180px;
	height: 40px;
}

</style>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<div>
		<div id="left">
			<button id="bt" type="button" class="btn btn-outline-primary"
				onclick="location.href='company_news_List.do?com_idx=${dto.getCom_idx()}';">목록</button>
			
			
			<div class="mt-3"><a href="company_news_List.do?com_idx=${dto.getCom_idx()}">회사소식</a> <br> <a href="company_event_List.do?com_idx=${dto.getCom_idx()}">경조사</a></div>
			
		</div>
		
		<form name="company_newsWrite" action="company_newsWrite.do" method="post">
		<input type="hidden" name="com_idx" value="${dto.getCom_idx()}">
		<div id="right"> 
		<div class="container">
		
		<div class="mt-5 mb-2"><span class="h4">회사소식 &gt;&gt; 게시글 작성</span></div>
		
		<div class="mb-2 d-flex gap-2">
		<input type="text" name="news_title" class="form-control" placeholder="제목" autocomplete="off" id="news_title">
		<input type="text" name="news_writer" class="form-control" placeholder="작성자" id="news_writer" value="${dto.getName()}">
		</div>
		
		
		 <div>
		 	<textarea id="summernote" name="news_content"></textarea>
		 </div>	
		 
		 <div class="mt-2 d-flex gap-2 justify-content-center">
		<button class="btn btn-primary" id="submit">저장</button>
		</div>
		
		</div>
  <script>
      $('#summernote').summernote({
        placeholder: '내용을 입력해 주세요.',
        tabsize: 2,
        height: 300,
        width :875,
        
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],      
          ['view', ['codeview', 'help']]
        ]
      });
      
      $('textarea[name="news_content"]').html($('.summernote').code());
    </script> 
		</div>
		</form>
		
	</div>

</body>
</html>