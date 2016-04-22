/**
 * For Assignment: , June 8th, 2015 
 * TaskListRefBased.java
 * This is the implements of TaskList interface.
 */


public class TaskListRefBased implements TaskList {

	TaskListNode head = null;
	
	
	/**
	 * constructor for TaskListRefBased
	 */
	public TaskListRefBased() {

    }
	
	
	/** 
     * Examines the task list; if there are no tasks
     * returnst true, otherwise return false.
     * @return boolean value that shows 
     * whether or not the list contains tasks
     */
    public boolean isEmpty() {
        return (head == null);
    }

    
    /** 
     * get the Task list size
     * @return the length of the list
     */
    public int getLength() {
    	int length = 0;
    	TaskListNode curr = head;
    	while(curr != null) {
    		length++;
    		curr = curr.next;
    	}
        return length;
    }

    
    /** 
     * Accepts a task to be inserted into the list. 
     * @param t task to be placed into the task list
     */
    public void insert(Task t) {

    	TaskListNode newNode = new TaskListNode(t);
    	TaskListNode prev = null;
    	TaskListNode curr = head;

    	if(head == null){
    		head = newNode;
    	} else {
    		while(curr != null) {
    			if(curr.task.priority < t.priority) {
    				break;
    			} 
    			prev = curr;
    			curr = curr.next;
    		}

    		newNode.next = curr;

    		if(prev == null) {
    			head = newNode;
    		} else {
    			prev.next = newNode;
    		}
    	}
    }

    
    /**
     * If the list has at least one task, then the task at
     * the head will be removed, and this task will be returned. 
     * If there are no items in the list, the return value is null.
     * @return a Task object corresponding the the task at the
     * head of the list; possibly null.
     */
    public Task removeHead() {
    		
    Task result = null;
    
    	if(head == null) {
    		return null;
    	} else {
            result = head.task;
	    	head = head.next;
	    	return result;
	    }
    }
    
    
	/**
     * If there are no items in the list, the value of
     * of null is returned.
     *
     * If the list has at least one task, then the list
     * is searched for a task with the same priority and
     * number as t. When found, this task is removed from
     * the list, and t is returned; otherwise the value
     * of null is returned.
     * @param t Task to be removed from the list.
     * @return a Task object corresponding the the task at the
     * head of the list; possibly null.
     */
    public Task remove(Task t) {

    	TaskListNode prev = null;
    	TaskListNode curr = head;

    	if(head == null) {
    		return null;
    	} else { 
    		while(curr != null) {
    			if(curr.task.priority == t.priority && curr.task.number == t.number) {
    				break;
    			}
    			prev = curr;
    			curr = curr.next;
    		}
    		if(curr == null) {
    			return null;
    		}
    		if(prev == null) {
    			head = head.next;
    			return t;
    		} else {
    			prev.next = curr.next;
    			return t;
    		}

    	}
    }

    
    /**
     * Takes an integer value indicate that the ith task
     * in the list is to be returned. When i is 0, the first
     * task is returned, when i is 1, the second task is
     * returned, etc. If there is no such task i, then null
     * is returned. The list is not modified by this operation.
     * @param i indicates the number of task from the start of
     * of the list which will be the task returned
     * @return contents of the ith task in the list; possibly null
     */ 
    public Task retrieve(int i) {

    	TaskListNode curr = head;
    	Task result = null;

    	if (head == null || i < 0 || i >= getLength()) {
    		return null;
    	} else {
            result = curr.task;
	    	for(int j = 0; j <= i; j++) {
                result = curr.task;
	    		curr = curr.next;
	    	}
		}
        return result;
    }
}