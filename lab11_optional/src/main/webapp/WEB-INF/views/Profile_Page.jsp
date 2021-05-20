<%@page import="java.util.Iterator" %>
<%@page import="com.example.socialnetwork.entity.Profile_Bean" %>
<%@page import="com.example.socialnetwork.service.Profile_Modal" %>
<%@page import="java.util.List" %>
<%@page import="com.example.socialnetwork.entity.Post" %>
<%@ page import="com.example.socialnetwork.service.GetPostsService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%

    Profile_Bean obj_Profile_Bean = (Profile_Bean) session.getAttribute("fb_user_session");
%>

<center>

    <table border="1">
        <tr>
            <td colspan="2" align="center">
                <h2>Profile Page</h2>
            </td>

        </tr>
        <tr>
            <td align="center">
                <img src="<%=obj_Profile_Bean.getProfile_picture() %>"></img><br>
                Name : <%=obj_Profile_Bean.getUser_name() %><br>

                id : <%=obj_Profile_Bean.getId() %><br>
            </td>
            <td>
                <%
                    GetPostsService obj_Post_Modal = new GetPostsService();
                    List<Post> list_of_posts = obj_Post_Modal.call_me_to_get_posts(obj_Profile_Bean.getAccess_token());

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
            </td>

        </tr>

    </table>

</center>


</body>
</html>