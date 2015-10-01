package ca.ubc.ece.eece210.mp2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a genre (or collection of albums/genres).
 * 
 * @author Sathish Gopalakrishnan, Keltie Murdoch, Emmanuel Ioannides
 * 
 */
public final class Genre extends Element {
    String newGenreName;

    /**
     * Creates a new genre with the given name.
     * 
     * @param name
     *            the given name of the genre.
     */
    public Genre(String name) {

        newGenreName = name;

    }

    /**
     * Restores a genre from its given string representation. Splits a string by
     * each instance of the substring "<\then>".
     * 
     * @param stringRepresentation
     *            : the representation of a Genre as a String to be split.
     * @return splitArray: an array of strings split from the original
     *         stringRepresentation.
     */
    public static String[] restoreCollection(String stringRepresentation) {

        String[] splitArray = stringRepresentation.split("<\then>");

        return splitArray;
    }

    /**
     * Returns the string representation of a genre
     * 
     * @param newGenre
     *            : an ArrayList which holds all the children of a parent genre
     * @return genreString: the string representation of a genre
     */
    public String toString() {
        String genreString = new String();
        ArrayList<Element> newGenre = new ArrayList<Element>();

        newGenre = getChildren(parent);

        genreString = newGenreName + "<\then>";

        for (int index = 1; index < newGenre.size(); index++) {
            genreString += newGenre.get(index) + "<\then>";
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
        addChild(b);
    }

    /**
     * Returns true, since a genre can contain other albums and/or genres.
     */
    @Override
    public boolean hasChildren() {
        return true;
    }
}
