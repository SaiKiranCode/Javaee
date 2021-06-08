package test;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class ViewBooksServlet2 extends GenericServlet {
	public Connection con;
	public void init() throws ServletException
	{
		con=DBConnection.getCon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct=this.getServletContext();
		String fname=(String)sct.getAttribute("fname");
		pw.println("welcome user :"+fname+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("link2.html");
		rd.include(req,res);
		try
		{	
			PreparedStatement ps=con.prepareStatement("select * from book20");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				pw.println("<br>"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getFloat(4)+"&nbsp&nbsp"+rs.getInt(5));
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
