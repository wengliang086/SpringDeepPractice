<%@ page import="com.my.test.web.TestServlet" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    TestServlet testServlet = new TestServlet();
    System.out.println(testServlet.getString());
%>
</body>
</html>
