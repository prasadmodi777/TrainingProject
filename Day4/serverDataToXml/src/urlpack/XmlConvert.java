package urlpack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class XmlConvert {


	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException, IOException, org.json.simple.parser.ParseException {


		JSONParser parser = new JSONParser();

		try {         
			URL url = new URL("http://localhost:8081/jsonproj/json"); // URL to Parse
			java.net.URLConnection yc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {               
				JSONArray a = (JSONArray) parser.parse(inputLine);

				// Loop through each item
				for (Object o : a) {
					JSONObject jsonobj = (JSONObject) o;

					Document doc=DocumentFactory.getInstance().createDocument();
					Element root=doc.addElement((String) jsonobj.get("car"));
					Element supe=root.addElement((String) jsonobj.get("id"));
					Element child1=supe.addElement((String) jsonobj.get("model"));
					Element child2=supe.addElement((String) jsonobj.get("year"));

					FileOutputStream fos=new FileOutputStream("supercars.xml");

					OutputFormat out= OutputFormat.createCompactFormat();

					XMLWriter xw=new XMLWriter(fos,out);

					xw.write(doc);
					xw.flush();
					System.out.println("done");
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}  




	}

}
