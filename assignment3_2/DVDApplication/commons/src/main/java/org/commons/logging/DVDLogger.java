package org.commons.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.model.DVD;


public class DVDLogger {
	
	private static final String FILE_NAME="log.txt";
	
	
	
	public DVDLogger(){
		try{
		    PrintWriter writer = new PrintWriter(FILE_NAME, "UTF-8");
		    writer.println("DVD-app logger");
		    writer.close();
		} catch (Exception e) {
		   System.out.println("The logger could not be initiated"+e);
		}
	}
	
	public void append(DVD dvdAdded){
		try{
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)));
			    out.println("DVD added: "+dvdAdded.toString());
			    out.close();
		} catch (Exception e) {
		   System.out.println("DVD could not be logged"+e);
		}
	}

}
