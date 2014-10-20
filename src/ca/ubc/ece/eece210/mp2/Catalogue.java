package ca.ubc.ece.eece210.mp2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Container class for all the albums and genres. Its main 
 * responsibility is to save and restore the collection from a file.
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
public final class Catalogue {
    
    ArrayList<Genre> listOfGenres;
    
    /**
	 * Builds a new, empty catalogue.
	 */
	public Catalogue() {
	    
	    ArrayList<Genre> catalogue = new ArrayList<Genre>();
		
	}

	/**
	 * Builds a new catalogue and restores its contents from the 
	 * given file.
	 * 
	 * @param fileName
	 *            the file from where to restore the library.
	 * @throws FileNotFoundException 
	 */
	public Catalogue(String fileName) throws FileNotFoundException {
		
	    Scanner input = new Scanner(new File(fileName));
		String line = new String();
		ArrayList<String> catalogue = new ArrayList<String>();
		
		while (input.hasNextLine()){   
		   line = input.nextLine();
		   catalogue.add(Genre.restoreCollection(line));
		   
		}
	    
	    
	    
	}

	/**
	 * Saved the contents of the catalogue to the given file.
	 * @param fileName the file where to save the library
	 * @throws FileNotFoundException 
	 */
	public void saveCatalogueToFile(String fileName) throws FileNotFoundException {
	    File newCatalogue = new File(fileName);
	    PrintStream outputFile = new PrintStream(newCatalogue);
	    
	    for (Genre genre : listOfGenres){
	    outputFile.println(genre.toString());
	    }
	}
	
	  
	   
	
	
	
	
	    
}
	
	
	
	
	
