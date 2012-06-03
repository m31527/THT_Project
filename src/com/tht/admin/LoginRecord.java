package com.tht.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.util.ConnectionDB;

public class LoginRecord {

	public LoginRecord() {

	}

	private Long record_id;
	private String user_name;
	private String login_time;
	private java.util.Date today=new java.util.Date();

	public Long getRecord_id() {
		return record_id;
	}

	public void setRecord_id(Long record_id) {
		this.record_id = record_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	
	
	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public java.util.Date getToday() {
		return today;
	}

	public void setToday(java.util.Date today) {
		this.today = today;
	}

	public void save(LoginRecord[] bean) throws Exception, SQLException {
		Connection con = null;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			save(bean, con);
			con.commit();
		} catch (SQLException e) {
			if (con != null)
				con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}

	}

	/**
	 * @return save people
	 */

	public void save(LoginRecord[] bean, Connection con) throws Exception,
			SQLException {
		String sql = "insert into loginrecord (user_name,login_time) values (?,?)";
		for (int i = 0; i < bean.length; i++) {

			PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bean[i].getUser_name());
			ps.setString(2,	today.toString());
			ps.executeUpdate();
			ps.close();

		}
	}
	
	public static void main(String[] args){
		ArrayList<LoginRecord> list=new ArrayList<LoginRecord>();
		LoginRecord bean=new LoginRecord();
		bean.setUser_name("test");
		list.add(bean);
		try {
			bean.save(list.toArray(new LoginRecord[]{}));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
