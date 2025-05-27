<%@page import="kr.co.sist.member.login.LoginResultDTO"%>
<%@page import="kr.co.sist.member.login.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%
//세션에 존재하는 값 얻기
//String name=(String)session.getAttribute("name");
Object obj= session.getAttribute("userData");
if(obj == null){
	//세션에 값이 없다면 페이지를 이동.
	response.sendRedirect("http://192.168.10.69/jsp_prj/index.html");
	return;
}//end if
LoginResultDTO lDTO = (LoginResultDTO)obj;
%>