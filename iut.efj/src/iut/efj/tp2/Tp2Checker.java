package iut.efj.tp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tp2Checker {

	public static final int NB_CHECK_LOOP = 5;
	
	public static void main(String[] args) throws IOException {
		File file = new File("ids.csv");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.print(line);
			System.out.print(";");
			String id = line.substring(0, line.indexOf(';'));
			check("iut.efj.tp2.id" + id + ".Tp2");
		}
		reader.close();
	}

	static public void check(String className) {
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(className);
			@SuppressWarnings("unchecked")
			ITp2 tp = (ITp2) clazz.getDeclaredConstructor().newInstance();
			check(tp);
		} catch (Exception e) {
			System.out.println("Error while trying to create the class instance to check \'" + className + "\': "
					+ e.getClass().getName() + " - " + e.getMessage());
		}
	}

	static public void check(ITp2 tp) {
		System.out.print(tp.getStudentName());
		System.out.print(";");
		IDictionary arrayListDictionary = tp.getArrayListDictionary();
		for (int i = 0 ; i < NB_CHECK_LOOP ; i++) {
			checkDictionary(arrayListDictionary);
		}
		IDictionary hashMapDictionary = tp.getHashMapDictionary();
		for (int i = 0 ; i < NB_CHECK_LOOP ; i++) {
			checkDictionary(hashMapDictionary);
		}
		System.out.println();
	}
	
	static public void checkDictionary(IDictionary dictionary) {
		DictionaryPopulator populator = new DictionaryPopulator(dictionary);
		runAndMeasureTime(populator);

		DictionarySearcher searcher = new DictionarySearcher(dictionary);
		runAndMeasureTime(searcher);
		
		dictionary.clear();
	}
	
	static private void runAndMeasureTime(Runnable runnable) {
		long t0 = System.nanoTime();
		runnable.run();
		long elapsed = System.nanoTime() - t0;
		System.out.print(elapsed);
		System.out.print(";");
	}

}
