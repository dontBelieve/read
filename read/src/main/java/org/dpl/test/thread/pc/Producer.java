package org.dpl.test.thread.pc;

public class Producer implements Runnable {

	private volatile Depot depot;

	public Producer(Depot depot) {
		this.depot = depot;
	}

	public void produce() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				depot.produce();
			}
		}).start();
	}

	@Override
	public void run() {
		System.out.println("productor");
	}

}
