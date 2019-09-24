package topInterviewQuestions;

public class CustomMethods {

	
    public void swapCharElement(char[] s, int a, int b) {
    	s[a] = (char) ((int)s[a] + (int)s[b]);
    	s[b] = (char) ((int)s[a] - (int)s[b]);
    	s[a] = (char) ((int)s[a] - (int)s[b]);
    }
}


