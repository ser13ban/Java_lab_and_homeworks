
<%@page import="com.example.socialnetwork.entity.Profile_Bean"%>
<%@page import="com.example.socialnetwork.service.Profile_Modal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    String access_token=(String)request.getParameter("access_token");
    Profile_Modal obj_Profile_Modal=new Profile_Modal();
    Profile_Bean obj_Profile_Bean= obj_Profile_Modal.call_me(access_token);
    obj_Profile_Bean.setAccess_token(access_token);
    session.setAttribute("fb_user_session", obj_Profile_Bean);
%>
<script type="text/javascript">
    window.location.href="Profile_Page";
</script>
</body>
</html>