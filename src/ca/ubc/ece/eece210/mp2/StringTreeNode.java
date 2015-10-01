package ca.ubc.ece.eece210.mp2;

/**
 * 
 * @author Keltie Murdoch, Emmanuel Ioannides
 * 
 */

public class StringTreeNode {
    public String rootGenre;
    public StringTreeNode left;
    public StringTreeNode right;
    public int rootNode;
    
    
    public StringTreeNode(String rootGenre, StringTreeNode left, StringTreeNode right){
        
        this.rootGenre = rootGenre;
        this.left = left;
        this.right = right;
        
        
        
        if(rootGenre != null){
            if (left == null && right == null){
                rootNode = 1;
            }
            else rootNode = 0;
        }
        
        
    }
    
}
