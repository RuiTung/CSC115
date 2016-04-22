/**
 * For Assignment: , July 17th, 2015 
 * StringStackRefBased.java
 * This is the implementation of StringStack.
 */


public class StringStackRefBased implements StringStack {

    private  StringNode top = null;

    /**
    * constructor of StringStackRefBased
    */
    public StringStackRefBased() {
        
    }

    /**
     * Returns true if there are no strings in the stack; false
     * otherwise.
     * @return true or false as described
     */
    public boolean isEmpty() {

        return (top == null);
    }

    /**
     * If the stack contains at least one string, then the string
     * at the top of the stack is removed, and the value contained
     * returned to the caller. Otherwise if the stack was empty
     * at the start of the method, then a StringStackException must
     * be thrown.
     *
     * @return the value of the String at the top of the stack.
     */
    public String pop() throws StringStackException {
        
        try {
            if(!isEmpty()) {
                String result = top.item;
                top = top.next;
                return result;
            } else {
                throw new StringStackException("Method 'pop': Empty Stack");
            }
        } catch(StringStackException ex) {
             throw ex;
        }
    }

    /**
     * Clears the stack such that is contains no elements (i.e.,
     * isEmpty() on the stack will be true after this call completes).
     */
    public void popAll() {

        top = null;
    }

    /**
     * Places the item onto the top of the stack. However, if there
     * is no room in which to place this item, then the method
     * must instead thrown a StringStackException.
     */
    public void push(String item) throws StringStackException {

        try {
            if(item != null) {
                StringNode head = top;
                top = new StringNode(item);
                top.next = head;
            } else {
                throw new StringStackException("Method 'push': Parameter item is null");
            }
        } catch(StringStackException ex) {
            throw ex;
        }
    }

    /**
     * If the stack contains at least one string, then the value of
     * the String at the top of the stack is returned to the caller.
     * Otherwise if the stack was empty at the start of the method, 
     * then a StringStackException must be thrown. This method
     * does not modify the stack's contents.
     *
     * @return the value of the String at the top of the stack.
     */
    public String peek() throws StringStackException {
        
        try {
            if(!isEmpty()) {
              return top.item;
            } else {
                throw new StringStackException("Method 'peek': Empty Stack.");
            }
        } catch(StringStackException ex){
            throw ex;
        }

    }

    // main method for testing
    public static void main(String[] args) throws StringStackException {

        StringStackRefBased test = new StringStackRefBased();

        System.out.println("Test for StringStackRefBased.java starts.");

        // test case1: check the empty status before push any item into
        // the stack.
        if(test.isEmpty()) {
            System.out.println("\nTest1 of isEmpty passed.");
        } else {
            System.out.println("\nTest1 of isEmpty failed.");
        }
        
        // test case2: check the peek method exception.
        try {
            test.peek();
            System.out.println("\nTest2 of pop failed.");
        } catch(StringStackException ex) {
            System.out.println("\nTest2 of peek passed.");
        }
        
        // test case3: check the pop method exception.   
        try {
            test.pop();
            System.out.println("\nTest3 of pop failed.");
        } catch(StringStackException ex) {
            System.out.println("\nTest3 of pop passed.");
        }

        // test case4: check the push method exception.
        try {
            test.push(null);
            System.out.println("\nTest4 of push failed.");
        } catch(StringStackException ex) {
            System.out.println("\nTest4 of push passed.");
        }
        
        // test case5: check the empty status after push
        // into an item into the stack.
        try {
            test.push("1st");
            if(!test.isEmpty()) {
                System.out.println("\nTest5 of push passed.");
            } else {
                System.out.println("\nTest5 of push failed.");
                throw new StringStackException("Empty Stack.");
            }
        } catch(StringStackException ex) {
            throw ex;
        }
        
        // test case6: check peek method after push into
        // an item into the stack.      
        try {
            if(test.peek().equals("1st")) {
                System.out.println("\nTest6 of peek passed.");
            } else {
                System.out.println("\nTest6 of peek failed.");
                throw new StringStackException("Empty Stack");
            }
        } catch(StringStackException ex) {
            throw ex;
        }

        // test case7: check popAll method after insertion 
        // several items into the stack
        test.push("2nd");
        test.push("3rd");
        test.popAll();
        if(test.isEmpty()) {
            System.out.println("\nTest7 of popAll passed.");
        } else {
            System.out.println("\nTest7 of popAll failed.");
        }

        System.out.println("\nTest for StringStackRefBased.java ends.");
    }
}