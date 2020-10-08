package iut.efj.tp2;

import java.util.Random;

public class DictionaryPopulator implements Runnable {

	private static final int NB_WORDS = 100000;

	private IDictionary _dictionary;

	private Random _random = new Random(0);

	DictionaryPopulator(IDictionary dictionary) {
		super();
		
		_dictionary = dictionary;
	}

	@Override
	public void run() {
		for (int i = 0; i < NB_WORDS; i++) {
			_dictionary.put(generateWord(i), generateDefinition(i));
		}
	}

	private String generateDefinition(int i) {
		return "fake definition for word " + i + " with random part: " + _random.nextInt();
	}

	public static String generateWord(int i) {
		return "fake_word_" + i;
	}

	public static String generateWord(Random random) {
		return generateWord(random.nextInt(NB_WORDS));
	}

}
