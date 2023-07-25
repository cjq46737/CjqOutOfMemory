<%@ page import="com.cjq.jvm.classloader.practice.remoteexecute.JavaClassExecuter" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.InputStream" %>
<%
    InputStream is = new FileInputStream(
            "/Users/chenjunqi/github/CjqOutOfMemory/out/production/CjqOutOfMemory/com/cjq/jvm/classloader/practice/remoteexecute/CjqCool.class");
    byte[] b = new byte[is.available()];
    is.read(b);
    is.close();
    //    OutputStream out = response.getOutputStream();
    out.println("<textarea style='width:1000;height=800'>");
    out.println(JavaClassExecuter.execute(b));
    out.println("</textarea>");
%>
