package iut.efj.tp3;

import java.util.Random;

public class HeavyTask implements Runnable {

	private final static int LOAD = 100000;

	Random _random = new Random(0);
	
	@Override
	public void run() {
		System.out.print(Thread.currentThread().getName() + ";");
		for (int i = 0; i < LOAD; i++) {
			doSomethingHeavy();
		}
	}

	private void doSomethingHeavy() {
		for (int i = 0; i < 100; i++) {
			Math.sqrt(_random.nextDouble() * Double.MAX_VALUE);
		}
	}

}
