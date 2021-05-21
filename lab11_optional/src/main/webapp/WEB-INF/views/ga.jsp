<%@page import="com.example.socialnetwork.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.socialnetwork.service.GetPostsService" %>
<%@ page import="java.util.Map" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<script>
    function formHandler(ID, token) {
        //document.getElementById("link2").href = "/firstAPIcall?token=" + token + "?link="+fLink;
        window.location.href="/giveaway/getWinner/" + ID + "/" + token;
    }
</script>

<h2>
    This is the GiveAway page, you will have to chose one of you posts and we will give you one winner from youre comments
    <br>
    <br>
    <hr>
    <!-- In this page I want to display to the first 10-->
    <%
        String token  = (String) request.getAttribute("token");
        GetPostsService obj_Post_Modal = new GetPostsService();
        List<Post> list_of_posts = obj_Post_Modal.call_me_to_get_posts(token);
        Iterator<Post> it_list_of_posts = list_of_posts.iterator();
        if (list_of_posts.size() > 0) {
            Post obj_Post_Use_Bean = new Post();
            while (it_list_of_posts.hasNext()) {
                obj_Post_Use_Bean = it_list_of_posts.next();


    %>
    <%=obj_Post_Use_Bean.getMessage() %><br>
    <%=obj_Post_Use_Bean.getCreated_time() %><br>
    <br>
    <form action="javascript:void(0);" onsubmit='formHandler( "<%=obj_Post_Use_Bean.getId()%>", "<%=(String) request.getAttribute("token")%>")'>
        <input type="submit" value="Get winner">
    </form>
    <hr>
    <%
            }
        }
    %>
</h2>
</body>
</html>