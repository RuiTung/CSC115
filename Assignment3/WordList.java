/**
 * For Assignment: , June 30th, 2015 
 * WordList.java
 */


public class WordList {

    WordListNode head;


/**
*constructor for WordList
*/
    public WordList() {
        
        this.head = null;

    }


    /**
    * Insert a task for head into a list
    * @para w string to be placed into the list
    */
    public void insertHead(String w) {

        WordListNode node = new WordListNode(w);
        node.next = head;
        head = node;

    }


    /**
    * Remove the head of the list
    */

    public void removeHead() {

        if(isEmpty()) {

            System.err.println("List is empty, no items will be removed.");
            System.exit(-1);

        } else {

            if(head.next != null) {

                head = head.next;

            } else {

                head = null;
            }
        }
    }


    /**
    * Examins whether the list contains the item
    * @para w string to be placed to compare
    * @return boolean value that shows whether
    *or not the list contains w
    */
    public boolean contains(String w) {

        WordListNode curr = head;
        
        while(curr != null) {

            if (curr.word.equals(w)) {

                return true;

            } else {

                curr = curr.next;
            }
        }

        return false;

    }


    /**
    * Examine the task is empty or not
    * @return booleanvalue that shows whether
    * or not the list is empty
    */

    public boolean isEmpty() {

        return (head == null);

    }


    /**
    * Get the length of the list
    * @return the length of the list
    */
    public int getLength() {

        int length = 0;
        WordListNode curr = head;

        while(curr != null) {

            length++;
            curr = curr.next;
        }

        return length;

    }


    /**
    * Retrieve tasks in the list
    * @para index indicate the retrieve location
    * @return string task
    */
    public String retrieve(int index) {

       if(isEmpty()) {

            System.err.println("List is Empty, no items will be retrieved.");
            System.exit(-1);
        }

        WordListNode curr = head;

        for(int i = 0; i <= index; i++) {

            if(curr.next != null) {

                curr = curr.next;
            }
       }

       String result = curr.word;
       return result;
    }


    /**
    * Get the String type of the String itself
    * @return String itself
    */
    public String toString() {

        String result = "";
        WordListNode curr = head;

        while(curr != null) {

            result += curr.word;
            result += "\t";
            curr = curr.next;
        }

        return result;
    }


    /**
    * main method for test case that makes the code run
    */
    public static void main(String [] args) {

        WordList test = new WordList();

        //test case 1: before insert a task, whether the list is empty.
        if(test.isEmpty() == true) {
            System.out.println("Test1 of 'isEmpty' method passed.");
        } else {
            System.out.println("Test1 of 'isEmpty' method failed.");
        }

        //test case 2: after insert a task, whether the list head 
        //is inserted one.
        test.insertHead("hello");
        if(test.contains("hello")) {
            System.out.println("\nTest2 of 'insertHead' method passed.");
        } else {
            System.out.println("\nTest2 of 'insertHead' method failed.");
        }

        //test case 3: after insert a task, whether the list is empty.
        if(test.isEmpty() != true) {
            System.out.println("\nTest3 of 'isEmpty' method passed.");
        } else {
            System.out.println("\nTest3 of 'isEmpty' method failed.");
        }

        //test case 4: after insert a task, whether the list length is 1.
        test.getLength();
        if(test.getLength() == 1) {
            System.out.println("\nTest4 of 'getLength' method passed.");
        } else {
            System.out.println("\nTest4 of 'getLength' method failed.");
        }

        //test case 5: after insert a task, whether the list contains 
        //the inserted task.
        if(test.contains("hello") == true) {
            System.out.println("\nTest5 of 'contains' method passed.");
        } else {
            System.out.println("\nTest5 of 'contains' method failed.");
        }

        //test case 6: after insert a task, whether the inserted task
        //can be retrieved.
        if(test.retrieve(0).equals("hello")) {
            System.out.println("\nTest6 of 'retrieve' method passed.");
        } else {
            System.out.println("\nTest6 of 'retrieve' method failed.");
        }

        //test case 7: whether the head of the list can be removed, 
        //and it works,now the length of the list is 0.
        test.removeHead();
        if(test.getLength() == 0) {
            System.out.println("\nTest7 of 'removeHead' method passed.");
        } else {
            System.out.println("\nTest7 of 'removeHead' method failed.");
        }

        //test case 8: after remove the only task of the list,
        //whether the length of the list is 0.
        if(test.getLength() == 0) {
            System.out.println("\nTest8 of 'getLength' method passed.");
        } else {
            System.out.println("\nTest8 of 'getLength' method failed.");
        }

    }

}