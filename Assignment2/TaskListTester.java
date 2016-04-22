/**
 * For Assignment: , June 8th, 2015 
 * TaskListTester.java
 * This is the test of TaskListRefBased.java
 */

public class TaskListTester {
	public static void main(String[] args) {

		TaskListRefBased test = new TaskListRefBased();

		//test case 1: before insert a task, whether the task list is empty or not
		if(test.isEmpty() == true) {
			System.out.println("Test 1 of 'isEmpty' method passed.");
		} else {
			System.out.println("Test 1 of 'isEmpty' method failed. ");
		}


		//test case 2: after insert a task, whether the task list is empty or not
		Task t = new Task(1,1);
		test.insert(t);
		if(test.isEmpty() == false) {
			System.out.println("\nTest 2 of 'isEmpty' method passed.");
		} else {
			System.out.println("\nTest 2 of 'isEmpty' method failed.");
		}


		//test case 3: after insert 1 task, test the task list length is 1 or not
		t = new Task(6,13);
		test.insert(t);
		test.getLength();
		if(test.getLength() == 2) {
			System.out.println("\nTest 3 of 'getLength' method passed.");
		} else {
			System.out.println("\nTest 3 of 'getLength' method failed.");
		}


		//test case 4: remove head
		Task deleteHead = test.removeHead();
		if(deleteHead.priority == 6 && deleteHead.number == 13) {
			System.out.println("\nTest 4 of 'removeHead' method passed.");
		} else {
			System.out.println("\nTest 4 of 'removeHead' method failed.");
		}


		//test case 5: check the current length of task list
		test.getLength();
		if(test.getLength() == 1) {
			System.out.println("\nTest 5 of 'getLength' method passed.");
		} else {
			System.out.println("\nTest 5 of 'getLength' method failed.");
		}


		//test case 6: retrieve the first position of the task list
		if(test.retrieve(0).priority == 1 && test.retrieve(0).number == 1) {
			System.out.println("\nTest 6 of 'retrieve' method passed.");
		} else {
			System.out.println("\nTest 6 of 'retrieve' method failed.");
		}


		//test case 7: the passing parameter into the retrieve method is negative
		if(test.retrieve(-123) == null) {
			System.out.println("\nTest 7 of 'retrieve' method passed.");
		} else {
			System.out.println("\nTest 7 of 'retrieve' method failed.");
		}


		//test case 8: retrieve any position which out of task list length
		if(test.retrieve(88888888) == null) {
			System.out.println("\nTest 8 of 'retrieve' method passed.");
		} else {
			System.out.println("\nTest 8 of 'retrieve' method failed.");
		}


		//test case 9: remove task which is the only task in the task list
		t = new Task(1,1);
		test.remove(t);
		if(t.priority == 1 && t.number == 1) {
			System.out.println("\nTest 9 of 'remove' method passed.");
		} else {
			System.out.println("\nTest 9 of 'remove' method failed.");
		}


		//test case 10: remove head yet the task list is empty
		if(test.removeHead() == null) {
			System.out.println("\nTest 10 of 'removeHead' method passed.");
		} else {
			System.out.println("\nTest 10 of 'removeHead' method failed.");
		}
	}
}