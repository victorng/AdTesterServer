package com.rdm.AdTester;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		FileInputStream fileInputStream = null;
		
		try {
			String requestedFile = request.getParameter("file");
			String physicalFile = "/Projects/AdTesterServer/conf/AdTester-PredefinedAdList.txt";
			
			if ( requestedFile != null ) {
				if ( requestedFile.equalsIgnoreCase("citytv.xml") ) {
					physicalFile = "/Projects/Citytv.xml";
				} else if ( requestedFile.equalsIgnoreCase("schedule1.json") ) {
					physicalFile = "/Projects/citytv_primetime_ipad/schedule1.json";
				} else if ( requestedFile.equalsIgnoreCase("schedule2.json") ) {
					physicalFile = "/Projects/citytv_primetime_ipad/schedule2.json";
				}
			}
			
			int currentOffset = 0;
			int bufferSize = 0;
			byte[] buffer = new byte[1024];
			
			fileInputStream = new FileInputStream(physicalFile);
			
			while ( (bufferSize = fileInputStream.read(buffer, 0, 1024)) > 0 ) {
				response.getOutputStream().write(buffer, 0, bufferSize);
				currentOffset += bufferSize;
			}
			response.addHeader("Content-Type", "text/plain");
			response.setContentLength(currentOffset);
		} catch ( Exception e ) {
			
		} finally {
			if ( fileInputStream != null ) {
				fileInputStream.close();
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
