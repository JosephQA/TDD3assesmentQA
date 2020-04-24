package com.qa.testdrivendevelopment;

import java.lang.Character.Subset;
import java.util.Arrays;

public class Questions {
	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {

		return "Hi " + name;
	}

	/**
	 * Write a function which takes 2 integers greater than 0, X,Y as input and
	 * generates a 2-dimensional array. The element value in the i-th row and j-th
	 * column of the array should be i*j. <br>
	 * Note: i=0,1.., X-1; j=0,1,¡­Y-1. <br>
	 * <br>
	 * For Example: <br>
	 * multiply(3,2) → [[0,0,0],[0,1,2]] <br>
	 * multiply(2,1) → [[0,0]] <br>
	 * multiply(3,4) → [[0,0,0],[0,1,2],[0,2,4],[0,3,6]]
	 */
	public int[][] multiply(int arrayLength, int numOfArrays) {
		int[][] arr = new int[numOfArrays][arrayLength];
		// each 2D arr num n is= i*j where i is the index of the 1Depth array j is the
		// index in that(2Depth) array
		// cyle array 1D
		for (int i = 0; i < numOfArrays; i++) {
			// cycle array 2D
			for (int j = 0; j < arrayLength; j++) {
//				System.out.println(i + ":" + j);
				arr[i][j] = i * j;
			}
		}
		return arr;
	}

	/**
	 * Write a function that accepts a comma separated sequence of words as input
	 * and prints the words in a comma-separated sequence after sorting them
	 * alphabetically.
	 * 
	 * For Example: sortAlphabetically({"bag","car","dog"}) → {"bag","car","dog"}
	 * sortAlphabetically({"dog","car","bag"}) → {"bag","car","dog"}
	 * sortAlphabetically({"car","bark","bag","dog"}) → {"bag","bark","car","dog"}
	 */
	public String[] sortAlphabetically(String[] wordSequence) {
		Arrays.sort(wordSequence);
		return wordSequence;
	}

	/**
	 * Write a function which takes an input, a, and returns the sum a+aa+aaa+aaaa.
	 * So if 2 was the input, the function should return 2+22+222+2222 which is
	 * 2468.
	 * 
	 * For Example: aPlus(5) → 6170 aPlus(9) → 11106
	 */
	public int aPlus(int num) {
		int ret = 0;
		String n = "" + num;
		for (int i = 0; i <= 3; i++) {
			ret = ret + Integer.parseInt(n);
			// System.out.println(ret);
			n = n + num;
			// System.out.println(n);
		}
		return ret;
	}

	/**
	 * Write a function which takes a string of numbers, separated by commas, and
	 * returns all the odd numbers as a string, separated by commas. If there are no
	 * odd numbers then the function should return "null".
	 * 
	 * Inputs will always be given in ascending order, eg "3,4,5". Outputs should
	 * also be given in ascending order.
	 * 
	 * For Example: oddNum("1,2,3,4,5") → "1,3,5" oddNum("2,4,6,8") → "null"
	 * oddNum("23,48,52,57") → "23,57"
	 */
	public String oddNum(String allNums) {
		String[] strArr = allNums.split("\\s*,\\s*");
		int[] intArr = new int[strArr.length];
		String retStr = "";
		for (int i = 0; i < strArr.length; i++) {
			String str = strArr[i];
			int eint = Integer.parseInt(str);
			if (eint % 2 != 0) {
				retStr = retStr + "," + str;
			}
		}
		if (retStr != "") {
			retStr = retStr.substring(1, retStr.length());
		} else {
			retStr = null;
		} // expecting null on no matches not ""
//		System.out.println(retStr);
		return retStr;
	}

	/**
	 * Define a function that can accept two strings as input and returns the string
	 * of largest length
	 * 
	 * If two strings have the same length, then the function should return both
	 * strings separated by a single space. In this case, the strings should be
	 * returned in the same order in which they were given.
	 * 
	 * For Example: longString("hi","hello") → "hello" longString("three", "two") →
	 * "three" longString("three", "hello") → "three hello"
	 */
	public String longString(String input1, String input2) {
		String i = input1, j = input2;
		if (i.length() < j.length()) {
			return j;
		}
		if (j.length() < i.length()) {
			return i;
		}
		return i + " " + j;
	}

	/**
	 * Given an email address person@company.com, and a parameter "person" or
	 * "company", write a function which returns the corresponding piece of
	 * information. Your function should ignore case.
	 * 
	 * For Example: email("john@google.com", "person") → "john"
	 * email("jane@Microsoft.com", "company") → "microsoft"
	 * email("Dave@amazon.com","person") → "dave"
	 */
	public String email(String email, String parameter) {
		String result = "";
		switch (parameter) {
		case "person":
			result = splitPerson(email);
			break;
		case "company":
			result = splitCompany(email);
			break;
		default:
			break;
		}

		return result.toLowerCase();
	}

	private String splitCompany(String in) {
		String out = "";
		String[] arr = in.split("@");
		// System.out.println(arr[0]+ arr[1]);
		arr = arr[1].split("\\.");
		// System.out.println(arr[0]);
		out = arr[0];
		// System.out.println(out);
		return out;
	}

