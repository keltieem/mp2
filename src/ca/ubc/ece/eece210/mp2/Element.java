package ca.ubc.ece.eece210.mp2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * An abstract class to represent an entity in the catalogue. The element (in
 * this implementation) can either be an album or a genre.
 * 
 * @author Sathish Gopalakrishnan
 * 
 */
public abstract class Element { 
    
    Node root;
    
    class Node{
       int key;
       String name;
       
       Node leftChild;
       Node rightChild;
       
       Node (int key, String name){
           this.key = key;
           this.name = name;
       }
        
    }

	/**
	 * Returns all the children of this entity. They can be albums or genres. In
	 * this particular application, only genres can have children. Therefore,
	 * this method will return the albums or genres contained in this genre.
	 * 
	 * @return the children
	 */
	public void getChildren(Node element) {

	    inOrderTraverseTree(element);
	    
	}


    private ArrayList<Node> inOrderTraverseTree(Node element) {
  
        ArrayList<Node> children = new ArrayList<Node>();
        
        if (element != null) {
            inOrderTraverseTree(element.leftChild);
            children.add(element);
            inOrderTraverseTree(element.rightChild);
            children.add(element);
        }
        return children;    
    
        
    }


    /**
	 * Adds a child to this entity. Basically, it is adding an album or genre to
	 * an existing genre
	 * 
	 * @param b
	 *            the entity to be added.
	 */
	protected void addChild(int key, String name) {
	        Node newChild = new Node(key, name);

	        if (root == null) {
	            root = newChild;
	        } else {

	            Node focusNode = root;

	            Node parent;

	            while (true) {
	                
	                parent = focusNode;

	                if (key < focusNode.key) {
	                    focusNode = focusNode.leftChild;
	                    
	                    if(focusNode.leftChild != null){
	                        throw new IllegalArgumentException("Cannot add children to an album!");
	                    }
	                    else{    
	                        int count;
	                        
	                        for (count = 0; count < 1; count++){
	                            parent.leftChild = newChild;
	                            return;
	                        }
	                       }   
	                    }

	                else { 
	                    focusNode = focusNode.rightChild;

	                    if (focusNode == null) {
	                        parent.rightChild = newChild;
	                        return; 
	                    }
	                }
	            }
	        }
	    }
	    

	/**
	 * Abstract method to determine if a given entity can (or cannot) contain
	 * any children.
	 * 
	 * @return true if the entity can contain children, or false otherwise.
	 */
	public abstract boolean hasChildren();

    public void removeChild(int key) {

        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                System.out.println("Child not found.");
        }
        focusNode = null;
    }
    
    public Node findNode(int key){
        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                System.out.println("Node not found.");
        }
        return focusNode;
        
    }
}