package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.my.hibernate.HibernateUtil;

public class ProfileImp {

	public ProfileImp() {

	}

	/*
	 * �x�s���
	 * 
	 */
	
	public void save(Profile bean) {
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			session.save(bean);
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * �Ҧ�data
	 * 
	 * 
	 */
	
	public List<Profile> list() {
		List<Profile> result = new ArrayList<Profile>();

		Session ses = null;
		Transaction tx = null;
		try {
			ses = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = ses.beginTransaction();
			Criteria ct = ses.createCriteria(Profile.class);
			result = ct.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return result;
	}

	/*
	 * ��s
	 * 
	 */
	
	public static void update(Profile bean) {
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			session.update(bean);
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * �ǩm�W ������ �q�� �Ӭd��
	 * 
	 */

	public static List<Profile> findUser(String name, String identity,
			String phoneNumber) {
		List<Profile> beanList = new ArrayList<Profile>();

		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Profile.class);
			criteria.add(Restrictions.eq("name", name));
			criteria.add(Restrictions.eq("identity", identity));
			criteria.add(Restrictions.eq("phoneNumber1", phoneNumber));
			criteria.add(Restrictions.eq("phoneNumber2", phoneNumber));
			beanList = criteria.list();
			HibernateUtil.getSessionFactory().close();
			if (!beanList.isEmpty()) {
				HibernateUtil.getSessionFactory().close();
				return beanList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/*
	 * 
	 * ��parent_id id ��a�H
	 */
	
	public List<Profile> findFamily(long parent_id){
		List<Profile> beanList = new ArrayList<Profile>();

		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Profile.class);
			criteria.add(Restrictions.eq("parent_id", parent_id));
			beanList = criteria.list();
			HibernateUtil.getSessionFactory().close();
			if (!beanList.isEmpty()) {
				HibernateUtil.getSessionFactory().close();
				return beanList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * �ǥثe�ĴX���A�@���n�X���A�^�ǤU�@��data
	 * 
	 */
	
	public List<Profile> listByPageNum(int now, int total) {
		int start = (now - 1) * total;
		List<Profile> beanList = new ArrayList<Profile>();
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Profile.class);
			criteria.setFirstResult(start);
			criteria.setMaxResults(total);
			beanList = criteria.list();
			HibernateUtil.getSessionFactory().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
}
