<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="주석 사용"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- favicon 설정 -->
<link rel="shortcut icon" href="http://192.168.10.70/jsp_prj/common/images/favicon.ico"/>
<!--  bootstrap CDN -->
<link rel="stylesheet" type="text/css"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<style type="text/css">
 #container{ min-height: 600px; margin-top: 30px; margin-left: 20px}
</style>
<!-- jquery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script type="text/javascript">
$(function(){
	
});//ready


</script>
</head>
<body>
<% 
//Java 주석
String name="이장훈";
%>
<!-- HTML 주석 : JSP > Java > class > instance 생성 > HTML로 만들어진다. -->
<!-- Java 주석 : JSP > Java > class에 포함되지 x > instance 생성 x > HTML로 만들어지지 않는다. -->
<!-- JSP 주석 : JSP > Java 포함 x> class에 포함되지 x > instance 생성 x > HTML로 만들어지지 않는다. -->
HTML 주석 : <!-- <%= name %> --><br>
Java 주석 : <!-- <%=/*이것은 이름변수임 */ name %> --><br>
JSP 주석 : <%-- <%=name %> --%>
<main>
<div id="container">
<ul>
<li>URL : <%= request.getRequestURL() %></li>
<li>URI : <%= request.getRequestURI() %></li>
</ul>
</div>
</main>
<footer class="text-body-secondary py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#">Back to top</a>
    </p>
    <p class="mb-1"><strong style="font-size: 18px">2강의실</strong> 서울특별시 강남구 테헤란로 132(역삼동) 한독약품빌딩 8층 쌍용교육센터 <strong>Tel_02-3482-4632~5</strong> </p>
  </div>
</footer>


</body>
</html>