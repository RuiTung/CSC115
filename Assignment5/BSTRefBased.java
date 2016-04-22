/**
 * For Assignment: , July 27th, 2015
 * BSTRefBased.java
 * This is the reference-based implementation of the ADT binary search tree.
 */

import java.util.Iterator;

public class BSTRefBased extends AbstractBinaryTree implements Iterable<WordRefs> {
	
    private TreeNode root;
 
    public BSTRefBased() {
        root = null;
    }
    
    /**
     * Constructor for BSTRefBased
     * @param item
     * @param left
     * @param right
     */
    public BSTRefBased(WordRefs item, AbstractBinaryTree left, AbstractBinaryTree right) {
    	
        root = new TreeNode(item, null, null);
        
        if (left != null) {
            attachLeftSubtree(left);
        }
        
        if (right != null) {
            attachRightSubtree(right);
        }
    }

    /**
     * Check whether the binary search tree is empty or not
     * @return boolean value to demonstrate the empty situation
     *	for true if the BST is empty, for false if the BST is not empty
     */
    public boolean isEmpty() {
    	
        return (root == null);
        
    }

    /**
     * According to assign root equals null to make the whole
     * BST empty
     */
    public void makeEmpty() {
    	
        root = null;
    
    }

    /**
     * Get the root node of the BST
     * @return the root node
     */
    protected TreeNode getRoot() {
    	
        return root;
    
    }

    /**
     * Assign root to another value
     * @param TreeNode r is the one that waiting to be assigned to the root
     */
    protected void setRoot(TreeNode r) {
    	
        this.root = r;
    
    }
    
    /**
     * Get the root item and thorws expcetion if the root is null object
     * @return root item
     */
    public WordRefs getRootItem() throws TreeException {
    	
        if (root == null) {
            throw new TreeException("getRootItem() on empty tree");
        }

        return root.item;
        
    }

    /**
     * Assign item to the root.
     * @param item is the one that waiting to be assigned to the root.
     */
    public void setRootItem(WordRefs item) {
    	
        if (root == null) {
            root = new TreeNode(item);
        } else {
            root.item = item;
        }
        
    }

    /**
     * Attach left subtree to the BST.
     * @param item is the one that waiting to be assigned to the left subtree.
     */
    public void attachLeft(WordRefs item) throws TreeException {
    	
        if (isEmpty()) {
            throw new TreeException("attachLeft to empty tree");
        }

        if (!isEmpty() && root.left != null) {
            throw new TreeException("attachLeft to occupied left child");
        }

        root.left = new TreeNode(item, null, null);

        return;
    } 

    /**
     * Set left subtree according to the parameter.
     * @param AbstractBinaryTree left
     */
    public void attachLeftSubtree(AbstractBinaryTree left) {
    	
        if (isEmpty()) {
            throw new TreeException("attachLeftSubtree to empty tree");
        }

        if (!isEmpty() && root.left != null) {
            throw new 
                TreeException("attachLeftSubtree to occupied right child");
        }

        root.left = left.getRoot();
        left.makeEmpty();

        return;    
        
    }

    /**
     * Attach right subtree to the BST.
     * @param item is the one that waiting to be assigned to the right subtree.
     */
    public void attachRight(WordRefs item) throws TreeException {
    	
        if (isEmpty()) {
            throw new TreeException("attachRight to empty tree");
        }

        if (!isEmpty() && root.right != null) {
            throw new TreeException("attachRight to occupied right child");
        }

        root.right = new TreeNode(item, null, null);

        return;
        
    } 

    /**
     * Set right subtree according to the parameter.
     * @param AbstractBinaryTree right
     */
    public void attachRightSubtree(AbstractBinaryTree right) {
    	
        if (isEmpty()) {
            throw new TreeException("attachRightSubtree to empty tree");
        }

        if (!isEmpty() && root.right != null) {
            throw new 
                TreeException("attachRightSubtree to occupied right child");
        }

        root.right = right.getRoot();
        right.makeEmpty();

        return;
        
    }

    /**
     * Remove left subtree from the BST.
     * This method will throws exception if the root is null object
     * @return a new BST
     */
    public AbstractBinaryTree detachLeftSubtree() throws TreeException {
    	
        if (root == null) {
            throw new TreeException("detachLeftSubtree on empty tree");
        }

        BSTRefBased result = new BSTRefBased();
        result.setRoot(root.left);
        root.left = null;

        return result;
        
    }

    /**
     * Remove right subtree from the BST.
     * This method will throws exception if the root is null object
     * @return a new BST
     */
    public AbstractBinaryTree detachRightSubtree() throws TreeException {
    	
        if (root == null) {
            throw new TreeException("detachLeftSubtree on empty tree");
        }

        BSTRefBased result = new BSTRefBased();
        result.setRoot(root.right);
        root.right = null;

        return result;
        
    }

    /**
     * Insert root into the BST
     * @param word
     */
    public void insert(String word) {
    	
    	root = insertItem(root,word);
    
    }

    /**
     * Insert the new node according to the parameter.
     * @param r 
     * @param word the one that waiting to be inserted
     * @return node
     */
    protected TreeNode insertItem(TreeNode r, String word) {
    	
        if(r == null) {
            WordRefs reference = new WordRefs(word);
        	return new TreeNode(reference);  
        }
        
        if(word.compareTo(r.item.getWord()) < 0) {
        	r.left = insertItem(r.left,word);
        } else {
        	r.right = insertItem(r.right,word);
        }
        
        return r;
    }

