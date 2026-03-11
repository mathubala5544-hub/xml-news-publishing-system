
<%@ page import="java.sql.*" %>
<html>
<body>
<h2>Published News</h2>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","password");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from ARTICLES");
while(rs.next()){
%>
<h3><%=rs.getString("TITLE")%></h3>
Author: <%=rs.getString("AUTHOR")%><br>
Category: <%=rs.getString("CATEGORY")%><br>
<p><%=rs.getString("CONTENT")%></p>
<hr>
<% } %>
</body>
</html>
