

public class HashTagTokenizer {

	public static void main(String[] args) { 

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) {
		// Your code here
		for(int i=0;i<dictionary.length;i++)
		{
			if(word.compareTo(dictionary[i])==0)
			{
				return true;
			}
		}
		return false;
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

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
	
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
         
        for (int i = 1; i <= N; i++) {
		    
			if(existInDictionary(hashtag.substring(0, i), dictionary))//in the dictionary
			{
               System.out.println(hashtag.substring(0, i));
			   String chashtag=hashtag.substring(i++);
			   breakHashTag(chashtag, dictionary);
			}
        }
    }
}
