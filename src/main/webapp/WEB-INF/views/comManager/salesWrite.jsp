<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="newTel.do">
<h1>회원 수정</h1>
<hr>
<table style="width:800px">

<tr>
	<th style="width:100px; height: 50px;">기업명</th>
	<td><input class="text2" type="text" name="com_name"></td>
</tr>
<tr>
	<th style="width:100px; height: 50px;">대표자</th>
	<td><input class="text2" type="text" name="ceo"></td>
</tr>
<tr>
	<th style="width:100px; height: 50px;">기업명</th>
	<td><input class="text2" type="text" name="tel"></td>
</tr>
</table>
<input type="hidden" value="${cdto.com_idx }">
</form>