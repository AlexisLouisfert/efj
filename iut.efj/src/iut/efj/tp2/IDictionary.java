package iut.efj.tp2;

public interface IDictionary {

	public void put(String word, String definition);

	public String getDefinition(String word);
	
	public void clear();
	
}