    /**
     * Retrieve the string according to the parameter
     * @param word is the one that waiting to be retrieved.
     * @return item
     */
    public WordRefs retrieve(String word) {
   	
       	if(retrieveItem(root, word) == null) {
       		return null;
       	} else {
       		return retrieveItem(root, word).item;
       	}
    }
    	
    

    /**
     * Retrieve node according to the parameter
     * @param r
     * @param word the one that waiting to be retrieved
     * @return node
     */
    protected TreeNode retrieveItem(TreeNode r, String word) {
    	
    	TreeNode element;
    	
        if(r == null) {
        	return null;
        } else {
        	if(word.compareTo(r.item.getWord()) == 0) {
            	element = r;
            } else if(word.compareTo(r.item.getWord()) < 0) {
            	element = retrieveItem(r.left, word);
            } else {
            	element = retrieveItem(r.right, word);
            }
        	return element;
        }
        
    }

    /**
     * Delete item according to the parameter
     * @param word is the one that waiting to be deleted
     */
    public void delete(String word) {
    	
    	root = deleteItem(root, word);
    	
    }

    /**
     * Delete item according to the parameter
     * @param r
     * @param word is the one that waiting to be deleted
     * @return node
     */
    protected TreeNode deleteItem(TreeNode r, String word) {
    	
    	if(r == null) {
    		return null;
    	} else {
    		if(word.compareTo(r.item.getWord()) == 0) {
        		r = deleteNode(r);
        	} else if(word.compareTo(r.item.getWord()) < 0) {
        		r.left = deleteItem(r.left, word);
        	} else {
        		r.right = deleteItem(r.right, word);
        	}
        	return r;
    	}
    	
    }

    /**
     * Delete the node according to the parameter
     * @param node is the one that waiting to be deleted
     * @return node
     */
    protected TreeNode deleteNode(TreeNode node) {
    	
    	if(node.left == null && node.right ==null) {
    		return null;
    	} else if(node.left == null) {
    		return node.right;
    	} else if(node.right == null) {
    		return node.left;
    	} else {
    		node.item = findLeftMost(node.right).item;
    		node.right = deleteLeftMost(node.right);
    		return node;
    	}
    	
    }

    /**
     * Find the leftmost node the BST
     * @param node is the one that waiting to be found
     * @return node
     */
    protected TreeNode findLeftMost(TreeNode node) {
    	
    	if(node.left == null) {
    		return node;
    	} else {
    		return (findLeftMost(node.left));
    	}
    	
    }
        
    /**
     * Delete the leftmost node of the BST according to the parameter
     * @param node is the one that waiting to be deleted.
     * @return node
     */
    protected TreeNode deleteLeftMost(TreeNode node) {
    	
    	if(node.left == null) {
    		return node.right;
    	} else {
    		node.left = deleteLeftMost(node.left);
    		return node;
    	}
    	
    }

    public Iterator<WordRefs> iterator() {
        return new BSTIterator(this);
    }


    public static void main(String args[]) {
        BSTRefBased t;
        AbstractBinaryTree tt;
        int i;
        boolean result;
        String message;

        message = "Test 1: inserting 'humpty' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            result = t.getRootItem().getWord().equals("humpty");
        } catch (Exception e) {
            result = false;
        }
        System.out.println("\n" + message + (result ? "passed" : "FAILED"));

        message = "Test 2: inserting 'humpty', 'dumpty', 'sat' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            result = t.getRootItem().getWord().equals("humpty");
            tt = t.detachLeftSubtree();
            result &= tt.getRootItem().getWord().equals("dumpty");
            tt = t.detachRightSubtree();
            result &= tt.getRootItem().getWord().equals("sat");
        } catch (Exception e) {
            result = false;
        }
        System.out.println("\n" + message + (result ? "passed" : "FAILED"));
        
       BSTRefBased t1 = new BSTRefBased();
       if(t1.isEmpty()) {
    	   System.out.println("\nTest 3 of 'isEmpty' passed.");
       } else {
    	   System.out.println("\nTest 3 of 'isEmpty' FAILED.");
       }
       
       BSTRefBased t2 = new BSTRefBased();
       t2.insert("blue");
       t2.insert("green");
       t2.insert("aquamarine");
       t2.insert("cornsilk");  
       TreeNode retrieveNode1 = t2.retrieveItem(t2.root, "blue");
       if(retrieveNode1.item.getWord().equals("blue")) {
    	   System.out.println("\nTest 4 of 'retrieveItem' passed." );
       } else {
    	   System.out.println("\nTest 4 of 'retrieveItem' FAILED." );
       }
       
       t2.delete("cornsilk");
       TreeNode retrieveNode2 = t2.retrieveItem(t2.root, "cornsilk");
       if(retrieveNode2 == null) {
    	   System.out.println("\nTest 5 of 'delete' passed.");
       } else {
    	   System.out.println("\nTest 5 of 'delete' FAILED.");
       }
       
       BSTRefBased t3 = new BSTRefBased();
       t3.insert("blue");
       t3.insert("green");
       t3.insert("aquamarine");
       t3.insert("cornsilk"); 
       t3.insert("black");
       TreeNode retrieveNode3 = t3.findLeftMost(t3.root);
       if(retrieveNode3.item.getWord().equals("aquamarine")) {
    	   System.out.println("\nTest 6 of 'findLeftMost' passed.");
       } else {
    	   System.out.println("\nTest 6 of 'findLeftMost' FAILED.");
       }
    }
} 
