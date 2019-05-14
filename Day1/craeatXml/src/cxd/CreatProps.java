package cxd;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreatProps {
	public static void main(String[] args) throws IOException {
		
		
		Properties p=new Properties();
		p.setProperty("comName","mobigesture");
		p.setProperty("addr","hyd");
		p.store(new FileWriter("D://compeny.properties"),"Javatpoint Properties Example");  
		System.out.println("done");
		
		
	
		
		
	}

}
