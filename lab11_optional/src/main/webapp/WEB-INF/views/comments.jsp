<%@ page import="com.example.socialnetwork.service.GetCommentsService" %>
<%@ page import="com.example.socialnetwork.entity.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.socialnetwork.service.GetCommentsQaService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Comments</title>
    <style type="text/css">
        .boolean{
            width: 50px;
            height: 50px;
        }
        .answered{
            background: lawngreen;

        }
        .notAnswered{
            background: lightcoral;
        }
    </style>
    <script type="application/javascript" defer>
        function changeBack(bool,id){
            console.log(bool);
            console.log(id)
            if (bool == false){
                document.getElementById(id).classList.remove("notAnswered")
                document.getElementById(id).classList.add("answered");
            }else{
                document.getElementById(id).classList.remove("answered")
                document.getElementById(id).classList.add("notAnswered");
            }

        }
    </script>
</head>
<body>
    THIS IS THE COMMENTS PAGE
    <br><hr>
    <!-- this is were I want to take the photos of-->
<%
    String token  = (String) request.getAttribute("token");
    String postId  = (String) request.getAttribute("id");
    GetCommentsQaService commentsService = new GetCommentsQaService();
    List<Comment> commentList =  commentsService.qaComments(postId,token);

    Iterator<Comment> comments = commentList.iterator();

    if (commentList.size() > 0) {

        Comment comment = new Comment();
        String id="0";
        while (comments.hasNext()) {
            id+="0";
            comment = comments.next();
%>
            <%=comment.getName() %><br>
            <%=comment.getMessage() %><br>
            <%=comment.getCreated_time() %><br>
            <button id="bool<%=id%>" class="notAnswered boolean"  onclick='changeBack(<%=comment.getAnswered()%>,"bool<%=id%>")'>
            </button>


    <hr>
    <%

            }
        }

    %>

</body>
</html>