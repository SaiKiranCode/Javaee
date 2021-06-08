package test;
import java.io.*;
import javax.servlet.*;
public class AddBookServlet  extends GenericServlet {
	public ServletContext sct;
	public BookBean bb;
	public void init() throws ServletException
	{
		sct=this.getServletContext();
		bb=new BookBean();
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String bcode=req.getParameter("bcode");
		String bname=req.getParameter("bname");
		String bauthor=req.getParameter("bauthor");
		float bprice=Float.parseFloat(req.getParameter("bprice"));
		int bqty=Integer.parseInt(req.getParameter("bqty"));
		String fname=(String)sct.getAttribute("fname");
		bb.setBcode(bcode);
		bb.setBname(bname);
		bb.setBauthor(bauthor);
		bb.setBprice(bprice);
		bb.setBqty(bqty);
		pw.println("welcome admin "+fname+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("link1.html");
		rd.include(req,res);
		AddBookDAO abd=new AddBookDAO();
		int z=abd.addBook(bb);
		if(z>0)
		{
			pw.println("<br>book added successfully");
		}
	}
}
