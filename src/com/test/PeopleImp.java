package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.my.hibernate.HibernateUtil;
import com.tht.person.People;

public class PeopleImp {

	public PeopleImp() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * �x�s���
	 */

	public void save(People bean) {
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
	 */

	public List<People> list() {
		List<People> result = new ArrayList<People>();

		Session ses = null;
		Transaction tx = null;
		try {
			ses = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = ses.beginTransaction();
			Criteria ct = ses.createCriteria(People.class);
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
	 */

	public static void update(People bean) {
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
	 * �ǩm�W �q�� �Ӭd��
	 */

	public static List<People> findUser(String people_name, String people_phone) {
		List<People> beanList = new ArrayList<People>();

		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(People.class);
			if (!people_name.equals("")) {
				criteria.add(Restrictions.eq("people_name", people_name));
			}
			if (!people_phone.equals("")) {
				criteria.add(Restrictions.eq("people_phone", people_phone));
			}
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
}
