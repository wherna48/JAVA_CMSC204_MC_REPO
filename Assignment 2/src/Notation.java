/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class with methods to convert to and from postfix and infix. Plus a method to 
 * 				evaluate the postfix. There is also an additional method to co the arithmetic
 * 				calculation.
 * Due: 02/20/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
public class Notation {
	/**
	 * empty notation constructor
	 */
	public Notation() {
		
	}
	/**
	 * method to convert postfix to infix
	 * @param postfix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostFixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> infixS = new MyStack<String>(15);	// new infix stack set to size 15
		String infixString;	// infix string
		
		char[] postfixA = postfix.toCharArray();	// adds postfix string to a char array
		
		try {
			for(int i = 0; i < postfixA.length; i++) {	// read through char array
				if(postfixA[i] == ' ') {
					continue;	// if a space is encountered, skip
				}
				
				if(Character.isDigit(postfixA[i])) {
					infixS.push(String.valueOf(postfixA[i]));	// if char is a digit, push to infix stack
				}
				if(postfixA[i]=='+'||postfixA[i]=='-'||postfixA[i]=='*'||postfixA[i]=='/') {	// if operator is encountered
					if(infixS.size()<2) {
						throw new InvalidNotationFormatException();	// if less than 2 elements in the stack , throw error
					}	
					else {
						String top = infixS.pop();	// pops second value and stores string value to top
						infixString = "(" + infixS.pop()+ postfixA[i] + top + ")";	// encapulates string with first popped + operator + top value
						infixS.push(infixString);		// push string back into the stack			
					}
					
				}
			}
			if(infixS.size() > 1) {
				throw new InvalidNotationFormatException();	// throw error if size is greater than 1
			}
			
		}catch(InvalidNotationFormatException ex) {
			throw new InvalidNotationFormatException();
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		return infixS.toString();	// return string
	}
	/**
	 * method to convert infix to postfix
	 * @param infix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix​(String infix) throws InvalidNotationFormatException {
		MyQueue<String> postfixQ = new MyQueue<String>(15);
		MyStack<String> postfixS = new MyStack<String>(15);	// creates postfix queue and stack
		
		char[] infixA = infix.toCharArray();	// char array
		
		try {
			for(int i = 0; i < infixA.length; i++) {
				
				if(infixA[i] == ' ') {
					continue;	// if space is encountered, continues to next line of code
				}
				
				if(Character.isDigit(infixA[i])) {
					postfixQ.enqueue(String.valueOf(infixA[i]));	// enqueues string value if its a digit
				}
				
				if(infixA[i] == '(') {
					postfixS.push(String.valueOf(infixA[i]));		// pushes '(' onto the stack
				}
				
				if(infixA[i] == '+') {	// when an op is encountered
					if(!postfixS.isEmpty()) {	// if stack is not empty
						while(postfixS.top().equals("+")||postfixS.top().equals("-")||postfixS.top().equals("*")||postfixS.top().equals("/")) {	// while top is equal to one of the operators
							postfixQ.enqueue(postfixS.pop());	// pop the top operator from the stack, then enqueue the popped element
						}
					}
					postfixS.push(String.valueOf(infixA[i]));	// push the current character onto the stack
				}
				
				if(infixA[i] == '-') {
					if(!postfixS.isEmpty()) {
						while(postfixS.top().equals("+")||postfixS.top().equals("-")||postfixS.top().equals("*")||postfixS.top().equals("/")) {
							postfixQ.enqueue(postfixS.pop());	// pop the top operator from the stack, then enqueue the popped element
						}	
					}
					postfixS.push(String.valueOf(infixA[i]));	// push the current character onto the stack
				}
				
				
				if(infixA[i] == '*') {
					if(!postfixS.isEmpty()) {
						while(postfixS.top().equals("+")||postfixS.top().equals("-")||postfixS.top().equals("*")||postfixS.top().equals("/")) {
							postfixQ.enqueue(postfixS.pop());	// pop the top operator from the stack, then enqueue the popped element
						}
					}
					postfixS.push(String.valueOf(infixA[i]));	// push the current character onto the stack
				}
				
				
				if(infixA[i] == '/') {
					if(!postfixS.isEmpty()) {
						while(postfixS.top().equals("+")||postfixS.top().equals("-")||postfixS.top().equals("*")||postfixS.top().equals("/")) {
							postfixQ.enqueue(postfixS.pop());	// pop the top operator from the stack, then enqueue the popped element
						}
					}
					postfixS.push(String.valueOf(infixA[i]));	// push the current character onto the stack
				}
				
				
				if(infixA[i] == ')') {
					while(!postfixS.isEmpty()&&!postfixS.top().equals("(")) {
						postfixQ.enqueue(postfixS.pop());	// pop the top operator from the stack, then enqueue the popped element
					}
					if(postfixS.isEmpty()||!postfixS.top().equals("(")) {
						throw new InvalidNotationFormatException();
					}
					if(!postfixS.isEmpty()&&postfixS.top().equals("(")) {
						postfixS.pop();	// pops and discards the left '('
					}
				}
				
				
			}
			while(!postfixS.isEmpty()&&!postfixS.top().equals("(")) {
				postfixQ.enqueue(postfixS.pop());	// pops any remaining elements from the stack and enqueues them
			}
			
		
		}catch(InvalidNotationFormatException ex) {
			throw new InvalidNotationFormatException();
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		return postfixQ.toString();	// returns string
		
		
		
	}
	/**
	 * method to evaluate postfix
	 * @param postfixExpr
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostFix(String postfixExpr) throws InvalidNotationFormatException {
		String first, second;
		double result = 0;
		
		MyStack<String> postS = new MyStack<String>(15);
		char[] postfixEx = postfixExpr.toCharArray();
		
		
		try {
			for(int i = 0; i < postfixEx.length; i++) {
				if(postfixEx[i] == ' ') {
					continue;	// if space is encountered, continues to next line of code
				}
				if(Character.isDigit(postfixEx[i])) {
					postS.push(String.valueOf(postfixEx[i]));	// pushes digit onto the stack
				}
				else {
					if(postS.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					else {
						second = postS.pop();	// pops second value
						first = postS.pop();	// pops first value
						result = arithmeticCalc(first, second, postfixEx[i]); // calls calc method to get result
						postS.push(Double.toString(result)); // push reesult onto the stack after getting the double value to the string
					}
				}

			}
			if(postS.size() > 1) {
				throw new InvalidNotationFormatException();	// if size greate than 1, throw error
			}
			
		}catch(InvalidNotationFormatException ex) {
			throw new InvalidNotationFormatException();
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		return result;	// RETURN RESULT
	}
	/**
	 * method to calculate the postfix with parameters
	 * @param first
	 * @param second
	 * @param operator
	 * @return
	 */
	public static double arithmeticCalc(String first, String second, char operator) {
		double first1, second1, result = 0;
		
		switch(operator) {
			case '+':	
				first1 = Double.parseDouble(first);		// parse string to double value
				second1 = Double.parseDouble(second);	// parse string to double value
				
				result = first1 + second1;				// do the math
				
				break;									// exit the switch
				
			case '-':
				first1 = Double.parseDouble(first);		// parse string to double value	
				second1 = Double.parseDouble(second);	// parse string to double value
				
				result = first1 - second1;				//maths
				break;									// exit the switch
				
			case '*':
				first1 = Double.parseDouble(first);		// parse string to double value
				second1 = Double.parseDouble(second);	// parse string to double value
				
				result = first1 * second1;				// maths
				break;									// exit the switch
				
			case '/':
				first1 = Double.parseDouble(first);		// parse string to double value
				second1 = Double.parseDouble(second);	// parse string to double value
				
				result = first1 / second1;				// maths
				break;									// exit the switch
				
			default:
				System.out.println("Incorrect operators sent in");	// default statement in case something bad happens
			
		}
		
		return result;	// return result
	}
	

}
