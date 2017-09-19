package setAndMap_Exe;

public class WordOccurrence implements Comparable<WordOccurrence> {
	private String word;
	private Integer count;
	
	public WordOccurrence() {
		
	}
	
	public WordOccurrence(String word, Integer count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o instanceof WordOccurrence) {
			WordOccurrence another = (WordOccurrence)o;
			if(this.word.equals(another.word) && this.count == another.count) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = this.word.hashCode() + 31*this.count.hashCode();
		return hash;
	}
	      
	public int compareTo(WordOccurrence wo) {
		if(this.count > wo.count)
			return 1;
		else if(this.count == wo.count)
			return 0;
		else
			return -1;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String toString() {
		return word + ":\t" + count + "\n";
	}
}
