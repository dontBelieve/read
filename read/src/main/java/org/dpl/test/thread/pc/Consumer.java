package org.dpl.test.thread.pc;

public class Consumer implements Runnable {

	private volatile Depot depot;

	public Consumer(Depot depot) {
		this.depot = depot;

	}

	public void consume() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				depot.consume();
			}
		}).start();
	}

	@Override
	public void run() {
		System.out.println("Consumer");
	}
}
