package test;
import java.io.*;
import javax.servlet.*;
public class RegServlet2  extends GenericServlet{
	public RegBean rb;
	public ServletContext sct;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("beanref");
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String addr=req.getParameter("addr");
		long phno=Long.parseLong(req.getParameter("phno"));
		String mid=req.getParameter("mid");
		rb.setAddr(addr);
		rb.setPhno(phno);
		rb.setMid(mid);
		pw.println("your registration details are valid");
		pw.println("<a href='dis'> click</a>");
		pw.println("to view full registration details");
	
	}
}
