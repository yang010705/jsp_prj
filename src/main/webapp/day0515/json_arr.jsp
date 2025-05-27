<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%
String name = "이장훈";
int age = 25;

String name2 = "주현석";
int age2 = 26;

//1. JSONArray 생성 ) [ ]
	JSONArray jsonArr = new JSONArray();

//2. data 를 사용하여 JSONObject 생성
	JSONObject jsonObj = new JSONObject();
	jsonObj.put("name", name);
	jsonObj.put("age", age);
	
	JSONObject jsonObj2 = new JSONObject();
	jsonObj2.put("name2", name2);
	jsonObj2.put("age2", age2);
	
//3. JSONObject 를 JSONArray 배치
	jsonArr.add(jsonObj);
	jsonArr.add(jsonObj2);
	
//4. JSONArray 값을 출력
	String strJSON = jsonArr.toJSONString();
%>
<%= strJSON %>