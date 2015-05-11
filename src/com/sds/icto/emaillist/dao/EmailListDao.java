package com.sds.icto.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.emaillist.vo.EmailListVo;

public class EmailListDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dburl="jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn=DriverManager.getConnection(dburl,"webdb","webdb");
		return conn;
	}
	
	public void insert(EmailListVo vo) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="INSERT INTO EMAIL_LIST VALUES(email_list_no_seq.nextval, ?, ?, ?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getFirstName());
		pstmt.setString(2, vo.getLastName());
		pstmt.setString(3, vo.getEmail());
		pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();					
		if(conn!=null) conn.close();
	}
	
	public void delete(Long no) throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="DELETE FROM EMAIL_LIST WHERE NO = ?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setLong(1, no);
		pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();					
		if(conn!=null) conn.close();
	}
	
	public void delete() throws ClassNotFoundException, SQLException{
		Connection conn=getConnection();
		String sql="DELETE FROM EMAIL_LIST";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();					
		if(conn!=null) conn.close();
		
	}
	
	public List<EmailListVo> fetchList() throws ClassNotFoundException, SQLException{
		List<EmailListVo> list=new ArrayList<EmailListVo>();
		Connection conn=getConnection();
		String sql="SELECT * FROM EMAIL_LIST";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			long no=rs.getLong(1);
			String firstname=rs.getString(2);
			String lastname=rs.getString(3);
			String email=rs.getString(4);
			EmailListVo vo=new EmailListVo();
			vo.setNo(no);
			vo.setFirstName(firstname);
			vo.setLastName(lastname);
			vo.setEmail(email);
			list.add(vo);
		}
		if(rs!=null) rs.close();					
		if(stmt!=null) stmt.close();					
		if(conn!=null) conn.close();
		return list;
	}
	
}
