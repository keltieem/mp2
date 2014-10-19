package ca.ubc.ece.eece210.mp2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a genre (or collection of albums/genres).
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
public final class Genre extends Element {
    String newGenreName;
    
	/**
	 * Creates a new genre with the given name.
	 * 
	 * @param name
	 *            the name of the genre.
	 */
	public Genre(String name) {
	
	    newGenreName = name;
	    
	    
	}

	/**
	 * Restores a genre from its given string representation.
	 * 
	 * @param stringRepresentation
	 */
	public static String restoreCollection(String stringRepresentation) {
		
	    String[] splitArray = stringRepresentation.split("<\then>");
	    
		return splitArray[0];
	}

	/**
	 * Returns the string representation of a genre
	 * 
	 * @return genreString: the string representation of a genre
	 */
	public String toString() {
		String genreString = new String();
		ArrayList<Element> newGenre = new ArrayList<Element>();
		
		newGenre = getChildren(parent);
		
		genreString = newGenreName + "<\then>";
		
		for(int index=1; index < newGenre.size(); index++){
	       genreString += newGenre.get(index) + "<\then>";
		}
	    
		return genreString;
	}

	/**
	 * Adds the given album or genre to this genre
	 * 
	 * @param b
	 *          the element to be added to the collection.
	 */
	public void addToGenre(Element b) {
		addChild(b);
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