package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class LoginDAO {
	public boolean z;
	public boolean validate(String uname,String pward,String name,ServletContext sct)
	{
		try
		{ 
			Connection con=DBConnection.getCon();
			if(name.equals("userlogin"))
			{
				PreparedStatement ps=con.prepareStatement("select * from userreg20 where uname=? and pward=?");
				ps.setString(1,uname);
				ps.setString(2,pward);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					z=true;
					sct.setAttribute("fname",rs.getString(3));
				}
			
			}
			else
			{
				PreparedStatement ps=con.prepareStatement("select * from admin20 where uname=?and pward=?");
				ps.setString(1,uname);
				ps.setString(2,pward);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					z=true;
					sct.setAttribute("fname",rs.getString(3));
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return z;
	}
}
