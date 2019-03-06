package org.dpl.concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
	private final AtomicLong sequenceNumber = new AtomicLong(0);

	public long next() {
		return sequenceNumber.getAndIncrement();
	}
}
