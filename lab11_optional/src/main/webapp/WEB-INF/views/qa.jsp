<%@page import="com.example.socialnetwork.entity.Post" %>
<%@page import="com.example.socialnetwork.service.Profile_Modal" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.socialnetwork.service.GetPostsService" %>
<%@ page import="com.example.socialnetwork.entity.Profile_Bean" %>
<%@ page import="java.util.Map" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>
    This is the Q&A page you will have to chose one of your posts
    <br>
    <!-- In this page I want to display to the first 10-->
    <%
        String token  = (String) request.getAttribute("token");
        Profile_Bean obj_Profile_Bean = (Profile_Bean) session.getAttribute("fb_user_session");
        GetPostsService obj_Post_Modal = new GetPostsService();
        List<Post> list_of_posts = obj_Post_Modal.call_me_to_get_posts(token);
        Iterator<Post> it_list_of_posts = list_of_posts.iterator();
        if (list_of_posts.size() > 0) {
            Post obj_Post_Use_Bean = new Post();
            while (it_list_of_posts.hasNext()) {
                obj_Post_Use_Bean = it_list_of_posts.next();


    %>
    <%=obj_Post_Use_Bean.getId() %><br>
    <%=obj_Post_Use_Bean.getMessage() %><br>
    <%=obj_Post_Use_Bean.getCreated_time() %><br>
    <hr>
    <%
            }
        }
    %>
</h2>
</body>
</html>