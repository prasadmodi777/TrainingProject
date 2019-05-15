package emp;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;



public class Dom4jXmlGen {
	
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("cars.properties");
		
		Properties properties = new Properties();
		properties.load(fileReader);
		
		
		
		
		Document doc=DocumentFactory.getInstance().createDocument();
		Element root=doc.addElement(properties.getProperty("root"));
		 
		Element supe=root.addElement(properties.getProperty("subroot"));

		Element child1=supe.addElement("carid");
		child1.addText(properties.getProperty("carid"));
		
		Element child2=supe.addElement("carname");
		child2.addText(properties.getProperty("carname"));
		
		FileOutputStream fos=new FileOutputStream("supercars.xml");
		
		OutputFormat out= OutputFormat.createCompactFormat();
		
		XMLWriter xw=new XMLWriter(fos,out);
		
		xw.write(doc);
		xw.flush();
		System.out.println("done");
	}

}
