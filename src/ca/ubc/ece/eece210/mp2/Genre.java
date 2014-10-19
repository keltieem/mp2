package ca.ubc.ece.eece210.mp2;

import java.util.ArrayList;

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
		
		for(int index=1; index < newGenre.size(); index++){
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
	public void addToGenre(int key, String name) {
		super.addChild(key, name);
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