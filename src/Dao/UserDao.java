package Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Model.User;

public class UserDao {

	String url = "jdbc:mysql://localhost:3306/JSP_CRUD";
	String uname = "root";
	String upass = "abc123";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	Connection con;
	
	private Connection getconnect() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uname,upass);
		return con;
		
	}
	
	public int insert(User u) throws ClassNotFoundException, SQLException
	{
		String sql = "insert into jsp(uname, email, pass) values (?,?,?)";
		con = getconnect();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, u.getUname());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPass());
		
		int a = ps.executeUpdate();
		con.close();
		return a;
		
	}
	
	
	public List<User> getallUser() throws ClassNotFoundException, SQLException
	{
		String sql = "select * from jsp";
		con = getconnect();
		java.sql.Statement st =  con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<User> le = new  ArrayList<User>();
		while(rs.next())
		{
			User e = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			
			le.add(e);
			
		}
		return le;
	}
	
	

    public User getoneUser(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM jsp WHERE id = ?";
        Connection con = getconnect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int userId = rs.getInt("id");
            String username = rs.getString("uname");
            String email = rs.getString("email");
            String password = rs.getString("pass");

            return new User(userId, username, email, password);
        } else {
            return null; // User not found
        }
    }
    
    public int update(User u) throws ClassNotFoundException, SQLException
    {
    	
    	Connection con =getconnect();
    	PreparedStatement ps = con.prepareStatement("update jsp set uname=?, email = ?, pass = ? where id = ?");
    	ps.setString(1, u.getUname());
    	ps.setString(2, u.getEmail());
    	ps.setString(3, u.getPass());
    	ps.setInt(4, u.getId());
    	
    	int a = ps.executeUpdate();
    	con.close();
    	
		return a;
    }
    
    public int delete(int id) throws ClassNotFoundException, SQLException{
    	Connection con = getconnect();
    	PreparedStatement ps = con.prepareStatement("delete from jsp where id =?");
    	
    	ps.setInt(1, id);
    	int a = ps.executeUpdate();
    	con.close();
		return a;
    	
    	
    }
	
}
