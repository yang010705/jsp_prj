<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/jsp/external_file.jsp"/>


<style type="text/css">
 #container{ min-height: 600px; margin-top: 30px; margin-left: 20px}
</style>
 
<script type="text/javascript">
$(function(){
	
});//ready


</script>
</head>
<body>
<header data-bs-theme="dark">
 <jsp:include page="../common/jsp/header.jsp"/>
</header>
<main>
<div id="container">
아이디 : <%= request.getParameter("id") %><br>
비밀번호 : <%= request.getParameter("pass") %><br>
이름 : <%= request.getParameter("name") %><br>
생일 : <%= request.getParameter("birth") %><br>
연락처 : <%= request.getParameter("num") %><br>
휴대폰 : <%= request.getParameter("phoneNum") %><br>
수신 : <%= request.getParameter("chk1") %><br>
이메일 : <%= request.getParameter("mail1") %><br>
이메일 : <%= request.getParameter("mail2") %><br>
수신 : <%= request.getParameter("chk2") %><br>
성별 : <%= request.getParameter("gender") %><br>
소재지 : <%= request.getParameter("domain") %><br>
우편번호 : <%= request.getParameter("addNum") %><br>
주소 : <%= request.getParameter("add") %><br>
주소 : <%= request.getParameter("add2") %><br>
자기소개 : <%= request.getParameter("self") %><br>
</div>
</main>
<footer class="text-body-secondary py-5">	````
 <jsp:include page="../common/jsp/footer.jsp"/>
 
</footer>


</body>
</html>