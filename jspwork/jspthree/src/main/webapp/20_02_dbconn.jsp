<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
Connection conn = null;
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "test";
String password = "1111";

Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(url, user, password);
%>