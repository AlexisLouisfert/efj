package iut.efj.tp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tp1Checker {

	public static void main(String[] args) throws IOException {
		File file = new File("ids.csv");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.print(line);
			System.out.print(";");
			String id = line.substring(0, line.indexOf(';'));
			check("iut.efj.tp1.id" + id + ".Tp1");
		}
		reader.close();
	}

	static public void check(String className) {
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(className);
			@SuppressWarnings("unchecked")
			ITp1 tp = (ITp1) clazz.getDeclaredConstructor().newInstance();
			check(tp);
		} catch (Exception e) {
			System.out.println("Error while trying to create the class instance to check \'" + className + "\': "
					+ e.getClass().getName() + " - " + e.getMessage());
		}
	}

	static public void check(ITp1 tp) {
		System.out.print(tp.getStudentName());
		System.out.print(";");
		checkLIFO(tp);
		checkFIFO(tp);
		System.out.println();
	}

	static private void checkLIFO(ITp1 tp) {
		checkStack(tp.getLIFO(), new Object[] { "a", "b", "c" }, "cba");
	}

	static private void checkFIFO(ITp1 tp) {
		checkStack(tp.getFIFO(), new Object[] { "a", "b", "c" }, "abc");
	}

	static private void checkStack(AbstractStack stack, Object[] in, String expectedOut) {
		boolean ok;
		try {
			for (Object o : in) {
				stack.put(o);
			}
			StringBuilder buffer = new StringBuilder();
			while (!stack.isEmpty()) {
				buffer.append(stack.get());
			}
			System.out.print(buffer);
			ok = expectedOut.equals(buffer.toString());
		} catch (Exception e) {
			System.out.print(e.getMessage());
			ok = false;
		}
		System.out.print(";");
		if (ok) {
			System.out.print("ok;");
		} else {
			System.out.print("ko;");
		}

	}

}
