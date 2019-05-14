package cxd;

import java.io.FileReader;
import java.util.Properties;

public class Props {
	
	public static void main1(String[] args) {
		
		try{
			FileReader fr=new FileReader("Emp.properties");
			
			Properties p=new Properties();
			p.load(fr);
			System.out.println(p.getProperty("empName"));
			System.out.println(p.getProperty("empId"));
			System.out.println(p.getProperty("empSal"));
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
