package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.parser.ParseException;

public class GettingDataUrl {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {


		try
		{
			URL url = new URL ("http://localhost:8081/jsonproj/json");

			BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( url.openStream()));

			String input;

			while ((input = bufferedReader.readLine()) != null)
			{
				System.out.println(input);
			}
			bufferedReader.close();			

	} catch (MalformedURLException me)
	{
		me.printStackTrace();
	} catch (IOException ie)
	{
		ie.printStackTrace();
	}



}

}