package com.tht.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.ConnectionDB;

public class Active {

	public Active() {

	}

	private Long active_id;
	private Date active_create_date;
	private int active_kind_id;
	private String active_note;
	private Long people_id;
	private int active_bido_id;

	public Long getActive_id() {
		return active_id;
	}

	public void setActive_id(Long activeId) {
		active_id = activeId;
	}

	public Date getActive_create_date() {
		return active_create_date;
	}

	public void setActive_create_date(Date activeCreateDate) {
		active_create_date = activeCreateDate;
	}

	public String getActive_note() {
		return active_note;
	}

	public void setActive_note(String activeNote) {
		active_note = activeNote;
	}

	public int getActive_kind_id() {
		return active_kind_id;
	}

	public void setActive_kind_id(int activeKindId) {
		active_kind_id = activeKindId;
	}

	public Long getPeople_id() {
		return people_id;
	}

	public void setPeople_id(Long peopleId) {
		people_id = peopleId;
	}
	

	public int getActive_bido_id() {
		return active_bido_id;
	}

	public void setActive_bido_id(int activeBidoId) {
		active_bido_id = activeBidoId;
	}

	public void save(Active[] bean) throws Exception, SQLException {
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

	public void save(Active[] bean, Connection con) throws Exception,
			SQLException {
		String sql = "insert into Active (active_create_date,active_kind_id,active_note,people_id,active_bido_id) values (?,?,?,?,?)";
		for (int i = 0; i < bean.length; i++) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, bean[i].getActive_create_date());
			ps.setInt(2, bean[i].getActive_kind_id());
			ps.setString(3, bean[i].getActive_note());
			ps.setLong(4, bean[i].getPeople_id());
			ps.setInt(5, bean[i].getActive_bido_id());
			ps.executeUpdate();
			ps.close();

		}
	}

	public void update(Active[] bean) throws Exception, SQLException {
		Connection con = null;
		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			update(bean, con);
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
	 * @return update people
	 */

	public void update(Active[] bean, Connection con) throws Exception,
			SQLException {
		for (int i = 0; i < bean.length; i++) {
			PreparedStatement ps = con
					.prepareStatement("update Active set active_create_date=?,active_kind_id=?,active_note=? ,people_id=?,active_bido_id=? where active_id=?");
			ps.setDate(1, bean[i].getActive_create_date());
			ps.setInt(2, bean[i].getActive_kind_id());
			ps.setString(3, bean[i].getActive_note());
			ps.setLong(4, bean[i].getPeople_id());
			ps.setInt(5, bean[i].getActive_bido_id());
			ps.setLong(6, bean[i].getActive_id());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * @return list all people
	 */
	public ArrayList<Active> list() throws Exception {
		Connection con = null;
		ArrayList<Active> list = new ArrayList<Active>();
		Active bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select * from Active";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Active();
				resultBean(bean, rs, con);
				list.add(bean);
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

		return list;
	}

	/**
	 * @return search by people name
	 */

	public ArrayList<Active> findByPeopleId(Long people_id,int limit) throws Exception {
		Connection con = null;
		ArrayList<Active> list = new ArrayList<Active>();
		Active bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select * from Active where people_id=? order by active_create_date desc limit 0,"+limit;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, people_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Active();
				resultBean(bean, rs, con);
				list.add(bean);
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

		return list;
	}
	
	/**
	 * @return search by people name
	 */

	public ArrayList<Active> findByActiveIdAndStartToEnd(int activeKindId,String startDate ,String endDate) throws Exception {
		Connection con = null;
		ArrayList<Active> list = new ArrayList<Active>();
		Active bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select * from Active where active_create_date between '"+startDate+"' and '"+endDate+"' and active_kind_id=?";
			System.out.println("sql::"+sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, activeKindId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Active();
				resultBean(bean, rs, con);
				list.add(bean);
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

		return list;
	}
	
	public ArrayList<Active> findByActiveIdAndActiveBidoIdAndStartToEnd(int activeKindId,String startDate ,String endDate,int activeBidoId) throws Exception {
		Connection con = null;
		ArrayList<Active> list = new ArrayList<Active>();
		Active bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select * from Active where active_kind_id=? and active_bido_id=? and active_create_date between '"+startDate+"' and '"+endDate+"'";
			System.out.println("sql::"+sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, activeKindId);
			ps.setInt(2, activeBidoId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Active();
				resultBean(bean, rs, con);
				list.add(bean);
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

		return list;
	}

	private void resultBean(Active bean, ResultSet rs, Connection con)
			throws Exception {
		bean.setPeople_id(rs.getLong("people_id"));
		bean.setActive_id(rs.getLong("active_id"));
		bean.setActive_create_date(rs.getDate("active_create_date"));
		bean.setActive_kind_id(rs.getInt("active_kind_id"));
		bean.setActive_note(rs.getString("active_note"));
		bean.setActive_bido_id(rs.getInt("active_bido_id"));
	}

	/**
	 * @return delete by people id
	 */

	public void delete(long id) throws Exception {

		Connection con = null;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con
					.prepareStatement("delete from Active where active_id=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			con.commit();

		} catch (SQLException e) {
			if (con != null)
				con.rollback();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Active bean=new Active();
		ArrayList<Active> list=new ArrayList<Active>();
		try {
			list=bean.findByActiveIdAndStartToEnd(14, "2011-09-01", "2011-09-30");
			for(Active b:list){
				System.out.println(b.getPeople_id());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
