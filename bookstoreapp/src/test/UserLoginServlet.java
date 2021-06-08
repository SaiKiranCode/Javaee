package test;
import java.io.*;
import javax.servlet.*;
public class UserLoginServlet extends GenericServlet{
	public ServletContext sct;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pward=req.getParameter("pward");
		String submit=req.getParameter("s1");
		LoginDAO ld=new LoginDAO();
		boolean z=ld.validate(uname, pward,submit, sct);
		if(z)
		{ 
			String fname=(String)sct.getAttribute("fname");			
		
		pw.println("welcome user:"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link2.html");
			rd.include(req,res);
		
		}
		else
		{
			pw.println("invalid username or passward");
			RequestDispatcher rd=req.getRequestDispatcher("ULogin.html");
			rd.include(req,res);
		}
		
	}
}
