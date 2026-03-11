
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ArticleServlet extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException{

String title=req.getParameter("title");
String author=req.getParameter("author");
String category=req.getParameter("category");
String content=req.getParameter("content");

try{
Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement(
"insert into ARTICLES values(ARTICLE_SEQ.nextval,?,?,?,?)");
ps.setString(1,title);
ps.setString(2,author);
ps.setString(3,category);
ps.setString(4,content);
ps.executeUpdate();

res.getWriter().println("Article Published Successfully");
}catch(Exception e){System.out.println(e);}
}
}
