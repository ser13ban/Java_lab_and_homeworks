<%@ page import="com.example.socialnetwork.service.GetCommentsService" %>
<%@ page import="com.example.socialnetwork.entity.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.socialnetwork.service.GetCommentsQaService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Comments</title>
</head>
<body>
RANDOM COMMENT: <br><hr>
<%

    String token  = (String) request.getAttribute("token");
    String postId  = (String) request.getAttribute("id");

    GetCommentsQaService commentsService = new GetCommentsQaService();
    List<Comment> commentList = null;

    try {
    commentList = commentsService.qaComments(postId,token);
    } catch (Exception e) {
    e.printStackTrace();
    }
    Comment randomComment = commentsService.randomComment(commentList);
%>

    <h3><%=randomComment.getName()%></h3>
    <h3><%=randomComment.getMessage()%></h3>

</body>
</html>