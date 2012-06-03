package com.tht.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.ConnectionDB;

public class Relation {

	/*
	 * @author by Sean 信徒關係
	 */

	public Relation() {
		// TODO Auto-generated constructor stub
	}

	private long relation_id;
	private String relation_name;
	private long people_id;
	private long main_people_id;
	private int people_gender;
	private String people_name;
	// 是否相同地址 0為相同 1為不同
	private int same_address;
	private String people_birthday;

	public long getRelation_id() {
		return relation_id;
	}

	public void setRelation_id(long relationId) {
		relation_id = relationId;
	}

	public String getRelation_name() {
		return relation_name;
	}

	public void setRelation_name(String relationName) {
		relation_name = relationName;
	}

	public long getPeople_id() {
		return people_id;
	}

	public void setPeople_id(long peopleId) {
		people_id = peopleId;
	}

	public int getPeople_gender() {
		return people_gender;
	}

	public void setPeople_gender(int peopleGender) {
		people_gender = peopleGender;
	}

	public String getPeople_name() {
		return people_name;
	}

	public void setPeople_name(String peopleName) {
		people_name = peopleName;
	}

	public int getSame_address() {
		return same_address;
	}

	public void setSame_address(int sameAddress) {
		same_address = sameAddress;
	}
	

	public long getMain_people_id() {
		return main_people_id;
	}

	public void setMain_people_id(long mainPeopleId) {
		main_people_id = mainPeopleId;
	}
	
	

	public String getPeople_birthday() {
		return people_birthday;
	}

	public void setPeople_birthday(String peopleBirthday) {
		people_birthday = peopleBirthday;
	}

	public void save(Relation[] bean) throws Exception, SQLException {
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
	 * @return save relation
	 */

	public void save(Relation[] bean, Connection con) throws Exception,
			SQLException {
		String sql = "insert into Relation (relation_name,people_id,main_people_id,people_gender,people_name,same_address,people_birthday) values (?,?,?,?,?,?,?)";
		for (int i = 0; i < bean.length; i++) {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bean[i].getRelation_name());
			ps.setLong(2, bean[i].getPeople_id());
			ps.setLong(3, bean[i].getMain_people_id());
			ps.setInt(4, bean[i].getPeople_gender());
			ps.setString(5, bean[i].getPeople_name());
			ps.setInt(6, bean[i].getSame_address());
			ps.setString(7, bean[i].getPeople_birthday());
			ps.executeUpdate();
			ps.close();

		}
	}

