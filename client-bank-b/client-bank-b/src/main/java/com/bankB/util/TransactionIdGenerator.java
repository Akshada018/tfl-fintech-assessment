package com.bankB.util;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionIdGenerator {
	
	 private static final AtomicLong counter = new AtomicLong(0);

	    public static String generate() {
	        return "TRX-" + LocalDate.now() + "-" +
	                String.format("%06d", counter.incrementAndGet());
	    }

}
