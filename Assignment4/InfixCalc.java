/**
 * For Assignment: , July 17th, 2015 
 * Infix.txt
 * This is the specific coding process of transfering an infix expression
 * into a postfix expression, and then calculate the expression.
 */

public class InfixCalc {
    /**
     * First ensure the arithmetic operations plus parentheses
     * are surrounded by spaces. Then go ahead and split up the
     * whole expression using spaces (i.e, the operands will be
     * nicely separated from everything else by at least a single
     * space). This will not work for negative numbers.
     */

    
    public static String[] tokenize(String s) {
        // Note the missing minus character...
        String symbols[] = {"\\(", "\\)", "\\+", "\\-", "\\*", "\\/",
            "\\^"};

        // First eliminate any quotation marks
        s = s.replaceAll("'", " ");
        s = s.replaceAll("\"", " ");

        // Now all operators or parentheses, surround the character
        // with a single space on either side.
        for (int i = 0; i < symbols.length; i++) {
            String regex = symbols[i];
            String replace = " " + regex + " ";
            s = s.replaceAll(regex, replace);
        }

        // Special case: If there is a unary minus, then then
        // what appears to the right of the symbol is whitespace
        // and a digit; what appears to the left whitespace
        // and a non-digit symbol.
        s = s.replaceAll("(^|([\\(\\+\\-\\*\\/]))\\s+\\-\\s+(\\d+)", "$1 -$3");

        // Eliminate extra whitespaces at start and end of the
        // transformed string. 
        s = s.trim();

        // Finally, take advantage of the whitespace to create an
        // array of strings where each item in the array is one
        // of the elements in the original string passed in to this
        // method.
        return s.split("\\s+");
    }
    
    /**
    * This method is for testing whether or not the infix expression
    * is balanced or not
    * @para String expr
    * @return whether the expression is balanced
    */
    public static boolean isBalanced(String expr) {
        
        StringStack stack = new StringStackRefBased();

        if(expr.length() == 0) {
            throw new IllegalArgumentException("String length must be greater than zero");
        }

        try {
            for(int i = 0; i < expr.length(); i++) {
                String token = expr.substring(i, i+1);
                if(token.equals("(")) {
                    stack.push("(");
                } else if(token.equals(")")) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch(StringStackException ex) {
            return false;
        }
    }
    
    /**
    * This method is for testing whether or not a token
    * is operator or not.
    * @para String tokens
    * @return boolean value
    */
    public static boolean isOperator(String tokens) {
        
        String operators = "^+-*/";
        if(tokens.length() != 1) {
            return false;
        }     
        if(operators.indexOf(tokens) != -1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
    * This method is for checking the order of operators
    * @para String tokens
    * @return sequence order value
    */
    public static int sequence(String tokens) {
        
        if(tokens.equals("^")) {
            return 3;
        } else if(tokens.equals("*") || tokens.equals("/")) {
            return 2;
        } else if(tokens.equals("+") || tokens.equals("-")) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
    * This method is for transfering an infix expression 
    * into a postfix expression
    * @para String[] tokens
    * @return StringList
    */
    public static StringList toPostfix(String[] tokens) throws StringStackException {
        
        StringStackRefBased stack = new StringStackRefBased();
        StringList list = new StringList();

        for(int i = 0; i < tokens.length; i ++) {
            String token = tokens[i];
            if(isInt(token)) {
                list.insertTail(token);
            } else if(token.equals("(")) {
                stack.push("(");
            } else if(isOperator(token) == true) {
                if(stack.isEmpty()) {
                    stack.push(token);
                } else {
                    while(!stack.isEmpty() && sequence(token) <= sequence(stack.peek())
                        && !stack.peek().equals("(") ) {
                        list.insertTail(stack.pop());
                    }
                    stack.push(token);
                }
            
            } else if(token.equals(")")) {
                while(!stack.peek().equals("(")) {
                    list.insertTail(stack.pop());
                }
                stack.peek();
            } else {
                System.out.println("<noninteger>");
            }       
        }
        while(!stack.isEmpty()) {
            list.insertTail(stack.pop());
        }
        return list;
    }
    
    /**
    * This method is for testing whether or not a token
    * is an int or not.
    * @para String token
    * @return boolean value
    */ 
    public static boolean isInt(String token) {

        try {
            Integer.parseInt(token);
        } catch(NumberFormatException ex) {
            return false;
        }
        return true;
    }
    
    /**
    * This method is calculating the result of an expression
    * after it is transfered into a postfix expression
    * @para StringList expr
    * @return String
    */
    public static String evaluatePostfix(StringList expr) throws StringStackException {
        
        StringStackRefBased result = new StringStackRefBased();
        int calc = 0;

        for(int i = 0; i < expr.getLength(); i++) {

            if(!isOperator((expr.retrieve(i)))) {
                if(isInt(expr.retrieve(i)) == true) {            
                    result.push(expr.retrieve(i));
                }
            } else {
                int difference = 1;
                if(difference != 1) {
                    System.out.println("<syntax error>");
                } else {
                    int first = Integer.parseInt(result.pop());
                    int second = Integer.parseInt(result.pop());

                    if(expr.retrieve(i).equals("^")) {
                        calc = 1;
                        for(int j = 0; j < first; j++) {
                            calc *= second;
                        }
                       
                    }
                    else if(expr.retrieve(i).equals("+")) {
                        calc = first + second;
                        
                    } else if(expr.retrieve(i).equals("-")) {
                        calc = second - first;
                        
                    } else if(expr.retrieve(i).equals("*")) {
                        calc = first * second;
                        
                    } else if(expr.retrieve(i).equals("/")) {
                        try {
                            calc = second / first;
                            
                        } catch(ArithmeticException errorZero) {
                            return("ArithmeticException: Zero cannot be divided.");
                        }
                    }
                }
                result.push(Integer.toString(calc));
            }
        }
        return (result.peek());
    }

    /**
    * This method is get the result of the who process
    * and cast the result into an int.
    * @para String expr
    * @return String
    */
    public static String evaluateExpression(String expr) {

        String result = "<nothing working right now>";
        
        if(isBalanced(expr) == false) {
            return ("<unbalanced ()>");
        }

        int numbers = 0;
        int operators = 0;

        String[] strings = tokenize(expr);
 
        for(int i = 0; i < strings.length; i++) {
            if(!isInt(strings[i]) && !isOperator(strings[i]) 
                && !strings[i].equals("(") && !strings[i].equals(")")
                && !strings[i].equals(" ")) {
                return("<noninteger>");
            } else if(isInt(strings[i])) {
                numbers++;
            } else if(isOperator(strings[i])) {
                operators++;
            }
        }
        int difference = numbers - operators;
        if(difference != 1) {
            return("<syntax error>");
        }

        StringList postfix = new StringList();
        
        try {
            result = evaluatePostfix(toPostfix(strings));
        } catch (StringStackException ex) {
            System.err.println(ex);
        }
        return result;
    }
    
    // main method for testing.
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("usage: java InfixCalc '<expression>'");
            System.exit(1);
        }

        System.out.println(evaluateExpression(args[0]));
    }
}
