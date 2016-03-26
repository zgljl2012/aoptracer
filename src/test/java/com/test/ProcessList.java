package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ProcessList {
	
	public static void main(String[] args) {
		try {
		    String line;
		    Process p = Runtime.getRuntime().exec(
		    		 (System.getenv("windir") +"\\system32\\"+"tasklist.exe"));
		    BufferedReader input =
		            new BufferedReader(
		            		new InputStreamReader(p.getInputStream(), 
		            				Charset.forName("GBK")));
		    while ((line = input.readLine()) != null) {
		        System.out.println(line); //<-- Parse data here.
		    }
		    input.close();
		} catch (Exception err) {
		    err.printStackTrace();
		}
	}
}
