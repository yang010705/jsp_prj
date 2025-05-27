<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2025년 4월 달력</title>

<!-- favicon 설정 -->
<link rel="shortcut icon" href="http://192.168.10.70/jsp_prj/common/images/favicon.ico"/>
<!--  bootstrap CDN -->
<link rel="stylesheet" type="text/css"
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<style type="text/css">
 th{border:1px solid #333; width:50px; height: 30px;}
 td{border:1px solid #333; width:50px; height: 30px;}
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
	Calendar cal = Calendar.getInstance();
	cal.set(2025, 3, 1); // 2025년 4월 1일

	int firstDay = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 달의 마지막 날
	String[] day = {"일", "월", "화", "수", "목", "금", "토"};
	int count = 0;
%>

<div id="calendarWrap">
  <div id="calendarHeader">
    <h1>2025년-4</h1>
  </div>
  <div id="calendarContainer">
    <table>
      <thead>
        <tr>
          <% for(int i = 0; i < 7; i++) { %>
            <th><%= day[i] %></th>
          <% } %>
        </tr>
      </thead>
      <tbody>
        <tr>
          <% 
            // 첫 번째 요일까지 빈 셀을 추가
            for(int i = 1; i < firstDay; i++) { 
          %>
            <td></td>
          <% 
            count++; 
            }
            // 실제 날짜를 출력
            for(int i = 1; i <= lastDay; i++) { 
          %>
            <td 
                <% 
                  // 토요일은 파란색, 일요일은 빨간색으로 날짜 글씨 색상 지정
                  if (count % 7 == 1) { // 일요일
                %>
                  style="color: red;"
                <% 
                  } else if (count % 7 == 0) { // 토요일
                %>
                  style="color: blue;"
                <% 
                  } 
                %>
            >
              <%= i %>
            </td>
            <% count++; %>
            
            <% 
              // 주의 마지막 날인 경우 줄바꿈
              if(count % 7 == 0) {
            %>
              </tr><tr>
            <% 
              }
            }
            // 마지막 주에 빈 칸을 채우는 부분
            while(count % 7 != 0) { 
            %>
              <td></td>
            <% 
              count++;
            }
          %>
        </tr>
      </tbody>
    </table>
  </div>
</div>

</body>
</html>
