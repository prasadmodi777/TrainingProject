package jsonoutputpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class JsonOutPut extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		  JSONObject json = new JSONObject();

		    json.put("car", "lambo");
		    json.put("id", "lamboId");
		    json.put("model", "advanced");
		    json.put("year", "2010");


		    out.print(json.toString());
		
		
	}

}
