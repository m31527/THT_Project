package com.tht.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.ConnectionDB;

public class Permissions {

	private long user_id;
	private String user_name;
	private String user_password;
	/*
	 * state type=1 最高權限(administrator) type=1 最高權限(write & read) type=1 最高權限
	 * (read)
	 */
	private int user_type;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	
	public boolean login(String user_name,String user_password) throws Exception {
		Connection con = null;
		boolean state=false;
		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from permissions where user_name=? and user_password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, user_password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				if(rs.getLong("user_id")!=0){
					state=true;
				}
			}
			ps.close();
		}

		catch (SQLException e) {
			if (con != null)
				con.rollback();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}

		return state;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Permissions bean=new Permissions();
		try {
			System.out.println(bean.login("m31527", "ssds"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
