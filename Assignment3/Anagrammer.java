/**
 * For Assignment: , June 30th, 2015 
 * Anagrammer.java
 */



public class Anagrammer {

	private String[] dictionary;
	private String phrase;
	private int maxWords;
	private WordList result;


	/**
	* constructor for Anagrammer
	*/
	public Anagrammer(String dictionary[], String phrase, int maxWords) {

		this.dictionary = dictionary;
		this.phrase = phrase;
		this.maxWords = maxWords;
		this.result = null;

	}


	/**
	* This method is finding the anagram
	* @para words WordList is the list of words so far in current anagram search
	* @para phraseStats AlphabetStats is the letters from the original phrase
	* 		which are still left out the list of words.
	*/
	private void findAnagram(WordList words, AlphabetStats phraseStats) {

		if(maxWords < 0) {

			System.err.println("Your input value of maxwords is invalid.");
			System.exit(-1);

		}

		if(words.getLength() > maxWords) {

			return;

		}

		if(phraseStats.isEmpty() || 
			(words.getLength() == maxWords && phraseStats.isEmpty())) {

			System.out.println(words.toString());
			return;

		}

		for(int i = 0; i < dictionary.length; i++) {

			String w = dictionary[i];
			AlphabetStats wd = new AlphabetStats(w);

			if(!phraseStats.contains(wd)) {

				continue;
				
			} else {

				if(!words.contains(w)) {

					words.insertHead(w);
					phraseStats.subtract(wd);
					findAnagram(words, phraseStats);
					phraseStats.add(wd);
					words.removeHead();
				}
			}		
		}
	}


	/**
	* This method generates the anagrams that result from the combination
	*/
	public void generate() {

		WordList result = new WordList();
		AlphabetStats ls = new AlphabetStats(phrase);
		findAnagram(result,ls);

	}
}