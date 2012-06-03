package com.util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.tht.person.People;

public class ReadExcel {

    static final String FILENAME = "list.csv";


    public ReadExcel() {

    }

    private void doLoadFromFile(File f) {
        try {
        	People bean=new People();
        	ArrayList<People> list=new ArrayList<People>();
            Date day = new Date();
            List<String> strList = FileUtils.readLines(f, "UTF-8");
            System.out.println(f.getAbsolutePath()); 
            for (String line : strList) {
            	People people=new People();
                String[] columns = line.split(",");
                if (columns.length < 4) continue;
            	System.out.println(columns[0].trim() + " "+columns.length);
            	people.setPeople_name(MyUtil.replaceMasks(columns[10].trim()));
                if(columns[12].trim().equals("")){
                	people.setPeople_gender(9);
                }else{
                	if(MyUtil.replaceMasks(columns[12].trim()).equals("¨k")){
                		people.setPeople_gender(1);
                	}else{
                		people.setPeople_gender(0);
                	}
                	
                }                
                people.setPeople_lunerBirthday(MyUtil.replaceMasks(columns[13].trim()));
                people.setPeople_birthday(MyUtil.replaceMasks(columns[14].trim()));
                if(columns.length>16){
                	people.setPeople_address(MyUtil.replaceMasks(columns[16].trim()));
                }
                list.add(people);
            }
            try {
				bean.save(list.toArray(new People[]{}));
				System.out.println("success");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
    	ReadExcel ap=new ReadExcel();
        File f = new File("/Users/Mac/MyProject/THT/tomcat/bin/list.csv");
        ap.doLoadFromFile(f);
        System.out.println("api key load success");
    }

}

