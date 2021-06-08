package test;
import java.io.*;
import javax.servlet.*;
public class RegServlet1 extends GenericServlet {
	public RegBean rb;
	public ServletContext sct;
	public void  init() throws ServletException
	{
		rb=new RegBean();
		sct=this.getServletContext();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		String uname=req.getParameter("uname");
		String pward=req.getParameter("pward");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		rb.setUname(uname);
		rb.setPward(pward);
		rb.setFname(fname);
		rb.setLname(lname);
		sct.setAttribute("beanref",rb);
		RequestDispatcher rd=req.getRequestDispatcher("register2.html");
		rd.forward(req,res);
	}
}
