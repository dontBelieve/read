package org.dpl.test.thread.pc;

public class Test {
	public static void main(String[] args) {
		Depot depot = new Depot();
		Consumer consumer = new Consumer(depot);
		Producer producer = new Producer(depot);
		while (true) {
			consumer.consume();
			producer.produce();
		}
	}
}
