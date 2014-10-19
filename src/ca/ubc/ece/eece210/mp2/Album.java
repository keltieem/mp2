package ca.ubc.ece.eece210.mp2;

import java.util.ArrayList;

/**
 * 
 * @author Sathish Gopalakrishnan
 * 
 * This class contains the information needed to represent 
 * an album in our application.
 * 
 */

public final class Album extends Element {
    String title;
    String performer;
    ArrayList<String> songlist = new ArrayList<String>();
    
    
	/**
	 * Builds an album with the given title, performer and song list
	 * 
	 * @param title
	 *            the title of the album
	 * @param author
	 *            the performer 
	 * @param songlist
	 * 			  the list of songs in the album
	 */
	public Album(String title, String performer, ArrayList<String> songlist) {
		
	       ArrayList<String> newAlbum = new ArrayList<String>();
	        newAlbum.add(title);
	        newAlbum.add(performer);
	        newAlbum.addAll(songlist);
		
	}

	/**
	 * Builds an album from the string representation of the object. It is used
	 * when restoring an album from a file.
	 * 
	 * @param stringRepresentation
	 *            the string representation
	 */
	public Album(String stringRepresentation) {

	    String[] splitArray = stringRepresentation.split("<\then>");

	}

	/**
	 * Returns the string representation of the given album. The representation
	 * contains the title, performer and songlist, as well as all the genre
	 * that the book belongs to.
	 * 
	 * @return albumString: the string representation
	 */
	public String toString(ArrayList<String> newAlbum) {
        String albumString = new String();  
        
        for(int index=0; index < newAlbum.size(); index++){
           albumString += newAlbum.get(index) + "<\then>";
        }
        
        return albumString;
	}

	/**
	 * Add the book to the given genre
	 * 
	 * @param genre
	 *            the genre to add the album to.
	 */
	public void addToGenre(Genre genre) {
		addChild(genre);
	}

	
	/**
	 * Finds child in genre and rewrites it as a null node
	 * 
	 * @param b the child to remove
	 */
	public void removeFromGenre(Element b){
	    removeChild(b);
	}
	
	/**
	 * Returns the genre that this album belongs to.
	 * 
	 * @return the genre that this album belongs to
	 */
	public Genre getGenre() {
	    return (Genre) parent;
	   
	}

	/**
	 * Returns the title of the album
	 * 
	 * @return title: the title
	 */
	public String getTitle(ArrayList<String> newAlbum) {
	    String title = new String();
	    
	    title = newAlbum.get(0);
	    
		return title;
	}

	/**
	 * Returns the performer of the album
	 * 
	 * @return performer: the performer
	 */
	public String getPerformer(ArrayList<String> newAlbum) {
	    String performer = new String();
	    
	    performer = newAlbum.get(1);
	    
		return performer;
	}

	/**
	 * An album cannot have any children (it cannot contain anything).
	 */
	@Override
	public boolean hasChildren() {
		return false;
	}
}
