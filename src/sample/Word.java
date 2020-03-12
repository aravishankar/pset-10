package sample;

public class Word {

	private String word;
	private Definition[] definitions;
	private String[] synonyms;
	private String[] antonyms;

	public Word(String word, Definition[] definitions, String[] synonyms, String[] antonyms) {
		this.word = word;
		this.definitions = definitions;
		this.synonyms = synonyms;
		this.antonyms = antonyms;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Definition[] getDefinitions() {
		return this.definitions;
	}

	public void setDefinitions(Definition[] definitions) {
		this.definitions = definitions;
	}

	public String[] getSynonyms() {
		return this.synonyms;
	}

	public void setSynonyms(String[] synonyms) {
		this.synonyms = synonyms;
	}

	public String[] getAntonyms() {
		return this.antonyms;
	}

	public void setAntonyms(String[] antonyms) {
		this.antonyms = antonyms;
	}

}
