package com.digizol.interviews.string.format;

public class Test {

	public static void main(String[] args) {

	 FormatValidator validator = new FormatValidator(createPairs());

	 String[] toTest = {
	 	   "[(])",
        	   "([<>])",
        	   "([)",
        	   "(][)",
        	   "()[]<>",
        	   "(()[]<>)",
        	   "[{()]}",
        	   "(mal [ formatted )",
        	   "(this [ is < well > formatted ] text)",
            
        };
        
        //usual case to check mathematical expressions
        String[] toTest2 = {
        	 "{2+[3*4/(3-1)]}",
        	 "[{2+1/(2-7)]}"            
        };

        // test toTest
        for (String string : toTest) {
            
            boolean valid = validator.validate(string, false);
            isFormatted(valid, string);
        }
        
          // test toTest2
        for (String string : toTest2) {
            
            boolean valid = validator.validate(string);
            isFormatted(valid, string);
        }
    }

    private static GroupingPair[] createPairs() {
        GroupingPair[] pairs = new GroupingPair[]{
            new GroupingPair('(', ')'),
            new GroupingPair('<', '>'),
            new GroupingPair('[', ']'),
            new GroupingPair('{', '}')
        };
        return pairs;
    }

   // print validity of expression
    public static void isFormatted(boolean valid, String string) {
        if (valid) {
            System.out.println(string + " \t-> well formatted");
        } else {
            System.out.println(string + " \t-> malformatted");
        }
    }
}
