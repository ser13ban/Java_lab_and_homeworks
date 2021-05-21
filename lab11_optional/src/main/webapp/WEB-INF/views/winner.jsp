<%@ page import="com.example.socialnetwork.service.GetCommentsService" %>
<%@ page import="com.example.socialnetwork.entity.Comment" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Comments</title>
</head>
<body>
AND THE WINNER YOUR YOUR GIVEAWAY IS: <br><hr>
<!-- this is were I want to take the photos of-->
<%
    String token  = (String) request.getAttribute("token");
    String postId  = (String) request.getAttribute("id");GetCommentsService commentsService = new GetCommentsService();
    List<Comment> commentList =  commentsService.call_me_to_get_comments(postId,token);
    Comment winner = commentsService.getWinner(commentList);
%>
<%=winner.getName()%><br>
<%=winner.getMessage()%><br>
<%=winner.getCreated_time()%><br>
</body>
</html>