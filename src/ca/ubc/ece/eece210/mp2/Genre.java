package ca.ubc.ece.eece210.mp2;

import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Represents a genre (or collection of albums/genres).
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
public final class Genre extends Element {

	/**
	 * Creates a new genre with the given name.
	 * 
	 * @param name
	 *            the name of the genre.
	 */
	public Genre(String name) {
	
	    ArrayList<String> newGenre = new ArrayList<String>();
	    newGenre.add(name);
	    
	    
	}

	/**
	 * Restores a genre from its given string representation.
	 * 
	 * @param stringRepresentation
	 */
	public static Genre restoreCollection(String stringRepresentation) {
		
	    String[] splitArray = stringRepresentation.split(" ");
	    
	    
		return null;
	}

	/**
	 * Returns the string representation of a genre
	 * 
	 * @return genreString: the string representation of a genre
	 */
	public String toString(ArrayList<String> newGenre) {
		String genreString = new String();	
		
		for(int index=0; index < newGenre.size(); index++){
	       genreString += newGenre.get(index) + " ";
		}
	    
		return genreString;
	}

	/**
	 * Adds the given album or genre to this genre
	 * 
	 * @param b
	 *            the element to be added to the collection.
	 */
	public void addToGenre(Element b) {
		super.addChild(b);
	}

	/**
	 * Returns true, since a genre can contain other albums and/or
	 * genres.
	 */
	@Override
	public boolean hasChildren() {
		return true;
	}
}