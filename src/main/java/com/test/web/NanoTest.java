package com.test.web;

public class NanoTest {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(t1);
		long t2 = System.nanoTime();
		System.out.println(t2);
	}
}
