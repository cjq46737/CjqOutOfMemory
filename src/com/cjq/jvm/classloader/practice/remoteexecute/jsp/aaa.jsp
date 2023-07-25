<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE HTML PUBLIC “-//W3C//DTD HTML 4.0 Transitional//EN”>
<HTML>
<HEAD>
    <TITLE>第一个cjq JSP页面</TITLE>
</HEAD>
<BODY>

<%
    for (int i = 0; i < 10; i++) {
        out.println(i);
%>
<br>
<%}%>
</BODY>
</HTML>
