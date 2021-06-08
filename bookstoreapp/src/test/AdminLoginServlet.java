package test;
import java.io.*;
import javax.servlet.*;
public class AdminLoginServlet extends GenericServlet {
	public ServletContext sct;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uname=req.getParameter("uname");
		String pward=req.getParameter("pward");
		String submit=req.getParameter("s1");
		LoginDAO id=new LoginDAO();
		boolean k=id.validate(uname,pward,submit, sct);
		if(k)
		{
			String fname=(String)sct.getAttribute("fname");
			pw.println("welcome admin :"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req,res);
		}
		else
		{
			pw.println("invalid username or passward<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
			rd.include(req,res);
			
		}
	}

}
