package com.tht.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.tht.action.Active;
import com.util.ConnectionDB;

public class People {

	/*
	 * @author by Sean �H�{�ӤH���
	 */

	public People() {

	}

	private long people_id;
	private String people_name;
	private String people_birthday;
	private String people_birthdayTime;
	private String people_lunerBirthday;
	private String people_address;
	private String people_phone;
	private String people_cellPhone;
	private String people_email;
	private int people_gender;
	// 是否為戶主
	private int people_main;
	private int people_sendmail;
	//同地址關係
	private ArrayList<Relation> relation_list = new ArrayList<Relation>();
	//儀式清單
	private ArrayList<Active> active_list=new ArrayList<Active>(); 
	
	public long getPeople_id() {
		return people_id;
	}

	public void setPeople_id(long peopleId) {
		people_id = peopleId;
	}

	public String getPeople_name() {
		return people_name;
	}

	public void setPeople_name(String peopleName) {
		people_name = peopleName;
	}

	public String getPeople_birthday() {
		return people_birthday;
	}

	public void setPeople_birthday(String peopleBirthday) {
		people_birthday = peopleBirthday;
	}

	public String getPeople_birthdayTime() {
		return people_birthdayTime;
	}

	public void setPeople_birthdayTime(String peopleBirthdayTime) {
		people_birthdayTime = peopleBirthdayTime;
	}

	public String getPeople_lunerBirthday() {
		return people_lunerBirthday;
	}

	public void setPeople_lunerBirthday(String peopleLunerBirthday) {
		people_lunerBirthday = peopleLunerBirthday;
	}

	public String getPeople_address() {
		return people_address;
	}

	public void setPeople_address(String peopleAddress) {
		people_address = peopleAddress;
	}

	public String getPeople_phone() {
		return people_phone;
	}

	public void setPeople_phone(String peoplePhone) {
		people_phone = peoplePhone;
	}

	public String getPeople_cellPhone() {
		return people_cellPhone;
	}

	public void setPeople_cellPhone(String peopleCellPhone) {
		people_cellPhone = peopleCellPhone;
	}

	public String getPeople_email() {
		return people_email;
	}

	public void setPeople_email(String peopleEmail) {
		people_email = peopleEmail;
	}

	public int getPeople_gender() {
		return people_gender;
	}

	public void setPeople_gender(int peopleGender) {
		people_gender = peopleGender;
	}

	public int getPeople_main() {
		return people_main;
	}

	public void setPeople_main(int peopleMain) {
		people_main = peopleMain;
	}

	
	public int getPeople_sendmail() {
		return people_sendmail;
	}

	public void setPeople_sendmail(int peopleSendmail) {
		people_sendmail = peopleSendmail;
	}

	public ArrayList<Relation> getRelation_list() {
		return relation_list;
	}

	public void setRelation_list(ArrayList<Relation> relationList) {
		relation_list = relationList;
	}

	
	public ArrayList<Active> getActive_list() {
		return active_list;
	}

	public void setActive_list(ArrayList<Active> activeList) {
		active_list = activeList;
	}

	public void save(People[] bean) throws Exception, SQLException {
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
	
	public Long saveReturnId(People[] bean) throws Exception, SQLException {
		Connection con = null;
		Long people_id= null;
		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			people_id=save(bean, con);
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
		return people_id;

	}

	/**
	 * @return save people
	 */

	public Long save(People[] bean, Connection con) throws Exception,
			SQLException {
		Long people_id = null;
		String sql = "insert into People (people_name,people_birthday,people_birthdayTime,people_lunerBirthday,people_address,people_phone,people_cellPhone,people_email,people_gender,people_main,people_sendmail) values (?,?,?,?,?,?,?,?,?,?,?)";
		for (int i = 0; i < bean.length; i++) {

			PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bean[i].getPeople_name());
			ps.setString(2, bean[i].getPeople_birthday());
			ps.setString(3, bean[i].getPeople_birthdayTime());
			ps.setString(4, bean[i].getPeople_lunerBirthday());
			ps.setString(5, bean[i].getPeople_address());
			ps.setString(6, bean[i].getPeople_phone());
			ps.setString(7, bean[i].getPeople_cellPhone());
			ps.setString(8, bean[i].getPeople_email());
			ps.setInt(9, bean[i].getPeople_gender());
			ps.setInt(10, bean[i].getPeople_main());
			ps.setInt(11, bean[i].getPeople_sendmail());
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if(generatedKeys.next()){
				people_id=generatedKeys.getLong(1);
			}
			ps.close();

		}
		return people_id;
	}

