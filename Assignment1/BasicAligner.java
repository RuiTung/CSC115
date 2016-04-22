/**
 * For Assignment: , May 28th, 2015 
 * BasicAligner.java
 * This is the implement of Aligner interface.
 */


public class BasicAligner implements Aligner {
    
    private String[] sequence;
    private char[][] arrayChar;
    private int numErrors;
    private int offSet;
    private int[] errors;
    private char[][] temp;

    /**
     * Given the alignment performed, indicate the position at
     * which the first string character would appear in the
     * aligned result. -1 indicates no alignment possible.
     *
     * @param sequenceNumber index of the sequence string for
     *        which the offset is requested
     * @return number of characters from the start of the alignment
     *         at which the sequence string lines up
     *
     */
    public BasicAligner(String[] sequence) {

        this.sequence = new String [sequence.length];

        for(int i = 0; i < sequence.length; i++) {
            this.sequence[i] = sequence[i];
        }

        arrayChar = new char[sequence.length][];
        temp = new char[sequence.length][];

        //convert the strings into char array
        //check the length of the two lines char array
        for(int i = 0; i < sequence.length; i++) {
            arrayChar[i] = sequence[i].toCharArray();
        }

        if(arrayChar[0].length < arrayChar[1].length) {
            temp[0] = arrayChar[1];
            arrayChar[1] = arrayChar[0];
            arrayChar[0] = temp[0];
        } 
    }
     
    /**
     * Performs the actual sequence alignment, but according to
     * the algorithm as implemented.
     */
    public void performAlignment() {

        // the test part of for loop
        int bounds = arrayChar[0].length - arrayChar[1].length + 1;

        // initialize an array that used to put all results from matchAt()
        errors = new int[bounds];

        for(int i = 0; i < bounds; i ++) {
            errors[i] = matchAt(i, 0);
            if (errors[i] == 0){
                offSet = i;
                numErrors = errors[i];
            } else {
                numErrors = errors[0];
                for(int j = 0; j < errors.length; j++ ) {
                    if (errors[j] <= numErrors) {
                        numErrors = errors[j];
                        offSet = j;
                    }               
                }
            }
        }
    }
    
    /**
     * Calculate the quantity of mismatched elements and return the value
     * @param firstI
     * @param secondI
     * @return the number of the mismatched characters
     */
    private int matchAt(int firstI, int secondI) {

        int misMatch = 0;

        for(int i = 0; i < arrayChar[1].length; i ++) {
            if(arrayChar[0][firstI + i] != arrayChar[1][i]) {
                misMatch++;
            }
        }
        return misMatch;
    }

    /**
     * Reports the number of mismatches the present in the
     * best-possible alignment of the sequences.
     *
     * @return number of mismatches positions in the current
     *         alignment
     */
    public int getOffset(int index) {

        return offSet;
    }

    /** 
    * Get the corresponding array in the arrayChar
    * @param index
    * @return the corresponding array in the arrayChar
    */
    public String getSequence(int index) {

        // return string array according to the value of index
        if (index == 0) {
            return sequence[0];
        } else {
            return sequence[1];
        }
    }

    /**
     * Reports the number of mismatches the present in the
     * best-possible alignment of the sequences.
     *
     * @return number of mismatches positions in the current
     *         alignment
     */
    public int getNumErrors() {
        
        return numErrors;
    }
}
