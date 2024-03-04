
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		word=HashTagTokenizer.lowerCase((word));
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) 
	{ 
		if(str.length()==1)
		{
			return "";
		}
	String newword=str.substring(1);
	return newword;
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		
		if(word1.length()==0) 
		{
              return word2.length();
		}
		if(word2.length()==0)
		{
			return word1.length();
		}  
	 if(word1.charAt(0)==word2.charAt(0))
		{ 
			word1=tail(word1);
			word2=tail(word2);
			return levenshtein(word1,word2);
		}
	     	
			return 1+ Math.min(Math.min(levenshtein(tail(word1),word2),levenshtein(word1,tail(word2))),
                     levenshtein(tail(word1),tail(word2)));
		
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		int i=0;
		while(!in.isEmpty())
		{
			dictionary[i]=in.readString();
          i++;
		}

		// Your code here

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		String sw="";
          for(int i=0;i<dictionary.length;i++)
		{
		 
                        if(threshold>=levenshtein(word, dictionary[i]))
			   {
                                 threshold=levenshtein(word, dictionary[i]);
					sw=dictionary[i];
			   }
		}
		if(sw=="")
		   sw=word;
		return sw;
	}

}
