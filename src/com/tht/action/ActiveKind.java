package com.tht.action;

import java.util.HashMap;
import java.util.Iterator;

/*
 *  �e�U��������
 * 
 */
public class ActiveKind {
	
	public static HashMap<Integer,String> list=new HashMap< Integer, String>();
	static {
		list.put(1, "光明燈");

		list.put(2, "藥師燈");

		list.put(3, "平安燈");

		list.put(4, "事業燈");

		list.put(5, "文昌燈");

		list.put(6, "財神燈");

		list.put(7, "全家燈");

		list.put(8, "太歲燈");

		list.put(9, "補運(每月15日)");

		list.put(10, "普渡法會");

		list.put(11, "年度祭改");

		list.put(12, "月祭改(每月13日)");

		list.put(13, "春季禮斗法會");

		list.put(14, "秋季禮斗法會");
	}
		/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iterator<Integer> it = ActiveKind.list.keySet().iterator();

		while (it.hasNext()) {
			int num=it.next();
		    System.out.println(num+"_"+ActiveKind.list.get(num));
		}
		// TODO Auto-generated method stub

	}

}
