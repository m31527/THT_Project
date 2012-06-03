package com.util;

import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class MyUtil {


	public static String StringToUTF8(String name) {
		name = "";
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	public static String getNumToChinese(String n) {
		HashMap<Integer, String> yearMapping = new HashMap<Integer, String>();
		yearMapping.put(100, "κ");
		yearMapping.put(101, "κ箂８");
		yearMapping.put(102, "κ箂");
		yearMapping.put(103, "κ箂");
		yearMapping.put(104, "κ箂");
		yearMapping.put(105, "κ箂き");
		yearMapping.put(106, "κ箂せ");
		yearMapping.put(107, "κ箂");
		yearMapping.put(108, "κ箂");
		yearMapping.put(109, "κ箂");

		String s = "";
		String c[] = { "", "", "κ", "", "窾", "窾", "κ窾", "窾", "货", "货",
				"κ货", "货" };
		String c2[] = { "箂", "", "", "", "", "き", "せ", "", "", "" };
		if(yearMapping.get(Integer.parseInt(n))==null){
			for (int x = 0; x < n.length(); x++) {
			s += c2[n.charAt(x) - 48] + c[n.length() - x - 1];
			}
		}else{
			s=yearMapping.get(Integer.parseInt(n));
		}
		return s;
	}

	public static String replaceNullForString(Object obj){
		String str="";
		str=obj==null?"":(String)obj;
		return str;
	}
	
	public static int replaceNullForInteger(Object obj){
		int str=0;
		str=obj==null?0:(Integer)obj;
		return str;
	}
	
	public static String getToday(String format){
		
		if(format.equals("")){
			format="yyyy-MM-dd";
		}
		Date   date   =   new   Date(); 
		Format   formatter   =   new   SimpleDateFormat(format); 
		String   s   =   formatter.format(date);//2004-09-03
		return s;
	}
	
	public static String replaceMasks(String str){
		str=str.replaceAll("\"", "");
		//str=str.replaceAll("\n", "");
		str=str.replaceAll(" ", "");
		str=str.replaceAll("/", "-");
		return str;
	}
	
	public static Date stringToDate(String dateStr,String format){
		if(format.equals("")){
			format="yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(MyUtil.getNumToChinese("101"));

	}

}
