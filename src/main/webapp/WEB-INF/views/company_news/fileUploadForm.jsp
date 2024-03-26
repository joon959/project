<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="fileUpload" action="fileUpload.do" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<ul>
				<li><label>파일선택</label><input type="file" name="news_file"></li>
			</ul>
			<div>
				<input type="submit" value="파일올리기">
			</div>
		</fieldset>
	</form>
</body>
</html>