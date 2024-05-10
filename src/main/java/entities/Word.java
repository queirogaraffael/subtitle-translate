package entities;

import java.util.Objects;

public class Word implements Comparable<Word> {
	private String word;
	private String wordTranslated;
	private Integer frequency = 1;

	public Word() {
	}

	public Word(String word) {
		super();
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordTranslated() {
		return wordTranslated;
	}

	public void setWordTranslated(String wordTranslated) {
		this.wordTranslated = wordTranslated;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public void adicionaFrequencia() {
		frequency += 1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	@Override
	public int compareTo(Word o) {
		return -frequency.compareTo(o.getFrequency());
	}

	@Override
	public String toString() {
		return String.format("%d : ", frequency) +  word + " - " + wordTranslated;
	}
}