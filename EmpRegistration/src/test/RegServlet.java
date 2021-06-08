package test;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
public class RegServlet extends GenericServlet {
	public Connection con;
	public void init() throws ServletException
	{
		con=DBConnection.getCon();

	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		StringJoiner sj1=new StringJoiner(",");
		StringJoiner sj2=new StringJoiner("/");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		
		String gen=req.getParameter("gen");
		String lang[]=req.getParameterValues("lang");
		for(String i: lang)
		{
			sj1.add(i);
		}
		String day=req.getParameter("days");
		sj2.add(day);
		String month=req.getParameter("month");
		sj2.add(month);
		String year=req.getParameter("years");
		sj2.add(year);
		String addr=req.getParameter("addr");
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into empreg20 values(?,?,?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,gen);
			ps.setString(4,sj1.toString());
			ps.setString(5,sj2.toString());
			ps.setString(6,addr);
			int k=ps.executeUpdate();
			if(k>0)
			{
				pw.println("registration sucessfull");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
