package com.test;

import java.sql.Date;

public class Profile {

	public Profile() {

	}

	private long id;
	private String name;
	private String identity;
	private int gender;
	private Date lunerCalendar;
	private Date solarCanlendar;
	private String phoneNumber1;
	private String phoneNumber2;
	private String address1;
	private String address2;
	private int old;
	private String title;
	// ���s�a�H���Y,�����������˩Υ���id�Ӫ�ܦP�@�a�H
	private int parent_id;

	// �U���Ѽ� 0��ܧ��� 1��ܦC�L���� 2��ܩ|���C�L

	// �ӷ��O
	private String taisuiLight;
	// �����O
	private String guangmingLight;
	// �Ʒ~�O
	private String shihyeLight;
	// ���a�O
	private String cyuanjiaLight;
	// �]���O
	private String caishenLight;
	// ����O
	private String wunchangLight;
	// �Įv
	private String yaoshih;
	// ����
	private String jigai;
	// �ɹB
	private String buyun;
	private String note;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		identity = identity;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getLunerCalendar() {
		return lunerCalendar;
	}

	public void setLunerCalendar(Date lunerCalendar) {
		this.lunerCalendar = lunerCalendar;
	}

	public Date getSolarCanlendar() {
		return solarCanlendar;
	}

	public void setSolarCanlendar(Date solarCanlendar) {
		this.solarCanlendar = solarCanlendar;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public String getTaisuiLight() {
		return taisuiLight;
	}

	public void setTaisuiLight(String taisuiLight) {
		this.taisuiLight = taisuiLight;
	}

	public String getGuangmingLight() {
		return guangmingLight;
	}

	public void setGuangmingLight(String guangmingLight) {
		this.guangmingLight = guangmingLight;
	}

	public String getShihyeLight() {
		return shihyeLight;
	}

	public void setShihyeLight(String shihyeLight) {
		this.shihyeLight = shihyeLight;
	}

	public String getCyuanjiaLight() {
		return cyuanjiaLight;
	}

	public void setCyuanjiaLight(String cyuanjiaLight) {
		this.cyuanjiaLight = cyuanjiaLight;
	}

	public String getCaishenLight() {
		return caishenLight;
	}

	public void setCaishenLight(String caishenLight) {
		this.caishenLight = caishenLight;
	}

	public String getWunchangLight() {
		return wunchangLight;
	}

	public void setWunchangLight(String wunchangLight) {
		this.wunchangLight = wunchangLight;
	}

	public String getYaoshih() {
		return yaoshih;
	}

	public void setYaoshih(String yaoshih) {
		this.yaoshih = yaoshih;
	}

	public String getJigai() {
		return jigai;
	}

	public void setJigai(String jigai) {
		this.jigai = jigai;
	}

	public String getBuyun() {
		return buyun;
	}

	public void setBuyun(String buyun) {
		this.buyun = buyun;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parentId) {
		parent_id = parentId;
	}

}
