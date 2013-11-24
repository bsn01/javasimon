package org.javasimon.examples.testapp;

import java.util.Random;

import org.javasimon.examples.testapp.test.Timer;

/**
 * Class UniformRandomTimer.
 *
 * @author Radovan Sninsky
 * @since 2.0
 */
public class UniformRandomTimer implements Timer {

	private final Random random = new Random();

	private long range;
	private long delay;

	public UniformRandomTimer(long range, long delay) {
		this.range = range;
		this.delay = delay;
	}

	public long getRange() {
		return range;
	}

	public long getDelay() {
		return delay;
	}

	public long delay() {
		return (long) Math.abs((this.random.nextDouble() * getRange()) + getDelay());
	}
}
