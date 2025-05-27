<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%
request.setCharacterEncoding("UTF-8"); //생성하는 parameter 에 한글이 포함되어 있다면 요청 시에 charset를 변경하여 전송 
String serverName=request.getServerName();
String movePage="eng.jsp";
String lang = "english";
//scope객체에 값을 설정하여 값을 전달할 수 있다.
request.setAttribute("ip",request.getRemoteAddr());
if("localhost".equals(serverName)){
	movePage="kor.jsp";
	lang="한국어";
}//end if
%>
<%-- parameter 없이 이동 <jsp:forward page="<%= movePage %>"/> --%>
<jsp:forward page="<%= movePage %>">
<jsp:param value="<%= lang %>" name="language"/>
</jsp:forward>