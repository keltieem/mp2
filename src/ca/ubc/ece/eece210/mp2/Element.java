package ca.ubc.ece.eece210.mp2;

import java.util.ArrayList;

/**
 * An abstract class to represent an entity in the catalogue. The element (in
 * this implementation) can either be an album or a genre.
 * 
 * @author Sathish Gopalakrishnan, Keltie Murdoch, Emmanuel Ioannides
 * 
 */
public abstract class Element {

    Element parent; // parent genre
    ArrayList<Element> genres = new ArrayList<Element>(); // list of all genres
    ArrayList<Element> albums = new ArrayList<Element>(); // list of all albums

    /**
     * Returns all the children of this entity. They can be albums or genres. In
     * this particular application, only genres can have children. Therefore,
     * this method will return the albums or genres contained in this genre.
     * 
     * 
     * @return children: an ArrayList of all albums and genres which are
     *         children to the parent genre.
     */
    public ArrayList<Element> getChildren(Element element) {
        ArrayList<Element> children = new ArrayList<Element>();

        if (albums.size() > 0) {
            children.addAll(albums);
        }
        if (genres.size() > 0) {
            children.addAll(genres);
        }

        return children;
    }

    /**
     * Adds an album or genre to an existing genre.
     * 
     * 
     * @param b
     *            : the album or genre to be added.
     */
    protected void addChild(Element b) {

        if (hasChildren()) {

            if (b instanceof Genre) {
                genres.add(b);
            }
            if (b instanceof Album) {
                albums.add(b);
            }
        }
    }

    /**
     * Removes an album or genre from a parent genre.
     * 
     * @param b
     *            : the album or genre to be removed.
     */

    protected void removeChild(Element b) {

        if (b instanceof Genre) {
            genres.remove(b);
        } else if (b instanceof Album) {
            albums.remove(b);
        }
    }

    /**
     * Abstract method to determine if a given entity can (or cannot) contain
     * any children.
     * 
     * @return true if the entity can contain children, or false otherwise.
     */
    public abstract boolean hasChildren();

}
