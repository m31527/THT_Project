package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.tht.action.Active;
import com.tht.admin.LoginRecord;
import com.tht.admin.Permissions;
import com.tht.person.People;
import com.tht.person.Relation;
import com.util.Lauar;
import com.util.MyUtil;

public class PeopleServlet extends HttpServlet {
	Date date = new Date();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		HttpSession session = req.getSession();
		String action = req.getParameter("action");
		// System.out.println("action:"+action);

		if (action.equals("AddPeoplePage")) {
			AddPeoplePage(req, resp, session);

		} else if (action.equals("AddPeopleData")) {
			AddPeopleData(req, resp, session);

		} else if (action.equals("DeletePeople")) {
			DeletePeople(req, resp, session);

		} else if (action.equals("QueryByName")) {
			QueryByName(req, resp, session);

		} else if (action.equals("DetailPeople")) {
			DetailPeople(req, resp, session);

		} else if (action.equals("ModifyPeople")) {
			ModifyPeople(req, resp, session);

		} else if (action.equals("QueryByNameForRelation")) {
			QueryByNameForRelation(req, resp, session);

		} else if (action.equals("QueryByNameForOtherRelation")) {
			QueryByNameForOtherRelation(req, resp, session);

		} else if (action.equals("JoinPeople")) {
			JoinPeople(req, resp, session);

		} else if (action.equals("notJoinPeople")) {
			NotJoinPeople(req, resp, session);

		} else if (action.equals("DeleteActive")) {
			DeleteActive(req, resp, session);

		} else if (action.equals("AddActive")) {
			AddActive(req, resp, session);
		} else if (action.equals("GoAddPeople")) {
			GoAddPeople(req, resp, session);
		} else if (action.equals("Login")) {
			Login(req, resp, session);
		} else if (action.equals("LoginOut")) {
			LoginOut(req, resp, session);
		}

	}

	private void DeletePeople(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		Long main_people_id = req.getParameter("people_id") == null ? 0 : Long
				.parseLong(req.getParameter("people_id"));
		People bean = new People();
		try {
			bean.delete(main_people_id);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext().getRequestDispatcher("/index.jsp");
			requestdispatch.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private void QueryByNameForOtherRelation(HttpServletRequest req,
			HttpServletResponse resp, HttpSession session) {
		// TODO Auto-generated method stub
		ArrayList<People> result = new ArrayList<People>();
		String people_name = req.getParameter("o_people_name") == null ? ""
				: req.getParameter("o_people_name");
		Long main_people_id = req.getParameter("o_main_people_id") == null ? 0
				: Long.parseLong(req.getParameter("o_main_people_id"));

		People bean = new People();
		try {
			result = bean.searchByName(people_name);
			req.setAttribute("search_result_relation", result);
			req.setAttribute("people_name_relation", people_name);
			req.setAttribute("main_people_id", main_people_id);
			req.setAttribute("search_state", "other");
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/people_search_result.jsp");
			requestdispatch.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void NotJoinPeople(HttpServletRequest req,
			HttpServletResponse resp, HttpSession session) {

		Long relation_id = req.getParameter("relation_id") == null ? 0 : Long
				.parseLong(req.getParameter("relation_id"));
		Long people_id = req.getParameter("people_id") == null ? 0 : Long
				.parseLong(req.getParameter("people_id"));

		Relation rel_bean = new Relation();
		People bean = new People();
		try {
			rel_bean.delete(relation_id);
			bean = bean.findByPK(people_id);
			req.setAttribute("bean", bean);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/modify.jsp");
			requestdispatch.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void LoginOut(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		session.removeAttribute("user_name");
		try {
			resp.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private void Login(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {

		Permissions bean = new Permissions();
		LoginRecord record = new LoginRecord();
		ArrayList<LoginRecord> re_list = new ArrayList<LoginRecord>();
		String user_name = req.getParameter("user_name") == null ? "" : req
				.getParameter("user_name");
		String user_password = req.getParameter("user_password") == null ? ""
				: req.getParameter("user_password");
		try {
			if (bean.login(user_name, user_password)) {
				session.setAttribute("user_name", user_name);
				record.setUser_name(user_name);
				re_list.add(record);
				record.save(re_list.toArray(new LoginRecord[] {}));
				resp.sendRedirect("index.jsp");
			} else {
				req.setAttribute("message", "您的帳號或密碼錯誤");
				RequestDispatcher requestdispatch = this.getServletConfig()
						.getServletContext().getRequestDispatcher("/login.jsp");
				requestdispatch.forward(req, resp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void GoAddPeople(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {

		String people_name = req.getParameter("people_name") == null ? "" : req
				.getParameter("people_name");
		try {
			req.setAttribute("people_name", people_name);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/create.jsp?type=parm");
			requestdispatch.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private void AddActive(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		Long people_id = req.getParameter("people_id") == null ? 0 : Long
				.parseLong(req.getParameter("people_id"));

		int active_kind_id = req.getParameter("active_kind_id") == null ? 0
				: Integer.parseInt(req.getParameter("active_kind_id"));

		String active_create_date = req.getParameter("active_create_date") == null ? MyUtil
				.getToday("") : req.getParameter("active_create_date");

		String active_note = req.getParameter("active_note") == null ? "" : req
				.getParameter("active_note");

		int active_bido_id = req.getParameter("active_bido_id") == null ? 0
				: Integer.parseInt(req.getParameter("active_bido_id"));

		ArrayList<Active> list = new ArrayList<Active>();
		Active abean = new Active();
		People bean = new People();
		abean.setActive_create_date(java.sql.Date.valueOf(new String(
				active_create_date)));
		abean.setActive_kind_id(active_kind_id);
		abean.setActive_note(active_note);
		abean.setPeople_id(people_id);
		if (active_bido_id != 0) {
			abean.setActive_bido_id(active_bido_id);
		}
		list.add(abean);

		try {
			abean.save(list.toArray(new Active[] {}));
			bean = bean.findByPK(people_id);
			req.setAttribute("bean", bean);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/modify.jsp");
			requestdispatch.forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	private void DeleteActive(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		Long people_id = req.getParameter("people_id") == null ? 0 : Long
				.parseLong(req.getParameter("people_id"));
		Long active_id = req.getParameter("active_id") == null ? 0 : Long
				.parseLong(req.getParameter("active_id"));
		Active a_bean = new Active();
		People bean = new People();
		try {
			a_bean.delete(active_id);
			bean = bean.findByPK(people_id);
			req.setAttribute("bean", bean);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/modify.jsp");
			requestdispatch.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	private void JoinPeople(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		// people id
		Long people_id = req.getParameter("people_id") == null ? 0 : Long
				.parseLong(req.getParameter("people_id"));
		// ��Did
		Long main_people_id = req.getParameter("main_people_id") == null ? 0
				: Long.parseLong(req.getParameter("main_people_id"));

		String dearname = req.getParameter("dearname_" + people_id) == null ? ""
				: req.getParameter("dearname_" + people_id);

		String search_state = req.getParameter("search_state") == null ? ""
				: (String) req.getParameter("search_state");
		int sameaddess = 0;
		People bean = new People();
		People bean2 = new People();
		Relation rel_bean = new Relation();
		Relation rel_bean2 = new Relation();
		Relation search_relbean = new Relation();
		ArrayList<Relation> rel_list = new ArrayList<Relation>();
		ArrayList<Relation> rel_list2 = new ArrayList<Relation>();

		try {
			// -----------query id 存至relation
			bean = bean.findByPK(people_id);
			rel_bean.setPeople_gender(bean.getPeople_gender());
			rel_bean.setPeople_id(bean.getPeople_id());
			rel_bean.setPeople_name(bean.getPeople_name());
			rel_bean.setRelation_name(dearname);
			rel_bean.setMain_people_id(main_people_id);
			rel_bean.setPeople_birthday(bean.getPeople_birthday());
			if (search_state.equals("other")) {
				rel_bean.setSame_address(1);
				sameaddess = 1;
			}
			rel_list.add(rel_bean);
			rel_bean.save(rel_list.toArray(new Relation[] {}));
			// --------------query id 存至relation

			// 先查是否有儲存戶主id在relation,為了避免發生錯誤
			// search_relbean=search_relbean.findByMainId(main_people_id,sameaddess);
			// if(search_relbean==null){
			// if(search_relbean.getPeople_name()==""){

			// if(rel_bean.ContainPeople(people_id,
			// main_people_id,sameaddess)==false){
			if (!search_state.equals("other")) {
				if (rel_bean.ContainPeople(main_people_id, main_people_id,
						sameaddess) == false) {
					// --------------將main_people也儲存ㄧ次(程式有判斷peopleid
					// mainpeopleid)
					bean2 = bean2.findByPK(main_people_id);
					rel_bean2.setPeople_gender(bean2.getPeople_gender());
					rel_bean2.setPeople_id(bean2.getPeople_id());
					rel_bean2.setPeople_name(bean2.getPeople_name());
					rel_bean2.setRelation_name(dearname);
					rel_bean2.setMain_people_id(main_people_id);//
					rel_bean2.setPeople_birthday(bean2.getPeople_birthday());
					rel_list2.add(rel_bean2);
					rel_bean2.save(rel_list2.toArray(new Relation[] {}));
				}
			}
			// }
			// }
			// --------------將main_people也儲存ㄧ次

			bean = bean.findByPK(main_people_id);
			req.setAttribute("bean", bean);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/modify.jsp");
			requestdispatch.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private void QueryByNameForRelation(HttpServletRequest req,
			HttpServletResponse resp, HttpSession session) {

		ArrayList<People> result = new ArrayList<People>();
		String people_name = req.getParameter("people_name") == null ? "" : req
				.getParameter("people_name");
		Long main_people_id = req.getParameter("main_people_id") == null ? 0
				: Long.parseLong(req.getParameter("main_people_id"));

		People bean = new People();
		try {
			result = bean.searchByName(people_name);
			req.setAttribute("search_result_relation", result);
			req.setAttribute("people_name_relation", people_name);
			req.setAttribute("main_people_id", main_people_id);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/people_search_result.jsp");
			requestdispatch.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void ModifyPeople(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		ArrayList<People> list = new ArrayList<People>();
		People bean = new People();
		Long people_id = req.getParameter("people_id") == null ? 0 : Long
				.parseLong(req.getParameter("people_id"));
		bean = PackageBean(req, bean);
		bean.setPeople_id(people_id);
		list.add(bean);

		try {
			bean.update(list.toArray(new People[] {}));
			bean = bean.findByPK(people_id);
			// session.setAttribute("bean", bean);
			// resp.sendRedirect("people/modify.jsp");

			req.setAttribute("bean", bean);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/modify.jsp");
			requestdispatch.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private void DetailPeople(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		Long people_id = req.getParameter("people_id") == null ? 0 : Long
				.parseLong(req.getParameter("people_id"));
		People bean = new People();
		try {
			bean = bean.findByPK(people_id);
			// session.setAttribute("bean", bean);
			// resp.sendRedirect("people/modify.jsp");
			req.setAttribute("bean", bean);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/modify.jsp");
			requestdispatch.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private void QueryByName(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		ArrayList<People> result = new ArrayList<People>();
		String people_name = req.getParameter("people_name") == null ? "" : req
				.getParameter("people_name");
		People bean = new People();
		try {
			result = bean.searchByName(people_name);
			session.setAttribute("search_result", result);
			session.setAttribute("people_name", people_name);
			resp.sendRedirect("search_result.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	private void AddPeopleData(HttpServletRequest req,
			HttpServletResponse resp, HttpSession session) {
		Long people_id = null;
		ArrayList<People> list = new ArrayList<People>();
		People bean = new People();
		bean = PackageBean(req, bean);
		list.add(bean);
		try {
			people_id = bean.saveReturnId(list.toArray(new People[] {}));
			bean = bean.findByPK(people_id);
			req.setAttribute("bean", bean);
			RequestDispatcher requestdispatch = this.getServletConfig()
					.getServletContext()
					.getRequestDispatcher("/people/modify.jsp");
			requestdispatch.forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private People PackageBean(HttpServletRequest req, People bean) {
		String people_name = req.getParameter("people_name") == null ? ""
				: StringUtils.trimToEmpty(req.getParameter("people_name"));

		String people_birthdayTime = req.getParameter("people_birthdayTime") == null ? ""
				: StringUtils.trimToEmpty(req
						.getParameter("people_birthdayTime"));
		String people_birthday = "";

		// tring people_birthday = req.getParameter("people_birthday") == null ?
		// ""
		// : StringUtils.trimToEmpty(req.getParameter("people_birthday"));
		if (req.getParameter("people_birthday") == null) {
			String people_birthday_year = req
					.getParameter("people_birthday_year") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_birthday_year"));
			String people_birthday_month = req
					.getParameter("people_birthday_month") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_birthday_month"));
			String people_birthday_day = req
					.getParameter("people_birthday_day") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_birthday_day"));
			if (!people_birthday_year.equals("")) {
				people_birthday = people_birthday + people_birthday_year + "-";
			}
			if (!people_birthday_month.equals("")) {
				people_birthday = people_birthday + people_birthday_month + "-";
			}
			if (!people_birthday_day.equals("")) {
				people_birthday = people_birthday + people_birthday_day;
			}
		} else {
			people_birthday = req.getParameter("people_birthday") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_birthday"));
		}

		/*
		 * String people_lunerBirthday =
		 * req.getParameter("people_lunerBirthday") == null ? "" :
		 * StringUtils.trimToEmpty(req .getParameter("people_lunerBirthday"));
		 */
		String people_lunerBirthday = "";
		if (req.getParameter("people_lunerBirthday") == null) {
			String people_lunerBirthday_year = req
					.getParameter("people_lunerBirthday_year") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_lunerBirthday_year"));
			String people_lunerBirthday_month = req
					.getParameter("people_lunerBirthday_month") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_lunerBirthday_month"));
			String people_lunerBirthday_day = req
					.getParameter("people_lunerBirthday_day") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_lunerBirthday_day"));
			if (!people_lunerBirthday_year.equals("")) {
				people_lunerBirthday = people_lunerBirthday
						+ people_lunerBirthday_year + "-";
			}
			if (!people_lunerBirthday_month.equals("")) {
				people_lunerBirthday = people_lunerBirthday
						+ people_lunerBirthday_month + "-";
			}
			if (!people_lunerBirthday_day.equals("")) {
				people_lunerBirthday = people_lunerBirthday
						+ people_lunerBirthday_day;
			}
		} else {
			people_lunerBirthday = req.getParameter("people_lunerBirthday") == null ? ""
					: StringUtils.trimToEmpty(req
							.getParameter("people_lunerBirthday"));
		}
		/*
		 * // �A�� String people_lunerBirthday = ""; String[] birthday =
		 * people_birthday.split("-"); if (birthday.length > 2) {
		 * people_lunerBirthday = Lauar.getLunarSample(birthday[0], birthday[1],
		 * birthday[2], ""); }
		 */
		String people_address = req.getParameter("people_address") == null ? ""
				: StringUtils.trimToEmpty(req.getParameter("people_address"));
		String people_phone = req.getParameter("people_phone") == null ? ""
				: StringUtils.trimToEmpty(req.getParameter("people_phone"));

		String people_cellPhone = req.getParameter("people_cellPhone") == null ? ""
				: StringUtils.trimToEmpty(req.getParameter("people_cellPhone"));
		String people_email = req.getParameter("people_email") == null ? ""
				: StringUtils.trimToEmpty(req.getParameter("people_email"));

		int people_gender = req.getParameter("people_gender") == null ? 9
				: Integer.parseInt(req.getParameter("people_gender"));
		int people_main = req.getParameter("people_main") == null ? 0 : Integer
				.parseInt(req.getParameter("people_main"));
		int people_sendmail = req.getParameter("people_sendmail") == null ? 0
				: Integer.parseInt(req.getParameter("people_sendmail"));

		bean.setPeople_name(people_name);
		bean.setPeople_birthday(people_birthday);
		bean.setPeople_birthdayTime(people_birthdayTime);
		bean.setPeople_lunerBirthday(people_lunerBirthday);
		bean.setPeople_address(people_address);
		bean.setPeople_phone(people_phone);
		bean.setPeople_cellPhone(people_cellPhone);
		bean.setPeople_email(people_email);
		bean.setPeople_gender(people_gender);
		bean.setPeople_main(people_main);
		bean.setPeople_sendmail(people_sendmail);

		return bean;
	}

	private void AddPeoplePage(HttpServletRequest req,
			HttpServletResponse resp, HttpSession session) {
		ArrayList<People> result = new ArrayList<People>();
		String people_name = req.getParameter("people_name") == null ? "" : req
				.getParameter("people_name");
		People bean = new People();
		try {
			result = bean.searchByName(people_name);
			if (result.size() > 0) {
				session.setAttribute("search_result", result);
				session.setAttribute("people_name", people_name);
				resp.sendRedirect("search_result.jsp");
			} else {
				req.setAttribute("people_name", people_name);
				RequestDispatcher requestdispatch = this.getServletConfig()
						.getServletContext()
						.getRequestDispatcher("people/create.jsp?type=parm");
				requestdispatch.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
