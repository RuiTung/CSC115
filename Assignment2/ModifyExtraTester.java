/**
 * For Assignment 2 extra part: , June 10th, 2015 
 * ModifyExtraTester.java
 * This is the test of ModifyExtra.java
 */


public class ModifyExtraTester {

	public static void main(String[] args) {

		ModifyExtra test = new ModifyExtra();

		//test case 1: before insert a task, 
		//whether 'modify' method will return null
		Task t = new Task(1,1);
		if(test.modify(0,t) == null) {
			System.out.println("Test 1 of 'modify' method passed.");
		} else {
			System.out.println("Test 1 of 'modify' method failed.");
		}


		//test case 2: the passing parameter 'index' is negative value
		t = new Task(1,1);
		test.insert(t);
		if(test.modify(-123,t) == null) {
			System.out.println("\nTest 2 of 'modify' method passed.");
		} else {
			System.out.println("\nTest 2 of 'modify' method failed.");
		}


		//test case 3: the passing parameter 'index'
		//is out of the length of link list
		t = new Task(2,2);
		test.insert(t);
		if(test.modify(88888888,t) == null) {
			System.out.println("\nTest 3 of 'modify' method passed.");
		} else {
			System.out.println("\nTest 3 of 'modify' method failed.");
		}


		//test case 4: after insert a task, whether the task list
		//can be modified according to the passing parameter of index	
		t = new Task(3,3);
		if(test.modify(0,t).priority == 3 && test.modify(0,t).number == 3) {
			System.out.println("\nTest 4 of 'modify' method passed.");
		} else {
			System.out.println("\nTest 4 of 'modify' method failed.");
		}
	}
}