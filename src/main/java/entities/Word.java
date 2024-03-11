package entities;

import java.util.Objects;

public class Word implements Comparable<Word> {
	private String name;
	private String nameTranslated;
	private Integer frequency = 1;

	public Word() {
	}

	public Word(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getNameTranslated() {
		return nameTranslated;
	}

	public void setNameTranslated(String nameTranslated) {
		this.nameTranslated = nameTranslated;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency += frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return name + " - " + nameTranslated + " - " + String.format("%d", frequency);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
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
		return Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Word o) {
		return -frequency.compareTo(o.getFrequency());
	}

}