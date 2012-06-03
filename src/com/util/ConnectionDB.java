package com.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ConnectionDB extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(ConnectionDB.class);

	private static String[] info = new String[6];

	public static void setInfo(String[] info) {
		ConnectionDB.info = info;
	}

	public ConnectionDB() {

	}

	public static Connection createConnection() throws Exception {

		Connection con = null;
		try {
			// read moodle_config.xml
			ConnectionDB condb = new ConnectionDB();
			//String[] info = condb.getConnectionConfig();
			
			 String[] info = new String[6];
			 info[0] = "com.mysql.jdbc.Driver";
			 info[1] = "tht";
			 info[2] = "127.0.0.1";
			 info[3] = "root";
			 //info[4] = "rootadmin";
			 info[4] = "thtroot";
			 info[5] = "mysql";
			String dbType = info[5];
			String jdbcDriver = info[0];
			String url = "";
			if (dbType.equals("oracle")) {

			} else if (dbType.equals("mssql")) {
				url = "jdbc:inetdae7:" + info[2] + ":1433?database=" + info[1];
			} else {
				url ="jdbc:mysql://"+info[2]+":3306/"+info[1]+"?useUnicode=true&characterEncoding=UTF-8";
			}

			String id = info[3];
			String password = info[4];

			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(url, id, password);

		} catch (Exception e) {

			System.out.println("mysql connection error ");
			e.printStackTrace();

		}
		return con;

	}

	public String[] getConnectionConfig() {
		String[] info = new String[6];
		SAXBuilder sb = new SAXBuilder();

		try {

			int str_length = String.valueOf(
					ConnectionDB.class.getResource("")).length();
			String str = String.valueOf(ConnectionDB.class.getResource(""))
					.substring(6, str_length);
			System.out.println(ConnectionDB.class.getResource(""));
			File file = new File(str + "db_confg.xml");
			Document doc = sb.build(file);
			Element root = doc.getRootElement();
			info[0] = root.getChild("jdbcDriver").getTextTrim();
			info[1] = root.getChild("dbname").getTextTrim();
			info[2] = root.getChild("url").getTextTrim();
			info[3] = root.getChild("id").getTextTrim();
			info[4] = root.getChild("password").getTextTrim();
			info[5] = root.getChild("dbtype").getTextTrim();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return info;
	}

	public String[] getMoodleConfig() {

		return info;
	}

	public static void main(String[] args) {

		Connection con = null;
		try {

			// con = ConnectionDB.createConnection(); ConnectionDB condb = new
			// ConnectionDB(); String[] a = condb.getMoodleConfig();
			// System.out.println(a[0] + "" + a[1] + "" + a[2] + "" + a[3] + ""
			// + a[4]);

			ConnectionDB db = new ConnectionDB();
			db.createConnection();
			System.out.println("sucess");
		} catch (Exception e) {
			e.printStackTrace(); // To change body of catch statement use
			// File | Settings | File Templates.
		}

	}

}