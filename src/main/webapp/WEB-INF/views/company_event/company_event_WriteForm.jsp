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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('sample4_postcode1').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
               // document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script>
function sb(event) {
	// addr1 = document.getElementById('sample4_postcode').value;
	var addr2 = document.getElementById('sample4_roadAddress').value;
	//var addr3 = document.getElementById('sample4_jibunAddress').value;
	var addr4 = document.getElementById('sample4_detailAddress').value;
	var addr5 = document.getElementById('sample4_extraAddress').value;
	//var fullAddr = addr2 + '/' + addr3 + '/' + addr4 + '/' + addr5;
	var fullAddr = addr2 + '/'+ addr4 + '/' + addr5;
	document.getElementById('event_addr').value = fullAddr;
	document.getElementById('event_addr').submit();
}
</script>
</head>
<body>
	<div>
		<div id="left">
			<button id="bt" type="button" class="btn btn-outline-primary"
				onclick="location.href='company_event_List.do?com_idx=${dto.getCom_idx()}';">목록</button>
			
			
			<div class="mt-3"><a href="company_news_List.do?com_idx=${dto.getCom_idx()}">회사소식</a> <br> <a href="company_event_List.do?com_idx=${dto.getCom_idx()}">경조사</a></div>
			
		</div>
		
		<form name="company_eventWrite" action="company_eventWrite.do" method="post" onsubmit="sb()">
		
		<input type="hidden" name="com_idx" value="${dto.getCom_idx()}">
		<input type="hidden" id="event_addr" name="event_addr">
	
		<div id="right"> 
		<div class="container">
		
		<div class="mt-5 mb-2"><span class="h4">경조사 &gt;&gt; 게시글 작성</span></div>
		
		<div class="mb-2 d-flex gap-2">
		<input type="text" name="event_title" class="form-control" placeholder="제목" autocomplete="off" id="event_title">
		<input type="text" name="event_writer" class="form-control" placeholder="작성자" id="event_writer" value="${dto.getName()}">
		</div>
		

		<div class="mb-2 d-flex gap-2">
		<input type="button" class="btn btn-outline-primary" onclick="sample4_execDaumPostcode()" value="주소검색">
		<input type="text" class="form-control" id="sample4_roadAddress" name="addr2" placeholder="도로명주소">
		
		<span id="guide" style="color:#999;display:none"></span>
		</div>
		<div class="mb-2 d-flex gap-2">
		<input type="text" class="form-control" id="sample4_detailAddress" name="add4" placeholder="상세주소">
		<input type="text" class="form-control" id="sample4_extraAddress" name="addr5" placeholder="참고항목">
		</div>

		 <div>
		 	<textarea id="summernote" name="event_content"></textarea>
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