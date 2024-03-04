
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		word=lowerCase(word);
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}
	public static String lowerCase(String s) {
        String news="";
       for(int i=0;i<s.length();i++)
       {
        if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
        {
          news+=(char)(s.charAt(i)+32);
        }
        else
        {
        news+=s.charAt(i);
        }
       }
        return news;
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
		word1=lowerCase(word1);
		word2=lowerCase(word2);
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
		int dis =0;
          for(int i=0;i<dictionary.length;i++)
		{
		   if(levenshtein(word,dictionary[i])==threshold)
			 {
                              return dictionary[i];
			 }
			dis=Math.abs(levenshtein(word,dictionary[i])-threshold);
			if(i!=0&&dis>=Math.abs(levenshtein(word,dictionary[i])-threshold))//doesnt include the first iteration
			{
                          dis=Math.abs(levenshtein(word,dictionary[i])-threshold);
			}
		}
		if(sw=="")
		   sw=word;
		return sw;
	}

}
