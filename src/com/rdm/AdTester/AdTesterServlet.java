package com.rdm.AdTester;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AdTesterServlet
 */
public class AdTesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdTesterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Print out contents of JSON file
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		
		try {
			fileReader = new FileReader("/Projects/AdTesterServer/conf/AdTester-PredefinedAdList.txt");
			bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			
			while ( (line = bufferedReader.readLine()) != null ) {
				stringBuffer.append(line);
			}
			
			response.getWriter().write(stringBuffer.toString());
		} catch ( Exception e ) {
			if ( fileReader != null ) {
				fileReader.close();
			}
			if ( bufferedReader != null ) {
				bufferedReader.close();
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
