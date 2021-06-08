package test;
import java.io.*;
import javax.servlet.*;
public class LoginServlet extends GenericServlet {
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
	String submit=req.getParameter("s1");
	if(submit.equals("admin"))
	{
		RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
		rd.forward(req,res);
	}
	else
	{
		RequestDispatcher rd=req.getRequestDispatcher("ULogin.html");
		rd.forward(req,res);
	}
}
}
