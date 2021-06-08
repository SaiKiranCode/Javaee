package test;
import java.sql.*;
public class RegisterDAO {
	public int k;
	public int register(RegBean rb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into userreg20 values(?,?,?,?,?,?,?)");
			ps.setString(1,rb.getUname());
			ps.setString(2,rb.getPward());
			ps.setString(3,rb.getFname());
			ps.setString(4,rb.getLname());
			ps.setString(5,rb.getAddr());
			ps.setLong(6,rb.getPhno());
			ps.setString(7,rb.getMid());
			k=ps.executeUpdate();
		}
		catch(Exception e) { e.printStackTrace();}
		return k;
	}
}