	public void update(People[] bean) throws Exception, SQLException {
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

	public void update(People[] bean, Connection con) throws Exception,
			SQLException {
		for (int i = 0; i < bean.length; i++) {
			PreparedStatement ps = con
					.prepareStatement("update People set people_name=?,people_birthday=?,people_birthdayTime=?,people_lunerBirthday=?,people_address=?,people_phone=?,people_cellPhone=?,people_email=?,people_gender=?,people_main=?,people_sendmail=? where people_id=?");
			ps.setString(1, bean[i].getPeople_name());
			ps.setString(2, bean[i].getPeople_birthday());
			ps.setString(3, bean[i].getPeople_birthdayTime());
			ps.setString(4, bean[i].getPeople_lunerBirthday());
			ps.setString(5, bean[i].getPeople_address());
			ps.setString(6, bean[i].getPeople_phone());
			ps.setString(7, bean[i].getPeople_cellPhone());
			ps.setString(8, bean[i].getPeople_email());
			ps.setInt(9, bean[i].getPeople_gender());
			ps.setInt(10, bean[i].getPeople_main());
			ps.setInt(11, bean[i].getPeople_sendmail());
			ps.setLong(12, bean[i].getPeople_id());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * @return list all people
	 */
	public ArrayList<People> list() throws Exception {
		Connection con = null;
		ArrayList<People> list = new ArrayList<People>();
		People bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select * from People";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new People();
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

	public ArrayList<People> searchByName(String people_name) throws Exception {
		Connection con = null;
		ArrayList<People> list = new ArrayList<People>();
		People bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from People where people_name like '%"
					+ people_name + "%'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new People();
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
	
	public ArrayList<People> findMainAndMail() throws Exception {
		Connection con = null;
		ArrayList<People> list = new ArrayList<People>();
		People bean;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from People where people_main=1 and people_sendmail=1 order by people_id asc";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new People();
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
					.prepareStatement("delete from People where people_id=?");
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

	public People findByPK(Long people_id) throws Exception {
		Connection con = null;
		People bean = null;

		try {
			con = ConnectionDB.createConnection();
			con.setAutoCommit(false);
			String sql = "select *  from People where people_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, people_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				bean = new People();
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

	private void resultBean(People bean, ResultSet rs, Connection con)
			throws Exception {

		Relation rel_bean=new Relation();
		Active active_bean=new Active();
		bean.setPeople_id(rs.getLong("people_id"));
		bean.setPeople_name(rs.getString("people_name"));
		bean.setPeople_birthday(rs.getString("people_birthday"));
		bean.setPeople_birthdayTime(rs.getString("people_birthdayTime"));
		bean.setPeople_lunerBirthday(rs.getString("people_lunerBirthday"));
		bean.setPeople_address(rs.getString("people_address"));
		bean.setPeople_phone(rs.getString("people_phone"));
		bean.setPeople_cellPhone(rs.getString("people_cellPhone"));
		bean.setPeople_email(rs.getString("people_email"));
		bean.setPeople_gender(rs.getInt("people_gender"));
		bean.setPeople_main(rs.getInt("people_main"));
		bean.setPeople_sendmail(rs.getInt("people_sendmail"));
		if(bean.getPeople_main()==1){
			bean.setRelation_list(rel_bean.findByMainPeopleId(bean.getPeople_id()));
		}else{
			//判斷如果不是戶主，也要把同地址user找出
			//此method將來要改成只拿id就好要拿整個bean
			Long people_main_id=rel_bean.findByMainIdSingle(bean.getPeople_id());
			if(people_main_id==0){
				people_main_id=bean.getPeople_id();
			}
			bean.setRelation_list(rel_bean.findByMainPeopleId(people_main_id));

		}
		bean.setActive_list(active_bean.findByPeopleId(bean.getPeople_id(), 10));
		
	}

	/*
	 * @ test save
	 */

	public static void test_save() {
		People bean = new People();

		ArrayList<People> list = new ArrayList<People>();
		bean.setPeople_name("�x�M");
		list.add(bean);
		try {
			bean.save(list.toArray(new People[] {}));
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
		People bean = new People();

		ArrayList<People> list = new ArrayList<People>();
		bean.setPeople_name("�p�p");
		bean.setPeople_id(id);
		list.add(bean);
		try {
			bean.update(list.toArray(new People[] {}));
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
		People bean = new People();
		try {
			bean = bean.findByPK(Long.parseLong("3"));

			System.out.println(bean.getPeople_name());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
