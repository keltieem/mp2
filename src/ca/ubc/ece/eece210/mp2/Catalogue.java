package ca.ubc.ece.eece210.mp2;

import java.io.*;
import java.util.Scanner;

/**
 * Container class for all the albums and genres. Its main 
 * responsibility is to save and restore the collection from a file.
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
public final class Catalogue {

	/**
	 * Builds a new, empty catalogue.
	 */
	public Catalogue() {
		File catalogue = new File("catalogue.txt"); // does not create new file on disk
		try {
            Scanner input = new Scanner(catalogue);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!"); //check that file (ln 19) exists
        }
		
	}

	/**
	 * Builds a new catalogue and restores its contents from the 
	 * given file.
	 * 
	 * @param fileName
	 *            the file from where to restore the library.
	 */
	public Catalogue(String fileName) {
		
	}

	/**
	 * Saved the contents of the catalogue to the given file.
	 * @param fileName the file where to save the library
	 */
	public void saveCatalogueToFile(String fileName) {
		// TODO implement
	}
	
	/**
	 * Assigns keys to each album or genre in a file based on their tag.
	 * <a> signifies an album, and <g> signifies a genre.
	 *
	 * @param genreNumber: the number of the tree to be constructed 
	 * @throws FileNotFoundException
	 */
	
	public void assignKeys(int genreNumber) throws FileNotFoundException{
        int numberOfGenres = 0; //keeps track of how many genres are in the file
        int numberOfAlbums = 0; //keeps track of how many albums are in the file
        int keyOfLine = genreNumber;
        int keyOfGenre;
        int keyOfAlbum;
        
	    Scanner input = new Scanner(new File("catalogue.txt"));
	    while (input.hasNextLine()){
	        int lineCount;
	        
	        for(lineCount = 1; input.hasNextLine(); lineCount++){
	        String line = input.nextLine();
	        
	        if (line.contains("<a>")){
	            numberOfAlbums++;
	        }
	        else if(line.contains("<g>")){
	            numberOfGenres++;
	        }
	        
	        if(line.contains("<g>")){
	            keyOfGenre = genreNumber*(genreNumber + (numberOfGenres*2));
	            keyOfLine = keyOfGenre;
	        }
	        else if(line.contains("<a>")){
	            keyOfAlbum = keyOfLine - 1;
	        }
	        
	      }  
	    }
	    
	}
	  
	   
	
	
	
	
	    
	}
	
	
	
	
	
