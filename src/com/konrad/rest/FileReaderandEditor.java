package com.konrad.rest;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class FileReaderandEditor {
	public String line;
	public static String cityxml = "";
	public static String sunrise = "";
	public static String sunset = "";
	public static String temp = "";
	public static String gifurl = "";
	
	public static void reader() throws IOException	{
	
	File f=new File("source\\weather.xml");
    FileReader fr=new FileReader(f);
    BufferedReader br=new BufferedReader(fr);

    String line;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    // IMPORTANT: Save the old System.out!
    PrintStream old = System.out;
    // Tell Java to use your special stream
    System.setOut(ps);
    while((line=br.readLine())!=null)
    {
        System.out.println(line);      
    }
    System.out.flush();
    System.setOut(old);
    // Show what happened
    String dates =  baos.toString();
//    System.out.println(dates);
    

    cityxml = dates.substring(
    		dates.lastIndexOf("city") + 6,
    		dates.lastIndexOf("city") + 10);

	sunrise = dates.substring(
    		dates.lastIndexOf("sunrise") + 9,
    		dates.lastIndexOf("sunrise") + 16);
	
	sunset = dates.substring(
    		dates.lastIndexOf("sunset") + 8,
    		dates.lastIndexOf("sunset") + 15);
    
	temp = dates.substring(
    		dates.lastIndexOf("temp") + 6,
    		dates.lastIndexOf("temp") + 8);
	
	gifurl = dates.substring(
    		dates.lastIndexOf("img src") + 9,
    		dates.lastIndexOf("\"/><br") - 0);

	
	}
	
	}
