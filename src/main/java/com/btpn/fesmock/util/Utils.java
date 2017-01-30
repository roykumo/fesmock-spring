package com.btpn.fesmock.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Utils {
	public static byte[] readFully(InputStream stream) throws IOException
	{
	    byte[] buffer = new byte[8192];
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();

	    int bytesRead;
	    while ((bytesRead = stream.read(buffer)) != -1)
	    {
	        baos.write(buffer, 0, bytesRead);
	    }
	    return baos.toByteArray();
	}

	public static byte[] loadFile(String sourcePath) throws IOException
	{
	    InputStream inputStream = null;
	    try 
	    {
	        inputStream = new FileInputStream(sourcePath);
	        return readFully(inputStream);
	    } 
	    finally
	    {
	        if (inputStream != null)
	        {
	            inputStream.close();
	        }
	    }
	}
	
	public static HttpHeaders constructHttpHeaderForPdf(String filename, long contentLength){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.setContentType(new MediaType("application", "pdf"));
		headers.set("Content-Disposition", "inline; filename="+filename);
		headers.setContentLength(contentLength);
		
		return headers;
	}
}
