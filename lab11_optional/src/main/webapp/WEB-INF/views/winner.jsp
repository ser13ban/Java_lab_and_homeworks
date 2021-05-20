<%@page import="com.example.socialnetwork.entity.Profile_Bean"%>
<%@page import="com.example.socialnetwork.service.Profile_Modal"%>
<%@ page import="com.example.socialnetwork.service.GetPostsService" %>
<%@ page import="com.example.socialnetwork.service.GetCommentsService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Comments</title>
</head>
<body>
AND THE WINNER YOUR YOUR GIVEAWAY IS:
<!-- this is were I want to take the photos of-->
<%
    String token  = (String) request.getAttribute("token");
    String postId  = (String) request.getAttribute("id");
    //TODO  chose a random comment and output to the user

%>
</body>
</html>