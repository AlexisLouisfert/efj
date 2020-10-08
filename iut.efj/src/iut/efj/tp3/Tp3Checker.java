package iut.efj.tp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tp3Checker {

	public static void main(String[] args) throws IOException {
		File file = new File("ids.csv");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.print(line);
			System.out.print(";");
			String id = line.substring(0, line.indexOf(';'));
			check("iut.efj.tp3.id" + id + ".Tp3");
		}
		reader.close();
	}

	static public void check(String className) {
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(className);
			@SuppressWarnings("unchecked")
			ITp3 tp = (ITp3) clazz.getDeclaredConstructor().newInstance();
			check(tp);
		} catch (Exception e) {
			System.out.println("Error while trying to create the class instance to check \'" + className + "\': "
					+ e.getClass().getName() + " - " + e.getMessage());
		}
	}

	static public void check(ITp3 tp) {
		System.out.print(tp.getStudentName());
		System.out.print(";");
		runAndMeasureTime(tp.getTaskExercice1());
		runAndMeasureTime(tp.getTaskExercice2());
		runAndMeasureTime(tp.getTaskExercice3());
		runAndMeasureTime(tp.getTaskExercice4());
		runAndMeasureTime(tp.getTaskExercice5());
		System.out.println();
	}
	
	
	static private void runAndMeasureTime(Runnable runnable) {
		long t0 = System.nanoTime();
		runnable.run();
		long elapsed = (System.nanoTime() - t0) / 1000000;
		System.out.print(elapsed);
		System.out.print(";");
	}

	
}