	private String splitPerson(String in) {
		String out = "";
		String[] arr = in.split("@");
		out = arr[0];
		// System.out.println(out);
		return out;
	}

	/**
	 * The fibonacci sequence is the sum of the last two numbers, with index 0 and 1
	 * having a value of 0 and 1 respectively
	 * 
	 * So fibonacci(5) is the sum of fibonacci(4) + fibonacci(3)
	 * 
	 * For Example: fibbonaci(0) → 0 fibbonaci(1) → 1 fibbonaci(2) → 1 fibbonaci(3)
	 * → 2 fibbonaci(4) → 3 fibbonaci(5) → 5 fibbonaci(8) → 21
	 */
	public int fibonacci(int num) {
		int n = 0;
		int m = 1;
		int b = 0;
		for (int i = 0; i < num; i++) {
			b = n;
			n = n + m;
			m = b;
		}
		return n;
	}

	/**
	 * Write a function which, given a string input, returns a string which contains
	 * only the characters with odd indexes.
	 * 
	 * For Example: oddLetters("Sponge") → "pne" oddLetters("hi") → "i"
	 * oddLetters("0H1e2l3l4o5w6o7r8l9d") → "Helloworld"
	 */
	public String oddLetters(String input) {
		String out = "";
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 != 0) {
				out = out + input.charAt(i);
			}
		}

		return out;
	}

	/**
	 * Write a function which solves the following puzzle. A farm has chickens and
	 * rabbits, and scanners are able to detect the number of heads and legs. How
	 * many chickens do we have, if we know the number of heads and legs? The values
	 * for 'heads' and 'legs' will be inputs. If there are no solutions to the
	 * puzzle, return null
	 * 
	 * For Example: chickenAndRabbits(35, 94) → 23 chickenAndRabbits(2, 6) → 1
	 * chickenAndRabbits(12,63) → null
	 */
	public Integer chickenAndRabbits(int heads, int legs) {
		// legsamo = 4r + 2c r is num of rabitts and c is num of chickens
		// headamo = r + c
		// 2r = legsamo - 2headamo
		// 2c = legsamo - 4(legsamo - 2headamo)/2 = -1legamo + 4headamo ||
		// r = legamo/2 - headamo
		// .....
//		heads = n. rabbit no = x . chicken no = y
		// L = 4x + 2y && n = x + y
		// x = L/2 - n && y = 2n -L/2
		// if both intergers . input logically sound return y
		// else return null
		double x = legs / 2 - heads;
		double y = 2 * heads - legs / 2;
		x = Math.floor(x);
//		System.out.println(x);
		y = Math.floor(y);
//		System.out.println(y);
		// check for logical amounts of chickens and rabbits
		if (x + y != heads || x < 0 || y < 0) {
			return null;
		}
		return (int) y;
	}

	/**
	 * Write a function which checks the validity of a credit card number. The
	 * function should return a boolean, True if the card is valid, or False if it
	 * is not.
	 * 
	 * A credit card has a valid number if it satisfies the following criteria. - it
	 * must start with a 4, 5 or 6. - it must contain exactly 16 digits. - each
	 * digit must be 0-9 inclusive. - it may contain hyphens ("-"), to separate
	 * groups of 4 digits only, but it cannot contain any other characters. - it
	 * must not have 4 or more consecutive repeated digits.
	 * 
	 * For Example: validCard("4012-3456-7890-1234") → True
	 * validCard("0123-4567-8901-2345") → False validCard("401234567890123") → False
	 * validCard("4012 3456 7890 1234") → False validCard("4444-0123-4567-8901") →
	 * False validCard("4012345678901234") → True
	 */
	public boolean validCard(String cardNumber) {
		String in = cardNumber;
		// check first char == 4 ||5||6 FAIL return false
		if (!(in.startsWith("4") || in.startsWith("5") || in.startsWith("6"))) {
			System.out.println("firstchar");
			return false;
		}
		// check for "-" presence
		if (in.contains("-")) {
			// check not > 4 chars between "-" FAIL return false
			String[] hyphArr = in.split("-");
			for (String ele : hyphArr) {
				if (ele.length() > 4) {
					System.out.println("hyphenlen");
					return false;
				}
			}
		}
		// remove any "-"
		in = in.replace("-", "");
		in =in.trim();
		System.out.println(in);
		
		
		// check length == 16 FAIL return false
		if(in.length()!= 16) {System.out.println("numlength"+ in.length());return false;}
		// check for only chars in range (0,9) FAIL return false
			try {long l = Long.parseLong(in);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("dissalowed chars");
				return false;
			}
		// check for only < 4 repeated chars in a row FAIL return false
			int MAXCOUNT = 3, count = 0; char ch1 =in.charAt(0),ch2;
			for(int i = 1; i < in.length()-1;i++) {
				ch2 = in.charAt(i);
				if(ch1 == ch2) { count = count + 1;}
				if(count >= MAXCOUNT) {System.out.println("repetedchars");return false;}
				ch1 = ch2;
			}
		//input passes tests PASS return true	
		return true;
	}
}