package com.digizol.interviews.string.format;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FormatValidator {

	private Map<Character, GroupingPair> openingChars;
	private Map<Character, GroupingPair> closingChars;

	public FormatValidator(GroupingPair[] pairs) {
		initOpeningCharacters(pairs);
		initClosingCharacters(pairs);
	}

	private void initClosingCharacters(GroupingPair[] pairs) {
		closingChars = new HashMap<Character, GroupingPair>();
		for (GroupingPair pair: pairs) {
			closingChars.put(pair.getEnd(), pair);
		}
	}

	private void initOpeningCharacters(GroupingPair[] pairs) {
		openingChars = new HashMap<Character, GroupingPair>();
		for (GroupingPair pair: pairs) {
			openingChars.put(pair.getStart(), pair);
		}
	}

	public boolean validate(String string) {
		return validate(string, false);
	}
	
	public boolean validate(String string, boolean validateOtherCharacters) {

		Stack<GroupingPair> stack = new Stack<GroupingPair>();

		char[] characterArray = string.toCharArray();

		for (Character c: characterArray) {

			if (openingChars.containsKey(c)) {
				stack.push(openingChars.get(c));
			} else if (closingChars.containsKey(c)) {
				if (!c.equals(stack.pop().getEnd())) {
					return false;
				}
			} else if (validateOtherCharacters) {
				System.out.println("Unexpected character '" + c + "' found in string: " + string);
				return false;
			}
		}
		return stack.isEmpty();
	}
}
