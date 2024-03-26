<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.getName()} 님의 aceworks</title>
<link rel="stylesheet" type="text/css" href="css/comManagerLayout.css">
<script src="js/httpRequest.js"></script>
<script>
function show(){
	var a = 'com_idx='+'${cdto.com_idx}';
	sendRequest('comNews3.do',a,showResult1,'GET');			
}
function showResult1(){
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data = XHR.responseText;
			var divNode = document.all.news;
				divNode.innerHTML = '';
				divNode.innerHTML = data;
				var a = 'com_idx='+'${cdto.com_idx}';
				sendRequest('comEvent3.do',a,showResult2,'GET');	
		}		
	}
}
function showResult2(){
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data = XHR.responseText;
			var divNode = document.all.event;
				divNode.innerHTML = '';
				divNode.innerHTML = data;
		}		
	}
}
</script>
</head>
<body onload="show()">
<c:if test="${dto.rank_num == 0 || dto.rank_num == null}">
<script>
	window.alert('승인이 필요합니다.\n자동 로그아웃 됩니다.');
	location.href='logout.do';
</script>
</c:if>
<c:if test="${dto.rank_num == 1}">
<script>
	window.alert('관리자입니다.');
	location.href='main_admin.do';
</script>
</c:if>
<c:if test="${dto.rank_num != 0}">
<h5>${dto.getName()} 님 접속 중 | <a class="logout" href="logout.do">로그아웃</a></h5>
<div class="divcen">
<a href="goMain.do">
			<img src="img/${cdto.com_name}/${cdto.com_img}"></a><br>
			<br><hr><br>
<a class="link" href="company_news_List.do?com_idx=${dto.getCom_idx()}">회사소식</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a class="link" href="company_event_List.do?com_idx=${dto.getCom_idx()}">경조사</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a class="link" href="#">결재문서</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a class="link" href="schedule.do">스케줄</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a class="link" href="#">인사관리</a>&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${dto.rank_num == 2}">
	<a class="link" href="companyManager.do">기업관리</a>
</c:if>
</div>
<div align="center">
<div id="news" style="display: inline-block"></div>
<div id="event" style="display: inline-block"></div>
</div>
</c:if>
</body>
</html>