/**
 * For Assignment: , May 28th, 2015 
 * TestBasicAligner.java
 * This is the test file.
 */

public class TestBasicAligner {
	public static void main(String[] args) {

		//test string arrays
		String[] s1 = {"ABCD", "EF"};
		String[] s2 = {"ABCD", "ABCD"};
		String[] s3 = {"ABCD", "CD"};
		String[] s4 = {"AB", "CD"};
		String[] s5 = {"D", "AB"};

		BasicAligner test1 = new BasicAligner(s1);
		BasicAligner test2 = new BasicAligner(s2);
		BasicAligner test3 = new BasicAligner(s3);
		BasicAligner test4 = new BasicAligner(s4);
		BasicAligner test5 = new BasicAligner(s5);

		// First case shows two different elements string array
		test1.performAlignment();
		if(test1.getOffset(0) == 2) {
			System.out.println("Test1 (getOffset): Passed");
		} else {
			System.out.println("Test1 (getOffset): Failed");
		}

		if(test1.getNumErrors() == 2) {
		 	System.out.println("Test1 (getNumErrors): Passed");
		} else {
		 	System.out.println("Test1 (getNumErrors): Failed");
		}

		System.out.println();

		// Second case shows two same elements and same length string array
		test2.performAlignment();
		if(test2.getOffset(0) == 0) {
			System.out.println("Test2 (getOffset): Passed");
		} else {
			System.out.println("Test2 (getOffset): Failed");
		}

		if(test2.getNumErrors() == 0) {
		 	System.out.println("Test2 (getNumErrors): Passed");
		} else {
		 	System.out.println("Test2 (getNumErrors): Failed");
		}

		System.out.println();

		//Third case shows two different length array with two same elements
		test3.performAlignment();
		if(test3.getOffset(0) == 2) {
			System.out.println("Test3 (getOffset): Passed");
		} else {
			System.out.println("Test3 (getOffset): Failed");
		}

		if(test3.getNumErrors() == 0) {
		 	System.out.println("Test3 (getNumErrors): Passed");
		} else {
		 	System.out.println("Test3 (getNumErrors): Failed");
		}

		System.out.println();

		//Fourth case shows two same length without same elements string array
		test4.performAlignment();
		if(test4.getOffset(0) == 0) {
			System.out.println("Test4 (getOffset): Passed");
		} else {
			System.out.println("Test4 (getOffset): Failed");
		}

		if(test4.getNumErrors() == 2) {
		 	System.out.println("Test4 (getNumErrors): Passed");
		} else {
		 	System.out.println("Test4 (getNumErrors): Failed");
		}

		System.out.println();

		//Fifth case shows the first string length is less than the second string length and with the different elements
		test5.performAlignment();
		if(test5.getOffset(0) == 1) {
			System.out.println("Test5 (getOffset): Passed");
		} else {
			System.out.println("Test5 (getOffset): Failed");
		}

		if(test5.getNumErrors() == 1) {
		 	System.out.println("Test5 (getNumErrors): Passed");
		} else {
		 	System.out.println("Test5 (getNumErrors): Failed");
		}
	}
}