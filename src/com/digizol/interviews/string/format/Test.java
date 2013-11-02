package com.digizol.interviews.string.format;

public class Test {

	public static void main(String[] args) {

		FormatValidator validator = new FormatValidator(createPairs());

		String[] toTest = { "[(])", 
							"([<>])", 
							"([)", 
							"()[]<>", 
							"(()[]<>)",
							"(mal [ formatted )",
							"(this [ is < well > formatted ] text)"
							};

		for (String string : toTest) {

			boolean valid = validator.validate(string, false);

			if (valid) {
				System.out.println(string + " \t-> well formatted");
			} else {
				System.out.println(string + " \t-> malformatted");
			}
		}
	}

	private static GroupingPair[] createPairs() {
		GroupingPair[] pairs = new GroupingPair[] {
								new GroupingPair('(', ')'), 
								new GroupingPair('<', '>'), 
								new GroupingPair('[', ']') 
		};
		return pairs;
	}
}
