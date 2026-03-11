
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException{

String username=req.getParameter("username");
String password=req.getParameter("password");

try{
Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement(
"select * from USERS where username=? and password=?");
ps.setString(1,username);
ps.setString(2,password);

ResultSet rs=ps.executeQuery();
if(rs.next()){
res.sendRedirect("dashboard.jsp");
}else{
res.getWriter().println("Invalid Login");
}
}catch(Exception e){System.out.println(e);}
}
}