	public void update(Relation[] bean) throws Exception, SQLException {
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
	 * @return update relation
	 */

	public void update(Relation[] bean, Connection con) throws Exception,
			SQLException {
		for (int i = 0; i < bean.length; i++) {
			PreparedStatement ps = con
					.prepareStatement("update Relation set relation_name=?,people_id=?,main_people_id=?,people_gender=?,people_name=?,same_address=?,people_birthday=? where relation_id=?");
			ps.setString(1, bean[i].getRelation_name());
			ps.setLong(2, bean[i].getPeople_id());
			ps.setLong(3, bean[i].getMain_people_id());
			ps.setInt(4, bean[i].getPeople_gender());
			ps.setString(5, bean[i].getPeople_name());
			ps.setInt(6, bean[i].getSame_address());
			ps.setString(7, bean[i].getPeople_birthday());
			ps.setLong(8, bean[i].getRelation_id());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * @return list all people
	 */
	public ArrayList<Relation> list() throws Exception {
		Connection con = null;
		ArrayList<Relation> list = new ArrayList<Relation>();
		Relation bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select * from Relation";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Relation();
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
	 * @return search by people id
	 */

	public ArrayList<Relation> findByMainPeopleId(Long main_people_id) throws Exception {
		Connection con = null;
		ArrayList<Relation> list = new ArrayList<Relation>();
		Relation bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from Relation where main_people_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, main_people_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Relation();
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
	 * @return search by people id and main_people_id
	 */

	public ArrayList<Relation> findByPeopleIdAndMainPeopleId(Long people_id,Long main_people_id) throws Exception {
		Connection con = null;
		ArrayList<Relation> list = new ArrayList<Relation>();
		Relation bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from Relation where people_id=? and main_people_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, people_id);
			ps.setLong(2, main_people_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Relation();
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
	 * @return delete by people id
	 */

	public void delete(long id) throws Exception {

		Connection con = null;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con
					.prepareStatement("delete from Relation where relation_id=?");
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
	 * @return find by people
	 */

	public Relation findByPK(Long relation_id) throws Exception {
		Connection con = null;
		Relation bean = null;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from Relation where relation_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, relation_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Relation();
				resultBean(bean, rs, con);
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

		return bean;
	}
	
	/**
	 * @return find by people
	 */

	public Relation findByMainId(Long people_id) throws Exception {
		Connection con = null;
		Relation bean = null;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from Relation where people_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, people_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Relation();
				resultBean(bean, rs, con);
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

		return bean;
	}
	
	public Relation findByMainId(Long people_id,int same_address) throws Exception {
		Connection con = null;
		Relation bean = null;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from Relation where people_id=? and same_address=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, people_id);
			ps.setInt(2, same_address);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new Relation();
				resultBean(bean, rs, con);
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

		return bean;
	}
	
	public Long findByMainIdSingle(Long people_id) throws Exception {
		Connection con = null;
		Relation bean = null;
		long main_people_id=0;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select main_people_id  from Relation where people_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, people_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				main_people_id=rs.getLong("main_people_id");
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

		return main_people_id;
	}
	
	private void resultBean(Relation bean, ResultSet rs, Connection con)
			throws SQLException {

		bean.setRelation_id(rs.getLong("relation_id"));
		bean.setRelation_name(rs.getString("relation_name"));
		bean.setPeople_id(rs.getLong("people_id"));
		bean.setMain_people_id(rs.getLong("main_people_id"));
		bean.setPeople_gender(rs.getInt("people_gender"));
		bean.setPeople_name(rs.getString("people_name"));
		bean.setSame_address(rs.getInt("same_address"));
		bean.setPeople_birthday(rs.getString("people_birthday"));

	}
	
	//找到回傳true
	public boolean ContainPeople(Long people_id,Long main_people_id){
		Connection con = null;
		boolean state=false;
		
		try{
		con = ConnectionDB.createConnection();
		con.setAutoCommit(false);
		String sql = "select *  from Relation where people_id=? and main_people_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, people_id);
		ps.setLong(2, main_people_id);
		ResultSet rs = ps.executeQuery();
		rs.last();
		rs.getRow();
		
		if(rs.getRow()>0){
			state=true;
		}
		ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return state;
	}
	
	//找到回傳true
		public boolean ContainPeople(Long people_id,Long main_people_id,int same_address){
			Connection con = null;
			boolean state=false;
			
			try{
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from Relation where people_id=? and main_people_id=? and same_address=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, people_id);
			ps.setLong(2, main_people_id);
			ps.setLong(3, same_address);
			ResultSet rs = ps.executeQuery();
			rs.last();
			rs.getRow();
			
			if(rs.getRow()>0){
				state=true;
			}
			ps.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return state;
		}

	/*
	 * @ test save
	 */

	public static void test_save() {
		Relation bean = new Relation();

		ArrayList<Relation> list = new ArrayList<Relation>();
		bean.setPeople_name("台專");
		bean.setPeople_id(3);
		list.add(bean);
		try {
			bean.save(list.toArray(new Relation[] {}));
			System.out.println("test save success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * @ test update
	 */

	public static void test_update(long id) {
		Relation bean = new Relation();

		ArrayList<Relation> list = new ArrayList<Relation>();
		bean.setPeople_name("喵喵");
		bean.setRelation_id(id);
		list.add(bean);
		try {
			bean.update(list.toArray(new Relation[] {}));
			System.out.println("test update success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//float pages=(float)15/14;
		//	System.out.println(Math.ceil(pages));
		Relation bean=new Relation();
		System.out.println(bean.ContainPeople(Long.parseLong("16"), Long.parseLong("13")));
		
		
	}

}
