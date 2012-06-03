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
		yearMapping.put(100, "�@��");
		yearMapping.put(101, "�@�ʹs��");
		yearMapping.put(102, "�@�ʹs�G");
		yearMapping.put(103, "�@�ʹs�T");
		yearMapping.put(104, "�@�ʹs�|");
		yearMapping.put(105, "�@�ʹs��");
		yearMapping.put(106, "�@�ʹs��");
		yearMapping.put(107, "�@�ʹs�C");
		yearMapping.put(108, "�@�ʹs�K");
		yearMapping.put(109, "�@�ʹs�E");

		String s = "";
		String c[] = { "", "�Q", "��", "�d", "�U", "�Q�U", "�ʸU", "�d�U", "��", "�Q��",
				"�ʻ�", "�d��" };
		String c2[] = { "�s", "�@", "�G", "�T", "�|", "��", "��", "�C", "�K", "�E" };
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
