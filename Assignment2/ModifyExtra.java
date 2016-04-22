/**
 * For Assignment 2 extra part: , June 10th, 2015 
 * ModifyExtra.java
 * This is the extra implements of TaskList interface. For this 
 * extra code, I add a new method at the end of the code called
 * 'modify', this method will passing an index position and a task
 * waited to be modified based on user's input. I did not change 
 * other method by the way.
 */


public class ModifyExtra implements TaskList {

	TaskListNode head = null;

	public ModifyExtra() {

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


    /**
    * Takes two value, first is the index indicate that the indexth
    * task that user want to modify. The second value is the one that
    * user want to replaced. 
    * @param i indicates the number of task waited to be modified
    * Task t is the task that user's need.
    * @return contents that the indexth task modified
    */
	public Task modify(int index, Task t) {
		
		TaskListNode newNode = new TaskListNode(t);
		TaskListNode curr = head;
		TaskListNode prev = null;

		if(head == null || index >= getLength() || index < 0) {
			return null;
		} else {
			int j = 0;
			while(curr != null && j < index - 1) {
				prev = curr;
				curr = curr.next;
				j++;
			}
			curr.next = newNode;
			newNode.next = curr.next.next;
			return t;
		}
	}
}