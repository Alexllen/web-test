package com.dao;
import com.po.*;
import java.text.*;
import java.sql.*;
import java.util.Date;
public class userDao {
	public boolean isUser(User user){
		boolean isuser=false;
		String tbName="webuser";
		String sql="select * from "+tbName;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				if(user.getId().equals(rs.getString("id")))
					if(user.getPassword().equals(rs.getString("password"))){
						user.setUsername(rs.getString("name"));
						user.setLastip(rs.getString("lastip"));
						user.setLastdate(rs.getString("lastlogindate"));
						isuser=true;
						break;
						}
				}
			}
		catch(SQLException  e){
			e.printStackTrace();
		}
		finally{
			try{
				if (rs!=null) rs.close();
				if (ps!=null) ps.close();
				if (conn!=null) conn.close();
				}
			catch(SQLException e){
				e.printStackTrace();
				}
		}
		return isuser;
	}
	public void update(User user,String nowip){
		String tbName="webuser";
		String sql="update "+tbName+" set lastlogindate=?,lastip=? where id=?";
		Connection conn=null;
		PreparedStatement ps=null;
		conn=getConn();
		try{
			ps=conn.prepareStatement(sql);
			Date now=new Date();
			 SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
			 ps.setString(1, sdf.format(now));
			 ps.setString(2, nowip);
			 ps.setString(3, user.getId());
			 ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public Connection getConn(){
		String driverName="com.mysql.jdbc.Driver";
		String userName="root";
		String passWord="";
		String dbName="data";
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/"+dbName+
				"?useUnicode=true&characterEncoding=UTF-8";
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url,userName, passWord);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
