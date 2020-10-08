package iut.efj.tp2;

import java.util.Random;

public class DictionarySearcher implements Runnable {

	private static final int NB_LOOKUPS = 10000;

	private IDictionary _dictionary;

	private Random _random = new Random(0);

	DictionarySearcher(IDictionary dictionary) {
		super();
		
		_dictionary = dictionary;
	}

	@Override
	public void run() {
		for (int i = 0; i < NB_LOOKUPS; i++) {
			_dictionary.getDefinition(DictionaryPopulator.generateWord(_random));
		}
	}

}
