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
		
		Properties p = new Properties();
		p.load(fileReader);
		
		
		
		
		Document doc=DocumentFactory.getInstance().createDocument();
		Element root=doc.addElement(p.getProperty("root"));
		 
		Element supe=root.addElement(p.getProperty("subroot"));

		Element child1=supe.addElement("carid");
		child1.addText(p.getProperty("carid"));
		
		Element child2=supe.addElement("carname");
		child2.addText(p.getProperty("carname"));
		
		FileOutputStream fos=new FileOutputStream("supercars.xml");
		
		OutputFormat out= OutputFormat.createCompactFormat();
		
		XMLWriter xw=new XMLWriter(fos,out);
		
		xw.write(doc);
		xw.flush();
		System.out.println("done");
	}

}
