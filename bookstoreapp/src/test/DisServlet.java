package test;
import java.io.*;
import javax.servlet.*;
public class DisServlet extends GenericServlet {
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
		pw.println("username :"+rb.getUname());
		pw.println("<br>passward :"+rb.getPward());
		pw.println("<br>firstname :"+rb.getFname());
		pw.println("<br>lastname :"+rb.getLname());
		pw.println("<br>address :"+rb.getAddr());
		pw.println("<br> phno :"+rb.getPhno());
		pw.println("<br>mailid :"+rb.getMid());
		pw.println("<br>");
		pw.println("<form action='final' method='post'>");
		pw.println("<input type='submit' value='register'>");
		pw.println("</form>");
	}
}
